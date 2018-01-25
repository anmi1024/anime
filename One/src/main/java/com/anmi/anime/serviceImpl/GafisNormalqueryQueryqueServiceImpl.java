package com.anmi.anime.serviceImpl;

import com.anmi.anime.model.*;
import com.anmi.anime.model.vo.AnalyzeResultVO;
import com.anmi.anime.model.vo.AnalyzeVO;
import com.anmi.anime.model.vo.QueryQueueVO;
import com.anmi.anime.queryQueue.define.CandListAnnotationObject;
import com.anmi.anime.queryQueue.define.MicAnnotationObject;
import com.anmi.anime.repository.daku.*;
import com.anmi.anime.service.GafisNormalqueryQueryqueService;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.fs.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import static com.anmi.anime.utils.ByteUtil.spliceBytes;

/**
 * Created by wangjue on 2017/9/14.
 */
@Service("queryQueueService")
public class GafisNormalqueryQueryqueServiceImpl implements GafisNormalqueryQueryqueService {
    private Logger logger = Logger.getLogger(this.getClass());
    private int threadSize = 5;
    private volatile boolean empty = false;
    private volatile boolean running = true;
    private volatile boolean validAllThreadRunning = true;
    private ExecutorService pool = Executors.newFixedThreadPool(threadSize+1+1);
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

    private LongAdder errorMsgCount = new LongAdder();
    private Vector<String> processMessage;
    private Vector<String> processErrorMessage;
    private Vector<Integer> oraSidVector;
    private String pkId;
    private Future future = null;

    public int getErrorMsgCount() {return errorMsgCount.intValue();}
    public Vector<String> getProcessMessage() {
        return processMessage;
    }
    public Vector<String> getProcessErrorMessage(){return processErrorMessage;}

    public void setErrorMsgCount() {errorMsgCount.add(1);}
    public void setClearCollect() {
        errorMsgCount.reset();
        processMessage = new Vector<>();
        processErrorMessage = new Vector<>();
    }


    @Autowired
    GafisNormalqueryQueryqueRepository gafisNormalqueryQueryqueRepository;
    @Autowired
    QueryqueueRepository queryqueueRepository;
    @Autowired
    GatherFingerRepository gatherFingerRepository;
    @Autowired
    GatherPalmRepository gatherPalmRepository;
    @Autowired
    GafisCaseFingerMntRepository gafisCaseFingerMntRepository;
    @Autowired
    GafisCasePalmMntRepository gafisCasePalmMntRepository;

    private void setTimeZone() {
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(tz);
    }

    private GafisDakuQueryqueEntity buildQueryqueue(QueryQueueVO queryQueueVO) {
        GafisDakuQueryqueEntity queryqueEntity = new GafisDakuQueryqueEntity();
        queryqueEntity.setPkid(UUID.randomUUID().toString().replace("-",""));
        queryqueEntity.setFilename(queryQueueVO.getFileName());
        queryqueEntity.setStatues(0L);
        queryqueEntity.setBeginTime(new Date());
        queryqueEntity.setQuerytype((long)queryQueueVO.getQueryType());
        queryqueEntity.setPriority((long)queryQueueVO.getPriority());
        queryqueEntity.setMaxcandnum((long)queryQueueVO.getMaxCandNum());
        queryqueEntity.setMinscore((long)queryQueueVO.getMinScore());
        queryqueEntity.setDescription(queryQueueVO.getDescription());
        queryqueEntity.setTextsql(queryQueueVO.getTextSql());
        queryqueEntity.setThreshold((long)queryQueueVO.getThreshold());
        queryqueEntity.setMatchStatues(0L);
        return queryqueEntity;
    }

    private void updateQueryqueue() {
        oraSidVector.sort((o1,o2) -> {
            int o = o1 > o2 ? -1 : 1;
            return o;
        });
        if (oraSidVector != null && oraSidVector.size() > 0) {
            int oraSidStart,oraSidEnd;
            if (oraSidVector.size() == 1) oraSidStart = oraSidEnd = oraSidVector.get(0);
            else {
                oraSidEnd = oraSidVector.get(0);
                oraSidStart = oraSidVector.get(oraSidVector.size()-1);
            }
            queryqueueRepository.modifyByOrasidStartAndOrasidEndAndPkid(Long.valueOf(oraSidStart), Long.valueOf(oraSidEnd) ,pkId);
            oraSidVector = null;
        }
    }

    private void initSendQuery() {
        setTimeZone();
        if (oraSidVector == null) oraSidVector = new Vector<>();
        if (processMessage == null) processMessage = new Vector<>();
        if (processErrorMessage == null) processErrorMessage = new Vector<>();
        empty= false;
        running = true;
        validAllThreadRunning = true;
    }

    @Override
    public void sendQuery(QueryQueueVO queryQueueVO){
        initSendQuery();
        pool.execute(() -> {
            List<String> kids  = queryQueueVO.getKeyId();
            GafisDakuQueryqueEntity queryqueEntity = buildQueryqueue(queryQueueVO);
            queryqueEntity.setTotal((long)kids.size());
            GafisDakuQueryqueEntity gafisDakuQueryqueEntity = null;
            String createQueryQueueMsg = "";
            try {
                gafisDakuQueryqueEntity = queryqueueRepository.save(queryqueEntity);
            } catch (Exception e) {
                createQueryQueueMsg = e.getMessage();
            }
            if (gafisDakuQueryqueEntity != null) {
                pkId = gafisDakuQueryqueEntity.getPkid();
                for (int i=0;i<kids.size();i++) {
                    try {
                        int total = kids.size();
                        String kid = kids.get(i).trim();
                        queue.put(total+":"+(i+1)+"#"+kid);
                    } catch (InterruptedException e) {
                        logger.error("The key add to queue fail!");
                    }
                }
                empty = true;
            } else {
                processErrorMessage.add("fail to create query queue for "+ queryQueueVO.getFileName() + "  "+createQueryQueueMsg);
                logger.equals("fail to create query queue for "+ queryQueueVO.getFileName() + "  "+createQueryQueueMsg);
            }
        });

        for (int i=0;i<threadSize;i++) {
            future = pool.submit(() -> {
                while (running) {
                    try {
                        String kid = queue.poll(2, TimeUnit.SECONDS);
                        if (kid == null || "".equals(kid)) {
                            if (empty) running = false;
                            continue;
                        }
                        String flag = kid.split("#")[0];
                        String keyId = kid.split("#")[1];
                        if (processMessage.size() > 50) {
                            Vector<String> vector = new Vector<>();
                            for (int t=0;t<20;t++) {
                                vector.add(processMessage.get(t));
                            }
                            processMessage.removeAll(vector);
                        }
                        if (queryQueueVO.getQueryType() == 0 || queryQueueVO.getQueryType() == 1) {
                            int oraSid = sendTemplateQuery(flag,keyId, queryQueueVO);
                            if (oraSid == 0) {
                                processErrorMessage.add(String.format("【Template】, %s , The Query for keyId 【%s】has send fail!",flag,keyId));
                                logger.equals(String.format("【Template】, %s , The Query for keyId 【%s】has send fail!",flag,keyId));
                                setErrorMsgCount();
                            } else {
                                processMessage.add(flag + ":" + oraSid + " ,【Template】 The key 【" + keyId + "】has send successful!");
                                oraSidVector.add(oraSid);
                            }
                        } else {
                            int oraSid = sendLatentQuery(flag, keyId, queryQueueVO);
                            if (oraSid == 0) {
                                processErrorMessage.add(flag+", 【Latent】,The Query for keyId 【"+keyId+"】has send fail!");
                                logger.error(flag+" , 【Latent】,The Query for keyId 【"+keyId+"】has send fail!");
                                setErrorMsgCount();
                            } else {
                                processMessage.add(flag + ":" + oraSid + " ,【Latent】 The key 【" + keyId + "】has send successful!");
                                oraSidVector.add(oraSid);
                            }
                        }
                    } catch (InterruptedException e) {
                        logger.error("The key poll from queue fail");
                    }
                }
            });
        }

        pool.execute(() -> {
            while (validAllThreadRunning) {
                if (future.isDone()) {
                    updateQueryqueue();
                    validAllThreadRunning = false;
                }
            }
        });
    }

    private int sendLatentQuery(String flag, String keyIds, QueryQueueVO queryQueueVO){
        String[] fingerOrPalmIds = keyIds.split(",");
        byte[] palmMIC = null;
        byte[] fingerMIC = null;
        for (int i=1;i<=fingerOrPalmIds.length;i++) {
            String fingerOrPalmId = fingerOrPalmIds[i-1];
            if (queryQueueVO.getFlag() == 2) {
                List<GafisCasePalmMntEntity> casePalms = gafisCasePalmMntRepository.findByPalmIdAndMainMnt(fingerOrPalmId,"1");
                if (casePalms == null || casePalms.size() == 0) {
                    logger.error(String.format("%s , There is no casePalm for %s",flag,fingerOrPalmId));
                } else {
                    for (GafisCasePalmMntEntity casePalm : casePalms) {
                        byte[] mnt = casePalm.getPalmMnt();
                        byte[] bin = casePalm.getPalmRidge();
                        int nItemFlag = 0;
                        if (mnt != null && mnt.length != 0) nItemFlag = 1;
                        if (bin != null && bin.length != 0) nItemFlag = 8;
                        if ((mnt != null && mnt.length != 0) && (bin != null && bin.length != 0)) nItemFlag = 9;
                        byte[] mic = buildMic(mnt,bin,(i-1),0,0,1,nItemFlag,casePalm.getPalmId());
                        palmMIC = palmMIC == null ? mic : spliceBytes(palmMIC,mic);
                    }
                }
            } else {
                List<GafisCaseFingerMntEntity> caseFingers = gafisCaseFingerMntRepository.findByfingerIdAndMainMnt(fingerOrPalmId,"1");
                if (caseFingers == null || caseFingers.size() == 0) {
                    logger.error(String.format("%s , There is no caseFinger for %s",flag,fingerOrPalmId));
                } else {
                    for (GafisCaseFingerMntEntity caseFinger : caseFingers) {
                        byte[] mnt = caseFinger.getFingerMnt();
                        byte[] bin = caseFinger.getFingerRidge();
                        int nItemFlag = 0;
                        if (mnt != null && mnt.length != 0) nItemFlag = 1;
                        if (bin != null && bin.length != 0) nItemFlag = 8;
                        if ((mnt != null && mnt.length != 0) && (bin != null && bin.length != 0)) nItemFlag = 9;
                        byte[] mic = buildMic(mnt,bin,(i-1),0,0,1,nItemFlag,caseFinger.getFingerId());
                        fingerMIC = fingerMIC == null ? mic : spliceBytes(fingerMIC,mic);
                    }
                }
            }
        }
        int oraSid = 0;
        String keyId = fingerOrPalmIds.length>1 ? fingerOrPalmIds[0] : keyIds;
        if (palmMIC != null) {
            oraSid = sendMatch(keyId,queryQueueVO,palmMIC);
        }
        if (fingerMIC != null) {
            oraSid = sendMatch(keyId,queryQueueVO,fingerMIC);
        }
        return oraSid;
    }

    private int sendTemplateQuery(String index, String keyIds, QueryQueueVO queryQueueVO){
        String[] personIdArray = keyIds.split(",");
        Map<String,byte[]> gatherDataMap = new HashMap<>();
        byte[] palmMIC = null;
        byte[] fingerMIC = null;
        Set<Long> fgpSet = new HashSet<>();
        for (int i=1;i<=personIdArray.length;i++) {
            String personId = personIdArray[i-1];
            if (queryQueueVO.getFlag() == 2) { //掌纹查询
                List<GafisGatherPalmEntity> palms = gatherPalmRepository.findByPersonId(personId);
                if (palms == null || palms.size() == 0) {
                    logger.error(index + " , There is no palms for "+personId);
                } else {
                    for (GafisGatherPalmEntity palm : palms) {
                        if (palm.getGroupId() == 0 || palm.getGroupId() == 4) {//特征和纹线
                            if (palm.getFgp() != 11 && palm.getFgp() != 12) continue; //暂时只支持左掌和右掌
                            long fgp = palm.getFgp()-10;
                            fgpSet.add(fgp);
                            if (palm.getGatherData() == null || "".equals(palm.getGatherData())) {
                                logger.warn(String.format("The palm 【%s】 fgp 【%s】 has no data!",personId,(int)fgp));
                            } else {
                                gatherDataMap.put("palm_"+personId+"_"+palm.getGroupId()+"_"+(int)fgp,palm.getGatherData());
                            }
                        } else continue;
                    }
                    if (fgpSet.isEmpty()) {
                        logger.error(String.format("%s , The palm 【%s】 all of fgp has no data!", index,personId));
                    } else {
                        byte[] tempMic = buildMicByFgp(fgpSet, gatherDataMap, "palm", personId, i, 2);
                        palmMIC = palmMIC == null ? tempMic : spliceBytes(palmMIC, tempMic);
                    }
                }
            } else {
                List<GafisGatherFingerEntity> fingers = gatherFingerRepository.findByPersonId(personId);
                if (fingers == null || fingers.size() == 0) {
                    logger.error(String.format("%s , There is no fingers for %s!", index,personId));
                } else {
                    for (GafisGatherFingerEntity finger : fingers) {
                        if (finger.getGroupId() == 0 || finger.getGroupId() == 4) {//特征和纹线
                            if (queryQueueVO.getFlag() == 1) { // 只比滚动
                                if ("1".equals(finger.getFgpCase())) continue;
                            } else if (queryQueueVO.getFlag() == 128) { // 只比平面
                                if ("0".equals(finger.getFgpCase())) continue;
                            }
                            int fgp = finger.getFgp();
                            fgp = "1".equals(finger.getFgpCase()) ? fgp+10 : fgp;
                            fgpSet.add(Long.valueOf(fgp));
                            if (finger.getGatherData() == null || "".equals(finger.getGatherData())) {
                                logger.warn(String.format("The finger 【%s】 fgp 【%s】 has no data! flag is 【%s】",personId,finger.getFgp(),queryQueueVO.getFlag()));
                            } else {
                                gatherDataMap.put("finger_"+personId+"_"+finger.getGroupId()+"_"+fgp,finger.getGatherData());
                            }
                        } else continue;
                    }
                    if (fgpSet.isEmpty()) {
                        logger.error(String.format("The finger 【%s】 all of fgp has no data! flag is 【%s】",personId,queryQueueVO.getFlag()));
                    }
                    else {
                        byte[] tempMic = buildMicByFgp(fgpSet,gatherDataMap,"finger",personId,i,1);
                        fingerMIC = fingerMIC == null ? tempMic : spliceBytes(fingerMIC,tempMic);
                    }
                }
            }
        }
        int oraSid = 0;
        String keyId = personIdArray.length>1 ? personIdArray[0] : keyIds;
        if (palmMIC != null) {
            oraSid = sendMatch(keyId,queryQueueVO,palmMIC);
        }
        if (fingerMIC != null) {
            oraSid = sendMatch(keyId,queryQueueVO,fingerMIC);
        }
        return oraSid;
    }

    public int sendMatch(String personId,QueryQueueVO queryQueueVO,byte[] data) {

        int oraSid = 0;
        GafisNormalqueryQueryqueEntity gafisBean = new GafisNormalqueryQueryqueEntity();
        //设置默认值
        if (queryQueueVO.getMaxCandNum() >= 0)
            gafisBean.setMaxcandnum(queryQueueVO.getMaxCandNum());
        else
            gafisBean.setMaxcandnum(null);
        gafisBean.setMinscore(queryQueueVO.getMinScore());
        gafisBean.setCurcandnum(0);
        gafisBean.setStatus(0);
        gafisBean.setVerifyresult(0);
        gafisBean.setHandleresult(0);
        gafisBean.setUserunitcode(queryQueueVO.getUnitcode());
        Date date = new Date();
        gafisBean.setCreatetime(date);
        gafisBean.setDeletag("1");//删除标志
        gafisBean.setUsername("管理员");
        gafisBean.setUserid("1");//发送提交者 1:admin
        gafisBean.setSubmittsystem("1");//1:指纹系统 　2:标采系统
        gafisBean.setPriority(queryQueueVO.getPriority());
        gafisBean.setPrioritynew(queryQueueVO.getPriority());
        gafisBean.setFlagc(0);
        gafisBean.setFlagd(1);
        gafisBean.setFlage(0);
        gafisBean.setFlagg(0);
        gafisBean.setFlag(queryQueueVO.getFlag());
        gafisBean.setKeyid(personId);
        gafisBean.setMic(data);
        gafisBean.setPkId(UUID.randomUUID().toString().replace("-",""));
        gafisBean.setQuerytype(queryQueueVO.getQueryType());
        gafisBean.setOraSid(gafisNormalqueryQueryqueRepository.getSeqOraSid());
        GafisNormalqueryQueryqueEntity queryqueEntity = gafisNormalqueryQueryqueRepository.save(gafisBean);
        if (queryqueEntity != null && personId.equals(queryqueEntity.getKeyid())) oraSid = queryqueEntity.getOraSid();
        return oraSid;
    }


    private byte[] buildMicByFgp(Set<Long> fgpSet,Map<String,byte[]> gatherDataMap,String type,String personId,int itemIndex,int itemType){
        byte[] queryMIC = null;
        byte[] mic;
        for (long fgp : fgpSet) {
            byte[] mnt = gatherDataMap.get(type+"_"+personId+"_0_"+fgp);
            byte[] bin = gatherDataMap.get(type+"_"+personId+"_4_"+fgp);
            int nItemFlag = 0;
            if (mnt != null && mnt.length != 0) nItemFlag = 1;
            if (bin != null && bin.length != 0) nItemFlag = 8;
            if ((mnt != null && mnt.length != 0) && (bin != null && bin.length != 0)) nItemFlag = 9;
            if ("finger".equals(type)) {
                if (fgp > 10) itemType = 8;
                else itemType = 1;
            }
            mic = buildMic(mnt, bin, (itemIndex - 1), (int) fgp, itemType, 0, nItemFlag,personId);
            if (queryMIC == null) queryMIC = mic;
            else queryMIC = spliceBytes(queryMIC, mic);
        }
        return queryMIC;
    }

    /**
     * 构造特征结构
     * @param mnt           //特征数据
     * @param bin           //纹线数据
     * @param itemIndex     //组查询标记，只有当itemIndex > 0时，赋此值
     * @param itemData      //指位，现场为0;指位处理,与8.0一致,滚指[1,10];平指[11,20];掌纹[1,2]
     * @param itemType      //类型(仅掌纹或掌纹+文本:2;仅滚动指纹或拇指+文本:1;仅平面指纹或平面指纹+文本:8)
     * @param isLatent      //0:template;1:latent
     * @param ItemFlag      //检索标记 1：mnt;8：bin;9：mnt && bin
     * @return
     * @throws Throwable
     */
    private byte[] buildMic(byte[] mnt,byte[] bin,int itemIndex,int itemData,int itemType,int isLatent,int ItemFlag,String keyId) {
        MicAnnotationObject mic = new MicAnnotationObject();
        mic.set$$ItemIndex(itemIndex);
        mic.set$$ItemFlag(ItemFlag);
        mic.set$$ItemType(itemType);
        mic.set$$ItemData(itemData);
        mic.set$$IsLatent(isLatent);
        mic.set$$Mnt(mnt);
        mic.set$$Bin(bin);
        byte[] strutsMic = null;
        try {
            strutsMic = MicAnnotationObject.buildMICByteBuf(mic, itemIndex);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            logger.error(keyId+" , buildMic fail , "+e.getMessage());
        }
        return strutsMic;
    }


    @Override
    public String getMatchResult(QueryQueueVO queryQueueVO) {
        long matchMark = System.currentTimeMillis();
        String currentMatchResultDir = queryQueueVO.getMatchResultSavePath()+"/"+matchMark;
        List<GafisNormalqueryQueryqueEntity> normalqueryQueryqueEntityList = gafisNormalqueryQueryqueRepository.findByOraSidBetween(queryQueueVO.getOraSidS(),queryQueueVO.getOraSidE());
        List<String> ttResultList;
        List<String> ltResultList;
        File ttResult = new File(currentMatchResultDir+File.separator+"tt");
        File ltResult = new File(currentMatchResultDir+File.separator+"lt");
        if (!ttResult.exists()) ttResult.mkdirs();
        ttResult = new File(ttResult.getAbsolutePath() + File.separator + queryQueueVO.getOraSidS()+"-"+queryQueueVO.getOraSidE()+"-TT-"+System.currentTimeMillis()+".txt");
        if (!ltResult.exists()) ltResult.mkdirs();
        for (GafisNormalqueryQueryqueEntity normalqueryQueryqueEntity : normalqueryQueryqueEntityList) {
            ttResultList = new ArrayList<>();
            ltResultList = new ArrayList<>();
            String keyId = normalqueryQueryqueEntity.getKeyid();
            int curcandnum = normalqueryQueryqueEntity.getCurcandnum();
            long timeElapsed = normalqueryQueryqueEntity.getTimeElapsed();
            long recordNumMatched = normalqueryQueryqueEntity.getRecordNumMatched();
            byte[] candList = normalqueryQueryqueEntity.getCandlist();
            List<CandListAnnotationObject> candListAnnotationObjectList;
            try {
                if (candList != null) {
                    candListAnnotationObjectList = new CandListAnnotationObject().readCandListByteBuf(candList);
                    for (CandListAnnotationObject candListAnnotationObject : candListAnnotationObjectList) {
                        int score = candListAnnotationObject.getNScore();
                        if (score < queryQueueVO.getCandMinScore() || score > queryQueueVO.getCandMaxScore()) continue;
                        String szKey = candListAnnotationObject.getSzKey();
                        byte nIndex = candListAnnotationObject.getNIndex();
                        if (normalqueryQueryqueEntity.getQuerytype() == 0) {
                            ttResultList.add(keyId + " " + szKey + " " + score);
                        } else if (normalqueryQueryqueEntity.getQuerytype() == 2) {
                            ltResultList.add(szKey + "--" + score + "--" + nIndex);
                        }
                    }
                }
                if (!ttResultList.isEmpty()) {
                    FileUtils.writeLines(ttResult,ttResultList,true);
                }
                if ((normalqueryQueryqueEntity.getQuerytype() == 2)) {
                    File file = new File(ltResult.getAbsolutePath() + File.separator + keyId + ".txt");
                    FileUtils.writeStringToFile(file,curcandnum+"\r\n",true);
                    FileUtils.writeStringToFile(file,timeElapsed+"\r\n",true);
                    FileUtils.writeStringToFile(file,recordNumMatched+"\r\n",true);
                    if (!ltResultList.isEmpty()) {
                        FileUtils.writeLines(file,ltResultList,true);
                    }
                }

            } catch (Throwable e) {
                logger.error(normalqueryQueryqueEntity.getOraSid()+","+normalqueryQueryqueEntity.getKeyid()+",candList parse fail!"+e.getMessage());
            }
        }
        return currentMatchResultDir;
    }

    @Override
    public List<String> getValidSuccessList(List<String> keysList, QueryQueueVO queryQueueVO) {
        List<String> validList = new ArrayList<>();
        for (String keys : keysList) {
            keys = keys.trim();
            String[] keyArr = keys.split(" |\t|,");
            boolean hasKey = true;
            if (queryQueueVO.getValidKeyType() == 0 || queryQueueVO.getValidKeyType() == 1) { // TT TL LEFT
                String key = keyArr[0].trim();
                int index = -1;
                if (key.indexOf("_") != -1) {
                    index = Integer.valueOf(key.split("_")[1]);
                    key = key.split("_")[0];
                }
                List<GafisGatherFingerEntity> left = gatherFingerRepository.findByPersonIdAndGroupId(key.trim(), 0);
                if (left == null || left.size() == 0) {
                    hasKey = false;
                } else if (index != -1) { // 判断某指位是否存在
                    Set<Integer> fgpSet = new HashSet<>();
                    for (GafisGatherFingerEntity finger : left) {
                        int fgp = finger.getFgp();
                        String fgpCase = finger.getFgpCase();
                        if ("1".equals(fgpCase)) fgp += 10;
                        fgpSet.add(fgp);
                    }
                    if (!fgpSet.contains(index)) hasKey = false;
                }
            } else {
                List<GafisCaseFingerMntEntity> left = gafisCaseFingerMntRepository.findByfingerIdAndMainMnt(keyArr[0].trim(),"1");
                if (left == null || left.size() == 0) hasKey = false;
            }
            if (!hasKey) {
                continue;
            } else {
                if (queryQueueVO.getValidKeyType() == 0 || queryQueueVO.getValidKeyType() == 2) { //TT LT RIGHT
                    String key = keyArr[1].trim();
                    int index = -1;
                    if (key.indexOf("_") != -1) {
                        index = Integer.valueOf(key.split("_")[1]);
                        key = key.split("_")[0];
                    }
                    List<GafisGatherFingerEntity> right = gatherFingerRepository.findByPersonIdAndGroupId(key.trim(), 0);
                    if (right == null || right.size() == 0) {
                        hasKey = false;
                    } else if (index != -1) { // 判断某指位是否存在
                        Set<Integer> fgpSet = new HashSet<>();
                        for (GafisGatherFingerEntity finger : right) {
                            int fgp = finger.getFgp();
                            if ("1".equals(finger.getFgpCase())) fgp += 10;
                            fgpSet.add(fgp);
                        }
                        if (!fgpSet.contains(index)) hasKey = false;
                    }
                } else {
                    List<GafisCaseFingerMntEntity> right = gafisCaseFingerMntRepository.findByfingerIdAndMainMnt(keyArr[1].trim(),"1");
                    if (right == null || right.size() == 0) hasKey = false;
                }
            }
            if (hasKey) validList.add(keys);
        }
        return validList;
    }


    public GafisDakuQueryqueEntity getGafisDakuQueryqueEntity(String pkId){
        return queryqueueRepository.findByPkid(pkId);
    }
    public void modifyQueryCandListDirByPkId(String queryCandListDir, String pkId){
        queryqueueRepository.modifyByQueryCandListDirAndPkid(queryCandListDir, pkId);
    }
    public List<GafisDakuQueryqueEntity> getQueryqueue() {
        return queryqueueRepository.findAll();
    }
    public Page<GafisDakuQueryqueEntity> getPageQueryqueue(int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "beginTime");
        Pageable pageable = new PageRequest(page, size, sort);
        return queryqueueRepository.findAll(pageable);
    }



    public List<GafisDakuQueryqueEntity> getQueryqueueNotMatched() {
        return queryqueueRepository.findByMatchStatuesNot(Long.valueOf(1));
    }
    public void queryMatchFinish(GafisDakuQueryqueEntity queryqueEntity) {
        int oraSidStart = queryqueEntity.getOrasidStart().intValue();
        int oraSidEnd = queryqueEntity.getOrasidEnd().intValue();
        List<GafisNormalqueryQueryqueEntity> normalqueryQueryqueEntityList = gafisNormalqueryQueryqueRepository.findByOraSidBetween(oraSidStart, oraSidEnd);
        long unMatchCount = normalqueryQueryqueEntityList.stream().filter(t -> t.getFinishtime() == null).count(); //任务区间未完成比对任务总数
        if (unMatchCount == 0) {
            Long recordNumMatched = queryqueEntity.getRecordNumMatched();
            if (recordNumMatched == null || recordNumMatched.longValue() == 0) {
                switch (queryqueEntity.getQuerytype().intValue()) {
                    case 0: recordNumMatched = 5000000L;break;
                    case 2: recordNumMatched = 50000000L;break;
                    default: recordNumMatched = 1580000L;
                }
            }
            List<Object> matchBeginAndFinishTimeAndAlgotithmQuerySpeed = gafisNormalqueryQueryqueRepository.getMatchBeginAndFinishTimeAndAlgotithmQuerySpeed(recordNumMatched,oraSidStart,oraSidEnd);
            Object[] o = (Object[]) matchBeginAndFinishTimeAndAlgotithmQuerySpeed.get(0);
            Date minBeginTime = (Date)o[0];
            Date maxFinishTime = (Date)o[1];
            BigDecimal algotithmQuerySpeed = (BigDecimal)o[2];
            queryqueEntity.setMatchStatues(1L);
            queryqueEntity.setMatchBeginTime(minBeginTime);
            queryqueEntity.setMatchFinishTime(maxFinishTime);
            queryqueEntity.setAlgotithmQuerySpeed(algotithmQuerySpeed.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            queryqueueRepository.save(queryqueEntity);
        }
    }

    public AnalyzeVO getAnalyzeResult(List<String> truePairList, String pkId) {
        String analyzeFileSaveBaseDir = "/matchResult/" + LocalDate.now()+"/analyzeFile";
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        AnalyzeVO analyzeVO = new AnalyzeVO();
        List<AnalyzeResultVO> matchViewList = new ArrayList<>();
        GafisDakuQueryqueEntity queryqueEntity = queryqueueRepository.findByPkid(pkId);
        if (queryqueEntity != null) {
            QueryQueueVO queryQueueVO = new QueryQueueVO();
            queryQueueVO.setMatchResultSavePath("/matchResult/" + LocalDate.now()+"/exportFile");
            if (queryqueEntity.getThreshold() != null)
                queryQueueVO.setCandMinScore(queryqueEntity.getThreshold().intValue());
            if (queryqueEntity.getQuerytype() == 0) queryQueueVO.setCandMaxScore(100);
            else queryQueueVO.setCandMaxScore(1000);
            queryQueueVO.setOraSidS(queryqueEntity.getOrasidStart().intValue());
            queryQueueVO.setOraSidE(queryqueEntity.getOrasidEnd().intValue());

            String candListFileDir = queryqueEntity.getQueryCandListDir();
            if (candListFileDir == null || candListFileDir.isEmpty())
                candListFileDir = getMatchResult(queryQueueVO);
            try {
                analyzeVO.setQueryType(queryqueEntity.getQuerytype());
                if (queryqueEntity.getQuerytype() == 0) {
                    if (!candListFileDir.endsWith("tt")) candListFileDir += "/tt";
                    Collection<File> files = FileUtils.listFiles(new File(candListFileDir), new String[]{"txt"}, true);
                    Iterator<File> it = files.iterator();
                    while (it.hasNext()) {
                        List<String> ttCandList = FileUtils.readLines(it.next());
                        List<String> ttCandListFilter = new ArrayList<>();
                        ttCandList.stream().forEach(t -> {
                            String[] arr = t.split(" |\t|,");
                            ttCandListFilter.add(arr[0]+" "+arr[1]);
                        });
                        long total = truePairList.size();
                        //比中
                        List<String> matchList = ttCandList.stream().filter(t -> truePairList.contains(t.substring(0,t.lastIndexOf(" ")))).collect(Collectors.toList());
                        matchList.forEach(t -> {
                            String[] arr = t.split(" |\t|,");
                            String sendKey = arr[0].trim();
                            String matchKey = arr[1].trim();
                            double score = Double.valueOf(arr[2].trim());
                            matchViewList.add(new AnalyzeResultVO(sendKey,matchKey,score));
                        });
                        long match = matchViewList.size();
                        //错比（候选结果中存在，真实对子中不存在）
                        List<String> missList = ttCandList.stream().filter(t -> !truePairList.contains(t.substring(0,t.lastIndexOf(" ")))).collect(Collectors.toList());
                        long miss = missList.size();
                        //漏比（真实对子中存在，候选结果中不存在）
                        List<String> lostList = truePairList.stream().filter(t -> !ttCandListFilter.contains(t)).collect(Collectors.toList());
                        long lost = lostList.size();
                        analyzeVO.setTotal(total);
                        analyzeVO.setMatchCount(match);
                        analyzeVO.setMatchList(matchViewList);
                        analyzeVO.setMissCount(miss);
                        analyzeVO.setMissList(missList);
                        analyzeVO.setLostCount(lost);
                        analyzeVO.setLostList(lostList);

                        /*导出列表*/
                        File lostFile = new File(analyzeFileSaveBaseDir+"/tt/lost_"+pkId+".txt");
                        if (lostList != null && lostList.size() > 0) {
                            if (lostFile.exists()) lostFile.delete();
                            FileUtils.writeLines(lostFile, lostList);
                        }
                        File missFile = new File(analyzeFileSaveBaseDir+"/tt/miss_"+pkId+".txt");
                        if (missList != null && missList.size() >0) {
                            if (missFile.exists()) missFile.delete();
                            FileUtils.writeLines(missFile, missList);
                        }
                        File matchFile = new File(analyzeFileSaveBaseDir+"/tt/match_"+pkId+".txt");
                        if (matchList != null && matchList.size() >0) {
                            if (matchFile.exists()) missFile.delete();
                            FileUtils.writeLines(matchFile, matchList);
                        }
                        analyzeVO.setLostFilePath(lostFile.getAbsolutePath());
                        analyzeVO.setMissFilePath(missFile.getAbsolutePath());
                        analyzeVO.setMatchFilePath(matchFile.getAbsolutePath());
                    }
                } else if (queryqueEntity.getQuerytype() == 2) {
                    if (!candListFileDir.endsWith("lt")) candListFileDir += "/lt";
                    Collection<File> files = FileUtils.listFiles(new File(candListFileDir), new String[]{"txt"}, true);
                    Iterator<File> it = files.iterator();
                    List<String> matchList = new ArrayList<>();                 //比中
                    Map<Integer,Integer> rankMap = new HashMap<>();             //比中排名分布
                    Map<Double,Integer> scoreMap = new HashMap<>();             //比中得分分布
                    List<String> matchLikeTruePairList = new ArrayList<>();     //真实对子格式比中列表
                    Map<String,String> matchMap = new HashMap<>();              //真实对子
                    truePairList.forEach( t -> {
                        if (!t.isEmpty()) {
                            String[] arr = t.split(" ");
                            String trueMatchKey = matchMap.get(arr[0]);
                            if (trueMatchKey == null) matchMap.put(arr[0], arr[1]);
                            else matchMap.put(arr[0], trueMatchKey+","+arr[1]);
                        }
                    });
                    while (it.hasNext()) {
                        File ltCandListFile = it.next();
                        String queryKey = ltCandListFile.getName().substring(0,ltCandListFile.getName().lastIndexOf("."));
                        String trueMatchKey = matchMap.get(queryKey);
                        if (trueMatchKey != null) {
                            String trueMatchKeyMaybeRepeat[] = trueMatchKey.split(",");
                            for (int i=0;i<trueMatchKeyMaybeRepeat.length;i++) {
                                String trueMatchKeyOne = trueMatchKeyMaybeRepeat[i];
                                String[] trueMatchKeyArr = trueMatchKeyOne.split("_");
                                List<String> ltCandList = FileUtils.readLines(ltCandListFile);
                                List<String> ltCandListWithRankAndQueryKey = new ArrayList<>();
                                ltCandList.stream().skip(3).collect(Collectors.toList()).forEach(t -> ltCandListWithRankAndQueryKey.add(t + "--" + (ltCandListWithRankAndQueryKey.size() + 1) + "--" + queryKey));
                                List<String> processList = ltCandListWithRankAndQueryKey.stream().filter(t -> {
                                    String[] arr = t.split("--");
                                    if (arr.length > 3)
                                        return arr[0].trim().equals(trueMatchKeyArr[0].trim()) && arr[2].trim().equals(trueMatchKeyArr[1].trim());
                                    else return false;
                                }).collect(Collectors.toList());
                                matchList.addAll(processList);
                            }
                        }
                    }

                    /**
                     * matchList
                     * 比中卡号--得分--指位--排名--查询卡号
                     * R2305160008882009010145--984--3--1--A130185000999201209110101
                     * */
                    matchList.stream().forEach(t -> {
                        if (!t.isEmpty()) {
                            String[] matchArr = t.split("--");
                            String sendKey = matchArr[4].trim();
                            String matchKey = matchArr[0].trim();
                            int rank = Integer.valueOf(matchArr[3].trim());
                            double score = Double.valueOf(matchArr[1].trim());
                            String fgp = matchArr[2].trim();
                            matchViewList.add(new AnalyzeResultVO(sendKey,matchKey,Integer.valueOf(fgp),rank,score));
                            //设置排名
                            if (rankMap.get(rank) == null) rankMap.put(rank,1);
                            else rankMap.put(rank,rankMap.get(rank)+1);
                            //设置得分
                            if (scoreMap.get(score) == null) scoreMap.put(score,1);
                            else scoreMap.put(score,scoreMap.get(score)+1);
                            //设置比中
                            matchLikeTruePairList.add(sendKey+" "+matchKey+"_"+fgp);
                        }
                    });
                    analyzeVO.setTotal(truePairList.size());
                    List<String> lostList = truePairList.stream().filter(t -> !matchLikeTruePairList.contains(t.trim())).collect(Collectors.toList());
                    if (lostList != null && lostList.size() > 0 && lostList.get(lostList.size()-1).isEmpty()) lostList.remove(lostList.size()-1);

                    /*Collections.sort(matchViewList,(t1,t2) -> {
                        int rank1 = t1.getRank();
                        int rank2 = t2.getRank();
                        return rank1 > rank2 ? 1 : -1;
                    });*/
                    matchViewList.stream().sorted((t1,t2) -> {
                        int rank1 = t1.getRank();
                        int rank2 = t2.getRank();
                        return rank1 > rank2 ? 1 : -1;
                    });
                    if (matchViewList !=null && matchViewList.size() > 0 && matchViewList.get(matchViewList.size()-1) == null) matchViewList.remove(matchViewList.size()-1);
                    analyzeVO.setMatchCount(matchViewList.size());
                    analyzeVO.setMatchList(matchViewList);
                    analyzeVO.setLostCount(lostList.size());
                    analyzeVO.setLostList(lostList);
                    /*导出列表*/
                    File lostFile = new File(analyzeFileSaveBaseDir+"/lt/lost_"+pkId+".txt");
                    File matchFile = new File(analyzeFileSaveBaseDir+"/lt/match_"+pkId+".txt");
                    if (lostList != null && lostList.size() > 0) {
                        if (lostFile.exists()) lostFile.delete();
                        FileUtils.writeLines(lostFile, lostList);
                    }
                    if (matchList != null && matchList.size() > 0) {
                        if (matchFile.exists()) matchFile.delete();
                        for (AnalyzeResultVO vo : matchViewList) {
                            FileUtils.writeStringToFile(matchFile, vo.getQueryKey()+" "+vo.getMatchKey()+"_"+vo.getMatchKeyFgp()+" "+vo.getRank()+" "+vo.getScore().intValue()+"\r\n", true);
                        }
                        //FileUtils.writeLines(matchFile, matchList);
                    }
                    analyzeVO.setLostFilePath(lostFile.getAbsolutePath());
                    analyzeVO.setMatchFilePath(matchFile.getAbsolutePath());

                    //排前率设置
                    Map<String,String> theTopRate = new HashMap<>();
                    long top1Rate = matchViewList.stream().filter(t -> t.getRank() == 1).count();
                    long top10Rate = matchViewList.stream().filter(t -> t.getRank() <= 10).count();
                    long top100Rate = matchViewList.stream().filter(t -> t.getRank() <= 100).count();
                    long top300Rate = matchViewList.stream().filter(t -> t.getRank() <= 300).count();
                    theTopRate.put("top1",numberFormat.format((double)top1Rate/(double)analyzeVO.getTotal()*100)+"%");
                    theTopRate.put("top10",numberFormat.format((double)top10Rate/(double)analyzeVO.getTotal()*100)+"%");
                    theTopRate.put("top100",numberFormat.format((double)top100Rate/(double)analyzeVO.getTotal()*100)+"%");
                    theTopRate.put("top300",numberFormat.format((double)top300Rate/(double)analyzeVO.getTotal()*100)+"%");
                    analyzeVO.setTheTopRate(theTopRate);
                    //分布展示
                    Map<Integer,String> rankViewMap = new HashMap<>();
                    Map<Double,String> scoreViewMap = new HashMap<>();
                    int candNum = queryqueEntity.getMaxcandnum() == null ? 200 : queryqueEntity.getMaxcandnum().intValue();

                    for (int i=1;i<=candNum;i++) { //完整排名分布
                        Integer rank = rankMap.get(i);
                        if (rank == null) rankViewMap.put(i,"0.0%");
                        else rankViewMap.put(i,numberFormat.format(rank.doubleValue()/(double)analyzeVO.getTotal()*100)+"%");
                    }
                    for (int i=0;i<=1000;i++) { //完整得分分布 1000分
                        Integer score = scoreMap.get(i);
                        if (score == null) scoreViewMap.put((double)i,"0.0%");
                        else scoreViewMap.put((double)i,numberFormat.format(score.doubleValue()/(double)analyzeVO.getTotal()*100)+"%");
                    }
                    analyzeVO.setRankMap(rankViewMap);
                    analyzeVO.setScoreMap(scoreViewMap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return analyzeVO;
    }
}

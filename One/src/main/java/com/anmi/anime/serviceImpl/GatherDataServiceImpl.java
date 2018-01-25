package com.anmi.anime.serviceImpl;

import com.anmi.anime.config.FPTConfig;
import com.anmi.anime.fpt.*;
import com.anmi.anime.model.*;
import com.anmi.anime.repository.daku.*;
import com.anmi.anime.service.GatherDataService;
import com.anmi.anime.utils.ProcessImageAndFeatureUtil;
import com.anmi.anime.utils.ProtoHttpClientUtil;
import com.google.protobuf.ByteString;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.gloclib.glocdef;
import org.apache.http.client.HttpClient;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by wangjue on 2017/9/21.
 */
@Service("gatherDataService")
public class GatherDataServiceImpl implements GatherDataService {
    private Logger logger = Logger.getLogger(this.getClass());
    private int threadSize = 20;
    private volatile boolean empty = false;
    private volatile boolean running = true;
    private ExecutorService pool = Executors.newFixedThreadPool(20+1);
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(36);

    private static LongAdder errorMsgCounnt = new LongAdder();
    private Vector<String> processMessageRate;
    private Vector<String> processErrorMessage;

    public Vector<String> getProcessErrorMessage() {
        return processErrorMessage;
    }
    public Long getErrorMsgCount() {
        return errorMsgCounnt.longValue();
    }
    public Vector<String> getProcessMessageRate() {
        return processMessageRate;
    }

    public void setClearCollect() {
        errorMsgCounnt.reset();
        processMessageRate = new Vector<>();
        processErrorMessage = new Vector<>();
    }

    private void setErrorMsgCount() {
        errorMsgCounnt.add(1);
    }

    @Autowired
    private FPTConfig fptConfig;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GatherFingerRepository gatherFingerRepository;

    @Autowired
    private GafisCaseRepository gafisCaseRepository;

    @Autowired
    private GafisCaseFingerRepository gafisCaseFingerRepository;

    @Autowired
    private GafisCaseFingerMntRepository gafisCaseFingerMntRepository;

    private synchronized Date getCurrentDate() {
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(tz);
        return new Date();
    }

    private void savePerson(String personId, String fptPath, String coverFPT) {
        GafisPersonEntity person = personRepository.findByPersonid(personId);
        if (person != null && "cover".equals(coverFPT)) {
            personRepository.delete(person);
            gatherFingerRepository.deleteBypersonId(personId);
            person = null;
        }
        //int result = personRepository.modifyPersonFptPath(fptPath, personId);
        if (person == null)  {
            GafisPersonEntity personEntity = new GafisPersonEntity();
            personEntity.setPersonid(personId);
            personEntity.setSeq(personRepository.getPersonSeq());
            personEntity.setSid(personRepository.getPersonSid());
            personEntity.setDeletag("1");
            personEntity.setDataIn("1");
            personEntity.setDataType("0");
            personEntity.setDataSources(5);
            personEntity.setFingershowStatus(1);
            personEntity.setInputDate(getCurrentDate());
            personEntity.setGatherDate(getCurrentDate());
            personEntity.setFptPath(fptPath);
            personRepository.save(personEntity);
        }
    }

    private Set<GafisGatherFingerEntity> queryGafisGatherFinger(String personId) {
        Set<GafisGatherFingerEntity> set = new HashSet<>();
        List<GafisGatherFingerEntity> fingers = gatherFingerRepository.findByPersonId(personId);
        if (fingers == null || fingers.size() ==0) return null;
        else fingers.forEach(t -> set.add(t));
        return set;
    }

    private void saveGatherFinger(List<GafisGatherFingerEntity> gatherFingerEntity) {
        gatherFingerEntity.forEach(t -> gatherFingerRepository.save(t));
    }

    private void saveCase(String caseId, String coverFPT) {
        GafisCaseEntity caseEntity = gafisCaseRepository.findByCaseId(caseId);
        if (caseEntity != null && "cover".equals(coverFPT)) {
            gafisCaseRepository.delete(caseEntity);
            caseEntity = null;
        }
        if (caseEntity == null) {
            GafisCaseEntity gafisCaseEntity = new GafisCaseEntity();
            gafisCaseEntity.setCaseId(caseId);
            gafisCaseEntity.setInputtime(getCurrentDate());
            gafisCaseEntity.setDeletag("1");
            gafisCaseEntity.setCaseSource("5");
            gafisCaseEntity.setIsChecked("0");
            gafisCaseRepository.save(gafisCaseEntity);
        }
    }

    private boolean findCaseFingerByFingerId(String fingerId, String coverFPT) {
        boolean saveFinger = false;
        GafisCaseFingerEntity caseFingerEntity = gafisCaseFingerRepository.findByFingerId(fingerId);
        if (caseFingerEntity == null) saveFinger = true;
        else {
            if ("cover".equals(coverFPT)) {
                gafisCaseFingerRepository.delete(caseFingerEntity);
                saveFinger = true;
            }
        }
        return saveFinger;
    }
    private void saveCaseFinger(GafisCaseFingerEntity caseFinger) {
        GafisCaseFingerEntity gafisCaseFingerEntity = new GafisCaseFingerEntity();
        gafisCaseFingerEntity.setCaseId(caseFinger.getCaseId());
        gafisCaseFingerEntity.setFingerId(caseFinger.getFingerId());
        gafisCaseFingerEntity.setSeqNo(caseFinger.getSeqNo());
        gafisCaseFingerEntity.setInputtime(getCurrentDate());
        gafisCaseFingerEntity.setDeletag("1");
        gafisCaseFingerEntity.setDataMatcher("1");
        gafisCaseFingerEntity.setDataIn("1");
        gafisCaseFingerEntity.setFingerImg(caseFinger.getFingerImg());
        gafisCaseFingerEntity.setSid(gafisCaseFingerRepository.getCaseFingerSeq());
        gafisCaseFingerEntity.setFptPath(caseFinger.getFptPath());
        gafisCaseFingerRepository.save(gafisCaseFingerEntity);
    }

    private boolean findCaseFingerMntByFingerId(String fingerId, String coverFPT) {
        boolean saveFinger = false;
        List<GafisCaseFingerMntEntity> list =  gafisCaseFingerMntRepository.findByfingerIdAndMainMnt(fingerId,"1");
        if (list == null || list.size() ==0) saveFinger = true;
        else {
            if ("cover".equals(coverFPT)) {
                list.forEach(t-> gafisCaseFingerMntRepository.delete(t));
                saveFinger = true;
            }
        }
        return saveFinger;
    }
    private void saveCaseFingerMnt(GafisCaseFingerMntEntity caseFingerMnt) {
        GafisCaseFingerMntEntity gafisCaseFingerMntEntity = new GafisCaseFingerMntEntity();
        gafisCaseFingerMntEntity.setPkId(UUID.randomUUID().toString().replace("-",""));
        gafisCaseFingerMntEntity.setFingerId(caseFingerMnt.getFingerId());
        gafisCaseFingerMntEntity.setMainMnt("1");
        gafisCaseFingerMntEntity.setInputtime(getCurrentDate());
        gafisCaseFingerMntEntity.setFingerMnt(caseFingerMnt.getFingerMnt());
        gafisCaseFingerMntRepository.save(gafisCaseFingerMntEntity);
    }


    private void process(String flag, String fptName, byte[] data, String coverFPT) {
        if (data == null) {
            processErrorMessage.add(fptName + " | error," + flag + " , process fail , FPT 下载失败!");
            setErrorMsgCount();
            logger.error(fptName + " | error," + flag + " , process fail , FPT 下载失败!");
        } else {
            Map<String,Object> map = null;
            try {
                map = FPTFile.readFPTByteBuf(data, FPTBase.GBK_ENCODEING);
            } catch (Throwable t) {
                t.printStackTrace();
                logger.error(fptName+" , parse fpt fail , "+t.getMessage());
                processErrorMessage.add(fptName + " | error," + flag + " , process fail!"+t.getMessage());
            }
            if (map != null) {
                if (map.containsKey("fpt3")) {
                    processFPT3(flag, fptName, map, coverFPT);
                } else if (map.containsKey("fpt4")) {
                    try {
                        fptName = processFPT4(flag, fptName, map, coverFPT);
                        System.out.println(flag + " | " + fptName + " , process success!");
                        if (processMessageRate.size() > 30) {
                            Vector<String> vector = new Vector<>();
                            for (int t=0;t<20;t++) {
                                vector.add(processMessageRate.get(t));
                            }
                            processMessageRate.removeAll(vector);
                        }
                        processMessageRate.add(flag + " | " + fptName + " , process success!");
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(fptName + " | " + flag + " , process fail! " + e.getMessage());
                        processErrorMessage.add(fptName + " | error," + flag + " , process fail!"+e.getMessage());
                        setErrorMsgCount();
                    }
                }
            }
        }
    }

    @Override
    public void singleProcessFPT(String flag,String fptName, byte[] data, String coverFPT){
        if (processErrorMessage == null) processErrorMessage = new Vector<>();
        if (processMessageRate == null) processMessageRate = new Vector<>();
        process(flag, fptName, data, coverFPT);
    }

    @Override
    public void multiProcessFPT(String fileServer,List<String> fptPaths, String coverFPT) {
        if (processErrorMessage == null) processErrorMessage = new Vector<>();
        if (processMessageRate == null) processMessageRate = new Vector<>();
        pool.execute(() -> {
            try {
                int total = fptPaths.size();
                String fptPathPrefix = fileServer;
                for (int i=0;i<fptPaths.size();i++) {
                    String path = fptPaths.get(i);
                    if (!path.isEmpty()) {
                        String url = path.trim();
                        if (!url.startsWith("http")) url = fptPathPrefix + path;
                        queue.put(total + ":" + (i + 1) + "#" + url);
                    }
                }
                empty = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i=0;i<threadSize;i++) {
            pool.execute(() -> {
                while (running) {
                    try {
                        String path = queue.poll(2, TimeUnit.SECONDS);
                        if (path == null || "".equals(path)) {
                            if (empty) running = false;
                            continue;
                        }
                        String[] queuePath = path.split("#");
                        String flag = queuePath[0];
                        String url = queuePath[1];
                        byte[] data = ProtoHttpClientUtil.download(url);
                        process(flag, url, data, coverFPT);
                    } catch (InterruptedException e) {
                        logger.error("0.0 , The path poll from queue fail");
                    }
                }
            });
        }
        empty = false;running = true;
    }

    private void commonSaveCase(String flag, String caseId, String fingerId, String fingerNo, String fptName, byte[] imgData) {
        try {
            byte[] GAFISIMAGE = ProcessImageAndFeatureUtil.imageWithHead(imgData);
            GafisCaseFingerEntity caseFinger = new GafisCaseFingerEntity();
            caseFinger.setCaseId(caseId);
            caseFinger.setFingerId(fingerId);
            caseFinger.setSeqNo(fingerNo);
            caseFinger.setFptPath(fptName);
            caseFinger.setFingerImg(GAFISIMAGE);
            saveCaseFinger(caseFinger);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(fptName+" , process fpt image fail , "+ e.getMessage());
            processErrorMessage.add(fptName + " | error," + flag + " , process fail!"+e.getMessage());
            setErrorMsgCount();
        }
    }

    private List<GafisGatherFingerEntity> commonSaveGatherFinger(String personId, String fptName, Set<GafisGatherFingerEntity> set, List<GafisGatherFingerEntity> fingers, FPTProperties properties) {
        byte[] GAFISIMAGE ;
        byte[] GAFISMNT ;
        byte[] GAFISBIN ;

        ByteString decompressImage ;
        int fgp = Integer.valueOf(properties.getFgp());
        int fgpCase = fgp > 10 ? 1 : 0;
        fgp = fgp > 10 ? (fgp-10) : fgp;
        if (fgp < 1 || fgp > 10) {
            logger.error(fptName+" , "+personId+" , invalid fgp : "+fgp);
            return fingers;
        }
        GafisGatherFingerEntity fingerImage = buildGatherFinger(personId,1,1,fgpCase,fgp);     //image
        GafisGatherFingerEntity fingerFeature = buildGatherFinger(personId,0,2,fgpCase,fgp);   //feature
        GafisGatherFingerEntity fingerRidge = buildGatherFinger(personId,4,2,fgpCase,fgp);     //ridge
        if (set != null && (set.contains(fingerImage) && set.contains(fingerFeature) && set.contains(fingerRidge))) return fingers; //已入库则不再执行解压等后续操作
        try {
            glocdef.GAFISIMAGESTRUCT gafisImg = ProcessImageAndFeatureUtil.FPTFingerDataToGafisImage(properties);
            decompressImage = ProcessImageAndFeatureUtil.decompress(gafisImg, personId, fgp, 1, fptConfig.getImageUrl(), (byte) 102);
        } catch (Exception e){
            logger.error(fptName+" , decompress images fail! , "+ e.getMessage());
            processErrorMessage.add(fptName+" , decompress images fail! , "+ e.getMessage());
            e.printStackTrace();
            setErrorMsgCount();
            return fingers;
        }

        try {
            ByteString compressWSQImage = ProcessImageAndFeatureUtil.compressWSQ(decompressImage, personId, fgp, fptConfig.getImageUrl());
            GAFISIMAGE = compressWSQImage == null ? null : compressWSQImage.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(fptName+" , compress images to WSQ fail! , "+ e.getMessage());
            processErrorMessage.add(fptName+" , compress images to WSQ fail! , "+ e.getMessage());
            setErrorMsgCount();
            return fingers;
        }
        if (set == null || !set.contains(fingerImage)) {
            fingerImage.setSeq(gatherFingerRepository.getFingerSeq());
            fingerImage.setGatherData(GAFISIMAGE);
            fingers.add(fingerImage);
        }
        try {
            glocdef.GAFISIMAGESTRUCT deconpressGafisImage = new glocdef.GAFISIMAGESTRUCT();
            deconpressGafisImage.fromByteArray(decompressImage.toByteArray(), AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN);
            ByteString[] mntAndBin = ProcessImageAndFeatureUtil.extractor(deconpressGafisImage, personId, fgp, 1, fptConfig.getExtractorUrl());
            ByteString reExtractorFeature = mntAndBin[0];
            ByteString reExtractorRidge = mntAndBin[1];
            GAFISMNT = reExtractorFeature == null ? null : reExtractorFeature.toByteArray();
            GAFISBIN = reExtractorRidge == null ? null : reExtractorRidge.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(fptName + " , extractor feature fail , " + e.getMessage());
            processErrorMessage.add(fptName + " , extractor feature fail , " + e.getMessage());
            setErrorMsgCount();
            return fingers;
        }
        if (set == null || !set.contains(fingerFeature)) {
            fingerFeature.setSeq(gatherFingerRepository.getFingerSeq());
            fingerFeature.setGatherData(GAFISMNT);
            fingers.add(fingerFeature);
        }
        if (set == null || !set.contains(fingerRidge)) {
            fingerRidge.setSeq(gatherFingerRepository.getFingerSeq());
            fingerRidge.setGatherData(GAFISBIN);
            fingers.add(fingerRidge);
        }
        /*合成图像
            ByteString displayImage = ProcessImageAndFeatureUtil.display(decompressImage.toByteArray(),GAFISMNT,fptConfig.getExtractorUrl());
            byte[] GAFISDISPLAY = displayImage == null ? null : displayImage.toByteArray();
        */
        return fingers;
    }

    private void processFPT3(String flag, String fptName, Map<String,Object> map, String coverFPT) {
        FPT3File fpt3 = (FPT3File)map.get("fpt3");
        for (FPT3File.LogicLPRec logicLPRec : fpt3.getLogicLPRec()) {
            String caseId = logicLPRec.getCaseId();
            saveCase(caseId,coverFPT);
            for (FPT3File.LogicLPFinger logicLPFinger : logicLPRec.getFingers()) {
                String fingerId = logicLPRec.getCaseId() + logicLPFinger.getFingerNo();
                if (fptName.isEmpty()) fptName = fingerId;
                if (findCaseFingerByFingerId(fingerId, coverFPT)) {
                    commonSaveCase(flag,caseId,fingerId,logicLPFinger.getFingerNo(),fptName,logicLPFinger.getImgData());
                }
                if (findCaseFingerMntByFingerId(fingerId, coverFPT)) {
                    try {
                        logicLPFinger.setFeature(logicLPFinger.getFeature().replaceAll("\u0000"," "));//特征中替换UNICODE 编码的空格
                        logicLPFinger.setFeatureCount(logicLPFinger.getFeatureCount().isEmpty() ? "0" : logicLPFinger.getFeatureCount());
                        ByteString converterFeature = ProcessImageAndFeatureUtil.latentConverterExtractorForFPT3(logicLPFinger, logicLPRec.getCaseId(), fingerId, fptConfig.getExtractorUrl());
                        byte[] GAFISMNT = converterFeature == null ? null : converterFeature.toByteArray();
                        GafisCaseFingerMntEntity caseFingerMnt = new GafisCaseFingerMntEntity();
                        caseFingerMnt.setFingerId(fingerId);
                        caseFingerMnt.setFingerMnt(GAFISMNT);
                        saveCaseFingerMnt(caseFingerMnt);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(fptName+" , process fpt feature fail , "+ e.getMessage());
                        processErrorMessage.add(fptName + " | error," + flag + " , process fail!"+e.getMessage());
                        setErrorMsgCount();
                    }
                }
                /*ByteString displayImage = ProcessImageAndFeatureUtil.display(GAFISIMAGE, GAFISMNT, fptConfig.getExtractorUrl());
                byte[] GAFISDISPLAY = displayImage == null ? null : displayImage.toByteArray();*/
            }
        }

        for (FPT3File.LogicTPRec logicTPRec : fpt3.getLogicTPRec()) {
            String personId = logicTPRec.getPersonId();
            if (fptName.isEmpty()) fptName = personId;
            savePerson(personId,fptName,coverFPT);
            Set<GafisGatherFingerEntity> set = this.queryGafisGatherFinger(personId);
            List<GafisGatherFingerEntity> fingers = new ArrayList<>();
            for (FPT3File.LogicTPFinger logicTPFinger :logicTPRec.getFingers()) {
                FPTProperties properties = new FPTProperties(logicTPFinger.getImgCompressMethod(), logicTPFinger.getImgHorizontalLength(), logicTPFinger.getImgVerticalLength(), logicTPFinger.getDpi(), logicTPFinger.getFgp(), logicTPFinger.getImgData());
                fingers = commonSaveGatherFinger(personId, fptName, set, fingers, properties);
            }
            this.saveGatherFinger(fingers);
        }

    }
    private String processFPT4(String flag, String fptName, Map<String,Object> map, String coverFPT){
        FPT4File fpt4 = (FPT4File) map.get("fpt4");
        for (FPT4File.LogicLPRec logicLPRec : fpt4.getLogicLPRec()) {
            String caseId = logicLPRec.getCaseId();
            saveCase(caseId,coverFPT);
            for (FPT4File.LogicLPFinger logicLPFinger : logicLPRec.getFingers()) {
                String fingerId = logicLPRec.getCaseId() + logicLPFinger.getFingerNo();
                if (fptName.isEmpty()) fptName = fingerId;
                if (findCaseFingerByFingerId(fingerId, coverFPT)) {
                    commonSaveCase(flag,caseId,fingerId,logicLPFinger.getFingerNo(),fptName,logicLPFinger.getImgData());
                }
                if (findCaseFingerMntByFingerId(fingerId, coverFPT)) {
                    try {
                        logicLPFinger.setFeature(logicLPFinger.getFeature().replaceAll("\u0000"," "));//特征中替换UNICODE 编码的空格
                        logicLPFinger.setFeatureCount(logicLPFinger.getFeatureCount().isEmpty() ? "0" : logicLPFinger.getFeatureCount());
                        ByteString converterFeature = ProcessImageAndFeatureUtil.latentConverterExtractorForFPT4(logicLPFinger, logicLPRec.getCaseId(), fingerId, fptConfig.getExtractorUrl());
                        byte[] GAFISMNT = converterFeature == null ? null : converterFeature.toByteArray();
                        GafisCaseFingerMntEntity caseFingerMnt = new GafisCaseFingerMntEntity();
                        caseFingerMnt.setFingerId(fingerId);
                        caseFingerMnt.setFingerMnt(GAFISMNT);
                        saveCaseFingerMnt(caseFingerMnt);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(fptName+" , process fpt feature fail , "+ e.getMessage());
                        processErrorMessage.add(fptName + " | error," + flag + " , process fail!"+e.getMessage());
                        setErrorMsgCount();
                    }
                }
                /*ByteString displayImage = ProcessImageAndFeatureUtil.display(GAFISIMAGE, GAFISMNT, fptConfig.getExtractorUrl());
                byte[] GAFISDISPLAY = displayImage == null ? null : displayImage.toByteArray();*/

            }
        }

        for (FPT4File.LogicTPRec logicTPRec : fpt4.getLogicTPRec()) {
            String personId = logicTPRec.getPersonId();
            if (fptName.isEmpty()) fptName = personId;
            savePerson(personId, fptName,coverFPT);
            Set<GafisGatherFingerEntity> set = this.queryGafisGatherFinger(personId);
            List<GafisGatherFingerEntity> fingers = new ArrayList<>();
            for (FPT4File.LogicTPFinger logicTPFinger :logicTPRec.getFingers()) {
                FPTProperties properties = new FPTProperties(logicTPFinger.getImgCompressMethod(), logicTPFinger.getImgHorizontalLength(), logicTPFinger.getImgVerticalLength(), logicTPFinger.getDpi(), logicTPFinger.getFgp(), logicTPFinger.getImgData());
                fingers = commonSaveGatherFinger(personId, fptName, set, fingers, properties);
            }
            this.saveGatherFinger(fingers);
        }
        return fptName;
    }

    private GafisGatherFingerEntity buildGatherFinger(String personId,int groupId,int lobType,int fgpCase,int fgp) {
        GafisGatherFingerEntity data = new GafisGatherFingerEntity();
        data.setPkId(UUID.randomUUID().toString().replace("-",""));
        data.setPersonId(personId);
        data.setFgpCase(fgpCase+"");
        data.setFgp(fgp>10?fgp-10:fgp);
        data.setInputtime(getCurrentDate());
        data.setGroupId(groupId);
        data.setLobtype(lobType);
        return data;
    }


    @Override
    public List<String> getValidSyncErrorList(List<String> keysList, String dataType, String url, boolean isRidge) {
        List<String> syncInvalidList = new ArrayList<>();
        for (String key : keysList) {
            key = key.trim();
            if ("person".equals(dataType) || "template_finger".equals(dataType)) {
                GafisPersonEntity personEntity = personRepository.findByPersonid(key);
                if (personEntity == null || personEntity.getSid() == null){
                    syncInvalidList.add("【"+dataType+"】|" + key + "| SID IS NULL");
                    continue;
                }
                int sid = personEntity.getSid().intValue();
                if ("person".equals(dataType)) {
                    String status = validSync(url, dataType, sid, 1, isRidge);
                    if ("FAIL".equals(status)) syncInvalidList.add("【"+dataType+"】|" + key + "|" + sid);
                } else {
                    List<GafisGatherFingerEntity> gatherFingerEntities;
                    if (isRidge) gatherFingerEntities = gatherFingerRepository.findByPersonIdAndGroupId(key,4);
                    else gatherFingerEntities = gatherFingerRepository.findByPersonIdAndGroupId(key,0);
                    if (gatherFingerEntities == null) {
                        syncInvalidList.add("【"+dataType+"】|" + key + "| FINGER IS NULL");
                        continue;
                    }
                    for (GafisGatherFingerEntity gatherFingerEntity : gatherFingerEntities) {
                        int fgp = gatherFingerEntity.getFgp();
                        String fgpCase = gatherFingerEntity.getFgpCase();
                        if ("1".equals(fgpCase)) fgp += 10;
                        String status = validSync(url, dataType, sid, fgp, isRidge);
                        if ("FAIL".equals(status)) {
                            syncInvalidList.add("【"+dataType+"】|" + key + "|" + sid + "|" + fgp);
                        }
                    }
                }
            } else if ("latent_finger".equals(dataType)) {
                GafisCaseFingerEntity caseFingerEntity = gafisCaseFingerRepository.findByFingerId(key);
                if (caseFingerEntity == null  || caseFingerEntity.getSid() == null) {
                    syncInvalidList.add("【"+dataType+"】|" + key + "| SID IS NULL");
                    continue;
                }
                int sid = caseFingerEntity.getSid().intValue();
                String status = validSync(url, dataType, sid, 1, isRidge);
                if ("FAIL".equals(status)) syncInvalidList.add("【"+dataType+"】|" + key + "|" + sid);
            }

        }
        return syncInvalidList;
    }

    private String validSync(String url,String dataType, int sid, int fgp, boolean isRidge) {
        String http = url + "?data_type="+dataType+"&sid="+sid+"&fgp="+fgp+"&is_ridge="+isRidge;
        byte[] sync = ProtoHttpClientUtil.download(http);
        String s = new String(sync, Charset.forName("UTF-8"));
        try {
            JSONObject jsonObject = new JSONObject(s);
            Object o = jsonObject.get("status");
            return o.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "FAIL";
        }
    }

    public String reSync(String syncType, List<String> reSyncList){
        try {
            for (String key : reSyncList) {
                key = key.trim();
                if ("person".equals(syncType)) {
                    GafisPersonEntity personEntity = personRepository.findByPersonid(key);
                    personEntity.setSeq(personRepository.getPersonSeq());
                    personRepository.save(personEntity);
                } else if ("templateFinger".equals(syncType)) {
                    List<GafisGatherFingerEntity> gatherFingerEntities = gatherFingerRepository.findByPersonId(key);
                    for (GafisGatherFingerEntity gatherFingerEntity : gatherFingerEntities) {
                        gatherFingerEntity.setSeq(gatherFingerRepository.getFingerSeq());
                        gatherFingerRepository.save(gatherFingerEntity);
                    }
                } else if ("caseFinger".equals(syncType)) {
                    GafisCaseFingerEntity caseFingerEntity = gafisCaseFingerRepository.findByFingerId(key);
                    caseFingerEntity.setSeq(gafisCaseFingerRepository.getCaseFingerSeq());
                    gafisCaseFingerRepository.save(caseFingerEntity);
                }
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }
}

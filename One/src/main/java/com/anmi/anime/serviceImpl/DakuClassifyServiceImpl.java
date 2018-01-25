package com.anmi.anime.serviceImpl;

import com.anmi.anime.fpt.FPT3File;
import com.anmi.anime.fpt.FPT4File;
import com.anmi.anime.fpt.FPTBase;
import com.anmi.anime.fpt.FPTFile;
import com.anmi.anime.model.*;
import com.anmi.anime.model.vo.PairsClassifyVO;
import com.anmi.anime.repository.daku.*;
import com.anmi.anime.service.DakuClassifyService;
import com.anmi.anime.utils.ProtoHttpClientUtil;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.gloclib.glocdef;
import nirvana.hall.c.services.kernel.mnt_checker_def;
import nirvana.hall.extractor.internal.FeatureExtractorImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.ByteOrder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangjue on 2017/11/28.
 */
@Service("dakuClassifyService")
public class DakuClassifyServiceImpl implements DakuClassifyService {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private GafisDakuPairsClassifyRepository gafisDakuPairsClassifyRepository;

    @Autowired
    private GafisDakuTemplateClassifyRepository gafisDakuTemplateClassifyRepository;

    @Autowired
    private GafisDakuLatentClassifyRepository gafisDakuLatentClassifyRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GatherFingerRepository gatherFingerRepository;

    @Autowired
    private GafisCaseFingerMntRepository gafisCaseFingerMntRepository;

    private synchronized Date getCurrentDate() {
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(tz);
        return new Date();
    }


    @Override
    public Page<GafisDakuLatentClassifyEntity> findLatentClassify(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return gafisDakuLatentClassifyRepository.findAll(pageable);
    }

    @Override
    public Page<GafisDakuTemplateClassifyEntity> findTemplateClassify(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return gafisDakuTemplateClassifyRepository.findAll(pageable);
    }


    @Override
    public List<GafisDakuPairsClassifyEntity> findPairsClassify(PairsClassifyVO pairsClassifyVO) {
        Pageable pageable = new PageRequest(pairsClassifyVO.getPage(),pairsClassifyVO.getSize());
        if ("tt".equals(pairsClassifyVO.getPairType())) {
            List<String> templates = gafisDakuTemplateClassifyRepository.findTemplateCard(pairsClassifyVO);
            List<GafisDakuPairsClassifyEntity> pairsClassifyEntities = gafisDakuPairsClassifyRepository.findByMatchType("tt");
            //List<GafisDakuPairsClassifyEntity> list = pairsClassifyEntities.stream().filter(t -> templates.contains(t.getQuerykey())).skip(10).limit(10).collect(Collectors.toList());
            List<GafisDakuPairsClassifyEntity> list = pairsClassifyEntities.stream().filter(t -> templates.contains(t.getQuerykey())).collect(Collectors.toList());
            return list;
            //return gafisDakuPairsClassifyRepository.findByQuerykeyIn(templates,pageable);
        } else if ("lt".equals(pairsClassifyVO.getPairType())) {
            List<String> latents = gafisDakuLatentClassifyRepository.findLatentCard(pairsClassifyVO);
            List<GafisDakuPairsClassifyEntity> pairsClassifyEntities = gafisDakuPairsClassifyRepository.findByMatchType("lt");
            List<GafisDakuPairsClassifyEntity> list = pairsClassifyEntities.stream().filter(t -> latents.contains(t.getQuerykey())).collect(Collectors.toList());
            return list;
            //return gafisDakuPairsClassifyRepository.findByQuerykeyIn(latents,pageable);
        }
        return null;
    }

    private void savePairsClassifyEntity(String queryKey, String matchKey, String score, String rank, String matchindex, String description, String matchType) {
        GafisDakuPairsClassifyEntity pairsClassifyEntity = new GafisDakuPairsClassifyEntity();
        pairsClassifyEntity.setPkid(UUID.randomUUID().toString().replace("-",""));
        pairsClassifyEntity.setQuerykey(queryKey);
        pairsClassifyEntity.setMatchkey(matchKey);
        pairsClassifyEntity.setScore(Long.valueOf(score));
        pairsClassifyEntity.setCreatetime(getCurrentDate());
        pairsClassifyEntity.setRank(rank.isEmpty()?0:Long.valueOf(rank));
        pairsClassifyEntity.setMatchindex(matchindex.isEmpty()?0:Long.valueOf(matchindex));
        pairsClassifyEntity.setDescription(description);
        pairsClassifyEntity.setMatchType(matchType);
        gafisDakuPairsClassifyRepository.save(pairsClassifyEntity);
    }

    private void saveTemplateClassify(String key) {
        List<GafisDakuTemplateClassifyEntity> list = new ArrayList<>();
        List<GafisGatherFingerEntity> fingers = gatherFingerRepository.findByPersonIdAndGroupId(key, 0);
        fingers.forEach(t -> {
            String cardId = t.getPersonId();
            String fgpCase = t.getFgpCase();
            int fgp = t.getFgp();
            fgp = "0".equals(fgpCase) ? fgp : (fgp+10);
            if (gafisDakuTemplateClassifyRepository.findByCardidAndFgp(cardId,fgp).size() == 0) {
                GafisDakuTemplateClassifyEntity templateClassifyEntity = buildTemplateClassify(t);
                list.add(templateClassifyEntity);
            }
        });
        if (list.size() != 0) {
            list.forEach(t -> gafisDakuTemplateClassifyRepository.save(t));
        }
    }

    private void saveLatentClassify(String key, String firmCode) {
        List<GafisDakuLatentClassifyEntity> list = new ArrayList<>();
        List<GafisCaseFingerMntEntity> caseFingers =  gafisCaseFingerMntRepository.findByfingerIdAndMainMnt(key,"1");
        caseFingers.forEach(t -> {
            if (gafisDakuLatentClassifyRepository.findByCardid(t.getFingerId()).size() == 0) {
                GafisDakuLatentClassifyEntity latentClassifyEntity = buildLatentClassify(t, firmCode);
                list.add(latentClassifyEntity);
            }
        });
        if (list.size() != 0) {
            list.forEach(t -> gafisDakuLatentClassifyRepository.save(t));
        }
    }

    @Override
    public void classify(List<String> cards, String cardType) {
        nirvana.hall.extractor.jni.JniLoader.loadJniLibrary(".",null);
        for (String card : cards) {
            if ("tt".equals(cardType)) {
                String[] lines = card.split(" ");
                String queryKey = lines[0].trim();
                String matchKey = lines[1].trim();
                String score = lines[2].trim();
                savePairsClassifyEntity(queryKey,matchKey,score,"","","",cardType);
                saveTemplateClassify(queryKey);
                saveTemplateClassify(matchKey);
            } else if ("lt".equals(cardType)) {
                String[] lines = card.split(" ");
                String queryKey = lines[0].trim();
                String matchKey = lines[1].trim();
                String[] keyAndFgp = matchKey.split("_");
                String rank = lines[2].trim();
                String score = lines[3].trim();
                String firmCode = lines[4].trim();
                savePairsClassifyEntity(queryKey,keyAndFgp[0],score,rank,keyAndFgp[1],"",cardType);
                saveLatentClassify(queryKey,firmCode);
                saveTemplateClassify(keyAndFgp[0]);
            }
        }
    }

    //转换为显示特征
    private mnt_checker_def.MNTDISPSTRUCT mntStdToMntDisp(byte[] mnt) {
        FeatureExtractorImpl featureExtractor = new FeatureExtractorImpl();
        glocdef.GAFISIMAGESTRUCT gafismnttruct = new glocdef.GAFISIMAGESTRUCT();
        gafismnttruct.fromByteArray(mnt, AncientConstants.UTF8_ENCODING(), ByteOrder.BIG_ENDIAN);
        mnt_checker_def.MNTDISPSTRUCT mntdisp = featureExtractor.GAFIS_MntStdToMntDisp(gafismnttruct);
        return mntdisp;
    }

    //现场候选纹型转换
    //fgrp 四字节 (x,x,x,x) 0:不确定 | 1:弓型;2:左箕;3:右箕;4:斗; x为1则对应代表纹型
    private String byteToFgrpDisp(byte[] rpCode) {
        String rpCodes = "";
        if (rpCode == null || rpCode.length != 4) return "0";
        if (rpCode[0] == 1) rpCodes += "1,";
        if (rpCode[1] == 1) rpCodes += "2,";
        if (rpCode[2] == 1) rpCodes += "3,";
        if (rpCode[3] == 1) rpCodes += "4,";
        if (!rpCodes.isEmpty()) rpCodes = rpCodes.substring(0,rpCodes.length()-1);
        else rpCodes = "0";
        return rpCodes;
    }

    private GafisDakuTemplateClassifyEntity buildTemplateClassify(GafisGatherFingerEntity finger) {
        GafisDakuTemplateClassifyEntity templateClassifyEntity = new GafisDakuTemplateClassifyEntity();
        byte[] mnt = finger.getGatherData();
        mnt_checker_def.MNTDISPSTRUCT mntdisp = mntStdToMntDisp(mnt);
        short mntCount = mntdisp.stCm().nMntCnt();
        byte imgqlev = mntdisp.FeatQlev().ImgQlev();
        byte rpqlev = mntdisp.FeatQlev().RpQlev();
        byte coreqlev = mntdisp.FeatQlev().CoreQlev();
        byte vcoreqlev = mntdisp.FeatQlev().VCoreQlev();
        byte ldeltaqlev = mntdisp.FeatQlev().LDeltaQlev();
        byte rdeltaqlev = mntdisp.FeatQlev().RDeltaQlev();
        byte mainPattern = mntdisp.stFg().rp();
        byte vicePattern = mntdisp.stFg().vrp();
        templateClassifyEntity.setPkid(UUID.randomUUID().toString().replace("-",""));
        templateClassifyEntity.setCardid(finger.getPersonId());
        long fgp = finger.getFgp().longValue();
        fgp = "0".equals(finger.getFgpCase()) ? fgp : (fgp+10);
        templateClassifyEntity.setFgp(fgp);
        templateClassifyEntity.setMntcount(Long.valueOf(mntCount));
        templateClassifyEntity.setImgqlev(Long.valueOf(imgqlev));
        templateClassifyEntity.setRpqlev(Long.valueOf(rpqlev));
        templateClassifyEntity.setCoreqlev(Long.valueOf(coreqlev));
        templateClassifyEntity.setVcoreqlev(Long.valueOf(vcoreqlev));
        templateClassifyEntity.setLdeltaqlev(Long.valueOf(ldeltaqlev));
        templateClassifyEntity.setRdeltaqlev(Long.valueOf(rdeltaqlev));
        templateClassifyEntity.setMainPattern(Long.valueOf(mainPattern));
        templateClassifyEntity.setVicePattern(Long.valueOf(vicePattern));
        templateClassifyEntity.setCreatetime(getCurrentDate());
        templateClassifyEntity.setModifytime(getCurrentDate());
        templateClassifyEntity.setWidth(Long.valueOf(mntdisp.nWidth()));
        templateClassifyEntity.setHeight(Long.valueOf(mntdisp.nHeight()));
        templateClassifyEntity.setResolution(Long.valueOf(mntdisp.nResolution()));
        return templateClassifyEntity;
    }
    private GafisDakuLatentClassifyEntity buildLatentClassify(GafisCaseFingerMntEntity caseFingerMnt,String firmCode) {
        GafisDakuLatentClassifyEntity latentClassifyEntity = new GafisDakuLatentClassifyEntity();
        byte[] mnt = caseFingerMnt.getFingerMnt();
        mnt_checker_def.MNTDISPSTRUCT mntdisp = mntStdToMntDisp(mnt);
        short mntCount = mntdisp.stCm().nMntCnt();
        byte imgqlev = mntdisp.FeatQlev().ImgQlev();
        byte rpqlev = mntdisp.FeatQlev().RpQlev();
        String fgp = mntdisp.stFg().FingerCode();//候选指位
        byte[] rpCode = mntdisp.stFg().RpCode();//候选纹型
        String rpCodes = byteToFgrpDisp(rpCode);

        latentClassifyEntity.setPkid(UUID.randomUUID().toString().replace("-",""));
        latentClassifyEntity.setCardid(caseFingerMnt.getFingerId());
        latentClassifyEntity.setMntcount(Long.valueOf(mntCount));
        latentClassifyEntity.setImgqlev(Long.valueOf(imgqlev));
        latentClassifyEntity.setRpqlev(Long.valueOf(rpqlev));
        latentClassifyEntity.setPattern(rpCodes);
        latentClassifyEntity.setFgp(fgp);
        latentClassifyEntity.setWidth(Long.valueOf(mntdisp.nWidth()));
        latentClassifyEntity.setHeight(Long.valueOf(mntdisp.nHeight()));
        latentClassifyEntity.setResolution(Long.valueOf(mntdisp.nResolution()));
        latentClassifyEntity.setCreatetime(getCurrentDate());
        latentClassifyEntity.setModifytime(getCurrentDate());
        latentClassifyEntity.setFirmcode(firmCode);

        return latentClassifyEntity;
    }

    @Override
    public void classify(List<String> cards, String cardType,String http) {
        for (String card : cards) {
            if ("template".equals(cardType)) {
                GafisPersonEntity personEntity = personRepository.findByPersonid(card);
                String fptPath = personEntity.getFptPath();
                if (!fptPath.startsWith("http")) fptPath = http + fptPath;
                byte[] data = ProtoHttpClientUtil.download(fptPath);
                Map<String,Object> map = null;
                try {
                    map = FPTFile.readFPTByteBuf(data, FPTBase.GBK_ENCODEING);
                } catch (Throwable t) {
                    t.printStackTrace();
                    logger.error(card +" ,classify parse fpt fail , "+t.getMessage());
                }
                if (map != null) {
                    if (map.containsKey("fpt3")) {
                        FPT3File fpt3 = (FPT3File)map.get("fpt3");
                        System.out.println("fpt3 -- SendUnitCode:"+fpt3.getSendUnitCode()+" , SendUnitName:"+fpt3.getSendUnitName()+" , SendUnitSystemType:"+fpt3.getSendUnitSystemType()+" , ReceiveUnitCode:"+fpt3.getReceiveUnitCode());
                    } else if (map.containsKey("fpt4")) {
                        FPT4File fpt4 = (FPT4File) map.get("fpt4");
                        System.out.println("fpt4 -- SendUnitCode:"+fpt4.getSendUnitCode()+" , SendUnitName:"+fpt4.getSendUnitName()+" , SendUnitSystemType:"+fpt4.getSendUnitSystemType()+" , ReceiveUnitCode:"+fpt4.getReceiveUnitCode());
                    }
                }
            }
        }
    }
}

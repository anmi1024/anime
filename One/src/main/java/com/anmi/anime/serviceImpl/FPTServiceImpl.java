package com.anmi.anime.serviceImpl;

import com.anmi.anime.config.FPTConfig;
import com.anmi.anime.fpt.FPT4File;
import com.anmi.anime.model.GafisCaseFingerEntity;
import com.anmi.anime.model.GafisGatherFingerEntity;
import com.anmi.anime.model.GafisPersonEntity;
import com.anmi.anime.repository.daku.*;
import com.anmi.anime.service.FPTService;
import com.anmi.anime.utils.ProtoHttpClientUtil;
import nirvana.hall.c.AncientConstants;
import nirvana.hall.c.services.AncientData;
import nirvana.hall.c.services.gloclib.glocdef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjue on 2017/10/24.
 */
@Service("fptService")
public class FPTServiceImpl implements FPTService{
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

    @Override
    public void export(List<String> kIds) {
        FPT4File fpt4 = new FPT4File();
        List<FPT4File.LogicTPRec> tps = new ArrayList<>();
        List<FPT4File.LogicTPFinger> tpFingers = new ArrayList<>();

        for (String kid : kIds) {
            FPT4File.LogicTPRec tp = new FPT4File().new LogicTPRec();
            FPT4File.LogicTPFinger tpFinger = new FPT4File().new LogicTPFinger();
            List<GafisGatherFingerEntity> gatherFingerEntities = gatherFingerRepository.findByPersonIdAndGroupId(kid, 0);
            for (GafisGatherFingerEntity gatherFingerEntity : gatherFingerEntities) {
                int fgp = gatherFingerEntity.getFgp();
                String fgpCase = gatherFingerEntity.getFgpCase();
                byte[] gatherData = gatherFingerEntity.getGatherData();
                glocdef.GAFISIMAGESTRUCT feature = new glocdef.GAFISIMAGESTRUCT();
                feature.fromByteArray(gatherData, AncientConstants.GBK_ENCODING(), ByteOrder.BIG_ENDIAN);
                //FPTMntConverter
            }
        }
    }

    public byte[] downloadFPTByKeyId(String keyId, String type, String fptPathServer) {
        String fptPath = "";
        if ("template".equals(type)) {
            GafisPersonEntity personEntity = personRepository.findByPersonid(keyId);
            if (personEntity != null)
                fptPath = personEntity.getFptPath();
        } else {
            GafisCaseFingerEntity caseFingerEntity = gafisCaseFingerRepository.findByFingerId(keyId);
            if (caseFingerEntity != null)
                fptPath = caseFingerEntity.getFptPath();
        }
        if (!fptPath.isEmpty()) {
            if (!fptPath.startsWith("http")) fptPath = fptPathServer + fptPath;
            byte[] data = ProtoHttpClientUtil.download(fptPath);
            return data;
        }
        return null;
    }
}

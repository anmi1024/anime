package com.anmi.anime.scheduler;

import com.anmi.anime.model.GafisDakuQueryqueEntity;
import com.anmi.anime.service.GafisNormalqueryQueryqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangjue on 2017/10/31.
 */
@Component
public class QueryQueueMatchStatuesScheduler {

    @Autowired
    GafisNormalqueryQueryqueService normalqueryQueryqueService;

    @Scheduled(cron = "*/60 * * * * ?")
    public void modifyQueryQueueMatchStatues() {
        List<GafisDakuQueryqueEntity> queryqueEntityList = normalqueryQueryqueService.getQueryqueueNotMatched();
        queryqueEntityList.forEach(t -> normalqueryQueryqueService.queryMatchFinish(t));
    }
}

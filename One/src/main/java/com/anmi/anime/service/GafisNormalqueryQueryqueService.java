package com.anmi.anime.service;

import com.anmi.anime.model.GafisDakuQueryqueEntity;
import com.anmi.anime.model.GafisNormalqueryQueryqueEntity;
import com.anmi.anime.model.vo.AnalyzeVO;
import com.anmi.anime.model.vo.QueryQueueVO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Vector;

/**
 * Created by wangjue on 2017/9/14.
 */
public interface GafisNormalqueryQueryqueService {
    void sendQuery(QueryQueueVO queryQueueVO);
    int getErrorMsgCount();
    Vector<String> getProcessMessage();
    Vector<String> getProcessErrorMessage();
    void setClearCollect();

    String getMatchResult(QueryQueueVO queryQueueVO);

    List<String> getValidSuccessList(List<String> keysList, QueryQueueVO queryQueueVO);

    GafisDakuQueryqueEntity getGafisDakuQueryqueEntity(String pkId);

    /**
     * 获取所有比对队列
     * @return
     */
    List<GafisDakuQueryqueEntity> getQueryqueue();

    /**
     * 分页获取所有比对队列
     * @return
     */
    Page<GafisDakuQueryqueEntity> getPageQueryqueue(int page, int size);

    /**
     * 获取未完成比对队列
     * @return
     */
    List<GafisDakuQueryqueEntity> getQueryqueueNotMatched();

    /**
     * 队列任务是否全部比对完成
     */
    void queryMatchFinish(GafisDakuQueryqueEntity queryqueEntity);

    void modifyQueryCandListDirByPkId(String queryCandListDir, String pkId);

    AnalyzeVO getAnalyzeResult(List<String> truePairList, String pkid);
}

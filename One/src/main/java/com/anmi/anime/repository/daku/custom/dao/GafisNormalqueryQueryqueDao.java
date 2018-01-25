package com.anmi.anime.repository.daku.custom.dao;

import java.util.List;

/**
 * Created by wangjue on 2017/9/20.
 */
public interface GafisNormalqueryQueryqueDao {

    int getSeqOraSid();

    List<Object> getMatchBeginAndFinishTimeAndAlgotithmQuerySpeed(long storage, int oraSidBegin, int oraSidEnd);

}

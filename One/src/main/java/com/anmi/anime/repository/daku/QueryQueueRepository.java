package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisDakuQueryqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by wangjue on 2017/10/19.
 */
public interface QueryqueueRepository extends JpaRepository<GafisDakuQueryqueEntity,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE GafisDakuQueryqueEntity t SET t.orasidStart = ?1 ,t.orasidEnd = ?2 ,t.statues=1, t.finishTime = SYSDATE WHERE t.pkid = ?3")
    int modifyByOrasidStartAndOrasidEndAndPkid(Long orasidStart, Long orasidEnd, String pkid);

    @Transactional
    @Modifying
    @Query("UPDATE GafisDakuQueryqueEntity t SET t.queryCandListDir = ?1 WHERE t.pkid = ?2")
    int modifyByQueryCandListDirAndPkid(String queryCandListDir, String pkid);

    GafisDakuQueryqueEntity findByPkid(String pkid);

    List<GafisDakuQueryqueEntity> findByMatchStatuesNot(Long matchStatues);

}

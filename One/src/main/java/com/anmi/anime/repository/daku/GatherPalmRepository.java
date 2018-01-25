package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisGatherPalmEntity;
import com.anmi.anime.repository.daku.custom.dao.GatherDataDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangjue on 2017/9/14.
 */
public interface GatherPalmRepository extends JpaRepository<GafisGatherPalmEntity,Long> ,GatherDataDao{
    List<GafisGatherPalmEntity> findByPersonId(String personId);

    @Query(value = "SELECT * FROM gafis_gather_palm t WHERE t.fgp IN (11,12) AND t.group_id IN (0,1) AND t.person_id = ?1",nativeQuery = true)
    List<GafisGatherPalmEntity> findByPersonIdAndFgpInAndGroupIdIn(String personId);
}

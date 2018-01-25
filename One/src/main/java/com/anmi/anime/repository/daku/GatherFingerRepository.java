package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisGatherFingerEntity;
import com.anmi.anime.repository.daku.custom.dao.GatherDataDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangjue on 2017/9/14.
 */
public interface GatherFingerRepository extends JpaRepository<GafisGatherFingerEntity,Long>,GatherDataDao {

    List<GafisGatherFingerEntity> findByPersonId(String personId);

    List<GafisGatherFingerEntity> findByPersonIdAndGroupId(String personId, int groupId);

    @Transactional
    @Modifying
    @Query("DELETE FROM GafisGatherFingerEntity t WHERE t.personId = ?1")
    int deleteBypersonId(String personId);

}

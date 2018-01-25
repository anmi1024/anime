package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisCaseFingerEntity;
import com.anmi.anime.repository.daku.custom.dao.GatherDataDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangjue on 2017/9/25.
 */
public interface GafisCaseFingerRepository extends JpaRepository<GafisCaseFingerEntity,Long>,GatherDataDao {

    GafisCaseFingerEntity findByFingerId(String fingerId);
}

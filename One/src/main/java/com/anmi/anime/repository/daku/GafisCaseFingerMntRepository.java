package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisCaseFingerMntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangjue on 2017/9/20.
 */
public interface GafisCaseFingerMntRepository extends JpaRepository<GafisCaseFingerMntEntity,Long> {

    List<GafisCaseFingerMntEntity> findByfingerIdAndMainMnt(String fingerId,String mainMnt);
}

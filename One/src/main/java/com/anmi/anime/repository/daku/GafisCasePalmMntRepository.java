package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisCasePalmMntEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangjue on 2017/9/20.
 */
public interface GafisCasePalmMntRepository extends JpaRepository<GafisCasePalmMntEntity,Long> {

    List<GafisCasePalmMntEntity> findByPalmIdAndMainMnt(String palmId,String mainMnt);
}

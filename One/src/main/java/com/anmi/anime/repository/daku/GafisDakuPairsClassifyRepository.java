package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisDakuPairsClassifyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangjue on 2017/12/7.
 */
public interface GafisDakuPairsClassifyRepository extends JpaRepository<GafisDakuPairsClassifyEntity,Long> {
    Page<GafisDakuPairsClassifyEntity> findByQuerykeyIn(List<String> keys, Pageable pageable);

    List<GafisDakuPairsClassifyEntity> findByMatchType(String matchType);
}

package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangjue on 2017/9/25.
 */
public interface GafisCaseRepository extends JpaRepository<GafisCaseEntity,Long> {
    GafisCaseEntity findByCaseId(String caseId);
}

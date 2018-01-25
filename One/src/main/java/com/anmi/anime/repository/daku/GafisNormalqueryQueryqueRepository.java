package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisNormalqueryQueryqueEntity;
import com.anmi.anime.repository.daku.custom.dao.GafisNormalqueryQueryqueDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangjue on 2017/9/14.
 */
public interface GafisNormalqueryQueryqueRepository extends JpaRepository<GafisNormalqueryQueryqueEntity,Long>,GafisNormalqueryQueryqueDao {

    List<GafisNormalqueryQueryqueEntity> findByOraSidBetween(int oraSidS, int oraSidE);

    List<GafisNormalqueryQueryqueEntity> findByOraSidBetweenAndFinishtimeIsNull(int oraSidStart, int oraSidEnd);
}

package com.anmi.anime.repository.daku.custom.impl;

import com.anmi.anime.model.vo.PairsClassifyVO;
import com.anmi.anime.repository.daku.custom.dao.DakuClassifyDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by wangjue on 2017/12/7.
 */
public class GafisDakuLatentClassifyRepositoryImpl implements DakuClassifyDao {
    @PersistenceContext(unitName = "dakuPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public List<String> findTemplateCard(PairsClassifyVO pairsClassifyVO) {
        return null;
    }

    @Override
    public List<String> findLatentCard(PairsClassifyVO pairsClassifyVO) {
        StringBuffer sb = new StringBuffer("SELECT t.cardid FROM gafis_daku_latent_classify t WHERE 1=1");
        if (pairsClassifyVO.getMntCount() != null) sb.append(" AND t.mntcount >= ").append(pairsClassifyVO.getMntCount());
        if (pairsClassifyVO.getMntCountLess() != null) sb.append(" AND t.mntcount <= ").append(pairsClassifyVO.getMntCountLess());
        if (pairsClassifyVO.getImgqlev() != null) sb.append(" AND t.imgqlev >= ").append(pairsClassifyVO.getImgqlev());
        if (pairsClassifyVO.getImgqlevLess() != null) sb.append(" AND t.imgqlev <= ").append(pairsClassifyVO.getImgqlevLess());
        if (pairsClassifyVO.getRpqlev() != null) sb.append(" AND t.rpqlev >= ").append(pairsClassifyVO.getRpqlev());
        if (pairsClassifyVO.getRpqlevLess() != null) sb.append(" AND t.rpqlev <= ").append(pairsClassifyVO.getRpqlevLess());
        String sql = sb.toString();
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        return list;
    }
}

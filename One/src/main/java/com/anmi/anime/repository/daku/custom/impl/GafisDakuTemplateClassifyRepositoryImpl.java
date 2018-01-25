package com.anmi.anime.repository.daku.custom.impl;

import com.anmi.anime.model.vo.PairsClassifyVO;
import com.anmi.anime.repository.daku.custom.dao.DakuClassifyDao;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by wangjue on 2017/12/7.
 */
public class GafisDakuTemplateClassifyRepositoryImpl implements DakuClassifyDao {
    @PersistenceContext(unitName = "dakuPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public List<String> findTemplateCard(PairsClassifyVO pairsClassifyVO) {
        StringBuffer sb = new StringBuffer("SELECT DISTINCT(t.cardid) FROM gafis_daku_template_classify t GROUP BY t.cardid HAVING 1=1");
        if (pairsClassifyVO.getMntCount() != null) sb.append(" AND AVG(t.mntcount) >= ").append(pairsClassifyVO.getMntCount());
        if (pairsClassifyVO.getMntCountLess() != null) sb.append(" AND AVG(t.mntcount) <= ").append(pairsClassifyVO.getMntCountLess());
        if (pairsClassifyVO.getImgqlev() != null) sb.append(" AND AVG(t.imgqlev) >= ").append(pairsClassifyVO.getImgqlev());
        if (pairsClassifyVO.getImgqlevLess() != null) sb.append(" AND AVG(t.imgqlev) <= ").append(pairsClassifyVO.getImgqlevLess());
        if (pairsClassifyVO.getRpqlev() != null) sb.append(" AND AVG(t.rpqlev) >= ").append(pairsClassifyVO.getRpqlev());
        if (pairsClassifyVO.getRpqlevLess() != null) sb.append(" AND AVG(t.rpqlev) <= ").append(pairsClassifyVO.getRpqlevLess());
        if (pairsClassifyVO.getCoreqlev() != null) sb.append(" AND AVG(t.coreqlev) >= ").append(pairsClassifyVO.getCoreqlev());
        if (pairsClassifyVO.getCoreqlevLess() != null) sb.append(" AND AVG(t.coreqlev) <= ").append(pairsClassifyVO.getCoreqlevLess());
        if (pairsClassifyVO.getVcoreqlev() != null) sb.append(" AND AVG(t.vcoreqlev) >= ").append(pairsClassifyVO.getVcoreqlev());
        if (pairsClassifyVO.getVcoreqlevLess() != null) sb.append(" AND AVG(t.vcoreqlev) <= ").append(pairsClassifyVO.getVcoreqlevLess());
        if (pairsClassifyVO.getLdeltaqlev() != null) sb.append(" AND AVG(t.ldeltaqlev) >= ").append(pairsClassifyVO.getLdeltaqlev());
        if (pairsClassifyVO.getLdeltaqlevLess() != null) sb.append(" AND AVG(t.ldeltaqlev) <= ").append(pairsClassifyVO.getLdeltaqlevLess());
        if (pairsClassifyVO.getRdeltaqlev() != null) sb.append(" AND AVG(t.rdeltaqlev) >= ").append(pairsClassifyVO.getRdeltaqlev());
        if (pairsClassifyVO.getRdeltaqlevLess() != null) sb.append(" AND AVG(t.rdeltaqlev) <= ").append(pairsClassifyVO.getRdeltaqlevLess());
        String sql = sb.toString();
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        return list;
    }

    @Override
    public List<String> findLatentCard(PairsClassifyVO pairsClassifyVO) {
        return null;
    }
}

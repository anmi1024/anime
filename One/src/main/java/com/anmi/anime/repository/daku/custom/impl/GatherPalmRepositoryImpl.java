package com.anmi.anime.repository.daku.custom.impl;

import com.anmi.anime.repository.daku.custom.dao.GatherDataDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wangjue on 2017/12/1.
 */
public class GatherPalmRepositoryImpl implements GatherDataDao {

    @PersistenceContext(unitName = "dakuPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public long getFingerSeq() {
        return 0;
    }

    @Override
    public long getCaseFingerSeq() {
        return 0;
    }

    @Override
    public long getPalmSeq() {
        String sql = "select GAFIS_GATHER_PALM_SEQ.nextval from dual";
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        BigDecimal seq = (BigDecimal)list.get(0);
        return (long)seq.intValue();
    }
}

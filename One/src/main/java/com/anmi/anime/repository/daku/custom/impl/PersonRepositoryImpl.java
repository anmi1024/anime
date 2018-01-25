package com.anmi.anime.repository.daku.custom.impl;

import com.anmi.anime.repository.daku.custom.dao.PersonDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wangjue on 2017/9/21.
 */
public class PersonRepositoryImpl implements PersonDao {
    @PersistenceContext(unitName = "dakuPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public long getPersonSid() {
        String sql = "select GAFIS_PERSON_SID_SEQ.nextval from dual";
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        BigDecimal sid = (BigDecimal)list.get(0);
        return (long)sid.intValue();
    }

    @Override
    public long getPersonSeq() {
        String sql = "select GAFIS_PERSON_SEQ.nextval from dual";
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        BigDecimal seq = (BigDecimal)list.get(0);
        return (long)seq.intValue();
    }
}

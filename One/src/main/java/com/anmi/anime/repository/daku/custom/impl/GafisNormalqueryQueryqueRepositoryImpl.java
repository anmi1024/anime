package com.anmi.anime.repository.daku.custom.impl;

import com.anmi.anime.repository.daku.custom.dao.GafisNormalqueryQueryqueDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wangjue on 2017/9/20.
 */
public class GafisNormalqueryQueryqueRepositoryImpl implements GafisNormalqueryQueryqueDao {

    @PersistenceContext(unitName = "dakuPersistenceUnit")
    private EntityManager entityManager;

    public int getSeqOraSid(){
        String sql = "select seq_orasid.nextval from dual";
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        BigDecimal sid = (BigDecimal)list.get(0);
        return sid.intValue();
    }

    public List<Object> getMatchBeginAndFinishTimeAndAlgotithmQuerySpeed(long storage, int oraSidBegin, int oraSidEnd){
        String sql = "SELECT MIN(t.begintime),MAX(t.finishtime),?/(AVG(t.time_elapsed)/1000) FROM gafis_normalquery_queryque t WHERE t.ora_sid BETWEEN ? AND ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1,storage);
        query.setParameter(2,oraSidBegin);
        query.setParameter(3,oraSidEnd);
        List list = query.getResultList();
        return list;
    }


}

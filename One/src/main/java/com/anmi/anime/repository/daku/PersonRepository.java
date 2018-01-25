package com.anmi.anime.repository.daku;

import com.anmi.anime.model.GafisPersonEntity;
import com.anmi.anime.repository.daku.custom.dao.PersonDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangjue on 2017/9/14.
 */
public interface PersonRepository extends JpaRepository<GafisPersonEntity,Long>,PersonDao {
    GafisPersonEntity findByPersonid(String personId);

    @Transactional
    @Modifying
    @Query("UPDATE GafisPersonEntity t SET t.fptPath = ?1 WHERE t.personid = ?2")
    int modifyPersonFptPath(String fptPath, String personId);

    @Transactional
    @Modifying
    @Query("DELETE FROM GafisPersonEntity t WHERE t.personid = ?1")
    int deleteBypersonId(String personId);
}

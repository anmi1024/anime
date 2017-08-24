package com.anmi.anime.domain.authorize_gz.repository;

import com.anmi.anime.domain.authorize_gz.model.UserGZ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangjue on 2017/8/24.
 */
public interface UserGZRepository extends JpaRepository<UserGZ,Integer>{
    UserGZ findByPkId(String pkId);
    List<UserGZ> findByName(String name);
    UserGZ findByUserGZnameAndPassword(String UserGZName, String passWord);
    List<UserGZ> findByNameContaining(String name);

    @Query(value = "SELECT * FROM gafis_authorize_UserGZ t WHERE t.DELTAG = :delTag", nativeQuery = true)
    List<UserGZ> findByState1(@Param("delTag") Integer delTag);

    @Query(value = "SELECT t FROM UserGZ t WHERE t.deltag = :delTag")
    List<UserGZ> findByState(@Param("delTag") Integer delTag);
}

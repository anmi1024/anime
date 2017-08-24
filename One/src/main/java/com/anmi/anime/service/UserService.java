package com.anmi.anime.service;

import com.anmi.anime.domain.authorize.model.User;
import com.anmi.anime.domain.authorize_gz.model.UserGZ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by wangjue on 2017/8/22.
 */
public interface UserService {
    List<UserGZ> getAll();
    Page<User> getAll(Pageable pageable);
    User findByPkId(String pkId);
    List<User> findByName(String name);
    List<User> findByNameContaining(String name);
    User findByUserNameAndPassWord(String userName,String passWord);

    List<User> findByState(Integer delTag);



}

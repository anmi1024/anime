package com.anmi.service;

import com.anmi.model.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjue on 2017/7/19.
 */
public interface UserService {
    List<User> getAll();

    List<User> getByProperties(Map<String,Object> properties);
}

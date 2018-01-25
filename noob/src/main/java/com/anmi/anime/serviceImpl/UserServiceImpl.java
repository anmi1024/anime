package com.anmi.anime.serviceImpl;

import com.anmi.anime.domain.UserData;
import com.anmi.anime.model.User;
import com.anmi.anime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjue on 2017/9/8.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserData userData;

    @Override
    public List<User> users() {
        return userData.getUsers();
    }
}

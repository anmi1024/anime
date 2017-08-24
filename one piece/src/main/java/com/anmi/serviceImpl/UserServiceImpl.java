package com.anmi.serviceImpl;

import com.anmi.mapper.UserMapper;
import com.anmi.model.User;
import com.anmi.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjue on 2017/7/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userMapper.getAll(User.class);
        return userList;
    }

    @Override
    public List<User> getByProperties(Map<String, Object> properties) {
        List<User> userList = userMapper.getByProperties(User.class,properties);
        return userList;
    }
}

package com.anmi;

import com.anmi.base.BaseDBOperateType;
import com.anmi.model.User;
import com.anmi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjue on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring.xml","classpath*:spring-mybatis.xml"})
public class BaseTest {
    @Resource
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void test_getUserAll() {
        List<User> userList = userService.getAll();
        System.out.println(userList.size());
    }

    @Test
    public void test_getUserByProperties() {
        Map<String,Object> properties = new LinkedHashMap<>();
        properties.put("userName"+ BaseDBOperateType.LIKE,"nan");
        properties.put("userName"+ BaseDBOperateType.EQ+BaseDBOperateType.OR,"'wj'");
        properties.put("passWord"+ BaseDBOperateType.ORDERBY,"");
        properties.put("passWord"+ BaseDBOperateType.GROUPBY,"");
        List<User> userList = userService.getByProperties(properties);
        for (User user : userList) {
            System.out.println(user.getUserName()+" , "+user.getName() +" , "+user.getPassWord());
        }
    }


}

package com.anmi.action;

import com.anmi.base.BaseDBOperateType;
import com.anmi.model.User;
import com.anmi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjue on 2017/7/19.
 */
@Controller
public class UserAction{

    @Resource
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "login1", method= RequestMethod.GET)
    public String userAll() {
        List<User> userList = userService.getAll();
        return "success";
    }

    @RequestMapping(value = "login", method= RequestMethod.GET)
    public String userByProperties() {
        Map<String,Object> properties = new HashMap<>();
        properties.put("passWord"+BaseDBOperateType.SUFLIKE,"123");
        properties.put("delTag","1");
        List<User> userList = userService.getByProperties(properties);
        return "success";
    }

}

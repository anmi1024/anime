package com.anmi.anime.controller;

import com.anmi.anime.model.User;
import com.anmi.anime.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wangjue on 2017/9/8.
 */
@Controller
public class ThymeleafController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("message","welcome to hell!");
        return "/index";
    }

    @RequestMapping("login")
    public String hello(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "/login/hello";
    }

    @RequestMapping("users")
    public String users(Model model) {
        List<User> userList = userService.users();
        model.addAttribute("users",userList);
        return "/view/viewUserList";
    }
}

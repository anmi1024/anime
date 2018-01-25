package com.anmi.anime.controller;

import com.anmi.anime.model.User;
import com.anmi.anime.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangjue on 2017/8/22.
 */
@Controller
public class ThymeleafController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("thymeleafIndex")
    public String index(Model model){
        model.addAttribute("message","welcome to hell!");
        return "/index";
    }

    @RequestMapping("thymeleafLogin")
    public String hello(){
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "/login/hello";
    }

    @RequestMapping("viewUsers")
    public String viewUsers(Model model, @RequestParam("page")Integer page, @RequestParam("limit")Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC,"deltag");
        Pageable pageable = new PageRequest(page,size,sort);
        Page<User> userPage = userService.getAll(pageable);
        model.addAttribute("users",userPage);
        return "/view/viewUserList";
    }

}

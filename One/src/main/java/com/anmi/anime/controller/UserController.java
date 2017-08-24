package com.anmi.anime.controller;

import com.anmi.anime.domain.authorize.model.User;
import com.anmi.anime.domain.authorize_gz.model.UserGZ;
import com.anmi.anime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangjue on 2017/8/22.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showAllUser")
    public List<UserGZ> getAllUser(){
        return userService.getAll();
    }
    @RequestMapping("/showAllUserByPageable")
    public Page<User> getAllUser(@RequestParam("page")Integer page,@RequestParam("limit")Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC,"deltag");
        Pageable pageable = new PageRequest(page,size,sort);
        return userService.getAll(pageable);
    }
    @RequestMapping("/showByPkId")
    public User getByPkId(@RequestParam("pkId")String id) {
        return userService.findByPkId(id);
    }
    @RequestMapping("/showByName")
    public List<User> getByName(@RequestParam("name")String name){
        return userService.findByName(name);
    }
    @RequestMapping("/showByNameContaining")
    public List<User> getByNameLike(@RequestParam("name")String name){
        return userService.findByNameContaining(name);
    }
    @RequestMapping("/showByUserNameAndPassWord")
    public User getByUserNameAndPassWord(@RequestParam("userName")String userName,@RequestParam("passWord")String passWord) {
        return userService.findByUserNameAndPassWord(userName,passWord);
    }
    @RequestMapping("/findByDelTag")
    public List<User> findByDelTag(@RequestParam("delTag")Integer delTag){
        return userService.findByState(delTag);
    }
}

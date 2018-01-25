package com.anmi.anime.domain;

import com.anmi.anime.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjue on 2017/9/8.
 */
@Repository
public class UserData {

    public List<User> getUsers(){
        User zhangshan = new User("zhangshan","zhangshan","张珊","女",10);
        User lisi = new User("lisi","lisi","李斯","男",20);
        User wangwu = new User("wangwu","wangwu","王舞","女",30);
        User zhaoliu = new User("zhaoliu","zhaoliu","赵柳","男",40);
        List<User> userList = new ArrayList<>();
        userList.add(zhangshan);
        userList.add(lisi);
        userList.add(wangwu);
        userList.add(zhaoliu);
        return userList;
    }
}

package com.anmi.anime.model;

/**
 * Created by wangjue on 2017/9/8.
 */
public class User {
    private String userName;
    private String passWord;
    private String name;
    private String gender;
    private Integer age;

    public User(String userName, String passWord, String name, String gender, Integer age) {
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

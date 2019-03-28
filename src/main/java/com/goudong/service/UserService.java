package com.goudong.service;

import com.goudong.model.User;

/**
 * Created by CTL on 2019/3/28.
 */
public class UserService {

    private static User dao = User.dao;

    public User getUser(String username,String password){
        return dao.findFirst("select * from shop_user where account = ? and password = ?",username,password);
    }
}

package com.goudong.controller;

import com.jfinal.core.Controller;

/**
 * Created by CTL on 2019/3/27.
 */
public class UserController extends Controller {

    public void login(){
        render("login.html");
    }

    public void index(){
        render("index.html");
    }
}

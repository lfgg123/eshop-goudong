package com.goudong.controller;

import com.jfinal.core.Controller;

/**
 * Created by CTL on 2019/3/27.
 */
public class HelloController extends Controller{

    public void index(){
        renderText("hello world");
    }
}

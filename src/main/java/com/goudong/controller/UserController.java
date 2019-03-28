package com.goudong.controller;

import com.goudong.model.Goods;
import com.goudong.service.UserService;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by CTL on 2019/3/27.
 */
public class UserController extends Controller {

    public static UserService userService = new UserService();

    public void login(){
        String username = getPara("username");
        String password = getPara("password");
        renderJson(userService.getUser(username,password));
    }

    public void saveGoods(){
        String filepath = File.separator + UUID.randomUUID().toString() + File.separator;
        UploadFile samllPic = getFile("samllPic",filepath);
        UploadFile pic1 = getFile("pic1",filepath);
        UploadFile pic2 = getFile("pic2",filepath);
        UploadFile pic3 = getFile("pic3",filepath);
        Goods goods = getModel(Goods.class,"",true);
        if(null != samllPic)
            goods.setSamllPic(samllPic.getUploadPath() + samllPic.getFileName());
        if(null != pic1)
            goods.setPic1(pic1.getUploadPath() + pic1.getFileName());
        if(null != pic2)
            goods.setPic2(pic2.getUploadPath() + pic2.getFileName());
        if(null != pic3)
            goods.setPic3(pic3.getUploadPath() + pic3.getFileName());
        goods.save();
        render("/main.html");
    }

    public void welcome(){
        render("/login.html");
    }

    public void index(){
        render("/index.html");
    }
}

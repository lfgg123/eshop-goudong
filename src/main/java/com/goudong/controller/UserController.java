package com.goudong.controller;

import com.goudong.model.Goods;
import com.goudong.model.Letus;
import com.goudong.model.Message;
import com.goudong.model.User;
import com.goudong.service.GoodsService;
import com.goudong.service.LetusService;
import com.goudong.service.MessageService;
import com.goudong.service.UserService;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * Created by CTL on 2019/3/27.
 */
public class UserController extends Controller {

    private final static UserService userService = new UserService();
    private final static GoodsService goodsService = new GoodsService();
    private final static MessageService messageService = new MessageService();
    private final static LetusService letusService = new LetusService();

    /**
     * 登录
     */
    public void login() {
        String username = getPara("username");
        String password = getPara("password");
        User user = userService.getUser(username, password);
        setSessionAttr("user_id", user.getId());
        renderJson(user);
    }

    /**
     * 保存货品
     */
    public void saveGoods() {
        String filepath = File.separator + UUID.randomUUID().toString() + File.separator;
        UploadFile samllPic = getFile("samllPic", filepath);
        UploadFile pic1 = getFile("pic1", filepath);
        UploadFile pic2 = getFile("pic2", filepath);
        UploadFile pic3 = getFile("pic3", filepath);
        Goods goods = getModel(Goods.class, "", true);
        if (null != samllPic)
            goods.setSamllPic(samllPic.getUploadPath() + samllPic.getFileName());
        if (null != pic1)
            goods.setPic1(pic1.getUploadPath() + pic1.getFileName());
        if (null != pic2)
            goods.setPic2(pic2.getUploadPath() + pic2.getFileName());
        if (null != pic3)
            goods.setPic3(pic3.getUploadPath() + pic3.getFileName());
        goods.save();
        render("/main.html");
    }

    /**
     * 货品列表
     */
    public void goodsPage() {
        List<Goods> list = goodsService.getAll();
        setAttr("list", list);
        renderFreeMarker("/list.html");
    }

    /**
     * 货品编辑页面
     */
    public void updatePage() {
        Long id = getParaToLong("id");
        Goods goods = goodsService.findOne(id);
        setAttr("goods", goods);
        renderFreeMarker("/update.html");
    }

    /**
     * 更新货品
     */
    public void updateGoods() {
        String filepath = File.separator + UUID.randomUUID().toString() + File.separator;
        UploadFile samllPic = getFile("samllPic", filepath);
        Goods goods = getModel(Goods.class, "", true);
        if (null != samllPic)
            goods.setSamllPic(samllPic.getUploadPath() + samllPic.getFileName());
        goods.update();
        render("/main.html");
    }

    /**
     * banner编辑页面
     */
    public void bannerPage() {
        Long id = getParaToLong("id");
        Goods goods = goodsService.findOne(id);
        setAttr("goods", goods);
        renderFreeMarker("/updatebanner.html");
    }

    /**
     * 更新banner
     */
    public void updateBanner() {
        String filepath = File.separator + UUID.randomUUID().toString() + File.separator;
        UploadFile banner = getFile("banner", filepath);
        Long id = getParaToLong("id");
        String content = getPara("content");
        Goods goods = new Goods();
        goods.setContent(content);
        if (null != banner)
            goods.setBanner(banner.getUploadPath() + banner.getFileName());
        goods.setId(BigInteger.valueOf(id));
        goods.update();
        render("/main.html");
    }

    /**
     * 详情编辑页面
     */
    public void picPage() {
        Long id = getParaToLong("id");
        Goods goods = goodsService.findOne(id);
        setAttr("goods", goods);
        renderFreeMarker("/updatepic.html");
    }

    /**
     * 更新详情图片
     */
    public void updatePics() {
        String filepath = File.separator + UUID.randomUUID().toString() + File.separator;
        UploadFile pic1 = getFile("pic1", filepath, 100000000);
        UploadFile pic2 = getFile("pic2", filepath, 100000000);
        UploadFile pic3 = getFile("pic3", filepath, 100000000);
        Long id = getParaToLong("id");
        Goods goods = new Goods();
        if (null != pic1)
            goods.setPic1(pic1.getUploadPath() + pic1.getFileName());
        if (null != pic2)
            goods.setPic2(pic2.getUploadPath() + pic2.getFileName());
        if (null != pic3)
            goods.setPic3(pic3.getUploadPath() + pic3.getFileName());
        goods.setId(BigInteger.valueOf(id));
        goods.update();
        render("/main.html");
    }

    public void saveMessage() {
        Message message = getModel(Message.class, "", true);
        message.save();
        render("/main.html");
    }

    public void messageList() {
        setAttr("list", messageService.getAll());
        renderFreeMarker("/message_list.html");
    }

    public void deleteMessage() {
        Long id = getParaToLong("id");
        Message message = new Message();
        message.setId(BigInteger.valueOf(id));
        message.delete();
        render("/main.html");
    }

    public void letusPage(){
        List<Letus> list = letusService.getAll();
        if (null != list && list.size() > 0) {
            setAttr("letus",list.get(0));
        }
        renderFreeMarker("/letus.html");
    }

    public void saveLetus() {
        List<Letus> list = letusService.getAll();
        if (null != list && list.size() > 0) {
            list.forEach(letus -> letus.delete());
        }
        Letus letus = getModel(Letus.class, "", true);
        letus.save();
        render("/main.html");
    }

    /**
     * 图片展示
     */
    public void showImg() {
        String path = getPara("path");
        if (null == path || path.length() == 0)
            return;
        renderFile(new File(path));
    }

    public void welcome() {
        render("/login.html");
    }

    public void index() {
        render("/index.html");
    }
}

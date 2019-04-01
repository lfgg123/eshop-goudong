/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.goudong.controller;

import com.goudong.dto.CartDTO;
import com.goudong.filter.CrossOrigin;
import com.goudong.model.Cart;
import com.goudong.model.CartItem;
import com.goudong.model.User;
import com.goudong.service.GoodsService;
import com.goudong.service.UserService;
import com.jfinal.core.Controller;

import java.math.BigInteger;
import java.util.List;

/**
 * @author chentl
 * @version ApiController, v0.1 2019/4/1 9:46
 */
@CrossOrigin
public class ApiController extends Controller {

    private final static UserService userService = new UserService();

    private final static GoodsService goodsService = new GoodsService();

    /**
     * 注册
     */
    public void register(){
        String username = getPara("username");
        String password = getPara("password");
        User user = new User();
        user.setAccount(username);
        user.setPassword(password);
        user.save();
        renderJson(user);
    }


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
     * 获取商品列表
     */
    public void getGoods() {
        renderJson(goodsService.getAll());
    }

    /**
     * 保存购物车
     */
    public void saveCart() {
        Long uid = getParaToLong("user_id");
        Long goodsId = getParaToLong("goods_id");
        Integer num = getParaToInt("num");
        if (null == uid) {
            return;
        }
        Cart cart = new Cart();
        cart = cart.findFirst("select * from shop_cart where user_id = ?", uid);
        if (null == cart) {
            cart.setUserId(BigInteger.valueOf(uid));
            cart.save();
        }
        CartItem cartItem = new CartItem();
        cartItem.setGoodsId(goodsId);
        cartItem.setCartId((long) cart.getId());
        cartItem.setNum(num);
        cartItem.save();
        renderText("SUCCESS");
    }

    /**
     * 获取购物车详情
     */
    public void getCart() {
        Long uid = getParaToLong("user_id");
        if (null == uid) {
            return;
        }
        Cart cart = new Cart();
        cart = cart.findFirst("select * from shop_cart where user_id = ?", uid);
        if (null == cart) {
            return;
        }
        List<CartItem> items = CartItem.dao.find("select * from shop_cart_item where cart_id = ?", cart.getId());
        CartDTO dto = new CartDTO();
        dto.setCart(cart);
        dto.setCartItems(items);
        renderJson(dto);
    }
}

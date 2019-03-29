/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.goudong.dto;

import com.goudong.model.Cart;
import com.goudong.model.CartItem;

import java.io.Serializable;
import java.util.List;

/**
 * @author chentl
 * @version CartDTO, v0.1 2019/3/29 17:44
 */
public class CartDTO implements Serializable{
    private static final long serialVersionUID = 6012070988885678863L;

    private Cart cart;
    private List<CartItem> cartItems;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}

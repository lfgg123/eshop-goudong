package com.goudong.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseCartItem<M extends BaseCartItem<M>> extends Model<M> implements IBean {

	public M setId(java.math.BigInteger id) {
		set("id", id);
		return (M)this;
	}
	
	public java.math.BigInteger getId() {
		return get("id");
	}

	public M setNum(java.lang.Integer num) {
		set("num", num);
		return (M)this;
	}

	public java.lang.Integer getNum() {
		return getInt("num");
	}

	public M setCartId(java.lang.Long cartId) {
		set("cart_id", cartId);
		return (M)this;
	}
	
	public java.lang.Long getCartId() {
		return getLong("cart_id");
	}

	public M setGoodsId(java.lang.Long goodsId) {
		set("goods_id", goodsId);
		return (M)this;
	}
	
	public java.lang.Long getGoodsId() {
		return getLong("goods_id");
	}

	public M setCreateAt(java.util.Date createAt) {
		set("create_at", createAt);
		return (M)this;
	}
	
	public java.util.Date getCreateAt() {
		return get("create_at");
	}

	public M setUpdate(java.util.Date update) {
		set("update", update);
		return (M)this;
	}
	
	public java.util.Date getUpdate() {
		return get("update");
	}

}

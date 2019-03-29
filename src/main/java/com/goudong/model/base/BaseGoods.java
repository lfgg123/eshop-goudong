package com.goudong.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseGoods<M extends BaseGoods<M>> extends Model<M> implements IBean {

	public M setId(java.math.BigInteger id) {
		set("id", id);
		return (M)this;
	}
	
	public java.math.BigInteger getId() {
		return get("id");
	}

	public M setKind(java.lang.Integer kind) {
		set("kind", kind);
		return (M)this;
	}
	
	public java.lang.Integer getKind() {
		return getInt("kind");
	}

	public M setTitle(java.lang.String title) {
		set("title", title);
		return (M)this;
	}
	
	public java.lang.String getTitle() {
		return getStr("title");
	}

	public M setSecondTitle(java.lang.String secondTitle) {
		set("second_title", secondTitle);
		return (M)this;
	}
	
	public java.lang.String getSecondTitle() {
		return getStr("second_title");
	}

	public M setAttr(java.lang.String attr) {
		set("attr", attr);
		return (M)this;
	}
	
	public java.lang.String getAttr() {
		return getStr("attr");
	}

	public M setPrice(java.math.BigDecimal price) {
		set("price", price);
		return (M)this;
	}
	
	public java.math.BigDecimal getPrice() {
		return get("price");
	}

	public M setAddress(java.lang.String address) {
		set("address", address);
		return (M)this;
	}
	
	public java.lang.String getAddress() {
		return getStr("address");
	}

	public M setNum(java.lang.Long num) {
		set("num", num);
		return (M)this;
	}
	
	public java.lang.Long getNum() {
		return getLong("num");
	}

	public M setSamllPic(java.lang.String samllPic) {
		set("samll_pic", samllPic);
		return (M)this;
	}
	
	public java.lang.String getSamllPic() {
		return getStr("samll_pic");
	}

	public M setPic1(java.lang.String pic1) {
		set("pic1", pic1);
		return (M)this;
	}
	
	public java.lang.String getPic1() {
		return getStr("pic1");
	}

	public M setPic2(java.lang.String pic2) {
		set("pic2", pic2);
		return (M)this;
	}
	
	public java.lang.String getPic2() {
		return getStr("pic2");
	}

	public M setPic3(java.lang.String pic3) {
		set("pic3", pic3);
		return (M)this;
	}
	
	public java.lang.String getPic3() {
		return getStr("pic3");
	}

	public M setBanner(java.lang.String banner) {
		set("banner", banner);
		return (M)this;
	}
	
	public java.lang.String getBanner() {
		return getStr("banner");
	}

	public M setContent(java.lang.String content) {
		set("content", content);
		return (M)this;
	}
	
	public java.lang.String getContent() {
		return getStr("content");
	}

	public M setCreateAt(java.util.Date createAt) {
		set("create_at", createAt);
		return (M)this;
	}
	
	public java.util.Date getCreateAt() {
		return get("create_at");
	}

	public M setUpdateAt(java.util.Date updateAt) {
		set("update_at", updateAt);
		return (M)this;
	}
	
	public java.util.Date getUpdateAt() {
		return get("update_at");
	}

}

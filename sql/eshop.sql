/*
Navicat MySQL Data Transfer

Source Server         : 47.93.18.21
Source Server Version : 50560
Source Host           : 47.93.18.21:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-04-01 10:33:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '会员唯一标识',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_userid` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES ('20', '1', '2019-03-29 17:46:06', null);

-- ----------------------------
-- Table structure for shop_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart_item`;
CREATE TABLE `shop_cart_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cart_id` bigint(20) NOT NULL COMMENT '购物车唯一标识',
  `goods_id` bigint(20) NOT NULL COMMENT '货品唯一标识',
  `num` int(10) unsigned zerofill NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update` timestamp NULL DEFAULT NULL COMMENT '更新',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1757 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shop_cart_item
-- ----------------------------
INSERT INTO `shop_cart_item` VALUES ('1755', '20', '2', '0000000003', '2019-03-29 17:46:44', null);
INSERT INTO `shop_cart_item` VALUES ('1756', '20', '3', '0000000004', '2019-03-29 17:47:01', null);

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `kind` smallint(5) DEFAULT '1' COMMENT '标题',
  `title` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '标题',
  `second_title` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '二级标题',
  `attr` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '属性',
  `price` decimal(20,4) DEFAULT '0.0000' COMMENT '价格',
  `address` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '地址',
  `num` int(10) unsigned DEFAULT '0' COMMENT '购买数/浏览数',
  `samll_pic` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '缩略图路径',
  `pic1` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '详情图片1',
  `pic2` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '详情图片2',
  `pic3` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT '详情图片3',
  `banner` varchar(255) CHARACTER SET utf8 DEFAULT '' COMMENT 'banner',
  `content` varchar(2000) CHARACTER SET utf8 DEFAULT '' COMMENT '描述',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES ('2', '321', null, null, null, '321.0000', null, '1231', '/pics/1/abc.jpg', '/pics\\ef4b544e-0a93-4999-b7c2-f77509642770\\abc.jpg', '/pics\\ef4b544e-0a93-4999-b7c2-f77509642770\\abc1.jpg', '/pics\\ef4b544e-0a93-4999-b7c2-f77509642770\\abc2.jpg', '/pics\\b5a61e3c-e1e2-4101-8ebc-2fd66f91684b\\abc.jpg', '开心', '2019-03-28 23:18:17', null);
INSERT INTO `shop_goods` VALUES ('3', '231', null, null, '123', null, '321', null, '/pics\\521056f6-f75a-4bdc-a1c4-0887f1e87460\\timg.jpg', '/pics\\521056f6-f75a-4bdc-a1c4-0887f1e87460\\timg1.jpg', '/pics\\521056f6-f75a-4bdc-a1c4-0887f1e87460\\timg2.jpg', '/pics\\521056f6-f75a-4bdc-a1c4-0887f1e87460\\timg3.jpg', '', '', '2019-03-28 23:21:34', null);
INSERT INTO `shop_goods` VALUES ('4', '321', null, '312', null, null, '321', null, '/pics\\38117884-3b7e-4c7c-8ed0-6f8759d8c8c1\\timg.jpg', '/pics\\38117884-3b7e-4c7c-8ed0-6f8759d8c8c1\\timg1.jpg', '/pics\\38117884-3b7e-4c7c-8ed0-6f8759d8c8c1\\timg2.jpg', '/pics\\38117884-3b7e-4c7c-8ed0-6f8759d8c8c1\\timg3.jpg', '', '', '2019-03-28 23:22:08', null);
INSERT INTO `shop_goods` VALUES ('5', '123', null, '321', null, null, '321', null, '/pics\\cd069a23-f535-465c-9f25-a07a63d913fe\\timg.jpg', '/pics\\cd069a23-f535-465c-9f25-a07a63d913fe\\timg1.jpg', '/pics\\cd069a23-f535-465c-9f25-a07a63d913fe\\timg2.jpg', '/pics\\cd069a23-f535-465c-9f25-a07a63d913fe\\timg3.jpg', '', '', '2019-03-28 23:23:33', null);
INSERT INTO `shop_goods` VALUES ('6', '312', null, null, null, null, null, null, '/pics\\4d1261ed-9b59-47c6-b118-d2da9b4f4399\\timg.jpg', '/pics\\4d1261ed-9b59-47c6-b118-d2da9b4f4399\\timg1.jpg', '/pics\\4d1261ed-9b59-47c6-b118-d2da9b4f4399\\timg2.jpg', '/pics\\4d1261ed-9b59-47c6-b118-d2da9b4f4399\\timg3.jpg', '', '', '2019-03-28 23:24:05', null);
INSERT INTO `shop_goods` VALUES ('7', '321', null, null, null, null, null, null, '/pics\\9ae4a4ee-e20c-486f-8999-d18230405d42\\timg.jpg', '', '', '', '', '', '2019-03-28 23:25:29', null);
INSERT INTO `shop_goods` VALUES ('8', '123', '测试', '测试', '测试', '0.0000', '测试', '1', '/pics\\ea3e7244-4fb3-429c-97db-8a5ae5b01aae\\mmexport1536066959413.jpg', '/pics\\9275f737-7cdd-4f9a-a69c-2ef3e899f638\\mmexport1536066959413.jpg', '/pics\\9275f737-7cdd-4f9a-a69c-2ef3e899f638\\mmexport1536066954644.jpg', '', '', '', '2019-04-01 10:31:51', null);

-- ----------------------------
-- Table structure for shop_letus
-- ----------------------------
DROP TABLE IF EXISTS `shop_letus`;
CREATE TABLE `shop_letus` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `letus_content` varchar(2000) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '关于我们',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shop_letus
-- ----------------------------
INSERT INTO `shop_letus` VALUES ('3', '好的哈撒', '2019-04-01 10:31:20', null);

-- ----------------------------
-- Table structure for shop_message
-- ----------------------------
DROP TABLE IF EXISTS `shop_message`;
CREATE TABLE `shop_message` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `message_content` varchar(2000) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '消息详情',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shop_message
-- ----------------------------

-- ----------------------------
-- Table structure for shop_user
-- ----------------------------
DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(100) DEFAULT NULL COMMENT '管理登陆账号',
  `password` varchar(100) DEFAULT NULL COMMENT '管理员登陆密码',
  `bz` varchar(100) DEFAULT NULL COMMENT '说明',
  `role` int(3) DEFAULT '0' COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` timestamp NULL DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of shop_user
-- ----------------------------
INSERT INTO `shop_user` VALUES ('1', 'admin', 'admin', '默认用户，具有所有模块权限', '2', '2017-10-16 10:50:28', '2017-11-10 11:22:34', '1');
INSERT INTO `shop_user` VALUES ('2', 'fengpei', 'fengpei', '商品管理模块的操作', '3', '2017-11-09 10:46:35', '2017-11-10 11:35:33', '1');
INSERT INTO `shop_user` VALUES ('16', '测试', '123456', '', '3', '2017-11-11 16:16:00', '2017-11-15 12:32:46', '1');

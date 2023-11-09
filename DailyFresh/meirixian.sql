/*
Navicat MySQL Data Transfer

Source Server         : bendiceshi
Source Server Version : 80017
Source Host           : 127.0.0.1:3306
Source Database       : meirixian

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-02-19 13:09:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buyerid` int(11) DEFAULT NULL COMMENT '用户id',
  `goodsid` int(11) DEFAULT NULL COMMENT '商品id',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('4', '6', '1', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `supplierid` int(11) DEFAULT NULL COMMENT '供应商',
  `sortid` int(11) DEFAULT NULL COMMENT '分类',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '细节',
  `pub_time` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '发布日期',
  `status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '状态',
  `pic_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '图片路径',
  `inventory` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '猪肉', '88', '1', '1', '1KG猪肉', '2018-09-01', '1', '/uploadPic/daa82444-aab7-405e-9800-bae57cb8e92b.jpg', '94');
INSERT INTO `goods` VALUES ('2', '黑猪肉', '89', '1', '1', '1KG猪肉', '2018-09-01', '1', '/uploadPic/9f96c749-5ea6-43aa-bfc5-41fe8fb625d0.jpg', '98');
INSERT INTO `goods` VALUES ('4', '无籽露葡萄', '10', '1', '7', '新疆无籽露葡萄 1kg装 新鲜水果', '2018-08-30', '1', '/uploadPic/f02f5818-7af5-40e9-b45b-3d10f559e35b.jpg', '6000');
INSERT INTO `goods` VALUES ('5', '黑虎虾', '80', '1', '8', '泰国活冻黑虎虾（大号） 400g 16-20只/盒', '2018-09-03', '1', '/uploadPic/8189aa7b-38a5-468a-8a4f-1639ee8e600d.jpg', '15');

-- ----------------------------
-- Table structure for goods_sorts
-- ----------------------------
DROP TABLE IF EXISTS `goods_sorts`;
CREATE TABLE `goods_sorts` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sortname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '品类名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属大类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of goods_sorts
-- ----------------------------
INSERT INTO `goods_sorts` VALUES ('1', '猪肉类', '2');
INSERT INTO `goods_sorts` VALUES ('2', '苹果', '1');
INSERT INTO `goods_sorts` VALUES ('3', '小青菜', '3');
INSERT INTO `goods_sorts` VALUES ('4', '小草鱼', '4');
INSERT INTO `goods_sorts` VALUES ('5', '鲜牛奶', '5');
INSERT INTO `goods_sorts` VALUES ('6', '碳酸饮料', '6');
INSERT INTO `goods_sorts` VALUES ('7', '葡萄', '1');
INSERT INTO `goods_sorts` VALUES ('8', '虾类', '4');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL COMMENT '商品id',
  `buyerid` int(11) DEFAULT NULL COMMENT '用户id',
  `supplierid` int(11) DEFAULT NULL COMMENT '供应商id',
  `totalPrice` decimal(10,2) DEFAULT NULL COMMENT '总金额',
  `order_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单时间',
  `order_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单地址',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `num` int(11) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '6', '1', '88.00', '2021-02-01 19:24:44', '山东省 菏泽市 ', '0', '1');
INSERT INTO `order` VALUES ('2', '1', '6', '1', '88.00', '2021-02-01 19:31:38', '福建省 莆田市 ', '0', '1');
INSERT INTO `order` VALUES ('3', '1', '6', '1', '88.00', '2021-02-01 19:31:38', '福建省 莆田市 ', '0', '1');
INSERT INTO `order` VALUES ('4', '1', '6', '1', '88.00', '2021-02-01 19:31:44', '福建省 莆田市 ', '0', '1');
INSERT INTO `order` VALUES ('5', '1', '6', '1', '88.00', '2021-02-01 19:31:44', '福建省 莆田市 ', '0', '1');
INSERT INTO `order` VALUES ('6', '1', '6', '1', '88.00', '2021-02-01 19:44:13', '江西省 南昌市 ', '0', '1');
INSERT INTO `order` VALUES ('7', '1', '6', '1', '88.00', '2021-02-01 19:50:52', '江苏省 南京市 ', '0', '1');
INSERT INTO `order` VALUES ('8', '2', '6', '1', '89.00', '2021-02-03 11:02:47', '安徽省 合肥市 ', '0', '1');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `is_admin` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '管理员级别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', 'admin', '1', '2021-02-02 00:00:00', '1');
INSERT INTO `supplier` VALUES ('2', 'sysadmin', '123', '2018-08-26 00:00:00', '1');
INSERT INTO `supplier` VALUES ('3', 'gys', '123', '2018-08-26 00:00:00', '0');
INSERT INTO `supplier` VALUES ('4', 'gys2', '123', '2018-08-26 00:00:00', '0');
INSERT INTO `supplier` VALUES ('5', 'admin2', '123', '2018-09-05 23:09:11', '1');
INSERT INTO `supplier` VALUES ('6', 'gys3', '1', '2018-09-07 23:09:42', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '性别 0-女 1-男',
  `birthday` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '生日',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `money` decimal(10,0) DEFAULT NULL COMMENT '金额',
  `count` decimal(10,0) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', '123', '1', '1995-09-01', '江苏省南京市雨花台区科技园', '88888', '0', null);
INSERT INTO `user` VALUES ('2', 'test2', '123', '0', '2018-01-20', '江苏省南京市雨花台区', '5555555', '0', null);
INSERT INTO `user` VALUES ('3', 'test3', '1', '1', '2018-01-20', '江苏省南京市雨花台区', '666', '0', null);
INSERT INTO `user` VALUES ('4', 'test4', '123', '1', '2018-09-10', '江苏省南京市雨花台区2', '777', '0', null);
INSERT INTO `user` VALUES ('5', 'test5', '1', '1', '1995-09-04', '江苏省南京市雨花台', '8888', '0', null);
INSERT INTO `user` VALUES ('6', 'wangxianhui', '1', '1', '1998-05-09', '山东省菏泽市', '88888799', '90', null);

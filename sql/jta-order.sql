/*
Navicat MySQL Data Transfer

Source Server         : 150.109.38.149
Source Server Version : 50723
Source Host           : 150.109.38.149:3306
Source Database       : jta-order

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-01-03 12:17:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for T_ORDER
-- ----------------------------
DROP TABLE IF EXISTS `T_ORDER`;
CREATE TABLE `T_ORDER` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `shop_name` varchar(50) DEFAULT NULL,
  `shop_price` decimal(10,2) unsigned DEFAULT NULL,
  `pay_status` tinyint(4) unsigned DEFAULT NULL COMMENT '0未支付 1已经支付',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of T_ORDER
-- ----------------------------
INSERT INTO `T_ORDER` VALUES ('1', '29', 'IPHONE6S', '3000.00', '0');
INSERT INTO `T_ORDER` VALUES ('2', '29', 'IPHONE5S', '2000.00', '1');
INSERT INTO `T_ORDER` VALUES ('3', '29', 'IPHONE4S', '999999.00', '0');
INSERT INTO `T_ORDER` VALUES ('5', '1', 'Iphone 20', '1.00', '0');

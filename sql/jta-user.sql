/*
Navicat MySQL Data Transfer

Source Server         : 120.78.160.41
Source Server Version : 50724
Source Host           : 120.78.160.41:3306
Source Database       : jta-user

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-03 12:16:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `balance` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('29', 'lishengrong', '6664666.00');
INSERT INTO `user` VALUES ('34', '用户', '0.00');
INSERT INTO `user` VALUES ('40', 'anyly', '1000.00');

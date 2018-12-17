/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : workplan

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-16 23:39:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for abc_detail
-- ----------------------------
DROP TABLE IF EXISTS `abc_detail`;
CREATE TABLE `abc_detail` (
  `detail_id` int(11) NOT NULL,
  `detail_month` varchar(50) DEFAULT NULL,
  `detail_status` varchar(50) DEFAULT NULL,
  `detail_week` text,
  `detail_suggest` text,
  `plan_id` int(11) DEFAULT NULL,
  `plan_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abc_detail
-- ----------------------------

-- ----------------------------
-- Table structure for abc_menu
-- ----------------------------
DROP TABLE IF EXISTS `abc_menu`;
CREATE TABLE `abc_menu` (
  `menu_id` int(11) NOT NULL,
  `menu_no` int(11) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abc_menu
-- ----------------------------

-- ----------------------------
-- Table structure for abc_plan
-- ----------------------------
DROP TABLE IF EXISTS `abc_plan`;
CREATE TABLE `abc_plan` (
  `plan_id` int(11) NOT NULL,
  `plan_project` varchar(255) DEFAULT NULL,
  `plan_aims` varchar(255) DEFAULT NULL,
  `plan_detail` text,
  `plan_user` varchar(255) DEFAULT NULL,
  `plan_result` text,
  `plan_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abc_plan
-- ----------------------------

-- ----------------------------
-- Table structure for abc_rule
-- ----------------------------
DROP TABLE IF EXISTS `abc_rule`;
CREATE TABLE `abc_rule` (
  `rule_id` int(11) NOT NULL,
  `rule_level` varchar(255) DEFAULT NULL,
  `rule_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abc_rule
-- ----------------------------

-- ----------------------------
-- Table structure for abc_user
-- ----------------------------
DROP TABLE IF EXISTS `abc_user`;
CREATE TABLE `abc_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_phone` int(11) DEFAULT NULL,
  `user_group` varchar(50) DEFAULT NULL,
  `user_department` varchar(100) DEFAULT NULL,
  `user_uuid` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(50) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abc_user
-- ----------------------------
INSERT INTO `abc_user` VALUES ('1', 'sys', '123', '110', 'ceo', 'abc', 'qweasdzxc', '2018-12-16 23:15:23', 'reen', '2018-12-16 23:15:29', 'reen');

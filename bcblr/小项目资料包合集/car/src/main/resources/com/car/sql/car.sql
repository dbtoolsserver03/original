/*
 Navicat Premium Data Transfer

 Source Server         : xiaochen的数据库
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 127.0.0.1:3306
 Source Schema         : car

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 23/09/2020 21:27:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` varchar(40) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `ship` varchar(40) DEFAULT NULL,
  `bir` date DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
BEGIN;
INSERT INTO `t_car` VALUES ('77b65a93-2913-4bd3-8ccf-0528ef8302a4', '奥迪A6', '100', '奥迪汽车专业品牌', '2012-12-12', '/car/830caf29-1e8e-4a79-bfdc-d398c76d7a47.gif');
INSERT INTO `t_car` VALUES ('8a6b5a06-0973-46a6-bba6-5d0993b1c295', '小奥迪', '12', '这是好车', '2012-12-12', '/car/39fc73fb-0136-4338-9dfa-9471dddad3df.jpg');
INSERT INTO `t_car` VALUES ('a5eeb538-d003-46ae-b090-801a61170f97', 'dfsfdsfds ', '123', '奥迪汽车专业品牌', '2012-12-12', '/car/bf560715-a516-403d-a430-7db861f3eba9.png');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(40) DEFAULT NULL,
  `realname` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `role` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'chen', 'xiaochen', '123', '男', 'admin');
INSERT INTO `t_user` VALUES ('2', 'xiaohei', 'xiaohei', '111', '男', 'tourist');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

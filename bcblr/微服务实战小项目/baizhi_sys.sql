/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : baizhi_sys

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 31/05/2021 20:24:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_city
-- ----------------------------
BEGIN;
INSERT INTO `t_city` VALUES (4, '北京');
INSERT INTO `t_city` VALUES (5, '南京');
INSERT INTO `t_city` VALUES (6, '天津');
INSERT INTO `t_city` VALUES (7, '杭州');
INSERT INTO `t_city` VALUES (8, '上海');
INSERT INTO `t_city` VALUES (9, '深圳');
INSERT INTO `t_city` VALUES (11, '福建');
INSERT INTO `t_city` VALUES (12, '郑州');
INSERT INTO `t_city` VALUES (13, '云南');
INSERT INTO `t_city` VALUES (15, '辽宁');
COMMIT;

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `path` varchar(300) DEFAULT NULL,
  `tagId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
BEGIN;
INSERT INTO `t_clazz` VALUES (10, '2010班', '/20210531170642.png', '13');
INSERT INTO `t_clazz` VALUES (11, '2011班', '/20210531170831.png', '14');
INSERT INTO `t_clazz` VALUES (12, '2012班', '/20210531170842.png', '5');
INSERT INTO `t_clazz` VALUES (13, '2013班', '/20210531170853.png', '5');
COMMIT;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `clazzId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
BEGIN;
INSERT INTO `t_group` VALUES (5, '1组', '2021-05-31', '11');
INSERT INTO `t_group` VALUES (6, '2组', '2021-05-31', '10');
INSERT INTO `t_group` VALUES (7, '1组', '2021-05-31', '10');
INSERT INTO `t_group` VALUES (8, '2组', '2021-05-31', '11');
INSERT INTO `t_group` VALUES (9, '3组', '2021-05-31', '11');
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `bir` date DEFAULT NULL,
  `starts` varchar(20) DEFAULT NULL,
  `attr` varchar(10) DEFAULT NULL,
  `mark` varchar(600) DEFAULT NULL,
  `clazzId` varchar(40) DEFAULT NULL,
  `groupId` varchar(40) DEFAULT NULL,
  `cityId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (11, 'yannan chen', 9, '344355', '01010533789', '2012-12-12', '射手座', '龙', '', '11', '5', '4');
COMMIT;

-- ----------------------------
-- Table structure for t_student_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_student_tag`;
CREATE TABLE `t_student_tag` (
  `sid` int(40) NOT NULL,
  `tid` int(40) NOT NULL,
  PRIMARY KEY (`sid`,`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_student_tag` VALUES (11, 16);
INSERT INTO `t_student_tag` VALUES (11, 17);
INSERT INTO `t_student_tag` VALUES (11, 18);
COMMIT;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `type` varchar(8) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
BEGIN;
INSERT INTO `t_tag` VALUES (3, '帅哥', '学生', '2021-05-24');
INSERT INTO `t_tag` VALUES (4, '美女', '学生', '2021-05-24');
INSERT INTO `t_tag` VALUES (5, '探知源码', '班级', '2021-05-24');
INSERT INTO `t_tag` VALUES (6, '学渣', '学生', '2021-05-24');
INSERT INTO `t_tag` VALUES (13, '人数最多', '班级', '2021-05-31');
INSERT INTO `t_tag` VALUES (14, '坚持不懈', '班级', '2021-05-31');
INSERT INTO `t_tag` VALUES (15, '勤学好问', '班级', '2021-05-31');
INSERT INTO `t_tag` VALUES (16, '聪明', '学生', '2021-05-31');
INSERT INTO `t_tag` VALUES (17, '浪漫', '学生', '2021-05-31');
INSERT INTO `t_tag` VALUES (18, '油腻', '学生', '2021-05-31');
INSERT INTO `t_tag` VALUES (19, '懒惰', '学生', '2021-05-31');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (6, 'xiao', '123', NULL, '2021-05-31', 'admin');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

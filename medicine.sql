/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 100136
Source Host           : localhost:3306
Source Database       : medicine

Target Server Type    : MYSQL
Target Server Version : 100136
File Encoding         : 65001

Date: 2019-01-13 13:48:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agency
-- ----------------------------
DROP TABLE IF EXISTS `agency`;
CREATE TABLE `agency` (
  `ano` int(8) NOT NULL AUTO_INCREMENT,
  `aname` char(8) NOT NULL,
  `asex` char(4) NOT NULL,
  `aphone` char(12) NOT NULL,
  `aremark` varchar(50) NOT NULL,
  PRIMARY KEY (`ano`,`aname`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency
-- ----------------------------
INSERT INTO `agency` VALUES ('1', '李二', '男', '13556509406', '测试帐号修改');
INSERT INTO `agency` VALUES ('2', '李四', '男', '13556509407', '测试帐号2');
INSERT INTO `agency` VALUES ('11', '王二', '男', '13567896789', '新增店员');
INSERT INTO `agency` VALUES ('12', '青柳', '女', '13789678967', '数据传递');
INSERT INTO `agency` VALUES ('13', 'MVC', '男', '14789090927', 'Spring');
INSERT INTO `agency` VALUES ('14', '郑成', '男', '18909080908', '成功添加');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `cno` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(8) NOT NULL,
  `csex` char(1) NOT NULL,
  `cage` int(4) NOT NULL,
  `caddress` varchar(50) NOT NULL,
  `cphone` varchar(20) NOT NULL,
  `csymptom` varchar(50) NOT NULL,
  `mno` int(12) NOT NULL,
  `ano` int(8) NOT NULL,
  `cdate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `cremark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `fk_medicine` (`mno`),
  KEY `fk_ano` (`ano`),
  CONSTRAINT `fk_ano` FOREIGN KEY (`ano`) REFERENCES `agency` (`ano`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicine` FOREIGN KEY (`mno`) REFERENCES `medicine` (`mno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', '测试名', '男', '25', '金华市', '13556562323', '发烧', '1', '1', '2018-12-27 11:59:41', '测试使用');
INSERT INTO `client` VALUES ('2', '李青', '女', '23', '华泰市', '13576768787', '喉咙痛', '1', '1', '2018-12-27 17:56:32', '来店两次');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `mno` int(12) NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) NOT NULL,
  `mmode` char(2) NOT NULL,
  `mefficacy` varchar(50) NOT NULL,
  PRIMARY KEY (`mno`,`mname`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', '板蓝根', '内服', '清热解毒，凉血利咽');
INSERT INTO `medicine` VALUES ('2', '柴胡', '内服', '清虚热中药，用于感冒发热、寒热往来、疟疾、肝郁气滞、胸肋胀痛、脱肛、子宫脱落、月经不调');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `usern` varchar(20) NOT NULL,
  `passwd` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`usern`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', '管理员');
INSERT INTO `user` VALUES ('test', 'test', '会员');

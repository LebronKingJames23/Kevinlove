/*
Navicat MySQL Data Transfer

Source Server         : Virus
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ssh

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-06 00:28:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `cid` int(20) NOT NULL AUTO_INCREMENT,
  `custName` varchar(255) DEFAULT NULL,
  `custSource` varchar(255) DEFAULT NULL,
  `custPhone` varchar(255) DEFAULT NULL,
  `custMobile` varchar(255) DEFAULT NULL,
  `custAddress` varchar(255) DEFAULT NULL,
  `custZip` varchar(255) DEFAULT NULL,
  `custlevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FKaj4gj3slypg1o0hkptywwwm39` (`custlevel`),
  CONSTRAINT `FKaj4gj3slypg1o0hkptywwwm39` FOREIGN KEY (`custlevel`) REFERENCES `t_dict` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('5', '大唐官府', '人族', '11313123', '7868313', '长安', '1566666', '3');
INSERT INTO `t_customer` VALUES ('6', '化生寺', '人族', '8812313', '173891', '长安', '48239472384', '3');
INSERT INTO `t_customer` VALUES ('7', '女儿村', '人族', '12381231', '123871', '傲来国', '1312312312', '1');
INSERT INTO `t_customer` VALUES ('8', '方寸山', '人族', '123981093', '123718371', '长寿村', '12389138912', '2');
INSERT INTO `t_customer` VALUES ('9', '狮驼岭', '魔族', '13183712', '123817312', '大唐境外', '123123', '2');
INSERT INTO `t_customer` VALUES ('10', '魔王寨', '魔族', '1877731312', '877123123', '大唐境外', '12331', '3');
INSERT INTO `t_customer` VALUES ('12', '盘丝洞', '魔族', '12312312', '31123123131', '大唐境外', '24234', '2');
INSERT INTO `t_customer` VALUES ('14', '天宫', '仙族', '1265756', '123688', '天界', '3555522', '1');
INSERT INTO `t_customer` VALUES ('15', '普陀山', '仙族', '837283', '2384923748923', '大唐国境', '1231', '3');
INSERT INTO `t_customer` VALUES ('16', '五庄观', '仙族', '12313', '56478', '大唐境外', '312312366', '3');
INSERT INTO `t_customer` VALUES ('18', '阴曹地府', '魔族', '123123123', '12312312312312', '大唐国境', '123123123123123112312', '1');

-- ----------------------------
-- Table structure for `t_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `ltype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', 'vip客户', '级别');
INSERT INTO `t_dict` VALUES ('2', '普通客户', '级别');
INSERT INTO `t_dict` VALUES ('3', '游客', '级别');

-- ----------------------------
-- Table structure for `t_linkman`
-- ----------------------------
DROP TABLE IF EXISTS `t_linkman`;
CREATE TABLE `t_linkman` (
  `linkid` int(11) NOT NULL AUTO_INCREMENT,
  `lkmName` varchar(255) DEFAULT NULL,
  `lkmGender` varchar(255) DEFAULT NULL,
  `lkmPhone` varchar(255) DEFAULT NULL,
  `lkmMobile` varchar(255) DEFAULT NULL,
  `clid` int(11) DEFAULT NULL,
  PRIMARY KEY (`linkid`),
  KEY `FKjtgu0oocf35ij4fmulu123vwk` (`clid`),
  CONSTRAINT `FKjtgu0oocf35ij4fmulu123vwk` FOREIGN KEY (`clid`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_linkman
-- ----------------------------
INSERT INTO `t_linkman` VALUES ('2', '你是不是弱智啊', '女', '12312312', '43534534', null);
INSERT INTO `t_linkman` VALUES ('3', '小红', '女', '123123', '4545', '6');
INSERT INTO `t_linkman` VALUES ('4', '冥火', '女', '1231234', '123123123', null);
INSERT INTO `t_linkman` VALUES ('5', '程咬金', '男', '12312', '65756765', '5');
INSERT INTO `t_linkman` VALUES ('6', '程夫人', '女', '1231231', '45645645', '5');
INSERT INTO `t_linkman` VALUES ('7', '智空', '男', '3123123', '65756756756', '6');
INSERT INTO `t_linkman` VALUES ('8', '守门童子', '男', '1231', '456456456', '6');
INSERT INTO `t_linkman` VALUES ('9', '菩提祖师', '男', '13123123', '4645645645', '8');
INSERT INTO `t_linkman` VALUES ('10', '大大王', '男', '1876988888', '177555311122', '9');
INSERT INTO `t_linkman` VALUES ('11', '二大王', '男', '188712312', '1234445677', '9');
INSERT INTO `t_linkman` VALUES ('12', '牛魔王', '女', '12383123781', '12311512', '10');
INSERT INTO `t_linkman` VALUES ('15', '龙王', '男', '123123', '657567567', null);
INSERT INTO `t_linkman` VALUES ('16', '三太子', '男', '1231231', '5645645112', null);
INSERT INTO `t_linkman` VALUES ('17', '杨戬', '男', '12312312', '435345345', '14');
INSERT INTO `t_linkman` VALUES ('18', '玉皇大帝', '男', '123123123', '7768678678', '14');
INSERT INTO `t_linkman` VALUES ('19', '王母娘娘', '女', '123123123', '5434534534', '14');
INSERT INTO `t_linkman` VALUES ('20', '太白星君', '男', '123123123', '43534534', '14');
INSERT INTO `t_linkman` VALUES ('21', '观音菩萨', '女', '123123123', '435345345', '15');
INSERT INTO `t_linkman` VALUES ('22', '镇元大仙', '男', '312312312', '43534534', '16');
INSERT INTO `t_linkman` VALUES ('25', '阎罗王', '男', '123123123', '12312412312312', '18');
INSERT INTO `t_linkman` VALUES ('26', '森罗王', '男', '12312313', '1312312312312312', '18');
INSERT INTO `t_linkman` VALUES ('27', '程昱', '男', '183123', '123123', '7');

-- ----------------------------
-- Table structure for `t_visit`
-- ----------------------------
DROP TABLE IF EXISTS `t_visit`;
CREATE TABLE `t_visit` (
  `visitid` int(11) NOT NULL AUTO_INCREMENT,
  `visitaddress` varchar(255) DEFAULT NULL,
  `visitcontent` varchar(255) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `idofcust` int(100) DEFAULT NULL,
  PRIMARY KEY (`visitid`),
  KEY `FKjmktdp2l4aql9q2y2cjqlxe9h` (`userid`),
  KEY `FKjtv5bw9bbdxfb38df98a29646` (`idofcust`),
  CONSTRAINT `FKjmktdp2l4aql9q2y2cjqlxe9h` FOREIGN KEY (`userid`) REFERENCES `user` (`uid`),
  CONSTRAINT `FKjtv5bw9bbdxfb38df98a29646` FOREIGN KEY (`idofcust`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_visit
-- ----------------------------
INSERT INTO `t_visit` VALUES ('2', '上海', '交流', '2', '5');
INSERT INTO `t_visit` VALUES ('8', '新疆', '项目', '2', '6');
INSERT INTO `t_visit` VALUES ('9', '西藏', '吃饭', '6', '8');
INSERT INTO `t_visit` VALUES ('11', '北京', '吃饭', '4', '7');
INSERT INTO `t_visit` VALUES ('15', '休斯顿', '合作', '3', '5');
INSERT INTO `t_visit` VALUES ('16', '俄克拉荷马', '玩', '8', '10');
INSERT INTO `t_visit` VALUES ('17', '圣安东尼奥', '项目', '2', '5');
INSERT INTO `t_visit` VALUES ('18', '达拉斯', '吃饭', '4', '8');
INSERT INTO `t_visit` VALUES ('19', '金州', '泡吧', '6', '6');
INSERT INTO `t_visit` VALUES ('20', '洛杉矶', '泡吧', '6', '7');
INSERT INTO `t_visit` VALUES ('27', '明尼苏达', '吃饭', '5', '5');
INSERT INTO `t_visit` VALUES ('29', '波特兰', '项目', '6', '5');
INSERT INTO `t_visit` VALUES ('32', '克利夫兰', '合作', '3', '7');
INSERT INTO `t_visit` VALUES ('33', '华盛顿', '合作', '6', '5');
INSERT INTO `t_visit` VALUES ('35', '新疆', '项目', '2', '6');
INSERT INTO `t_visit` VALUES ('37', '芝加哥', '吃饭', '5', '9');
INSERT INTO `t_visit` VALUES ('38', '墨西哥', '吃饭', '4', '5');
INSERT INTO `t_visit` VALUES ('39', '傻逼', '厉害了', '14', '18');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'wade', '202cb962ac59075b964b07152d234b70', 'chicago');
INSERT INTO `user` VALUES ('3', 'James', '202cb962ac59075b964b07152d234b70', '');
INSERT INTO `user` VALUES ('4', 'Paul', '202cb962ac59075b964b07152d234b70', '');
INSERT INTO `user` VALUES ('5', 'westbrook', '202cb962ac59075b964b07152d234b70', '');
INSERT INTO `user` VALUES ('6', 'harden', '202cb962ac59075b964b07152d234b70', '');
INSERT INTO `user` VALUES ('7', 'durant', '202cb962ac59075b964b07152d234b70', '');
INSERT INTO `user` VALUES ('8', 'curry', '202cb962ac59075b964b07152d234b70', '');
INSERT INTO `user` VALUES ('9', 'wobuzhidaoa', '81dc9bdb52d04dc20036dbd8313ed055', '');
INSERT INTO `user` VALUES ('10', 'yy', 'yy', '');
INSERT INTO `user` VALUES ('11', '66', '66', '');
INSERT INTO `user` VALUES ('12', 'ee', 'ee', '');
INSERT INTO `user` VALUES ('13', 'rrr', 'rrr', '');
INSERT INTO `user` VALUES ('14', 'yy6', '66', '');

-- ----------------------------
-- Procedure structure for `abc`
-- ----------------------------
DROP PROCEDURE IF EXISTS `abc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `abc`(IN `a` varchar(20),OUT `b` varchar(20))
BEGIN
	#Routine body goes here...
DECLARE c INT;
	select cid into c FROM  t_customer where custName=a;
	set b=c;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `loginUser`
-- ----------------------------
DROP PROCEDURE IF EXISTS `loginUser`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `loginUser`(IN `a` varchar(20),IN `b` varchar(20),OUT `c` varchar(20))
BEGIN
	#Routine body goes here...
	select c FROM `user` WHERE username=a and `password`=b;
	set c=username;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `nnn`
-- ----------------------------
DROP PROCEDURE IF EXISTS `nnn`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `nnn`(IN `a` varchar(20),OUT `c` varchar(20))
BEGIN
	#Routine body goes here...
	
	select custAddress as c FROM t_customer where custName=a;
	
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `userlogin`
-- ----------------------------
DROP PROCEDURE IF EXISTS `userlogin`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `userlogin`(INOUT`username` varchar(20),IN `password` varchar(255))
BEGIN
	#Routine body goes here...
	select DISTINCT username  FROM `user` WHERE `username`=username and `password`=password;
	CALL userlogin(@username);
	select @username;
END
;;
DELIMITER ;

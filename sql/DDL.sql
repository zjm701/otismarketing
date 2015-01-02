-- ----------------------------
-- Table structure for `tbl_role`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_role`;
CREATE  TABLE `otismarketing`.`tbl_role` (
  `id` INT NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `descr` varchar(20) default NULL,
  PRIMARY KEY (`id`) 
)ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `tbl_role` VALUES ('1', 'ROLE_ADMIN', 'Admin', 1, '2015-01-04 05:43:54', '2015-01-04 05:43:54');
INSERT INTO `tbl_role` VALUES ('2', 'ROLE_USER', 'User', 1, '2015-01-04 05:44:39', '2015-01-04 05:44:39');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_user`;
CREATE TABLE `otismarketing`.`tbl_user` (
  `id` INT NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(50) default NULL,
  `enabled` INT default 1,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', 'admin', 1, '2014-01-04 18:17:54', '2014-01-04 18:17:54');
INSERT INTO `tbl_user` VALUES ('2', 'user', 'user', 1, '2014-01-04 18:30:43', '2014-01-04 18:30:43');

-- ----------------------------
-- Table structure for `tbl_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role` (
  `id` INT NOT NULL auto_increment,
  `userid` INT default NULL,
  `roleid` INT default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_Reference_1` (`userid`),
  KEY `FK_Reference_2` (`roleid`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`userid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`roleid`) REFERENCES `tbl_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `tbl_user_role` VALUES ('1', '1', '1');
INSERT INTO `tbl_user_role` VALUES ('2', '2', '2');


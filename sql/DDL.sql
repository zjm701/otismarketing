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
INSERT INTO `tbl_role` VALUES ('1', 'ROLE_ADMIN', 'Admin');
INSERT INTO `tbl_role` VALUES ('2', 'ROLE_USER', 'User');

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
DROP TABLE IF EXISTS `otismarketing`.`tbl_user_role`;
CREATE TABLE  `otismarketing`.`tbl_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_UR_1` (`userid`),
  KEY `FK_UR_2` (`roleid`),
  CONSTRAINT `FK_UR_1` FOREIGN KEY (`userid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `FK_UR_2` FOREIGN KEY (`roleid`) REFERENCES `tbl_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `tbl_user_role` VALUES ('1', '1', '1');
INSERT INTO `tbl_user_role` VALUES ('2', '2', '2');

-- begining of survey module

-- ----------------------------
-- Table structure for `tbl_survey`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_survey`;
CREATE  TABLE `otismarketing`.`tbl_survey` (
  `surveyId` INT NOT NULL auto_increment,
  `title` varchar(100) NOT NULL,
  `description` varchar(1000) default NULL,
  `status` INT NOT NULL default 0,
  `type` INT default 0,
  `createTime` datetime default NULL,
  `updateTime` datetime default NULL,
  `publishTime` datetime default NULL,
  `startTime` datetime default NULL,
  `endTime` datetime default NULL,
  `authorId` INT NOT null,
  PRIMARY KEY  (`surveyId`),
  KEY `FK_S_1` (`authorId`),
  CONSTRAINT `FK_S_1` FOREIGN KEY (`authorId`) REFERENCES `tbl_user` (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_reply`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_reply`;
CREATE TABLE `otismarketing`.`tbl_reply` (
  `replyId` INT NOT NULL auto_increment,
  `userKey` varchar(100) NOT NULL,
  `userName` varchar(100) default NULL,
  `surveyId` INT NOT null,
  `createtime` datetime default NULL,
  PRIMARY KEY  (`replyId`),
  KEY `FK_R_1` (`surveyId`),
  CONSTRAINT `FK_R_1` FOREIGN KEY (`surveyId`) REFERENCES `tbl_survey` (`surveyId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_question`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_question`;
CREATE TABLE `otismarketing`.`tbl_question` (
  `questionId` INT NOT NULL auto_increment,
  `surveyId` INT NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(1000) default null,
  `type` INT NOT NULL default 0,
  `isRequired` INT NOT NULL default 0,
  `index` INT NOT NULL default 1,
  `optionsString` varchar(1000) default null,
  `linkRules` varchar(1000) default null,
  PRIMARY KEY  (`questionId`),
  KEY `FK_Q_1` (`surveyId`),
  CONSTRAINT `FK_Q_1` FOREIGN KEY (`surveyId`) REFERENCES `tbl_survey` (`surveyId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `tbl_answer`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_answer`;
CREATE TABLE `otismarketing`.`tbl_answer` (
  `answerId` INT NOT NULL auto_increment,
  `replyId` INT NOT NULL,
  `questionId` INT NOT NULL,
  `intValue` INT default null,
  `stringValue` varchar(1000) default null,
  PRIMARY KEY  (`answerId`),
  KEY `FK_A_1` (`replyId`),
  KEY `FK_A_2` (`questionId`),
  CONSTRAINT `FK_A_1` FOREIGN KEY (`replyId`) REFERENCES `tbl_reply` (`replyId`),
  CONSTRAINT `FK_A_2` FOREIGN KEY (`questionId`) REFERENCES `tbl_question` (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- end of survey module
-- ----------------------------
-- Table structure for `tbl_role`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_role`;
CREATE  TABLE `otismarketing`.`tbl_role` (
  `id` INT NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `descr` varchar(50) default NULL,
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
  `username` varchar(50) default NULL,
  `password` varchar(200) default NULL,
  `enabled` INT default 1,
  `createtime` datetime default NULL,
  `updatetime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', 'bad23d65eb63034c', 1, '2014-01-04 18:17:54', '2014-01-04 18:17:54');
INSERT INTO `tbl_user` VALUES ('2', 'user', '7c2a6637c0cf65ed', 1, '2014-01-04 18:30:43', '2014-01-04 18:30:43');

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

-- ----------------------------
-- Table structure for `tbl_resource`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_resource`;
CREATE TABLE `tbl_resource` (
  `id` INT NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  `descr` varchar(50) default NULL,
  `url` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_resource
-- ----------------------------

--User part--
INSERT INTO `tbl_resource` VALUES ('1', 'User List', '', '/userManagement/goUserManagement');
INSERT INTO `tbl_resource` VALUES ('2', 'Add User', '', '/userManagement/toAddUser');
INSERT INTO `tbl_resource` VALUES ('3', 'User Update', '', '/userManagement/initUpdate');
--App part--
INSERT INTO `tbl_resource` VALUES ('4', 'App List', '', '/appVersion/getVersionsInfoList');
INSERT INTO `tbl_resource` VALUES ('5', 'Preview App', '', '/appVersion/previewVersion');
INSERT INTO `tbl_resource` VALUES ('6', 'App Update', '', '/appVersion/initUpdate');
--News part--
INSERT INTO `tbl_resource` VALUES ('7', 'News List', '', '/newsManagement/getAllNews');
INSERT INTO `tbl_resource` VALUES ('8', 'Preview News', '', '/newsManagement/previewNews');
INSERT INTO `tbl_resource` VALUES ('9', 'News Update', '', '/newsManagement/initUpdateNews');
--Survey part--
INSERT INTO `tbl_resource` VALUES ('10', 'Survey List', '', '/survey/findAllSurvey');
INSERT INTO `tbl_resource` VALUES ('11', 'Preview Survey', '', '/survey/preview');
INSERT INTO `tbl_resource` VALUES ('12', 'Add Survey', '', '/survey/toAdd');
INSERT INTO `tbl_resource` VALUES ('13', 'Update Survey', '', '/survey/toEdit');

-- ----------------------------
-- Table structure for `tbl_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_role_resource`;
CREATE TABLE `tbl_role_resource` (
  `id` INT NOT NULL auto_increment,
  `resourceid` INT default NULL,
  `roleid` INT default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_RES_1` (`resourceid`),
  KEY `FK_RES_2` (`roleid`),
  CONSTRAINT `FK_RES_1` FOREIGN KEY (`resourceid`) REFERENCES `tbl_resource` (`id`),
  CONSTRAINT `FK_RES_2` FOREIGN KEY (`roleid`) REFERENCES `tbl_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_role_resource
-- ----------------------------
INSERT INTO `tbl_role_resource` VALUES ('1', '1', '1');
INSERT INTO `tbl_role_resource` VALUES ('2', '2', '1');
INSERT INTO `tbl_role_resource` VALUES ('3', '3', '1');
INSERT INTO `tbl_role_resource` VALUES ('4', '4', '1');
INSERT INTO `tbl_role_resource` VALUES ('5', '4', '2');
INSERT INTO `tbl_role_resource` VALUES ('6', '5', '1');
INSERT INTO `tbl_role_resource` VALUES ('7', '5', '2');
INSERT INTO `tbl_role_resource` VALUES ('8', '6', '1');
INSERT INTO `tbl_role_resource` VALUES ('9', '6', '2');
INSERT INTO `tbl_role_resource` VALUES ('10', '7', '1');
INSERT INTO `tbl_role_resource` VALUES ('11', '7', '2');
INSERT INTO `tbl_role_resource` VALUES ('12', '8', '1');
INSERT INTO `tbl_role_resource` VALUES ('13', '8', '2');
INSERT INTO `tbl_role_resource` VALUES ('14', '9', '1');
INSERT INTO `tbl_role_resource` VALUES ('15', '9', '2');
INSERT INTO `tbl_role_resource` VALUES ('16', '10', '1');
INSERT INTO `tbl_role_resource` VALUES ('17', '10', '2');
INSERT INTO `tbl_role_resource` VALUES ('18', '11', '1');
INSERT INTO `tbl_role_resource` VALUES ('19', '11', '2');
INSERT INTO `tbl_role_resource` VALUES ('20', '12', '1');
INSERT INTO `tbl_role_resource` VALUES ('21', '12', '2');
INSERT INTO `tbl_role_resource` VALUES ('22', '13', '1');
INSERT INTO `tbl_role_resource` VALUES ('23', '13', '2');
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
  `authorId` INT default NULL,
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
  `orderNO` INT NOT NULL default 1,
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


-- ----------------------------
-- Table structure for `tbl_news`
-- ----------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_news`;
CREATE TABLE `otismarketing`.`tbl_news` (
  `id` INT NOT NULL auto_increment,
  `title` varchar(200) default NULL,
  `content` text,
  `enabled` INT default 1,
  `status` INT default 0,
  `authorId` INT NOT NULL,
  `createTime` datetime default NULL,
  `updateTime` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_NEWS_1` (`authorId`),
  CONSTRAINT `FK_NEWS_1` FOREIGN KEY (`authorId`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ------------------------------------
-- Table structure for `tbl_appversion`
-- ------------------------------------
DROP TABLE IF EXISTS `otismarketing`.`tbl_appversion`;
CREATE TABLE `otismarketing`.`tbl_appversion` (
  `id` INT NOT NULL auto_increment,
  `versionId` varchar(50) default NULL,
  `versionName` varchar(100) default NULL,
  `downloadLink` varchar(200) default NULL,
  `fileName` varchar(100) default NULL,
  `filePath` varchar(200) default NULL,
  `comment` varchar(400) default NULL,
  `status` INT default 0,
  `createTime` datetime default NULL,
  `updateTime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;


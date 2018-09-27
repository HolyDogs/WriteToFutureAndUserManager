-- ----------------------------
-- Table structure for table_user
-- ---------------------------- 

DROP TABLE IF EXISTS table_user;
CREATE TABLE table_user (
  userid varchar(11) NOT NULL,
  userType int(1) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  sex int(1) DEFAULT NULL,
  PRIMARY KEY (userid)
);
-- ----------------------------
-- Records of table_user
-- ----------------------------
INSERT INTO `table_user` VALUES ( '10001', '0', '123456', 'admin', '0');
INSERT INTO `table_user` VALUES ( '10002', '0', '123456', 'adminx', '1');
INSERT INTO `table_user` VALUES ( '10003', '1', '333333', 'user1', '0');
INSERT INTO `table_user` VALUES ( '10004', '1', '888888', '周杰伦', '0');
INSERT INTO `table_user` VALUES ( '10005', '1', '888888', '陈奕迅', '0');
INSERT INTO `table_user` VALUES ( '10006', '1', '888888', '奥特曼', '0');
INSERT INTO `table_user` VALUES ( '10007', '1', '888888', 'James', '0');
INSERT INTO `table_user` VALUES ( '10008', '1', '888888', 'xffff', '0');
INSERT INTO `table_user` VALUES ( '10009', '1', '888888', 'DD 567', '0');

-- ----------------------------
-- Table structure for table_email
-- ----------------------------
DROP TABLE IF EXISTS table_email;
CREATE TABLE table_email (
emailid int NOT NULL primary key auto_increment,
title varchar(255) DEFAULT NULL,
bodytext text DEFAULT NULL,
emailaddr varchar(255) DEFAULT NULL,
senddate varchar(255) DEFAULT NULL
);
INSERT INTO table_email VALUES ('1','FIRST EMAIL','NOTHING','525443029@qq.com','2018-10-01');


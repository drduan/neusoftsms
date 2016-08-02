`teacher`/*
CREATE DATABASE /*!32312 IF NOT EXISTS*/`school` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `school`;

/*Table structure for table `classinfo` */

DROP TABLE IF EXISTS `classinfo`;
/*班级信息*/
CREATE TABLE `classinfo` (
  `clid` VARCHAR(20) NOT NULL,
  `clname` VARCHAR(50) NOT NULL,
  `clbegindate` DATE NOT NULL,
  `clenddate` DATE NOT NULL,
  PRIMARY KEY  (`clid`),
  UNIQUE KEY `clname` (`clname`)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

/*Data for the table `classinfo` */

INSERT  INTO `classinfo`(`clid`,`clname`,`clbegindate`,`clenddate`) VALUES ('cl_1','计算机应用1班','2012-09-01','2016-07-01'),('cl_2','计算机应用2','2012-09-01','2016-07-01'),('cl_3','计算机应用2班','2012-09-01','2016-07-01'),('cl_4','计算机应用3班','2012-09-01','2016-07-01'),('cl_5','计算机应用4班','2012-09-01','2016-07-01');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;
/*学生信息*/
CREATE TABLE `student` (
  `stid` VARCHAR(30) PRIMARY KEY,
  `stname` VARCHAR(50) NOT NULL,
  `stsex` INT(11) DEFAULT NULL,
  `stbirthday` DATE NOT NULL,
  `clid` VARCHAR(20) NOT NULL
  /*FOREIGN KEY (`clid`) REFERENCES `classinfo` (`clid`)*/
); 

/*Data for the table `student` */

INSERT  INTO `student`(`stid`,`stname`,`stsex`,`stbirthday`,`clid`) VALUES ('st_1','张三',1,'1993-10-05','cl_1'),('st_10','张磊',1,'1993-10-05','cl_3'),('st_11','张微',2,'1993-10-05','cl_3'),('st_12','徐涛',1,'1993-10-05','cl_4'),('st_13','陈蕾',2,'1993-10-05','cl_1'),('st_2','王磊',1,'1993-02-08','cl_1'),('st_3','李蕾',2,'1993-10-05','cl_3'),('st_4','罗雷',1,'1993-10-05','cl_4'),('st_5','韩梅梅',2,'1993-10-05','cl_1'),('st_6','李亮',1,'1993-10-05','cl_3'),('st_7','牛文',2,'1993-10-05','cl_3'),('st_8','段绪东',1,'1993-10-05','cl_4'),('st_9','雷静雅',2,'1993-10-05','cl_1');

/*Table structure for table `studentandsubject` */

DROP TABLE IF EXISTS `studentandsubject`;
/*选课信息*/
CREATE TABLE `studentandsubject` (
  `stid` VARCHAR(30) NOT NULL,
  `subid` INT(11) NOT NULL,
  PRIMARY KEY  (`stid`,`subid`),
  KEY `subid` (`subid`),
  /*FOREIGN KEY (`stid`) REFERENCES `student` (`stid`),*/
  FOREIGN KEY (`subid`) REFERENCES `subjectinfo` (`subid`)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

/*Data for the table `studentandsubject` */

INSERT  INTO `studentandsubject`(`stid`,`subid`) VALUES ('st_1',1),('st_2',1),('st_4',1),('st_5',1),('st_6',1),('st_1',2),('st_2',2),('st_3',2),('st_4',2),('st_6',2),('st_1',3),('st_3',3),('st_4',3),('st_5',3),('st_6',3),('st_1',4),('st_2',4),('st_3',4),('st_4',4),('st_5',4),('st_6',4),('st_2',5),('st_3',5),('st_4',5),('st_5',5),('st_6',5);

/*Table structure for table `studentcard` */

DROP TABLE IF EXISTS `studentcard`;
/*学生证信息*/
CREATE TABLE `studentcard` (
  `stid` VARCHAR(30) NOT NULL,
  `carddate` DATE NOT NULL,
  `cardbg` INT(11) DEFAULT '1',
  PRIMARY KEY  (`stid`)
  /*FOREIGN KEY (`stid`) REFERENCES `student` (`stid`)*/
) ENGINE=INNODB DEFAULT CHARSET=gbk;

/*Data for the table `studentcard` */

INSERT  INTO `studentcard`(`stid`,`carddate`,`cardbg`) VALUES ('st_1','2012-09-10',1),('st_10','2012-09-10',1),('st_11','2012-09-10',1),('st_12','2012-09-10',1),('st_13','2012-09-10',1),('st_2','2012-09-10',1),('st_3','2012-09-10',1),('st_4','2012-09-10',1),('st_5','2012-09-10',1),('st_6','2012-09-10',1),('st_7','2012-09-10',1),('st_8','2012-09-10',1),('st_9','2012-09-10',1);

/*Table structure for table `subjectinfo` */

DROP TABLE IF EXISTS `subjectinfo`;
/*课程信息*/
CREATE TABLE `subjectinfo` (
  `subid` INT(11) NOT NULL AUTO_INCREMENT,
  `subname` VARCHAR(40) NOT NULL,
  PRIMARY KEY  (`subid`),
  UNIQUE KEY `subname` (`subname`)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

/*Data for the table `subjectinfo` */

INSERT  INTO `subjectinfo`(`subid`,`subname`) VALUES (3,'大学英语'),(2,'高等数学'),(4,'计算机操作系统'),(1,'计算机基础'),(5,'数据结构');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;
/*老师信息*/
CREATE TABLE `teacher` (
  `tid` INT(11) NOT NULL AUTO_INCREMENT,
  `tname` VARCHAR(30) NOT NULL,
  `tage` INT(11) DEFAULT NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=INNODB DEFAULT CHARSET=gbk;

/*Data for the table `teacher` */

INSERT  INTO `teacher`(`tid`,`tname`,`tage`) VALUES (1,'孔子',30),(2,'孟子',31),(3,'老子',35),(4,'居里夫人',39),(7,'atom2',34),(8,'atom3',35),(9,'atom4',36),(10,'李旭晨',44),(11,'李旭',50),(12,'李晨',350),(13,'李旭东',40),(14,'李杰晨',40),(15,'李旭晨',40),(16,'李旭',50),(17,'李晨',350),(18,'李旭东',40),(19,'李杰晨',40);

/*系统用户表*/
create table userinfo(
uid int primary key auto_increment,
logname varchar(20) not null unique,
keyword varchar(20) not null

);
insert into userinfo(logname,keyword) values('tom1','123');
insert into userinfo(logname,keyword) values('tom2','123');
insert into userinfo(logname,keyword) values('tom3','123');
/*系统登陆日志表*/
create table userloginfo(
logid int primary key auto_increment,
uid int not null,--操作用户
logdate date not null,--操作时间
logtype int check(logtype=1 or logtype=0)--操作状态


);

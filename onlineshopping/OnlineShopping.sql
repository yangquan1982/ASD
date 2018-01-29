/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.17-log : Database - db_xsxk
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_OnlineShopping` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_OnlineShopping`;

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `courseName` VARCHAR(40) DEFAULT NULL,
  `credit` INT(11) DEFAULT NULL,
  `teacherId` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_course` (`teacherId`),
  CONSTRAINT `FK_t_course` FOREIGN KEY (`teacherId`) REFERENCES `t_teacher` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_course` */

INSERT  INTO `t_course`(`id`,`courseName`,`credit`,`teacherId`) VALUES (1,'洗衣机',5,1),(2,'电视机',3,1),(4,'收音机',44,1),(5,'电冰箱',5,1),(7,'笔记本电脑',222,7),(8,'矿泉水',2,7),(9,'椅子',45,5),(10,'桌子',6,5),(11,'大卡车',2222,2),(12,'小汽车',45,2),(13,'象棋',2,5);

/*Table structure for table `t_manager` */

DROP TABLE IF EXISTS `t_manager`;

CREATE TABLE `t_manager` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(20) DEFAULT NULL,
  `password` VARCHAR(20) DEFAULT NULL,
  `trueName` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_manager` */

INSERT  INTO `t_manager`(`id`,`userName`,`password`,`trueName`) VALUES (1,'admin','123','王大锤');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(20) DEFAULT NULL,
  `password` VARCHAR(20) DEFAULT NULL,
  `trueName` VARCHAR(20) DEFAULT NULL,
  `stuNo` VARCHAR(20) DEFAULT NULL,
  `professional` VARCHAR(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

INSERT  INTO `t_student`(`id`,`userName`,`password`,`trueName`,`stuNo`,`professional`) VALUES (1,'guowenjie','123','郭文杰','0012','男'),(8,'sunzhuo','123','孙卓','2313','男'),(16,'hongleyong','123','洪乐游','33432','男'),(18,'mabo','123','马博','5679','男');

/*Table structure for table `t_student_course` */

DROP TABLE IF EXISTS `t_student_course`;

CREATE TABLE `t_student_course` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `studentId` INT(11) DEFAULT NULL,
  `courseId` INT(11) DEFAULT NULL,
  `score` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_student_course` (`courseId`),
  KEY `FK_t_student_course2` (`studentId`),
  CONSTRAINT `FK_t_student_course` FOREIGN KEY (`courseId`) REFERENCES `t_course` (`id`),
  CONSTRAINT `FK_t_student_course2` FOREIGN KEY (`studentId`) REFERENCES `t_student` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `t_student_course` */

INSERT  INTO `t_student_course`(`id`,`studentId`,`courseId`,`score`) VALUES (4,1,5,85),(7,1,2,2),(68,8,5,2),(69,8,4,2),(70,8,11,2),(71,8,12,1),(72,8,7,1),(73,8,8,1),(74,8,13,2);

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(20) DEFAULT NULL,
  `password` VARCHAR(20) DEFAULT NULL,
  `trueName` VARCHAR(20) DEFAULT NULL,
  `title` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_teacher` */

INSERT  INTO `t_teacher`(`id`,`userName`,`password`,`trueName`,`title`) VALUES (1,'liyangyang','123','李洋洋','22'),(2,'sunsongtao','123','孙松涛','33'),(5,'yuyang','123','于洋','44'),(7,'zhongyifeng','123','钟宜锋',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

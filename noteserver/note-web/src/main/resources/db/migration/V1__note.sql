
/* SQLyog Ultimate v12.08 (32 bit)  */

/*MySQL - 8.0.18 : Database - vhr
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_tree` */

/*

DROP TABLE IF EXISTS `t_tree`;


CREATE TABLE `t_tree` (
  `node_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `type` int(4) DEFAULT NULL,
  `sort` int(23) DEFAULT '1',
  `user_id` int(4) DEFAULT '0',
  `create_user` varchar(32) DEFAULT NULL,
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

*/

/*Data for the table `t_tree` */

/*

insert  into `t_tree`(`node_id`,`title`,`parent_id`,`type`,`sort`,`user_id`) values (1,"演示",537,1,10,1),(7,"PHP",537,1,20, 1),(8,"Python",537,1,30,1),(9,"JavaScript",537,1,40,1),(13,"Java",537,1,50,1),(537,"root",0,1,10,1);

*/

/*Table structure for table `t_content` */

/*

DROP TABLE IF EXISTS `t_content`;


CREATE TABLE `t_content` (
  `node_id` int(11) NOT NULL,
  `content` text,
  `ref_node_id` text,
  `update_time` timestamp DEFAULT NULL DEFAULT CURRENT_TIMESTAMP,
  `ref_update_time` timestamp  DEFAULT NULL,
  `notify_status` tinyint(4) DEFAULT '0',
  `show_notify` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

*/
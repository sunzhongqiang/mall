-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.53 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 mall.user_address 结构
CREATE TABLE IF NOT EXISTS `user_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '会员id',
  `consignee` varchar(60) DEFAULT NULL COMMENT '收货人姓名',
  `country` smallint(5) DEFAULT NULL COMMENT '国家',
  `county_name` varchar(50) DEFAULT NULL COMMENT '国家名称',
  `province` smallint(5) DEFAULT NULL COMMENT '省',
  `province_name` varchar(50) DEFAULT NULL COMMENT '省名称',
  `city` smallint(5) DEFAULT NULL COMMENT '市',
  `city_name` varchar(50) DEFAULT NULL COMMENT '城市名称',
  `district` smallint(5) DEFAULT NULL COMMENT '区、县',
  `district_name` varchar(50) DEFAULT NULL COMMENT '区县名称',
  `address` varchar(120) DEFAULT NULL COMMENT '地址',
  `zipcode` varchar(60) DEFAULT NULL COMMENT '邮编',
  `telephone` varchar(60) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(60) DEFAULT NULL COMMENT '手机',
  `type` varchar(10) DEFAULT NULL COMMENT '地址类型：收货地址（recieve），退货地址(refund)',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户地址';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

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

-- 导出  表 mall.system_region 结构
CREATE TABLE IF NOT EXISTS `system_region` (
  `region_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主键',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '所属区域id',
  `region_name` varchar(120) DEFAULT NULL COMMENT '区域名称',
  `is_display` int(1) DEFAULT NULL COMMENT '是否显示1-显示',
  `belongs_bigregion` varchar(20) DEFAULT NULL COMMENT '所属大区：华东、华北等，存汉字，总共就这些个区域',
  `full_region_name` varchar(300) DEFAULT NULL COMMENT '区域全地址',
  `region_type` int(11) DEFAULT NULL COMMENT '地区类型',
  PRIMARY KEY (`region_id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='地区表';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

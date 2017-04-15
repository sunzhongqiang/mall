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

-- 导出  表 mall.system_function 结构
CREATE TABLE IF NOT EXISTS `system_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '功能主键',
  `uri` varchar(200) NOT NULL COMMENT '统一资源标识符',
  `name` varchar(20) DEFAULT NULL COMMENT '资源名称',
  `icon_cls` varchar(20) DEFAULT NULL COMMENT '图标样式',
  `state` varchar(10) DEFAULT NULL COMMENT 'closed:关闭，open:打开',
  `type` varchar(20) DEFAULT NULL COMMENT '资源类型：function:功能;menu:菜单;module:模块;system:系统;一个系统有多个模块，一个模块包含多个功能',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统功能';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

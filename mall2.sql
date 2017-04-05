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


-- 导出 mall 的数据库结构
CREATE DATABASE IF NOT EXISTS `mall` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mall`;

-- 导出  表 mall.system_api 结构
CREATE TABLE IF NOT EXISTS `system_api` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `api_group` varchar(50) NOT NULL DEFAULT '0' COMMENT 'API组',
  `name` varchar(50) DEFAULT NULL COMMENT 'API名称',
  `description` text COMMENT '接口说明',
  `uri` varchar(150) DEFAULT NULL COMMENT '地址',
  `params` varchar(500) DEFAULT NULL COMMENT '参数',
  `return_values` text COMMENT '返回值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统API';

-- 数据导出被取消选择。
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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统功能';

-- 数据导出被取消选择。
-- 导出  表 mall.system_login_log 结构
CREATE TABLE IF NOT EXISTS `system_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统登录日志';

-- 数据导出被取消选择。
-- 导出  表 mall.system_operation_log 结构
CREATE TABLE IF NOT EXISTS `system_operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `function_name` varchar(255) DEFAULT NULL,
  `function_uri` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `operation_time` datetime DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统操作日志';

-- 数据导出被取消选择。
-- 导出  表 mall.system_organization 结构
CREATE TABLE IF NOT EXISTS `system_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(50) DEFAULT NULL COMMENT '机构编码',
  `name` varchar(255) DEFAULT NULL COMMENT '机构名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `path` varchar(500) DEFAULT NULL COMMENT '路径',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `FKbnoir82m8ed9glmbre81j8kus` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='组织结构';

-- 数据导出被取消选择。
-- 导出  表 mall.system_privilege 结构
CREATE TABLE IF NOT EXISTS `system_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色编码',
  `function_id` bigint(20) NOT NULL COMMENT '功能资源地址',
  `function_uri` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统权限表';

-- 数据导出被取消选择。
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
-- 导出  表 mall.system_role 结构
CREATE TABLE IF NOT EXISTS `system_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `code` varchar(50) NOT NULL COMMENT '角色编码',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `status` varchar(10) NOT NULL COMMENT '状态：enable启用；disable:禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统角色';

-- 数据导出被取消选择。
-- 导出  表 mall.system_user 结构
CREATE TABLE IF NOT EXISTS `system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `organization_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '部门主键',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `realname` varchar(50) DEFAULT NULL COMMENT '用户显示昵称',
  `status` varchar(10) DEFAULT NULL COMMENT '状态：enable启用；disable:禁用',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户';

-- 数据导出被取消选择。
-- 导出  表 mall.system_user_role 结构
CREATE TABLE IF NOT EXISTS `system_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户主键',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户角色';

-- 数据导出被取消选择。
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
-- 导出  表 mall.user_shop 结构
CREATE TABLE IF NOT EXISTS `user_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户主键',
  `title` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `shop_description` varchar(200) DEFAULT NULL COMMENT '经营范围',
  `address` varchar(200) DEFAULT NULL COMMENT '实体店地址',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户店铺';

-- 数据导出被取消选择。
-- 导出  表 mall.user_user 结构
CREATE TABLE IF NOT EXISTS `user_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(15) DEFAULT NULL COMMENT '用户名（电话既用户）',
  `realname` varchar(20) DEFAULT NULL COMMENT '真实名称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信绑定的openid',
  `is_seller` bit(1) DEFAULT NULL COMMENT '是否是商户',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态：enable,disable,启用禁用',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `modified` datetime DEFAULT NULL COMMENT '变更日期',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

本项目是springboot+jpa 和 jdbc两种方式分别对数据库进行增删改查
* 启动springboot，在http://localhost:8080/druid/index.html 里可以查看连接池的信息用户名admin 密码admin
* http://localhost:8080/findAllFruit 可以查看数据库中所有水果的信息
* http://localhost:8080/findFruitByName?id=1 查找id=1的水果信息
* http://localhost:8080/addFruit?fruit_name=pear&price=4.0&address=Shanghai 添加一条水果信息
* http://localhost:8080/updataFruit?id=2&fruit_name=apple&price=4.0&address=Shanghai 更新一条水果信息
* http://localhost:8080/deleteFruit?id=1 根据id删除一条水果信息

jdbc的操作见FruitJDBCController 
#构建步骤
##数据库构建
```mysql
# Host: localhost  (Version: 5.7.26)
# Date: 2020-01-13 14:19:25
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "fruit"
#

DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `fruit_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#
# Data for table "fruit"
#

/*!40000 ALTER TABLE `fruit` DISABLE KEYS */;
INSERT INTO `fruit` VALUES (1,'apple',4,'Shanghai');
/*!40000 ALTER TABLE `fruit` ENABLE KEYS */;
```
##运行springboot 即可对数据库操作


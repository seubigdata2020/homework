
# 阶段二：SpringBoot框架应用
基于SpringBoot，集成Druid、logback，使用JDBC实现数据表操作

----------------------------------
#### 数据库表结构

CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(80) NOT NULL,
  `age` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

----------------------------------
#### 集成Druid、logback 
* DruidConfiguration类
* 数据库链接池druid监控平台的配置、访问路径 http://localhost:8080/druid/index.html
* pom中配置logback依赖、在资源文件夹下配置了logging-spring.xml

-----------------------------------------
#### 使用JDBC实现数据表操作
* 在UserTest中对CRUD进行单元测试、

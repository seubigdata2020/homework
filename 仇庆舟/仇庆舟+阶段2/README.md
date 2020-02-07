## 阶段二 SpringBoot框架应用
#### 数据库

采用MySQL数据库，数据库名为student，包含一个表person结构如下

~~~SQL
create table person
(
  id   int auto_increment primary key,
  name varchar(30) null,
  age  int         null
);
~~~

--------------------

#### CRUD

业务代码写在JDBCController类中

查找全部用户：http://localhost:8080/userList

增加一个用户：http://localhost:8080/addUser

更改id为1的用户：http://localhost:8080/updateUser/1

删除id为1的用户http://localhost:8080/deleteUser/1

------------------------------------

#### Druid

构建application.yml文件，更改数据源为Druid，配置Druid

构建DruidConfig 配置类，实现数据库的后台监控，监控页面为http://localhost:8080/druid/index.html

* 用户名：admin

* 密码：123456

-------------------------

#### logback

利用Spring-web依赖， 自动引入logback

配置logback.xml文件，将日志输出到"/home"目录


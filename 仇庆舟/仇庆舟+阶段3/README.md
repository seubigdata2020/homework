## 阶段三 MyBatis-Plubs框架应用
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

------------------------------

#### 代码生成器

编写Creator测试类，生成service，entity，controller，dao四个文件夹，包含相应组件

------------------

### CRUD

编写DemoApplicationTests测试类，完成数据的增删改查操作以及分页查询

-----------

### 分页查询

在config文件夹下编写PageConfig配置类，配置分页插件，在PersonMapper接口中增加findPersonListByPage方法，分页查询所有数据，自定义的sql语句写在PersonMapper.xml中


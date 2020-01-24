
# 阶段三：MyBatis-Plubs框架应用
使用SpringBoot集成MyBatis-Plus，实现数据表操作（CRUD）

----------------------------------
#### 代码生成器

使用Mybatis-plus的代码生成器完成实体组件、Mapper组件（包含XML）、Service组件、Controller组件的自动生成

----------------------------------
#### Service CRUD接口
* 使用Service CRUD接口完成基础数据操作(SampleTest.java)
* 使用queryWrapper完成条件查询(UserController.java)
* 使用注解的方式完成条件自定义查询(UserController.java)

-----------------------------------------
#### 实现数据分页查询
* 使用MP中的分页插件实现分页查询
* 首先进行配置(MybatisPlusConfig.java)
* 接着完善service层和controller层代码
* 页码数量和单页显示数量两个参数由访问时传入

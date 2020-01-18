#springboot + mybatis 实现对mysql的操作
##构建mysql
* 具体的sql文件在根目录下，数据库名为test
* runoob_tbl 包含博客信息 id title author submission_date
* tcount_tbl 包含博客作者信息和访问量 author count

##mybatis构建
* 首先在src\main\java\com\homework\stage_3 目录下创建号 dao，entity 文件夹
* 在src\main\resources\ 目录下创建好generator文件夹
* 在generator 中建好generatorConfig.xml 文件 并在里面写好表结构的映射关系及目录
* 在command-line中 输入mybatis-generator:generate -e 即可直接创建实体类和dao类
* 在application.properties 中要做好mapper.xml的位置设置


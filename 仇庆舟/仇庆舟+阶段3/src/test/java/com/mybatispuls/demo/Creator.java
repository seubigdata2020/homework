package com.mybatispuls.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

public class Creator {
    private static String author ="Qiu-Qingzhou";
    private static String outputDir ="C:\\MyBatisPuls\\src\\main\\java";
    private static String driver ="com.mysql.jdbc.Driver";
    //连接路径,注意修改数据库名称
    private static String url ="jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    private static String username ="root";
    private static String password ="root";
    private static String tablePrefix ="";
    private static String [] tables = {"person"};
    private static String parentPackage = "com.mybatispuls";
    private static String dao = "dao";
    private static String service = "service";
    private static String entity = "entity";
    private static String controller = "controller";
    private static String mapperxml = "dao";



    @Test
    public void  testGenerator() {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setAuthor(author)
                .setOutputDir(outputDir)
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName(driver)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password);

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(tablePrefix)
                .setInclude(tables);

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(parentPackage)
                .setMapper(dao)
                .setService(service)
                .setController(controller)
                .setEntity(entity)
                .setXml(mapperxml);

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        //6. 执行
        ag.execute();
    }
}

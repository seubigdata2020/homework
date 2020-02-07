package com.lane.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.lane.controller.MyStatLogger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druidDataSource()
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setStatLogger(new MyStatLogger());
        return dataSource;
    }

    //后台监控功能 druid
    @Bean
    //因为SpringBoot内置了servlet容器，所以没有web.xml，替代方法就是注册ServletRegistrationBean
    public ServletRegistrationBean statViewServlet()
    {
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //后台需要有人登录监控
        HashMap<String,String> initParameters=new HashMap<>();

        //增加配置
        initParameters.put("loginUsername","admin");//loginUsername是固定的不能瞎写
        initParameters.put("loginPassword","123456");//loginPassword是固定的参数不能瞎写

        //允许谁能访问
        initParameters.put("allow"," ");

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    @Bean
    //filter
    public FilterRegistrationBean webStatFilter()
    {
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //可以过滤哪些请求呢
        HashMap<String,String> initParameters=new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }



}
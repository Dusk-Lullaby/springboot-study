package com.sonnet.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sonnet.filter.MyFilter;
import com.sonnet.listener.MyListener;
import com.sonnet.servlet.ServletDemo1;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
public class MyConfig {

    // 注册Servlet到springboot中
    @Bean
    public ServletRegistrationBean<ServletDemo1> servletRegistrationBean() {
        return new ServletRegistrationBean<>(new ServletDemo1(), "/demo1");
    }

    // 注册filter到springboot中
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/demo1"));
        return filterRegistrationBean;
    }

    // 注册listener到springboot中
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return servletListenerRegistrationBean;
    }

    // 将Druid数据源配置到ioc容器中
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
/*
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis_lesson");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
*/
        // 开启监控
        dataSource.setFilters("stat");
        return dataSource;
    }

/*
    // 配置druid监控页的功能
    @Bean
    public ServletRegistrationBean servletRegistrationBean1() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<Servlet> servletServletRegistrationBean =
                new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        servletServletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletServletRegistrationBean.addInitParameter("loginPassword", "123456");
        return servletServletRegistrationBean;
    }

    // 配置过滤器，用于采集用户操作数据库的数据
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> bean =
                new FilterRegistrationBean<>(webStatFilter);
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
*/
}

package com.ysy.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ysy.config.DataSourceConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class DataSourceTest {

    @Test
    //手动创建c3p0数据源
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("1234");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //手动创建druid数据源
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    @Test
    //手动创建c3p0数据源(加载配置文件形式)
    public void test3() throws Exception {
        //读取配置文件
//        Properties properties = new Properties();
//        properties.load(new FileReader("E:\\IdeaProjects\\SSMDemo2\\src\\test\\resources\\jdbc.properties"));
//        String driver = properties.getProperty("jdbc.driver");
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String userName = bundle.getString("jdbc.username");
        String pw = bundle.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(userName);
        dataSource.setPassword(pw);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //从Spring中获取c3p0数据源
    public void test4() throws Exception {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        ComboPooledDataSource dataSource = (ComboPooledDataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}

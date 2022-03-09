package com.ysy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;

//标志该类为Spring核心配置类
@Configuration
//<context:component-scan base-package="com.ysy"></context:component-scan>
@ComponentScan("com.ysy")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}

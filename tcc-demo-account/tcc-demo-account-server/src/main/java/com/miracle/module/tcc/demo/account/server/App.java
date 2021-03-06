package com.miracle.module.tcc.demo.account.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, 
		MongoAutoConfiguration.class,
		EmbeddedServletContainerAutoConfiguration.class, 
        WebMvcAutoConfiguration.class})
@ComponentScan({"com.miracle.common.transaction", "com.miracle.module.tcc.demo.account"})
@MapperScan(basePackages = {"com.miracle.module.tcc.demo.account.server.dao"}
, sqlSessionFactoryRef = "sqlSessionFactory_account"
)
@EnableTransactionManagement(proxyTargetClass=true)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class App {
	// CHECKSTYLE:OFF
    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}

package com.qishi.admin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.qishi.admin.util.MyMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@EnableDiscoveryClient
@EnableApolloConfig
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.qishi.admin.mapper",markerInterface = MyMapper.class)
@ComponentScan("com.qishi.admin.*")
public class QsAdminServiceApplication extends SpringBootServletInitializer
{

	public static void main(String[] args)
	{
		SpringApplication.run(QsAdminServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application)
	{
		return application.sources(QsAdminServiceApplication.class);
	}
}

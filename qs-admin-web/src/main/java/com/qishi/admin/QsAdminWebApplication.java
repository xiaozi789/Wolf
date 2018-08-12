package com.qishi.admin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableApolloConfig
@SpringBootApplication
public class QsAdminWebApplication  extends SpringBootServletInitializer
{

	public static void main(String[] args)
	{
		SpringApplication.run(QsAdminWebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application)
	{
		return application.sources(QsAdminWebApplication.class);
	}
}

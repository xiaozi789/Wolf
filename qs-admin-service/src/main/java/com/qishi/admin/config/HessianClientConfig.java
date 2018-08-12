package com.qishi.admin.config;

import com.qishi.admin.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * Created by yunling on 2018/1/5.
 * yunling
 */
@Configuration
public class HessianClientConfig
{

	@Autowired
	private VerifyCodeService  verifyCodeService;

	@Bean(name="/VerifyCodeService")
	public HessianServiceExporter exporterGameInfoService(){
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(verifyCodeService);
		exporter.setServiceInterface(VerifyCodeService.class);
		return exporter;
	}

}

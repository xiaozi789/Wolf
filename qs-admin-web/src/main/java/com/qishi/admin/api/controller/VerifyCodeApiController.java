package com.qishi.admin.api.controller;

import com.qishi.admin.api.VerifyCodeApi;
import com.qishi.admin.bean.VerifyCodeBean;
import com.qishi.admin.service.VerifyCodeService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen.haisheng
 * @create 2018-08-08 13:56
 **/
@RefreshScope
@RestController
public class VerifyCodeApiController implements VerifyCodeApi
{

   @Resource
   private VerifyCodeService verifyCodeService;

	@Override
	public List<VerifyCodeBean> queryVerifyCodeByMobile(@RequestParam("mobile")String mobile)
	{
		return verifyCodeService.queryVerifyCodeBeanByMobile(mobile,"00");
	}
}

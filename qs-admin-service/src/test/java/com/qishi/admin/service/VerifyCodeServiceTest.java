package com.qishi.admin.service;

import com.qishi.admin.QsAdminServiceApplicationTests;
import com.qishi.admin.bean.VerifyCodeBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author chen.haisheng
 * @create 2018-08-06 9:33
 **/
public class VerifyCodeServiceTest extends QsAdminServiceApplicationTests
{

	@Autowired
	private VerifyCodeService  verifyCodeService ;

	@Test
	public void queryVerifyCodeBeanByMobileTest()
	{
		List<VerifyCodeBean> verifyCodeBeans = verifyCodeService
				.queryVerifyCodeBeanByMobile("15657133669", "00");
		System.out.println(verifyCodeBeans.size());
	}


}

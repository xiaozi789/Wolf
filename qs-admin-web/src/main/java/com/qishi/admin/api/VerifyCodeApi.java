package com.qishi.admin.api;

import com.qishi.admin.bean.VerifyCodeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author chen.haisheng
 * @create 2018-08-08 9:37
 **/
@RequestMapping(value = "/verifyCode")
public interface VerifyCodeApi
{
	@GetMapping
	List<VerifyCodeBean> queryVerifyCodeByMobile(String mobile);
}

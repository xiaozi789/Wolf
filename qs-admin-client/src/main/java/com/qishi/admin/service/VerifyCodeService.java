package com.qishi.admin.service;

import com.qishi.admin.bean.VerifyCodeBean;

import java.util.List;

/**
 * @author chen.haisheng
 * @create 2018-07-24 16:34
 **/
public interface VerifyCodeService
{
	/**
	 * 根据主键查询验证码信息
	 * @param key
	 * @return
	 */
	VerifyCodeBean selectByKey(String key);

	/**
	 * 根据手机号码倒序查询验证码
	 * @param mobile
	 * @param status 00：未使用，01：已使用
	 * @return
	 */
	List<VerifyCodeBean> queryVerifyCodeBeanByMobile(String mobile,String status);
}

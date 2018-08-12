package com.qishi.admin.service.impl;

import com.qishi.admin.bean.VerifyCodeBean;
import com.qishi.admin.mapper.VerifyCodeEntityMapper;
import com.qishi.admin.model.VerifyCodeEntity;
import com.qishi.admin.service.VerifyCodeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author chen.haisheng
 * @create 2018-07-24 17:24
 **/
@Service
@Transactional(readOnly = true)
public class VerifyCodeServiceImpl  implements
		VerifyCodeService
{
	@Autowired
	private VerifyCodeEntityMapper verifyCodeEntityMapper;

	@Override
	public VerifyCodeBean selectByKey(String key)
	{
		VerifyCodeEntity verifyCodeEntity = verifyCodeEntityMapper.selectByPrimaryKey(key);
		return Optional.ofNullable(verifyCodeEntity).map(x-> {
			VerifyCodeBean verifyCodeBean = new VerifyCodeBean();
			BeanUtils.copyProperties(x,verifyCodeBean);
		    return verifyCodeBean;}).orElseGet(VerifyCodeBean::new);
	}

	@Override
	public List<VerifyCodeBean> queryVerifyCodeBeanByMobile(String mobile,
			String status)
	{
		List<VerifyCodeBean> verifyCodeBeans=verifyCodeEntityMapper.queryVerifyCodeBeanByMobile(mobile,status);
		return verifyCodeBeans;
	}
}

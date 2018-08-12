package com.qishi.admin.mapper;

import com.qishi.admin.bean.VerifyCodeBean;
import com.qishi.admin.model.VerifyCodeEntity;
import com.qishi.admin.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VerifyCodeEntityMapper extends MyMapper<VerifyCodeEntity> {

	List<VerifyCodeBean> queryVerifyCodeBeanByMobile(@Param("mobile") String mobile,
			@Param("status") String status);

}
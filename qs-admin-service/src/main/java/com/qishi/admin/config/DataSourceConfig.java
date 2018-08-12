
package com.qishi.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import net.yunling.util.DesUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * MyBatis基础配置
 *
 */
@Configuration
public class DataSourceConfig implements TransactionManagementConfigurer
{

	private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	@Value("${yunling.jdbc.driverClassName}")
	private String driverClassName;

	@Value("${yunling.jdbc.url}")
	private String url;

	@Value("${yunling.jdbc.username}")
	private String username;

	@Value("${yunling.jdbc.password}")
	private String password;



	@Bean(name = "druidDataSource", destroyMethod = "close", initMethod = "init")
	@Primary
	public DataSource druidDataSource() {

		DruidDataSource datasource = new DruidDataSource();
		try {
			DesUtil desUtil = new DesUtil();
			String decryptUsername = desUtil.decrypt(username);
			String decryptPassword = desUtil.decrypt(password);
			datasource.setUrl(url);
			datasource.setDriverClassName(driverClassName);
			datasource.setUsername(decryptUsername);
			datasource.setPassword(decryptPassword);
		} catch (Exception e) {
			logger.error("数据库连接用户信息加解密错误:", e);
		}finally{
			if (datasource != null) {
				datasource.close();
			}
		}
		return datasource;
	}



	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		try {
			return new DataSourceTransactionManager(druidDataSource());
		} catch (Exception e) {
			logger.error("配置transactionManager事物管理器错误:", e);
		}
		return null;
	}

	/**
	 * 使application.yml配置生效,如不主动配置,因@order配置顺序不同,将导致配置不能及时生效
	 * @return
	 */
	/*@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration globalConfiguration(){
		return new org.apache.ibatis.session.Configuration();
	}


	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() {
		try {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(druidDataSource());
//			bean.setTypeAliasesPackage("com.qishi.admin.model");
			bean.setConfiguration(globalConfiguration());
			// 指定mapper xml目录
//			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//			bean.setMapperLocations(resolver.getResources("classpath*:sqlmap/*Mapper.xml"));
			return bean.getObject();
		} catch (Exception e) {
			logger.error("创建sqlSessionFactory出错:", e);
		}
		return null;

	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() {
		return new SqlSessionTemplate(sqlSessionFactory());
	}*/


}
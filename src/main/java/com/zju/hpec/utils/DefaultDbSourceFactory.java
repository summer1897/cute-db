package com.zju.hpec.utils;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.alibaba.druid.pool.DruidDataSource;

/**
 *
 * @Description: 默认数据源连接池工厂,默认采用 @{link DruidDataSource}
 * @author hzduaho
 * @Date 2016年5月31日
 *
 */
public class DefaultDbSourceFactory extends AbstractDbSourceFactory implements ApplicationContextAware{

	private ApplicationContext app;
	
	@Override
	public DataSource newInstance(String source) {
		DruidDataSource druidDataSource = (DruidDataSource)this.app.getBean(source);
		if(null == druidDataSource)
			throw new RuntimeException("配置文件中没有定义该名字的数据源连接池对象: "+source);
		return druidDataSource;
	}

	public void setApplicationContext(ApplicationContext app) throws BeansException {
		this.app = app;
	}

}

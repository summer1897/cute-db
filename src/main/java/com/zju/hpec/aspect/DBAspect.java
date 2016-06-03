package com.zju.hpec.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @Description: 数据库相关增强操作
 * @author hzduhao
 * @Date 2016年5月23日
 *
 */
@Aspect
public class DBAspect {
	
	@After("@annotation(com.zju.hpec...DBAnnotation) && @args()")
	public void closeDB(){
		
	}
}

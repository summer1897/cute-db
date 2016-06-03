package com.zju.hpec.dbsource.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zju.hpec.dao.IUserDao;
import com.zju.hpec.domain.User;

/**
 *
 * @Description: MyBatis Spring集成测试
 * @author hzduhao
 * @Date 2016年5月24日
 *
 */
public class MybatisSpringTest {

	private  SqlSessionTemplate sqlSessionTemplate;
	private static final String PATH = "classpath:config/spring-application-context.xml";
	
	@SuppressWarnings("resource")
	@Before
	public void before() throws SQLException{
		ApplicationContext ac = new ClassPathXmlApplicationContext(PATH);
		sqlSessionTemplate = (SqlSessionTemplate)ac.getBean("sqlSessionTemplate");
	}
	
	@Test
	public void test(){
		IUserDao userDao = sqlSessionTemplate.getMapper(IUserDao.class);
		List<User> users = userDao.getAllUser();
		for(User user : users)
			System.out.println(user);
	}
	
}

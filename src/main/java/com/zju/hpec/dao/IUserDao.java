package com.zju.hpec.dao;

import java.util.List;


import com.zju.hpec.domain.User;

public interface IUserDao {

	//@Select("select *from user")
	public List<User> getAllUser();
	
	//@Select("select *from user where id = #{id}")
	public User getUserById(int id);
}

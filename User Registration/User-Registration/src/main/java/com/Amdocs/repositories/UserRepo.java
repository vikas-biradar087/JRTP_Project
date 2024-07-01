package com.Amdocs.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Amdocs.Entity.User;

public interface UserRepo extends JpaRepository<User, Serializable> {

	//select * from user where email=
	public User findByEmail(String email);
	
	//select * from user where email=? and user_pwd=?
	public User findByEmailAndUserPwd(String email,String pwd);
	
}

package com.xebia.StorePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.StorePortal.model.UsersType;
import com.xebia.StorePortal.repository.UserDao;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public List<UsersType>getAllUsers() {
		return userDao.findAll();
	}
	
}

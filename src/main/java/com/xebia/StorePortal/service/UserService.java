package com.xebia.StorePortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xebia.StorePortal.model.UsersType;

public interface UserService {
	public List<UsersType> getAllUsers();

}

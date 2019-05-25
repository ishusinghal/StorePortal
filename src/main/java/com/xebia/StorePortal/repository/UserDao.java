package com.xebia.StorePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.StorePortal.model.UsersType;

@Repository
public interface UserDao extends  JpaRepository<UsersType, Long>{
	
	
}

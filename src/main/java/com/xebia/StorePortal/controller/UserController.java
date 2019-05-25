package com.xebia.StorePortal.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xebia.StorePortal.model.Transactions;
import com.xebia.StorePortal.model.UsersType;
import com.xebia.StorePortal.pojo.Transaction;
import com.xebia.StorePortal.service.TransactionService;
import com.xebia.StorePortal.service.UserService;

@RestController
@RequestMapping("/private/v1/")
public class UserController {

	@Autowired
	UserService userServiceImpl;
	
	@Autowired
	TransactionService tranServiceImpl;
		
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	public List<UsersType> getAllUsers() {
		return  userServiceImpl.getAllUsers();
	}
	
	@RequestMapping(value = "/getNetAmount",method = RequestMethod.POST)
	public ResponseEntity<?> getNetAmount(@RequestBody Transaction transaction) {
			
//		validateTransact
		Transactions savedTran = tranServiceImpl.saveTransaction(transaction);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTransaction.getTid()).toUri();

		return ResponseEntity.created(location).build();
	}
}

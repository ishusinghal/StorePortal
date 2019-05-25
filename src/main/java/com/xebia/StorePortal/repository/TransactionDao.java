package com.xebia.StorePortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xebia.StorePortal.model.Transactions;

@Repository
public interface TransactionDao extends JpaRepository<Transactions, Integer> {

}

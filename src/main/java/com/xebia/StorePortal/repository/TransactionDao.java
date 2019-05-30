package com.xebia.StorePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xebia.StorePortal.model.Transactions;

@Repository
public interface TransactionDao extends JpaRepository<Transactions, Integer> {
	
	
	/*@Query("select * from transactions s where s.user_id= (:userid) and YEAR(tx_date) = YEAR(DATE_SUB(CURDATE(), INTERVAL 2 YEAR))")
    public List<Transactions> findCustomerTransactionFromLastTwoYear(@Param("userid") Integer userid);
	
	
*/
}

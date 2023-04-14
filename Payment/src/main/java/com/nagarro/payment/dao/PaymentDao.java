/**
 * 
 */
package com.nagarro.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.payment.entity.Payment;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer>{

	public List<Payment> findByOrderId(int id);
	public List<Payment> findByCustomerEmail(String email);
	public Payment findByTransactionId(String transactionId);
}

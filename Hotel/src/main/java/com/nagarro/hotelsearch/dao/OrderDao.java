/**
 * 
 */
package com.nagarro.hotelsearch.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.hotelsearch.entity.Order;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

	public Optional<List<Order>> findByCustomerEmail(String email);
	
}

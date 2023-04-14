/**
 * 
 */
package com.nagarro.flightsearch.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.entity.OrderForTwoWayTrip;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface OrderDaoForTwoWayTrip extends JpaRepository<OrderForTwoWayTrip, Integer>{
	
	public Optional< List<OrderForTwoWayTrip>> findByCustomerEmail(String email);

}

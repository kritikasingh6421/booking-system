/**
 * 
 */
package com.nagarro.flightsearch.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.entity.OrderForOneWayTrip;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface OrderDaoForOneWayTrip extends JpaRepository<OrderForOneWayTrip, Integer>{
	
	public Optional<List<OrderForOneWayTrip>> findByCustomerEmail(String email);

}

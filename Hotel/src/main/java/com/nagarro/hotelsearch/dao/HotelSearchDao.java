/**
 * 
 */
package com.nagarro.hotelsearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.hotelsearch.entity.Hotel;

/**
 * @author kritikasingh02
 *
 */
public interface HotelSearchDao extends JpaRepository<Hotel, Integer>{
	
}

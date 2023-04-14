/**
 * 
 */
package com.nagarro.flightsearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.entity.Flight;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface FlightDao extends JpaRepository<Flight, Integer>{

}

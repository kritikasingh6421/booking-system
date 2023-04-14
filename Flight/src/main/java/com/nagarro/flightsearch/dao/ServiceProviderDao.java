/**
 * 
 */
package com.nagarro.flightsearch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.flightsearch.entity.ServiceProvider;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface ServiceProviderDao extends JpaRepository<ServiceProvider, Integer>{
	
	public ServiceProvider findByServiceProviderName(String name);

}

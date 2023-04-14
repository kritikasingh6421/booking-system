/**
 * 
 */
package com.nagarro.hotelsearch.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.hotelsearch.entity.ServiceProvider;

/**
 * @author kritikasingh02
 *
 */
@Repository
public interface ServiceProviderDao extends JpaRepository<ServiceProvider, Integer>{
	
	public Optional<ServiceProvider> findByServiceProviderName(String name);

}

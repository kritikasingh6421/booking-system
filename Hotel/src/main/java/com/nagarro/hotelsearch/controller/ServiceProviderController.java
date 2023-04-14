/**
 * 
 */
package com.nagarro.hotelsearch.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.hotelsearch.entity.ServiceProvider;
import com.nagarro.hotelsearch.service.HotelSearchService;

/**
 * @author kritikasingh02
 *
 */
@RestController
@RequestMapping("/hotel/serviceProvider")
public class ServiceProviderController {

	@Autowired
	private HotelSearchService service;
	
	@GetMapping("/{name}")
	public ResponseEntity<ServiceProvider> serviceProvidersByName(@PathVariable String name) {
		ServiceProvider serviceProvidersByName = service.getServiceProviderByName(name);
		if(Objects.isNull(serviceProvidersByName)) {
			return ResponseEntity.badRequest().body(serviceProvidersByName);
		}
		return ResponseEntity.ok(serviceProvidersByName);
	}
	
	@PostMapping("/")
	public ResponseEntity<ServiceProvider> addServiceProvider(@RequestBody ServiceProvider serviceProvider) {
		ServiceProvider sp = service.addServiceProvider(serviceProvider);
		if(Objects.isNull(sp)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(sp);
	}
}

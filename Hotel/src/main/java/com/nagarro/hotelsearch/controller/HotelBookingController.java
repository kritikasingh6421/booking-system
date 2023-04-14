/**
 * 
 */
package com.nagarro.hotelsearch.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.hotelsearch.dto.HotelBooking;
import com.nagarro.hotelsearch.entity.Order;
import com.nagarro.hotelsearch.service.HotelSearchService;

/**
 * @author kritikasingh02
 *
 */
@RestController
@RequestMapping("/hotel/booking")
public class HotelBookingController {

	@Autowired
	private HotelSearchService service;
	
	@PostMapping("/")
	public ResponseEntity<HotelBooking> orderPlace(@RequestBody HotelBooking request) {
		
		HotelBooking response = service.orderPlace(request);
		if(Objects.isNull(response)) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/bookingCancel")
	public ResponseEntity<Order> orderCancel(@RequestBody Order order) {
		Order response = service.orderCancel(order);
		if(Objects.isNull(response)) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/order/{email}")
	public ResponseEntity<List<Order>> allOrderByCustomer(@PathVariable String email){
		List<Order> orders = service.allOrderByCustomer(email);
	    if(Objects.isNull(orders)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(orders);
	}
}

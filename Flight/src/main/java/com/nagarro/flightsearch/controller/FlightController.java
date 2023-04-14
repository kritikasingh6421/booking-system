/**
 * 
 */
package com.nagarro.flightsearch.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.flightsearch.dto.BookingOneWayFlight;
import com.nagarro.flightsearch.dto.BookingTwoWayFlight;
import com.nagarro.flightsearch.entity.Flight;
import com.nagarro.flightsearch.entity.OrderForOneWayTrip;
import com.nagarro.flightsearch.entity.OrderForTwoWayTrip;
import com.nagarro.flightsearch.entity.ServiceProvider;
import com.nagarro.flightsearch.service.FlightSearchService;

/**
 * @author kritikasingh02
 *
 */
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightSearchService service;

	@GetMapping("/")
	public ResponseEntity<List<Flight>> allFlights() {
		List<Flight> flights = service.allFlights();
		if (Objects.isNull(flights)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(flights);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
		Flight flight = service.getFlightById(id);
		if (Objects.isNull(flight)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(flight);
	}

	@GetMapping("/findWith")
	public ResponseEntity<List<Flight>> specificFlights(@RequestParam("departureLocation") String departureLocation,
			@RequestParam("arrivalLocation") String arrivalLocation, @RequestParam("flightClass") String flightClass,
			@RequestParam("date") String date) {
		LocalDate date1 = LocalDate.parse(date);
		List<Flight> flights = service.allPreferenceSpecificFlights(departureLocation, arrivalLocation, flightClass,
				date1);
		if (Objects.isNull(flights)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(flights);
	}

	@PostMapping("/")
	public ResponseEntity<Flight> add(@RequestBody Flight flight) {
		Flight f = service.addFlight(flight);
		if (Objects.isNull(f)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(f);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Flight> updateFlight(@PathVariable int id, @RequestBody Flight updatedFlight) {
		Flight flight = service.updateFlight(id, updatedFlight);
		if (Objects.isNull(flight)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(flight);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFromCart(@PathVariable int id) {
		if(Objects.isNull(service.getFlightById(id))) {
			service.deleteFlight(id);
			return new ResponseEntity<>("Successfully Deleted!!",HttpStatus.OK);
		}
		return new ResponseEntity<>("Not able to find Flight with given Id.",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/serviceProvider/{name}")
	public ResponseEntity<ServiceProvider> serviceProvidersByName(@PathVariable String name) {
		ServiceProvider serviceProvidersByName = service.getServiceProviderByName(name);
		if(Objects.isNull(serviceProvidersByName)) {
			return ResponseEntity.badRequest().body(serviceProvidersByName);
		}
		return ResponseEntity.ok(serviceProvidersByName);
	}
	
	@PostMapping("/serviceProvider")
	public ResponseEntity<ServiceProvider> addServiceProvider(@RequestBody ServiceProvider serviceProvider) {
		ServiceProvider sp = service.addServiceProvider(serviceProvider);
		if(Objects.isNull(sp)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(sp);
	}
	
	@PostMapping("/bookingOneWayFlight")
	public ResponseEntity<BookingOneWayFlight> bookingOneWayFlight(@RequestBody BookingOneWayFlight request) {
		BookingOneWayFlight orderResponse = service.bookingForOneWayFlight(request);
		if(Objects.isNull(orderResponse)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(orderResponse);
	}
	
	@PostMapping("/bookingTwoWayFlight")
	public ResponseEntity<BookingTwoWayFlight> bookingTwoWayFlight(@RequestBody BookingTwoWayFlight request) {
		BookingTwoWayFlight orderResponse = service.bookingForTwoWayFlight(request);
		if(Objects.isNull(orderResponse)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(orderResponse);
	}
		
	@PostMapping("/cancelOneWayFlight")
	public ResponseEntity<OrderForOneWayTrip> orderCancelForOneWayTrip(@RequestBody OrderForOneWayTrip order) {
		OrderForOneWayTrip response = service.cancelOneWayFlight(order);
		if(Objects.isNull(response)) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/cancelTwoWayFlight")
	public ResponseEntity<OrderForTwoWayTrip> orderCancelForTwoWayTrip(@RequestBody OrderForTwoWayTrip order) {
		OrderForTwoWayTrip response = service.cancelTwoWayFlight(order);
		if(Objects.isNull(response)) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/ordersForOneWayTrip/{email}")
	public ResponseEntity<List<OrderForOneWayTrip>> allOneWayTripByCustomer(@PathVariable String email){
		List<OrderForOneWayTrip> orders = service.allOneWayTripByCustomer(email);
	    if(Objects.isNull(orders)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/ordersForTwoWayTrip/{email}")
	public ResponseEntity<List<OrderForTwoWayTrip>> allTwoWayTripByCustomer(@PathVariable String email){
		List<OrderForTwoWayTrip> orders = service.allTwoWayTripByCustomer(email);
	    if(Objects.isNull(orders)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(orders);
	}

}

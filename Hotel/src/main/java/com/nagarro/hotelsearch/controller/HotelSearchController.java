package com.nagarro.hotelsearch.controller;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagarro.hotelsearch.dto.HotelBooking;
import com.nagarro.hotelsearch.entity.Hotel;
import com.nagarro.hotelsearch.entity.Order;
import com.nagarro.hotelsearch.entity.ServiceProvider;
import com.nagarro.hotelsearch.service.HotelSearchService;

@RestController
@RequestMapping("/hotel")
public class HotelSearchController {

	@Autowired
	private HotelSearchService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> allHotel(){
		List<Hotel> hotels = service.allHotels();
		if(Objects.isNull(hotels)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(hotels);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable int id){
		Hotel hotel = service.getHotelById(id);
		if(Objects.isNull(hotel)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(hotel);
	}

	@GetMapping("/findWith")
	public ResponseEntity<List<Hotel>> hotel(@RequestParam("name") String name, @RequestParam("city") String city,
			@RequestParam("checkInDate") String checkInDate, @RequestParam("checkOutDate") String checkOutDate) {
		
		LocalDate checkInDate1 = LocalDate.parse(checkInDate);
		LocalDate checkOutDate1 = LocalDate.parse(checkOutDate);
		List<Hotel> hotels = service.listOfHotels(name, city, checkInDate1, checkOutDate1);
	    if(Objects.isNull(hotels)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(hotels);
	}

	@GetMapping("/wishlist")
	public ResponseEntity<List<Hotel>> wishlist() {
		List<Hotel> hotels = service.wishListedHotel();
	    if(Objects.isNull(hotels)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(hotels);
	}

	@PostMapping("/")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
			
			Hotel h = service.addHotel(hotel);
			if(Objects.isNull(h)) {
		    	return ResponseEntity.badRequest().build();
		    }
		    return ResponseEntity.ok(h);

	}
	
	@PutMapping("/addToWishList/{id}")
	public ResponseEntity<Hotel> addToWishList(@PathVariable int id) {
		Hotel hotel = service.addToWishList(id);
		if(Objects.isNull(hotel)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(hotel);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel updateHotel) {
		Hotel hotel = service.updateHotel(id, updateHotel);
		if(Objects.isNull(hotel)) {
	    	return ResponseEntity.badRequest().build();
	    }
	    return ResponseEntity.ok(hotel);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable int id) {
		if(Objects.isNull(service.getHotelById(id))) {
			service.deleteHotel(id);
			return new ResponseEntity<>("Successfully Deleted!!",HttpStatus.OK);
		}
		return new ResponseEntity<>("Not able to find Hotel with given Id.",HttpStatus.BAD_REQUEST);
	}
}

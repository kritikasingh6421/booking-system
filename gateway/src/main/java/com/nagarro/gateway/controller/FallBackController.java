/**
 * 
 */
package com.nagarro.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kritikasingh02
 *
 */
@RestController
public class FallBackController {
	
	private Logger log = LoggerFactory.getLogger(FallBackController.class);

    @RequestMapping("/loginFallBack")
	public ResponseEntity<String> loginFallBackMethod(Exception e){
    	log.info("Login Service is down.");
		return new ResponseEntity<String>("Login Service is down or Something went worng try after some time!!",HttpStatus.BAD_REQUEST);
	}
    
    @RequestMapping("/bookingFallBack")
	public ResponseEntity<String> BookingFallBackMethod(Exception e){
    	log.info("Booking Service is down");
		return new ResponseEntity<String>("Booking Service is down or Something went worng try after some time!!",HttpStatus.BAD_REQUEST);
	}
    
    @RequestMapping("/flightFallBack")
	public ResponseEntity<String> flightFallBackMethod(Exception e){
    	log.info("Flight Search service is down");
		return new ResponseEntity<String>("Flight Search service is down or Something went worng try after some time!!",HttpStatus.BAD_REQUEST);
	}
    
    @RequestMapping("/hotelFallBack")
	public ResponseEntity<String> hotelFallBackMethod(Exception e){
    	log.info("Hotel Search is down");
		return new ResponseEntity<String>("Hotel Search is down or Something went worng try after some time!!",HttpStatus.BAD_REQUEST);
	}
    
    @RequestMapping("/paymentFallBack")
	public ResponseEntity<String> paymentFallBackMethod(Exception e){
    	log.info("Payment service is down");
		return new ResponseEntity<String>("Payment service is down or Something went worng try after some time!!",HttpStatus.BAD_REQUEST);
	}
}

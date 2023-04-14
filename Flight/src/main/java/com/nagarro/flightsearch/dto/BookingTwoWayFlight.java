/**
 * 
 */
package com.nagarro.flightsearch.dto;

import com.nagarro.flightsearch.entity.Flight;
import com.nagarro.flightsearch.entity.OrderForTwoWayTrip;

/**
 * @author kritikasingh02
 *
 */
public class BookingTwoWayFlight {
	
	private OrderForTwoWayTrip order;
	private Payment payment;
	private Flight flight1;
	private Flight flight2;
	private int noOfSeatBook;
	private String customerEmail;
	
	/**
	 * 
	 */
	public BookingTwoWayFlight() {
		super();
	}

	/**
	 * @param order
	 * @param payment
	 * @param flight1
	 * @param flight2
	 * @param noOfSeatBook
	 * @param customerEmail
	 */
	public BookingTwoWayFlight(OrderForTwoWayTrip order, Payment payment, Flight flight1, Flight flight2,
			int noOfSeatBook, String customerEmail) {
		super();
		this.order = order;
		this.payment = payment;
		this.flight1 = flight1;
		this.flight2 = flight2;
		this.noOfSeatBook = noOfSeatBook;
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the order
	 */
	public OrderForTwoWayTrip getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderForTwoWayTrip order) {
		this.order = order;
	}

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the flight1
	 */
	public Flight getFlight1() {
		return flight1;
	}

	/**
	 * @param flight1 the flight1 to set
	 */
	public void setFlight1(Flight flight1) {
		this.flight1 = flight1;
	}

	/**
	 * @return the flight2
	 */
	public Flight getFlight2() {
		return flight2;
	}

	/**
	 * @param flight2 the flight2 to set
	 */
	public void setFlight2(Flight flight2) {
		this.flight2 = flight2;
	}

	/**
	 * @return the noOfSeatBook
	 */
	public int getNoOfSeatBook() {
		return noOfSeatBook;
	}

	/**
	 * @param noOfSeatBook the noOfSeatBook to set
	 */
	public void setNoOfSeatBook(int noOfSeatBook) {
		this.noOfSeatBook = noOfSeatBook;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

    
}

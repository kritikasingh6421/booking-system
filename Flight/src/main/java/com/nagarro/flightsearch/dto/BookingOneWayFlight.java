/**
 * 
 */
package com.nagarro.flightsearch.dto;

import com.nagarro.flightsearch.entity.Flight;
import com.nagarro.flightsearch.entity.OrderForOneWayTrip;

/**
 * @author kritikasingh02
 *
 */
public class BookingOneWayFlight {
	
	private String customerEmail;
	private OrderForOneWayTrip order;
	private Payment payment;
	private Flight flight;
	private int numberOfSeatBook;
	
	/**
	 * 
	 */
	public BookingOneWayFlight() {
		super();
	}


	/**
	 * @param customerEmail
	 * @param order
	 * @param payment
	 * @param flight
	 * @param numberOfSeatBook
	 */
	public BookingOneWayFlight(String customerEmail, OrderForOneWayTrip order, Payment payment, Flight flight,
			int numberOfSeatBook) {
		super();
		this.customerEmail = customerEmail;
		this.order = order;
		this.payment = payment;
		this.flight = flight;
		this.numberOfSeatBook = numberOfSeatBook;
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


	/**
	 * @return the order
	 */
	public OrderForOneWayTrip getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderForOneWayTrip order) {
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
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}


	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	/**
	 * @return the numberOfSeatBook
	 */
	public int getNumberOfSeatBook() {
		return numberOfSeatBook;
	}


	/**
	 * @param numberOfSeatBook the numberOfSeatBook to set
	 */
	public void setNumberOfSeatBook(int numberOfSeatBook) {
		this.numberOfSeatBook = numberOfSeatBook;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookingOneWayFlight [customerEmail=" + customerEmail + ", order=" + order + ", payment=" + payment
				+ ", flight=" + flight + ", numberOfSeatBook=" + numberOfSeatBook + "]";
	}



}

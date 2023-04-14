/**
 * 
 */
package com.nagarro.hotelsearch.dto;

import com.nagarro.hotelsearch.entity.Hotel;
import com.nagarro.hotelsearch.entity.Order;

/**
 * @author kritikasingh02
 *
 */
public class HotelBooking {
	
	private String customerEmail;
	private Hotel hotel;
	private Payment payment;
	private Order order;
	private int numberOfRoomBook;
	
	/**
	 * 
	 */
	public HotelBooking() {
		super();
	}

	/**
	 * @param customerEmail
	 * @param hotel
	 * @param payment
	 * @param order
	 * @param numberOfRoomBook
	 */
	public HotelBooking(String customerEmail, Hotel hotel, Payment payment, Order order, int numberOfRoomBook) {
		super();
		this.customerEmail = customerEmail;
		this.hotel = hotel;
		this.payment = payment;
		this.order = order;
		this.numberOfRoomBook = numberOfRoomBook;
	}


	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
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
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}
	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	 * @return the numberOfRoomBook
	 */
	public int getNumberOfRoomBook() {
		return numberOfRoomBook;
	}

	/**
	 * @param numberOfRoomBook the numberOfRoomBook to set
	 */
	public void setNumberOfRoomBook(int numberOfRoomBook) {
		this.numberOfRoomBook = numberOfRoomBook;
	}
}

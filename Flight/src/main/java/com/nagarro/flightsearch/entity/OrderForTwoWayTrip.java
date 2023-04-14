/**
 * 
 */
package com.nagarro.flightsearch.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kritikasingh02
 *
 */
@Entity
@Table(name = "two_way_trip_orders")
public class OrderForTwoWayTrip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(nullable = false)
	private int product1Id;
	
	@Column(nullable = false)
	private int product2Id;

	@Column(nullable = false)
	private String serviceProviderName1;
	
	@Column(nullable = false)
	private String serviceProviderName2;
	
	@Column(nullable = false)
	private String customerEmail;
	
	private String transactionId;

	@Column(nullable = false)
	private double totalAmount;

	@Column(nullable = false)
	private LocalDate orderDate;

	@Column(nullable = false)
	private LocalTime orderTime;

	@Column(nullable = false)
	private String orderStatus;
	
	@Column(nullable = false)
	private String tripType;
	
	@Column(nullable = false)
	private int noOfSeatBook;

	/**
	 * 
	 */
	public OrderForTwoWayTrip() {
	}


	/**
	 * @param orderId
	 * @param product1Id
	 * @param product2Id
	 * @param serviceProviderName1
	 * @param serviceProviderName2
	 * @param customerEmail
	 * @param transactionId
	 * @param totalAmount
	 * @param orderDate
	 * @param orderTime
	 * @param orderStatus
	 * @param tripType
	 * @param noOfSeatBook
	 */
	public OrderForTwoWayTrip(int orderId, int product1Id, int product2Id, String serviceProviderName1,
			String serviceProviderName2, String customerEmail, String transactionId, double totalAmount,
			LocalDate orderDate, LocalTime orderTime, String orderStatus, String tripType, int noOfSeatBook) {
		super();
		this.orderId = orderId;
		this.product1Id = product1Id;
		this.product2Id = product2Id;
		this.serviceProviderName1 = serviceProviderName1;
		this.serviceProviderName2 = serviceProviderName2;
		this.customerEmail = customerEmail;
		this.transactionId = transactionId;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.tripType = tripType;
		this.noOfSeatBook = noOfSeatBook;
	}


	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the product1Id
	 */
	public int getProduct1Id() {
		return product1Id;
	}

	/**
	 * @param product1Id the product1Id to set
	 */
	public void setProduct1Id(int product1Id) {
		this.product1Id = product1Id;
	}

	/**
	 * @return the product2Id
	 */
	public int getProduct2Id() {
		return product2Id;
	}

	/**
	 * @param product2Id the product2Id to set
	 */
	public void setProduct2Id(int product2Id) {
		this.product2Id = product2Id;
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
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the orderDate
	 */
	public LocalDate getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderTime
	 */
	public LocalTime getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the tripType
	 */
	public String getTripType() {
		return tripType;
	}

	/**
	 * @param tripType the tripType to set
	 */
	public void setTripType(String tripType) {
		this.tripType = tripType;
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
	 * @return the serviceProviderName1
	 */
	public String getServiceProviderName1() {
		return serviceProviderName1;
	}


	/**
	 * @param serviceProviderName1 the serviceProviderName1 to set
	 */
	public void setServiceProviderName1(String serviceProviderName1) {
		this.serviceProviderName1 = serviceProviderName1;
	}


	/**
	 * @return the serviceProviderName2
	 */
	public String getServiceProviderName2() {
		return serviceProviderName2;
	}


	/**
	 * @param serviceProviderName2 the serviceProviderName2 to set
	 */
	public void setServiceProviderName2(String serviceProviderName2) {
		this.serviceProviderName2 = serviceProviderName2;
	}
	
	
}

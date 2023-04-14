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
@Table(name = "one_way_trip_orders")
public class OrderForOneWayTrip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(nullable = false)
	private int productId;

	@Column(nullable = false)
	private String serviceProviderName;
	
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
	public OrderForOneWayTrip() {
	}

	/**
	 * @param orderId
	 * @param productId
	 * @param serviceProviderName
	 * @param customerEmail
	 * @param transactionId
	 * @param totalAmount
	 * @param orderDate
	 * @param orderTime
	 * @param orderStatus
	 * @param tripType
	 */
	public OrderForOneWayTrip(int orderId, int productId, String serviceProviderName, String customerEmail, String transactionId,
			double totalAmount, LocalDate orderDate, LocalTime orderTime, String orderStatus, String tripType, int noOfSeatBook) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.serviceProviderName = serviceProviderName;
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
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the serviceProviderName
	 */
	public String getServiceProviderName() {
		return serviceProviderName;
	}

	/**
	 * @param serviceProviderName the serviceProviderName to set
	 */
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
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

}

/**
 * 
 */
package com.nagarro.hotelsearch.entity;

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
@Table(name = "orders")
public class Order {

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
	private int numberOfRoomBook;

	/**
	 * 
	 */
	public Order() {
	}

	/**
	 * @param orderId
	 * @param productId
	 * @param serviceProviderName
	 * @param transactionId
	 * @param totalAmount
	 * @param orderDate
	 * @param orderTime
	 * @param orderStatus
	 * @param numberOfRoomBook;
	 */
	public Order(int orderId, int productId, String serviceProviderName,String customerEmail, String transactionId, 
			double totalAmount, LocalDate orderDate, LocalTime orderTime, String orderStatus, int numberOfRoomBook) {
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
		this.numberOfRoomBook = numberOfRoomBook;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", serviceProviderName=" + serviceProviderName
				+ ", customerEmail=" + customerEmail + ", transactionId=" + transactionId + ", totalAmount="
				+ totalAmount + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", orderStatus=" + orderStatus
				+ ", numberOfRoomBook=" + numberOfRoomBook + "]";
	}


	
}

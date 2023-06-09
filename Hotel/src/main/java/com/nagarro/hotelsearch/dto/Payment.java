/**
 * 
 */
package com.nagarro.hotelsearch.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author kritikasingh02
 *
 */
public class Payment {

	private int paymentId;
	private String transactionId;
	private int orderId;
	private String customerEmail;
	private double totalAmount;
	private LocalDate paymentDate;
	private LocalTime paymentTime;
	private String paymentStatus;

	/**
	 * 
	 */
	public Payment() {}

	/**
	 * @param paymentId
	 * @param transactionId
	 * @param orderId
	 * @param customerEmail
	 * @param totalAmount
	 * @param paymentDate
	 * @param paymentTime
	 * @param paymentStatus
	 */
	public Payment(int paymentId, String transactionId, int orderId, String customerEmail, double totalAmount, LocalDate paymentDate,
			LocalTime paymentTime, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.customerEmail = customerEmail;
		this.totalAmount = totalAmount;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.paymentStatus = paymentStatus;
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
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	 * @return the paymentDate
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the paymentTime
	 */
	public LocalTime getPaymentTime() {
		return paymentTime;
	}

	/**
	 * @param paymentTime the paymentTime to set
	 */
	public void setPaymentTime(LocalTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", transactionId=" + transactionId + ", orderId=" + orderId
				+ ", customerEmail=" + customerEmail + ", totalAmount=" + totalAmount + ", paymentDate=" + paymentDate
				+ ", paymentTime=" + paymentTime + ", paymentStatus=" + paymentStatus + "]";
	}

}

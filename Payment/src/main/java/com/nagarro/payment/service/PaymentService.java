/**
 * 
 */
package com.nagarro.payment.service;

import java.util.List;

import com.nagarro.payment.entity.Payment;

/**
 * @author kritikasingh02
 *
 */
public interface PaymentService {

	public Payment paymentById(int id);
	public Payment storePayment(Payment payment);
	public void deletePayment(int id);
	public Payment updatePayment(int id, Payment updatedPayment);
	public List<Payment> allPayment();
	public List<Payment> allPaymentForOrder(int orderId);
	public List<Payment> allPaymentByCustomerEmail(String email);
	public Payment findByTransaction(String transactionId);
}

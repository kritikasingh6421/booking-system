/**
 * 
 */
package com.nagarro.payment.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.payment.constants.Constant;
import com.nagarro.payment.dao.PaymentDao;
import com.nagarro.payment.entity.Payment;

/**
 * @author kritikasingh02
 *
 */
@Service
public class PaymentServiceImp implements PaymentService{
	
	@Autowired
	private PaymentDao dao;
	
	private Logger log = LoggerFactory.getLogger(PaymentService.class);

	public Payment paymentById(int id) {
		log.info("Payment service request to get payment details by paymentId");
		return dao.findById(id).get();
	}

	public Payment storePayment(Payment payment) {
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentDate(LocalDate.now());
			payment.setPaymentTime(LocalTime.now());
			log.info("payment service: save payment successful");
			payment.setPaymentStatus(Constant.PAYMENT_SUCCESSFUL);
			dao.save(payment);
			return payment;
	}

	public void deletePayment(int id) {
		Payment payment = dao.findById(id).get();
		payment.setPaymentStatus(Constant.PAYMENT_RETURN);
		log.info("Payment Service: return payment sucessful");
		dao.deleteById(id);
		
	}

	public Payment updatePayment(int id, Payment updatedPayment) {
		Payment payment = dao.findById(id).get();
		payment.setTransactionId(updatedPayment.getTransactionId());
		payment.setOrderId(updatedPayment.getOrderId());
		payment.setCustomerEmail(updatedPayment.getCustomerEmail());
		payment.setTotalAmount(updatedPayment.getTotalAmount());
		payment.setPaymentDate(updatedPayment.getPaymentDate());
		payment.setPaymentTime(updatedPayment.getPaymentTime());
		payment.setPaymentStatus(updatedPayment.getPaymentStatus());
		dao.save(payment);
		log.info("Payment Service: updated payment successful");
		return payment;
	}

	public List<Payment> allPayment() {
		return dao.findAll();
	}

	@Override
	public List<Payment> allPaymentForOrder(int orderId) {
		List<Payment> payments = dao.findByOrderId(orderId);
		return payments;
	}

	@Override
	public List<Payment> allPaymentByCustomerEmail(String email) {
		List<Payment> payments = dao.findByCustomerEmail(email);
		return payments;
	}

	@Override
	public Payment findByTransaction(String transactionId) {
		Payment payment = dao.findByTransactionId(transactionId);
		return payment;
	}

}

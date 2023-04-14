/**
 * 
 */
package com.nagarro.payment.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.payment.entity.Payment;
import com.nagarro.payment.service.PaymentService;

/**
 * @author kritikasingh02
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;

	private Logger log = LoggerFactory.getLogger(PaymentController.class);

	@GetMapping("/")
	public ResponseEntity<List<Payment>> allTransactions() {
		List<Payment> payments = service.allPayment();
		if (Objects.isNull(payments)) {
			log.info("No payment exists");
			return ResponseEntity.badRequest().build();
		}
		log.info("List of all payments");
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/findByOrderId")
	public ResponseEntity<List<Payment>> getTransactionForOrder(@RequestParam("orderId") int orderId) {
		List<Payment> payments = service.allPaymentForOrder(orderId);
		if (Objects.isNull(payments)) {
			log.info("No payment exist with given id");
			return ResponseEntity.badRequest().build();
		}
		log.info("All payments with given order id");
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/findByCustomerEmail")
	public ResponseEntity<List<Payment>> allPaymentByCustomerEmail(@RequestParam("customerEmail") String email) {
		List<Payment> payments = service.allPaymentByCustomerEmail(email);
		if (Objects.isNull(payments)) {
			log.info("No payment exist for give email");
			return ResponseEntity.badRequest().build();
		}
		log.info("All payments of given user.");
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/paymentById/{id}")
	public ResponseEntity<Payment> getTransactionById(@PathVariable int id) {
		Payment payment = service.paymentById(id);
		if (Objects.isNull(payment)) {
			log.info("Payment with given id not exist");
			return ResponseEntity.badRequest().build();
		}
		log.info("Payment with given id");
		return ResponseEntity.ok(payment);
	}

	@GetMapping("/{transactionId}")
	public ResponseEntity<Payment> findByTransaction(@PathVariable String transactionId) {
		Payment payment = service.findByTransaction(transactionId);
		if (Objects.isNull(payment)) {
			log.info("Given transaction Id did not exists");
			return ResponseEntity.badRequest().build();
		}
		log.info("Payment with given transaction Id");
		return ResponseEntity.ok(payment);
	}

	@PostMapping("/")
	public ResponseEntity<Payment> add(@RequestBody Payment payment) {
		Payment p = service.storePayment(payment);
		if (Objects.isNull(p)) {
			log.info("Payment Fail");
			return ResponseEntity.badRequest().build();
		}
		log.info("Payment Successful");
		return ResponseEntity.ok(p);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Payment> updateTransaction(@PathVariable int id, @RequestBody Payment updatedPayment) {
		Payment payment = service.updatePayment(id, updatedPayment);
		if (Objects.isNull(payment)) {
			log.info("payment did not exist");
			return ResponseEntity.badRequest().build();
		}
		log.info("Payment updated sucessfully");
		return ResponseEntity.ok(payment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTransaction(@PathVariable int id){
		if (!Objects.isNull(service.paymentById(id))) {
			service.deletePayment(id);
			log.info("Payment deleted successfully : {}", service.paymentById(id).toString());
			return new ResponseEntity<String>("Deleted Successfully!", HttpStatus.OK);
		}
		log.info("Payment did not find with given id : {}", id);
		return new ResponseEntity<String>("Payment did not find with given Id.", HttpStatus.BAD_REQUEST);
	}
}

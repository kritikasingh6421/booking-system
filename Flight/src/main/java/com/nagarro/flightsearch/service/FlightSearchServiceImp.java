/**
 * 
 */
package com.nagarro.flightsearch.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.flightsearch.constant.Constant;
import com.nagarro.flightsearch.dao.FlightDao;
import com.nagarro.flightsearch.dao.OrderDaoForOneWayTrip;
import com.nagarro.flightsearch.dao.OrderDaoForTwoWayTrip;
import com.nagarro.flightsearch.dao.ServiceProviderDao;
import com.nagarro.flightsearch.dto.BookingOneWayFlight;
import com.nagarro.flightsearch.dto.BookingTwoWayFlight;
import com.nagarro.flightsearch.dto.Payment;
import com.nagarro.flightsearch.entity.Flight;
import com.nagarro.flightsearch.entity.OrderForOneWayTrip;
import com.nagarro.flightsearch.entity.OrderForTwoWayTrip;
import com.nagarro.flightsearch.entity.ServiceProvider;

/**
 * @author kritikasingh02
 *
 */
@Service
public class FlightSearchServiceImp implements FlightSearchService {

	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private OrderDaoForOneWayTrip oneWayOrderDao;
	
	@Autowired
	private OrderDaoForTwoWayTrip twoWayOrderDao;

	@Autowired
	private RestTemplate template;

	@Autowired
	private ServiceProviderDao serviceProviderDao;
	
	private Logger log = LoggerFactory.getLogger(FlightSearchServiceImp.class);

	@Override
	public List<Flight> allFlights() {
		return flightDao.findAll();
	}
	
	@Override
	public List<Flight> allPreferenceSpecificFlights(String departureLocation, String arrivalLocation,
			String flightClass, LocalDate date) {
		List<Flight> flights = flightDao.findAll();
		List<Flight> specificFlight = new ArrayList<Flight>();
		for (Flight flight : flights) {
			if (departureLocation.equalsIgnoreCase(flight.getDepartureLocation())
					&& arrivalLocation.equalsIgnoreCase(flight.getArrivalLocation())
					&& flightClass.equalsIgnoreCase(flight.getFlightClass()) && date.equals(flight.getDepartureDate())
					&& flight.getAvailability() > 0) {
				specificFlight.add(flight);
			}
		}
		return specificFlight;
	}

	@Override
	public Flight addFlight(Flight flight) {
		return flightDao.save(flight);
		
	}

	@Override
	public void deleteFlight(int id) {

		flightDao.deleteById(id);

	}

	@Override
	public Flight updateFlight(int id, Flight updatedFlight) {
		Flight flight = flightDao.findById(id).get();
		
		flight.setDepartureLocation(updatedFlight.getDepartureLocation());
		flight.setDepartureDate(updatedFlight.getDepartureDate());
		flight.setDepartureTime(updatedFlight.getDepartureTime());
		flight.setArrivalLocation(updatedFlight.getArrivalLocation());
		flight.setArrivalDate(updatedFlight.getArrivalDate());
		flight.setArrivalTime(updatedFlight.getArrivalTime());
		flight.setFlightName(updatedFlight.getFlightName());
		flight.setFlightClass(updatedFlight.getFlightClass());
		flight.setServiceProviderName(updatedFlight.getServiceProviderName());
		flight.setAvailability(updatedFlight.getAvailability());
		flight.setPrice(updatedFlight.getPrice());
		
		return flightDao.save(flight);
	}

	@Override
	public Flight getFlightById(int id) {

		return flightDao.findById(id).get();
	}
	
	@Override
	public ServiceProvider getServiceProviderByName(String name) {
		
		return serviceProviderDao.findByServiceProviderName(name);
	}
	
	@Override
	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		return serviceProviderDao.save(serviceProvider);
	}

	@Override
	public BookingOneWayFlight bookingForOneWayFlight(BookingOneWayFlight request) {

		String customerEmail = request.getCustomerEmail();
		OrderForOneWayTrip order = request.getOrder();
		Payment payment = request.getPayment();
		Flight flightRequested = request.getFlight();
		Flight flightInDB = flightDao.findById(flightRequested.getFlightId()).get();
		
		if (!Objects.isNull(flightInDB) && !Objects.isNull(flightRequested)) {
				
			if (flightInDB.getAvailability()>=request.getNumberOfSeatBook() 
					&& flightRequested.getFlightClass().equalsIgnoreCase(flightInDB.getFlightClass())
					&& flightRequested.getDepartureLocation().equalsIgnoreCase(flightInDB.getDepartureLocation())
					&& flightInDB.getDepartureDate().equals(flightRequested.getDepartureDate())
					&& flightInDB.getArrivalLocation().equalsIgnoreCase(flightRequested.getArrivalLocation())
					&& flightInDB.getArrivalDate().equals(flightRequested.getArrivalDate())) {
				
				order.setCustomerEmail(customerEmail);
				order.setTripType(Constant.ONE_WAY);
				order.setTotalAmount(flightInDB.getPrice());
				order.setProductId(flightRequested.getFlightId());
				order.setServiceProviderName(flightInDB.getServiceProviderName());
				order.setOrderDate(LocalDate.now());
				order.setOrderTime(LocalTime.now());
				order.setOrderStatus(Constant.ORDER_PROCESSING);
				order.setNoOfSeatBook(request.getNumberOfSeatBook());
				OrderForOneWayTrip orderProcessing = oneWayOrderDao.save(order);

				payment.setCustomerEmail(customerEmail);
				payment.setOrderId(orderProcessing.getOrderId());
				payment.setTotalAmount(orderProcessing.getTotalAmount());
				ResponseEntity<Payment> paymentResponse = template.postForEntity(Constant.PAYMENT_URL, payment,
						Payment.class);

				if (paymentResponse.getStatusCodeValue() == 200) {

					flightInDB.setAvailability(flightInDB.getAvailability() -request.getNumberOfSeatBook());
					Flight updatedFlightInDB = flightDao.save(flightInDB);

					orderProcessing.setTransactionId(paymentResponse.getBody().getTransactionId());
					orderProcessing.setOrderStatus(Constant.ORDER_SUCCESSFUL);
					OrderForOneWayTrip finalOrder = oneWayOrderDao.save(orderProcessing);

					String serviceProvider = getServiceProviderByName(finalOrder.getServiceProviderName()).toString();
					log.info("For User - Hotel Booking Successful : {}",serviceProvider);
					log.info("For Service Provider - Hotel book with : {}",finalOrder.toString());
					
					return new BookingOneWayFlight(customerEmail,finalOrder, paymentResponse.getBody(),
							flightInDB, request.getNumberOfSeatBook());
				} else {
					log.info("payment fail so, order cancel");
					
					orderProcessing.setOrderStatus(Constant.ORDER_FAIL);
					OrderForOneWayTrip finalOrder = oneWayOrderDao.save(orderProcessing);
					
					return  new BookingOneWayFlight(customerEmail,finalOrder, payment,
							flightInDB, request.getNumberOfSeatBook());
				}

			} else {
				log.info("flight does not have enough seat or not has flight according to user neeed.");
				return null;
			}

		} else {
			return null;
		}
	}

	@Override
	public BookingTwoWayFlight bookingForTwoWayFlight(BookingTwoWayFlight request) {
		
        OrderForTwoWayTrip order = request.getOrder();
        Flight flight1 = request.getFlight1();
        Flight flight2 = request.getFlight2();
        Flight flight1InDB = flightDao.findById(flight1.getFlightId()).get();
        Flight flight2InDB = flightDao.findById(flight2.getFlightId()).get();
        Payment payment = request.getPayment();
        
        if(!Objects.isNull(flight1InDB) && !Objects.isNull(flight2InDB)) {
        	
        	if((flight1InDB.getAvailability()>=request.getNoOfSeatBook() 
        			&& flight1.getFlightClass().equalsIgnoreCase(flight1InDB.getFlightClass())
					&& flight1InDB.getDepartureDate().equals(flight1.getDepartureDate())
					&& flight1InDB.getArrivalLocation().equalsIgnoreCase(flight1.getArrivalLocation())
					&& flight1InDB.getArrivalLocation().equalsIgnoreCase(flight1.getArrivalLocation())
					&& flight1InDB.getArrivalDate().equals(flight1.getArrivalDate()))
        			&& 
        			(flight2InDB.getAvailability()>=request.getNoOfSeatBook() 
        			&& flight2.getFlightClass().equalsIgnoreCase(flight2InDB.getFlightClass())
        			&& flight2InDB.getDepartureDate().equals(flight2.getDepartureDate())
        			&& flight2InDB.getArrivalLocation().equalsIgnoreCase(flight2.getArrivalLocation())
        			&& flight2InDB.getArrivalLocation().equalsIgnoreCase(flight2.getArrivalLocation())
        			&& flight2InDB.getArrivalDate().equals(flight2.getArrivalDate()))) {
        		
        		order.setProduct1Id(flight1.getFlightId());
        		order.setProduct2Id(flight2.getFlightId());
        		order.setServiceProviderName1(flight1InDB.getServiceProviderName());
        		order.setServiceProviderName2(flight2InDB.getServiceProviderName());
        		order.setTotalAmount(flight1.getPrice());
        		order.setCustomerEmail(request.getCustomerEmail());
        		order.setTotalAmount(flight1InDB.getPrice()+flight2InDB.getPrice());
        		order.setOrderDate(LocalDate.now());
        		order.setOrderTime(LocalTime.now());
        		order.setOrderStatus(Constant.ORDER_PROCESSING);
        		order.setTripType(Constant.TWO_WAY);
        		order.setNoOfSeatBook(request.getNoOfSeatBook());
        		OrderForTwoWayTrip orderProcessing = twoWayOrderDao.save(order);
        		
        		
        		payment.setCustomerEmail(request.getCustomerEmail());
				payment.setOrderId(orderProcessing.getOrderId());
				payment.setTotalAmount(orderProcessing.getTotalAmount());
        		ResponseEntity<Payment> paymentResponse = template.postForEntity(Constant.PAYMENT_URL, payment,
						Payment.class);
        		
        		if (paymentResponse.getStatusCodeValue() == 200) {

					flight1InDB.setAvailability(flight1InDB.getAvailability() -request.getNoOfSeatBook());
					Flight updatedFlight1InDB = flightDao.save(flight1InDB);
					flight2InDB.setAvailability(flight2InDB.getAvailability() -request.getNoOfSeatBook());
					Flight updatedFlight2InDB = flightDao.save(flight2InDB);

					orderProcessing.setTransactionId(paymentResponse.getBody().getTransactionId());
					orderProcessing.setOrderStatus(Constant.ORDER_SUCCESSFUL);
					OrderForTwoWayTrip finalOrder = twoWayOrderDao.save(orderProcessing);

					String serviceProvider1 = getServiceProviderByName(finalOrder.getServiceProviderName1()).toString();
					String serviceProvider2 = getServiceProviderByName(finalOrder.getServiceProviderName2()).toString();
					log.info("For User - Flight Booking Successful : {}",serviceProvider1);
					log.info("For User - Flight Booking for return trip: {}",serviceProvider2);
					log.info("For Service Provider - flight book with : {}",finalOrder.toString());
					
					return new BookingTwoWayFlight(finalOrder, paymentResponse.getBody(),
							flight1InDB,flight2InDB, request.getNoOfSeatBook(),request.getCustomerEmail());
				} else {
					log.info("payment fail so, order cancel");
					
					orderProcessing.setOrderStatus(Constant.ORDER_FAIL);
					OrderForTwoWayTrip finalOrder = twoWayOrderDao.save(orderProcessing);
					
					return  new BookingTwoWayFlight(finalOrder, paymentResponse.getBody(),
							flight1InDB,flight2InDB, request.getNoOfSeatBook(),request.getCustomerEmail());
				}

			} else {
				log.info("flight does not have enough seat or not has flight according to user neeed.");
				return null;
			}

		} else {
			return null;
		}
	}

	@Override
	public OrderForOneWayTrip cancelOneWayFlight(OrderForOneWayTrip order) {
		String customerEmail = order.getCustomerEmail();
		//Flight flight = flightDao.findById(order.getProductId()).get();
		Flight flightInDb = flightDao.findById(order.getProductId()).get();
		
		ResponseEntity<Payment> paymentEntity = template.getForEntity(Constant.PAYMENT_URL+order.getTransactionId(), Payment.class);
	    Payment payment = paymentEntity.getBody();
		
	    if(paymentEntity.getStatusCode().equals(HttpStatus.OK)) {
		
			
			if(!Objects.isNull(flightInDb)) {
				
			    flightInDb.setAvailability(flightInDb.getAvailability()+order.getNoOfSeatBook());
			    Flight updatedFlight = updateFlight(flightInDb.getFlightId(), flightInDb);
				
			    payment.setPaymentStatus(Constant.PAYMENT_CANCEL);
				template.put(Constant.PAYMENT_URL+payment.getPaymentId(), payment);
				
				order.setOrderStatus(Constant.ORDER_CANCEL);
				OrderForOneWayTrip updatedOrder = oneWayOrderDao.save(order);
				
				log.info("For User - Flight Booking cancel Successful");
				
				log.info("For Service Provider - Flight booking cancel");
				return updatedOrder;
			}else {

				log.info("Flight with given id does not exists.");
				return null;
			}
			
		}else {
			//payment not found or some error
			log.info("Payment do not found with id: ",payment.getPaymentId());
			return null;
		}
		
	}

	@Override
	public OrderForTwoWayTrip cancelTwoWayFlight(OrderForTwoWayTrip order) {
		String customerEmail = order.getCustomerEmail();
		//Flight flight = flightDao.findById(order.getProductId()).get();
		Flight flight1InDb = flightDao.findById(order.getProduct1Id()).get();
		Flight flight2InDb = flightDao.findById(order.getProduct2Id()).get();
		
		ResponseEntity<Payment> paymentEntity = template.getForEntity(Constant.PAYMENT_URL+order.getTransactionId(), Payment.class);
	    Payment payment = paymentEntity.getBody();
		
	    if(paymentEntity.getStatusCode().equals(HttpStatus.OK)) {
		
			
			if(!Objects.isNull(flight1InDb) && !Objects.isNull(flight2InDb)) {
				
			    flight1InDb.setAvailability(flight1InDb.getAvailability()+order.getNoOfSeatBook());
			    Flight updatedFlight1 = updateFlight(flight1InDb.getFlightId(), flight1InDb);
			    
			    flight2InDb.setAvailability(flight2InDb.getAvailability()+order.getNoOfSeatBook());
			    Flight updatedFlight2 = updateFlight(flight2InDb.getFlightId(), flight2InDb);
			    
			    payment.setPaymentStatus(Constant.PAYMENT_CANCEL);
				template.put(Constant.PAYMENT_URL+payment.getPaymentId(), payment);
				
				order.setOrderStatus(Constant.ORDER_CANCEL);
				OrderForTwoWayTrip updatedOrder = twoWayOrderDao.save(order);
				
				log.info("For User - Flight Booking cancel Successful");
				
				log.info("For Service Provider - Flight booking cancel");
				return updatedOrder;
			}else {

				log.info("Flight with given id does not exists.");
				return null;
			}
			
		}else {
			//payment not found or some error
			log.info("Payment do not found with id: ",payment.getPaymentId());
			return null;
		}
		
	}
	
	@Override
	public List<OrderForOneWayTrip> allOneWayTripByCustomer(String email) {
		List<OrderForOneWayTrip> orders = oneWayOrderDao.findByCustomerEmail(email).get();
		return orders;
	}

	@Override
	public List<OrderForTwoWayTrip> allTwoWayTripByCustomer(String email) {
		List<OrderForTwoWayTrip> orders = twoWayOrderDao.findByCustomerEmail(email).get();
		return orders;
	}
	
	
	
	/*@Override
	public OrderForOneWayTrip getOrderById(int id) {
		return orderDao.findById(id).get();
	}

	@Override
	public List<OrderForOneWayTrip> allOrders() {
		return orderDao.findAll();
	}

	@Override
	public void deleteOrder(int id) {

		orderDao.deleteById(id);
	}

	@Override
	public OrderForOneWayTrip updateOrder(int id, OrderForOneWayTrip updatedOrder) {
		OrderForOneWayTrip order = orderDao.findById(id).get();
		order.setProductId(updatedOrder.getProductId());
		order.setServiceProviderName(updatedOrder.getServiceProviderName());
		order.setCustomerEmail(updatedOrder.getCustomerEmail());
		order.setTransactionId(updatedOrder.getTransactionId());
		order.setTotalAmount(updatedOrder.getTotalAmount());
		order.setOrderDate(updatedOrder.getOrderDate());
		order.setOrderTime(updatedOrder.getOrderTime());
		order.setOrderStatus(updatedOrder.getOrderStatus());
		order.setTripType(updatedOrder.getTripType());
		order.setNoOfSeatBook(updatedOrder.getNoOfSeatBook());
		return orderDao.save(order);
	}*/

}

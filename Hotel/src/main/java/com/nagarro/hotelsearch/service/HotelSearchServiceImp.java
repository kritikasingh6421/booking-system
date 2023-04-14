package com.nagarro.hotelsearch.service;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.hotelsearch.constant.Constants;
import com.nagarro.hotelsearch.dao.HotelSearchDao;
import com.nagarro.hotelsearch.dao.OrderDao;
import com.nagarro.hotelsearch.dao.ServiceProviderDao;
import com.nagarro.hotelsearch.dto.HotelBooking;
import com.nagarro.hotelsearch.dto.Payment;
import com.nagarro.hotelsearch.entity.Hotel;
import com.nagarro.hotelsearch.entity.Order;
import com.nagarro.hotelsearch.entity.ServiceProvider;

@Service
public class HotelSearchServiceImp implements HotelSearchService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private RestTemplate template;

	@Autowired
	private ServiceProviderDao serviceProviderDao;

	@Autowired
	private HotelSearchDao dao;

	private Logger log = LoggerFactory.getLogger(HotelSearchServiceImp.class);

	public List<Hotel> listOfHotels(String name, String city, LocalDate checkInDate, LocalDate checkOutDate) {
		List<Hotel> hotels = dao.findAll();
		List<Hotel> shortedHotel = new ArrayList<Hotel>();
		for (Hotel hotel : hotels) {
			if (!hotel.isBooked()) {
				if (hotel.getHotelName().equalsIgnoreCase(name) && hotel.getCity().equalsIgnoreCase(city)
						&& hotel.getCheckInDate().equals(checkInDate) && hotel.getCheckOutDate().equals(checkOutDate)) {
					shortedHotel.add(hotel);
				}
			}
		}
		return shortedHotel;
	}

	public List<Hotel> wishListedHotel() {

		List<Hotel> hotels = dao.findAll();
		List<Hotel> wishListedHotel = new ArrayList<Hotel>();
		for (Hotel hotel : hotels) {
			if (hotel.isWishlist()) {
				wishListedHotel.add(hotel);
			}
		}
		return wishListedHotel;
	}

	public List<Hotel> allHotels() {
		return dao.findAll();
	}

	public Hotel addHotel(Hotel hotel) {
		if (hotel.getNumberOfRoomsAvailable() == 0) {
			hotel.setBooked(true);
		} else {
			hotel.setBooked(false);
		}
		hotel.setWishlist(false);
		return dao.save(hotel);
	}

	public void deleteHotel(int id) {
		dao.deleteById(id);
	}

	public Hotel getHotelById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public Hotel updateHotel(int id, Hotel updateHotel) {
		Hotel hotel = dao.findById(id).get();
		hotel.setServiceProviderName(updateHotel.getServiceProviderName());
		hotel.setHotelName(updateHotel.getHotelName());
		hotel.setCity(updateHotel.getCity());
		hotel.setNumberOfRoomsAvailable(updateHotel.getNumberOfRoomsAvailable());
		hotel.setCheckInDate(updateHotel.getCheckInDate());
		hotel.setCheckInTime(updateHotel.getCheckInTime());
		hotel.setCheckOutDate(updateHotel.getCheckOutDate());
		hotel.setCheckOutTime(updateHotel.getCheckOutTime());
		hotel.setWishlist(updateHotel.isWishlist());
		if(updateHotel.getNumberOfRoomsAvailable()==0) {
			hotel.setBooked(true);
		}else {
			hotel.setBooked(false);
		}
		hotel.setPrice(updateHotel.getPrice());
		return dao.save(hotel);
	}

	@Override
	public Hotel addToWishList(int id) {
		Hotel hotel = dao.findById(id).get();
		hotel.setWishlist(true);
		return dao.save(hotel);
	}

	@Override
	public ServiceProvider getServiceProviderByName(String name) {

		return serviceProviderDao.findByServiceProviderName(name).get();
	}

	@Override
	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		return serviceProviderDao.save(serviceProvider);
	}
	
	@Override
	public Order getOrderById(int id) {
		return orderDao.findById(id).get();
	}

	@Override
	public List<Order> allOrders() {
		return orderDao.findAll();
	}

	@Override
	public void deleteOrder(int id) {

		orderDao.deleteById(id);
	}

	@Override
	public Order updateOrder(int id, Order updatedOrder) {
		Order order = orderDao.findById(id).get();
		order.setProductId(updatedOrder.getProductId());
		order.setServiceProviderName(updatedOrder.getServiceProviderName());
		order.setCustomerEmail(updatedOrder.getCustomerEmail());
		order.setTransactionId(updatedOrder.getTransactionId());
		order.setTotalAmount(updatedOrder.getTotalAmount());
		order.setOrderDate(updatedOrder.getOrderDate());
		order.setOrderTime(updatedOrder.getOrderTime());
		order.setOrderStatus(updatedOrder.getOrderStatus());
		order.setNumberOfRoomBook(updatedOrder.getNumberOfRoomBook());
		return orderDao.save(order);
	}

	@Override
	public HotelBooking orderPlace(HotelBooking request) {
		String customerEmail = request.getCustomerEmail();
		Hotel hotel = request.getHotel();
		Payment payment = request.getPayment();
		Order order = request.getOrder();
		Hotel hotelInDb = dao.findById(hotel.getHotelId()).get();
		if (!Objects.isNull(hotelInDb) && !Objects.isNull(hotel)) {

			if (hotelInDb.getNumberOfRoomsAvailable() >= request.getNumberOfRoomBook()
					&& hotelInDb.getCheckInDate().equals(hotel.getCheckInDate())
					&& hotelInDb.getCity().equalsIgnoreCase(hotel.getCity())
					&& hotelInDb.getHotelName().equalsIgnoreCase(hotel.getHotelName())) {

				/*hotel.setServiceProviderName(hotelInDb.getServiceProviderName());
				hotel.setNumberOfRoomsAvailable(request.getNumberOfRoomBook());
				hotel.setPrice(hotelInDb.getPrice());
				hotel.setCheckInDate(hotelInDb.getCheckOutDate());
				hotel.setCheckInTime(hotelInDb.getCheckInTime());
				hotel.setCheckOutTime(hotelInDb.getCheckOutTime());
				hotel.setCheckOutDate(hotelInDb.getCheckOutDate());*/

				order.setCustomerEmail(customerEmail);
				order.setProductId(hotel.getHotelId());
				order.setServiceProviderName(hotelInDb.getServiceProviderName());
				order.setTotalAmount(hotelInDb.getPrice());
				order.setOrderDate(LocalDate.now());
				order.setOrderTime(LocalTime.now());
				order.setOrderStatus(Constants.ORDER_PROCESSING);
				order.setNumberOfRoomBook(request.getNumberOfRoomBook());
				Order processingOrder = orderDao.save(order);

				payment.setCustomerEmail(request.getCustomerEmail());
				payment.setOrderId(order.getOrderId());
				payment.setTotalAmount(hotelInDb.getPrice());

				ResponseEntity<Payment> paymentResponse = template.postForEntity(Constants.PAYMENT_URL, payment,
						Payment.class);

				if (paymentResponse.getStatusCode().equals(HttpStatus.OK)) {
					
					hotelInDb
					.setNumberOfRoomsAvailable(hotelInDb.getNumberOfRoomsAvailable() - order.getNumberOfRoomBook());
			Hotel updatedHotel = updateHotel(hotelInDb.getHotelId(), hotelInDb);

					processingOrder.setTransactionId(paymentResponse.getBody().getTransactionId());
					processingOrder.setOrderStatus(Constants.ORDER_SUCCESSFUL);
					Order completedOrder = updateOrder(processingOrder.getOrderId(), processingOrder);

					String serviceProvider = getServiceProviderByName(completedOrder.getServiceProviderName()).toString();
						log.info("For User - Hotel Booking Successful : {}",serviceProvider);
						log.info("For Service Provider - Hotel book with : {}",completedOrder.toString());


					return new HotelBooking(customerEmail, updatedHotel, paymentResponse.getBody(), completedOrder,
							request.getNumberOfRoomBook());

				} else {
					// payment fail
					processingOrder.setOrderStatus(Constants.ORDER_FAIL);
					Order completedOrder = updateOrder(processingOrder.getOrderId(), processingOrder);

					log.info("For User - Hotel Booking Fail");
					return null;
				}

			} else {
				// room not enough
				log.info(" Hotel do not have enough rooms or does not match with user specifications");
				return null;
			}
		}
		log.info("Hotel does not exits");
		return null;
	}

	@Override
	public Order orderCancel(Order order){

		String customerEmail = order.getCustomerEmail();
		// Hotel hotel = dao.findById(order.getProductId()).get();
		Hotel hotelInDb = dao.findById(order.getProductId()).get();

		
		ResponseEntity<Payment> paymentEntity = template.getForEntity(Constants.PAYMENT_URL + order.getTransactionId(),
				Payment.class);
		
		Payment payment = paymentEntity.getBody();

		if (paymentEntity.getStatusCode().equals(HttpStatus.OK)) {

			if (!Objects.isNull(hotelInDb)) {

				hotelInDb
						.setNumberOfRoomsAvailable(hotelInDb.getNumberOfRoomsAvailable() + order.getNumberOfRoomBook());
				Hotel updatedHotel = updateHotel(hotelInDb.getHotelId(), hotelInDb);

				payment.setPaymentStatus(Constants.PAYMENT_CANCEL);
				template.put(Constants.PAYMENT_URL + payment.getPaymentId(), payment);

				order.setOrderStatus(Constants.ORDER_CANCEL);
				Order updatedOrder = updateOrder(order.getOrderId(), order);
					
				log.info("For User - Hotel Booking cancel Successful");
					
				log.info("For Service Provider - Hotel booking cancel");
				
				return updatedOrder;
			}else {
				log.info("Hotel with given id does not exists.");
				return null;
			}

		} else {
			// payment not found or some error
			log.info("Payment do not found with id: ",payment.getPaymentId());
			return null;
		}
	}

	@Override
	public List<Order> allOrderByCustomer(String email) {
		List<Order> orders = orderDao.findByCustomerEmail(email).get();
		return orders;
	}

}

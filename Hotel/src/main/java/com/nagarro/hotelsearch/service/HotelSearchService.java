/**
 * 
 */
package com.nagarro.hotelsearch.service;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagarro.hotelsearch.dto.HotelBooking;
import com.nagarro.hotelsearch.entity.Hotel;
import com.nagarro.hotelsearch.entity.Order;
import com.nagarro.hotelsearch.entity.ServiceProvider;

/**
 * @author kritikasingh02
 *
 */
public interface HotelSearchService {

	public List<Hotel> listOfHotels(String name, String city, LocalDate checkInDate, LocalDate checkOutDate);

	public List<Hotel> wishListedHotel();

	public Hotel addToWishList(int id);

	public List<Hotel> allHotels();

	public Hotel addHotel(Hotel hotel);

	public void deleteHotel(int id);

	public Hotel getHotelById(int id);

	public Hotel updateHotel(int id, Hotel updateHotel);

	public ServiceProvider getServiceProviderByName(String name);
	
	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider);

	public Order getOrderById(int id);

	public List<Order> allOrders();

	public void deleteOrder(int id);

	public Order updateOrder(int id, Order updatedOrder);
	
	public HotelBooking orderPlace(HotelBooking request);
	
	public Order orderCancel(Order order);
	
	public List<Order> allOrderByCustomer(String email);
}

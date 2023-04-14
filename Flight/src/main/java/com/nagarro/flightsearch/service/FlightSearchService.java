/**
 * 
 */
package com.nagarro.flightsearch.service;

import java.time.LocalDate;
import java.util.List;

import com.nagarro.flightsearch.dto.BookingOneWayFlight;
import com.nagarro.flightsearch.dto.BookingTwoWayFlight;
import com.nagarro.flightsearch.entity.Flight;
import com.nagarro.flightsearch.entity.OrderForOneWayTrip;
import com.nagarro.flightsearch.entity.OrderForTwoWayTrip;
import com.nagarro.flightsearch.entity.ServiceProvider;

/**
 * @author kritikasingh02
 *
 */
public interface FlightSearchService {

	public List<Flight> allFlights();

	public List<Flight> allPreferenceSpecificFlights(String departureLocation, String arrivalLocation,
			String flightClass, LocalDate date);

	public Flight addFlight(Flight flight);

	public void deleteFlight(int id);

	public Flight updateFlight(int id, Flight updatedFlight);

	public Flight getFlightById(int id);

	public ServiceProvider getServiceProviderByName(String name);

	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider);

	public BookingOneWayFlight bookingForOneWayFlight(BookingOneWayFlight request);

	public BookingTwoWayFlight bookingForTwoWayFlight(BookingTwoWayFlight request);

	public OrderForOneWayTrip cancelOneWayFlight(OrderForOneWayTrip order);

	public OrderForTwoWayTrip cancelTwoWayFlight(OrderForTwoWayTrip order);

	public List<OrderForOneWayTrip> allOneWayTripByCustomer(String email);

	public List<OrderForTwoWayTrip> allTwoWayTripByCustomer(String email);

}

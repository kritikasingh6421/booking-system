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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;

/**
 * @author kritikasingh02
 *
 */
@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightId;
	
	@Column(nullable=false)
	private String serviceProviderName;
	
	@Column(nullable=false)
	private String flightName;
	
	@Column(nullable=false)
	private String departureLocation;
	
    @Column(nullable=false)
	private LocalDate departureDate;
	
	@Column(nullable=false)
	private LocalTime departureTime;
	
	@Column(nullable=false)
	private String arrivalLocation;
	
	@Column(nullable=false)
	private LocalDate arrivalDate;
	
	@Column(nullable=false)
	private LocalTime arrivalTime;
	
	@Column(nullable=false)
	private String flightClass;
	
	@Column(nullable=false)
	private int availability;
	
	@Column(nullable=false)
	private double price;
	
	/**
	 * 
	 */
	public Flight() {}

	/**
	 * @param flightId
	 * @param serviceProviderName
	 * @param flightName
	 * @param departureLocation
	 * @param departureDate
	 * @param departureTime
	 * @param arrivalLocation
	 * @param arrivalDate
	 * @param arrivalTime
	 * @param flightClass
	 * @param availability
	 * @param price
	 */
	public Flight(int flightId, String serviceProviderName, String flightName, String departureLocation,
			LocalDate departureDate, LocalTime departureTime, String arrivalLocation, LocalDate arrivalDate,
			LocalTime arrivalTime, String flightClass, int availability, double price) {
		super();
		this.flightId = flightId;
		this.serviceProviderName = serviceProviderName;
		this.flightName = flightName;
		this.departureLocation = departureLocation;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalLocation = arrivalLocation;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.flightClass = flightClass;
		this.availability = availability;
		this.price = price;
	}

	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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
	 * @return the flightName
	 */
	public String getFlightName() {
		return flightName;
	}

	/**
	 * @param flightName the flightName to set
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	/**
	 * @return the departureLocation
	 */
	public String getDepartureLocation() {
		return departureLocation;
	}

	/**
	 * @param departureLocation the departureLocation to set
	 */
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	/**
	 * @return the departureDate
	 */
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = LocalDate.of(departureDate.getYear(), departureDate.getMonthValue(), departureDate.getDayOfMonth());
	}

	/**
	 * @return the departureTime
	 */
	public LocalTime getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = LocalTime.of(departureTime.getHour(), departureTime.getMinute());
	}

	/**
	 * @return the arrivalLocation
	 */
	public String getArrivalLocation() {
		return arrivalLocation;
	}

	/**
	 * @param arrivalLocation the arrivalLocation to set
	 */
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	/**
	 * @return the arrivalDate
	 */
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(LocalDate arrivalDate) {
		int year = arrivalDate.getYear();
		int month = arrivalDate.getMonthValue();
		int dayOfMonth = arrivalDate.getDayOfMonth();
		this.arrivalDate = LocalDate.of(year, month, dayOfMonth);
	}

	/**
	 * @return the arrivalTime
	 */
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(LocalTime arrivalTime) {
		int hour = arrivalTime.getHour();
		int minute = arrivalTime.getMinute();
		this.arrivalTime = LocalTime.of(hour, minute);
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * @return the availability
	 */
	public int getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(int availability) {
		this.availability = availability;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
}

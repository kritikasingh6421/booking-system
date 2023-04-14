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
@Table(name="hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelId;
	
	@Column(nullable=false)
	private String serviceProviderName;
	
	@Column(nullable= false)
	private String hotelName;
	
	@Column(nullable= false)
	private String city;
	
	@Column(nullable=false)
	private int numberOfRoomsAvailable;
	
	@Column(nullable=false)
	private double price;
	
	@Column(nullable = false)
	private LocalDate checkInDate;
	
	@Column(nullable = false)
	private LocalTime checkInTime;
	
	@Column(nullable=false)
	private LocalDate checkOutDate;
	
	@Column(nullable=false)
	private LocalTime checkOutTime;
	
	@Column(nullable=false)
	private boolean wishlist;
	
	@Column(nullable=false)
	private boolean booked;

	
	/**
	 * 
	 */
	public Hotel() {}

	/**
	 * @param hotelId
	 * @param serviceProviderName
	 * @param hotelName
	 * @param city
	 * @param numberOfRoomsAvailable
	 * @param price
	 * @param checkInDate
	 * @param checkInTime
	 * @param checkOutDate
	 * @param checkOutTime
	 * @param wishlist
	 * @param booked
	 */
	public Hotel(int hotelId, String serviceProviderName, String hotelName, String city, int numberOfRoomsAvailable,
			double price, LocalDate checkInDate, LocalTime checkInTime, LocalDate checkOutDate, LocalTime checkOutTime,
			boolean wishlist, boolean booked) {
		super();
		this.hotelId = hotelId;
		this.serviceProviderName = serviceProviderName;
		this.hotelName = hotelName;
		this.city = city;
		this.numberOfRoomsAvailable = numberOfRoomsAvailable;
		this.price = price;
		this.checkInDate = checkInDate;
		this.checkInTime = checkInTime;
		this.checkOutDate = checkOutDate;
		this.checkOutTime = checkOutTime;
		this.wishlist = wishlist;
		this.booked = booked;
	}


	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}


	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
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
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}


	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the numberOfRoomsAvailable
	 */
	public int getNumberOfRoomsAvailable() {
		return numberOfRoomsAvailable;
	}


	/**
	 * @param numberOfRoomsAvailable the numberOfRoomsAvailable to set
	 */
	public void setNumberOfRoomsAvailable(int numberOfRoomsAvailable) {
		this.numberOfRoomsAvailable = numberOfRoomsAvailable;
	}


	/**
	 * @return the checkInDate
	 */
	public LocalDate getCheckInDate() {
		return checkInDate;
	}


	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}


	/**
	 * @return the checkInTime
	 */
	public LocalTime getCheckInTime() {
		return checkInTime;
	}


	/**
	 * @param checkInTime the checkInTime to set
	 */
	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}


	/**
	 * @return the checkOutDate
	 */
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}


	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	/**
	 * @return the checkOutTime
	 */
	public LocalTime getCheckOutTime() {
		return checkOutTime;
	}


	/**
	 * @param checkOutTime the checkOutTime to set
	 */
	public void setCheckOutTime(LocalTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}


	/**
	 * @return the wishlist
	 */
	public boolean isWishlist() {
		return wishlist;
	}


	/**
	 * @param wishlist the wishlist to set
	 */
	public void setWishlist(boolean wishlist) {
		this.wishlist = wishlist;
	}


	/**
	 * @return the booked
	 */
	public boolean isBooked() {
		return booked;
	}


	/**
	 * @param booked the booked to set
	 */
	public void setBooked(boolean booked) {
		this.booked = booked;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", serviceProviderName=" + serviceProviderName + ", hotelName=" + hotelName
				+ ", city=" + city + ", numberOfRoomsAvailable=" + numberOfRoomsAvailable + ", checkInDate="
				+ checkInDate + ", checkInTime=" + checkInTime + ", checkOutDate=" + checkOutDate + ", checkOutTime="
				+ checkOutTime + ", wishlist=" + wishlist + ", booked=" + booked + "]";
	}
	

}

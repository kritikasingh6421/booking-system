/**
 * 
 */
package com.nagarro.flightsearch.entity;

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
@Table(name="service_providers")
public class ServiceProvider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceProviderId;
	
	@Column(nullable=false)
	private String serviceProviderName;
	
	@Column(nullable=false)
	private String serviceProviderEmail;
	
	@Column(nullable=false)
	private int serviceProviderNumber;

	/**
	 * 
	 */
	public ServiceProvider() {}

	/**
	 * @param serviceProviderId
	 * @param serviceProviderName
	 * @param serviceProviderEmail
	 * @param serviceProviderNumber
	 */
	public ServiceProvider(int serviceProviderId, String serviceProviderName, String serviceProviderEmail,
			int serviceProviderNumber) {
		this.serviceProviderId = serviceProviderId;
		this.serviceProviderName = serviceProviderName;
		this.serviceProviderEmail = serviceProviderEmail;
		this.serviceProviderNumber = serviceProviderNumber;
	}

	/**
	 * @return the serviceProviderId
	 */
	public int getServiceProviderId() {
		return serviceProviderId;
	}

	/**
	 * @param serviceProviderId the serviceProviderId to set
	 */
	public void setServiceProviderId(int serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
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
	 * @return the serviceProviderEmail
	 */
	public String getServiceProviderEmail() {
		return serviceProviderEmail;
	}

	/**
	 * @param serviceProviderEmail the serviceProviderEmail to set
	 */
	public void setServiceProviderEmail(String serviceProviderEmail) {
		this.serviceProviderEmail = serviceProviderEmail;
	}

	/**
	 * @return the serviceProviderNumber
	 */
	public int getServiceProviderNumber() {
		return serviceProviderNumber;
	}

	/**
	 * @param serviceProviderNumber the serviceProviderNumber to set
	 */
	public void setServiceProviderNumber(int serviceProviderNumber) {
		this.serviceProviderNumber = serviceProviderNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceProvider [serviceProviderId=" + serviceProviderId + ", serviceProviderName="
				+ serviceProviderName + ", serviceProviderEmail=" + serviceProviderEmail + ", serviceProviderNumber="
				+ serviceProviderNumber + "]";
	}
}

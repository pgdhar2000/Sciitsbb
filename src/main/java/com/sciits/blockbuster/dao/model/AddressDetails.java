/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sciits.blockbuster.model.BaseData;
import com.sciits.blockbuster.web.model.WebAddressDetails;

@Entity
@Table(name = "address_details")
public class AddressDetails extends BaseData {
	private static final long serialVersionUID = 5252390486377465535L;
	
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID", length = 20, nullable = false)
	private Long addressId;
	
	@OneToOne
	private AddressTypeDetails addressTypeDetails;
	
	@Column(name = "STREET_ADDRESS", length = 45, nullable = false)
	private String streetAddress;
	
	@Column(name = "CITY", length = 25, nullable = false)
	private String city;
	
	@OneToOne
	private CountryDetails countryDetails;

	public AddressDetails(){}
	
	public AddressDetails(Long addressId, AddressTypeDetails addressTypeDetails, String streetAddress, String city,
			CountryDetails countryDetails) {
		super();
		this.addressId = addressId;
		this.addressTypeDetails = addressTypeDetails;
		this.streetAddress = streetAddress;
		this.city = city;
		this.countryDetails = countryDetails;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public AddressTypeDetails getAddressTypeDetails() {
		return addressTypeDetails;
	}

	public void setAddressTypeDetails(AddressTypeDetails addressTypeDetails) {
		this.addressTypeDetails = addressTypeDetails;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}
	
	public WebAddressDetails getAddressDetails(){
		WebAddressDetails webAddressDetails = new WebAddressDetails();
		webAddressDetails.setCity(city);
		webAddressDetails.setStreetAddress(streetAddress);
		webAddressDetails.setCountryDetails(countryDetails);
		return webAddressDetails;
	}
}
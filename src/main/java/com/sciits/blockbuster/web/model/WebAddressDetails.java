/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.web.model;

import com.sciits.blockbuster.dao.model.CountryDetails;

public class WebAddressDetails {
	private String streetAddress;
	private String city;
	private CountryDetails countryDetails;

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
}

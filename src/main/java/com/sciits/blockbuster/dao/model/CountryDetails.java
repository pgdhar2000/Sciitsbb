/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sciits.blockbuster.model.BaseData;
import com.sciits.blockbuster.web.model.WebCountryDetails;

@Entity
@Table(name="country_details")
public class CountryDetails extends BaseData {
	
	private static final long serialVersionUID = 5252093486377465535L;
	
	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID", length = 11, nullable = false)
	private Long countryId;
	
	@Column(name = "COUNTRY_CODE", length = 25, nullable = true)
	private String countryCode;
	
	@Column(name = "COUNTRY_NAME", length = 50, nullable = false)
	private String countryName;

	
	public CountryDetails(){}
	
	public CountryDetails(Long countryId, String countryCode, String countryName) {
		super();
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	/*public WebCountryDetails getWebCountryDetails() {
		WebCountryDetails webCountryDetails = new WebCountryDetails();
		webCountryDetails.setCountryId(countryId);
		webCountryDetails.setCountryCode(countryCode);
		webCountryDetails.setCountryName(countryName);
		return webCountryDetails;
	}*/
}
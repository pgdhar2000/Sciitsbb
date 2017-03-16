/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sciits.blockbuster.model.BaseData;
import com.sciits.blockbuster.web.model.WebRegistredAgentDetails;


@Entity
@Table(name = "registered_agent_details")
public class RegisteredAgentDetails extends BaseData {
	private static final long serialVersionUID = 5252390487367465535L;
	
	@Id
	@GeneratedValue
	@Column(name = "REGISTERED_AGENT_ID", length = 20, nullable = false)
	private Long registeredAagentId;
	
	@Column(name = "REGISTERED_AGENCY_NAME", length = 30, nullable = false)
	private String registeredAgencyName;
	
	@Column(name = "REGISTERED_AGENT_NAME", length = 150, nullable = true)
	private String registeredAgentName;
	
	@Column(name = "STATUS", length = 1, nullable = false)
	private String status;
	
	@Column(name = "REGISTERED_DATE_TIME", nullable = false)
	private Date registeredDateTime;
	
	@Column(name = "EMAIL", length = 150, nullable = false)
	private String email;
	
	@Column(name = "PHONE", length = 15, nullable = false)
	private String phone;
	
	@Column(name = "FAX", length = 15, nullable = false)
	private String fax;
	
	@Column(name = "WEBSITE", length = 50, nullable = false)
	private String website;
	
	@OneToOne
	private AddressDetails addressDetails;

	public RegisteredAgentDetails(){}

	public RegisteredAgentDetails(Long registeredAagentId, String registeredAgencyName, String registeredAgentName,
			String status, Date registeredDateTime, String email, String phone, String fax, String website,
			AddressDetails addressDetails) {
		super();
		this.registeredAagentId = registeredAagentId;
		this.registeredAgencyName = registeredAgencyName;
		this.registeredAgentName = registeredAgentName;
		this.status = status;
		this.registeredDateTime = registeredDateTime;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
		this.website = website;
		this.addressDetails = addressDetails;
	}

	public Long getRegisteredAagentId() {
		return registeredAagentId;
	}

	public void setRegisteredAagentId(Long registeredAagentId) {
		this.registeredAagentId = registeredAagentId;
	}

	public String getRegisteredAgencyName() {
		return registeredAgencyName;
	}

	public void setRegisteredAgencyName(String registeredAgencyName) {
		this.registeredAgencyName = registeredAgencyName;
	}

	public String getRegisteredAgentName() {
		return registeredAgentName;
	}

	public void setRegisteredAgentName(String registeredAgentName) {
		this.registeredAgentName = registeredAgentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegisteredDateTime() {
		return registeredDateTime;
	}

	public void setRegisteredDateTime(Date registeredDateTime) {
		this.registeredDateTime = registeredDateTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	
	public WebRegistredAgentDetails getRegistredAgentDetails() {
		WebRegistredAgentDetails  webRegistredAgentDetails = new WebRegistredAgentDetails();
		webRegistredAgentDetails.setRegisteredAagentId(registeredAagentId);
		webRegistredAgentDetails.setEmail(email);
		webRegistredAgentDetails.setFax(fax);
		webRegistredAgentDetails.setPhone(phone);
		webRegistredAgentDetails.setRegisteredAgencyName(registeredAgencyName);
		webRegistredAgentDetails.setRegisteredAgentName(registeredAgentName);
		webRegistredAgentDetails.setRegisteredDateTime(registeredDateTime);
		webRegistredAgentDetails.setStatus(status);
		webRegistredAgentDetails.setWebsite(website);
		
		return webRegistredAgentDetails;
		
	}
	
}
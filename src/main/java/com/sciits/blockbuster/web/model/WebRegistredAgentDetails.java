/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.web.model;

import java.util.Date;

public class WebRegistredAgentDetails {
	private Long registeredAagentId;
	
	private String registeredAgencyName;

	private String registeredAgentName;

	private String status;

	private Date registeredDateTime;

	private String email;

	private String phone;

	private String fax;

	private String website;

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
}

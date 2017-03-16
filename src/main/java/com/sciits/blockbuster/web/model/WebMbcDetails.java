package com.sciits.blockbuster.web.model;

import java.math.BigDecimal;
import java.util.Date;

import com.sciits.blockbuster.model.BaseData;

public class WebMbcDetails extends BaseData {
	private static final long serialVersionUID = 5252390487367465535L;
	private Long mbcId;
	private String legalName;
	private String mbcUniqueId; 
	private Long totalShares; 
	private String status;
	private String phone; 
	private String fax;
	private String pocEmail;
	private String website;
	private String writtenConfirmation;
	private String raConsentFlag;
	private String finRegFlag;
	private BigDecimal mbcGrossAssets;
	private Long numberEmployees;
	private Date dateTime;
	private String businessPurpose;
	private WebRegistredAgentDetails webRegistredAgentDetails;
	private WebAddressDetails webAddressDetails;

	public Long getMbcId() {
		return mbcId;
	}

	public void setMbcId(Long mbcId) {
		this.mbcId = mbcId;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getMbcUniqueId() {
		return mbcUniqueId;
	}

	public void setMbcUniqueId(String mbcUniqueId) {
		this.mbcUniqueId = mbcUniqueId;
	}

	public Long getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(Long totalShares) {
		this.totalShares = totalShares;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPocEmail() {
		return pocEmail;
	}

	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWrittenConfirmation() {
		return writtenConfirmation;
	}

	public void setWrittenConfirmation(String writtenConfirmation) {
		this.writtenConfirmation = writtenConfirmation;
	}

	public String getRaConsentFlag() {
		return raConsentFlag;
	}

	public void setRaConsentFlag(String raConsentFlag) {
		this.raConsentFlag = raConsentFlag;
	}

	public String getFinRegFlag() {
		return finRegFlag;
	}

	public void setFinRegFlag(String finRegFlag) {
		this.finRegFlag = finRegFlag;
	}

	public BigDecimal getMbcGrossAssets() {
		return mbcGrossAssets;
	}

	public void setMbcGrossAssets(BigDecimal mbcGrossAssets) {
		this.mbcGrossAssets = mbcGrossAssets;
	}

	public Long getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Long numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getBusinessPurpose() {
		return businessPurpose;
	}

	public void setBusinessPurpose(String businessPurpose) {
		this.businessPurpose = businessPurpose;
	}

	public WebRegistredAgentDetails getWebRegistredAgentDetails() {
		return webRegistredAgentDetails;
	}

	public void setWebRegistredAgentDetails(WebRegistredAgentDetails webRegistredAgentDetails) {
		this.webRegistredAgentDetails = webRegistredAgentDetails;
	}

	public WebAddressDetails getWebAddressDetails() {
		return webAddressDetails;
	}

	public void setWebAddressDetails(WebAddressDetails webAddressDetails) {
		this.webAddressDetails = webAddressDetails;
	}
}
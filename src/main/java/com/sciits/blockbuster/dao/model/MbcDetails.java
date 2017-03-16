package com.sciits.blockbuster.dao.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sciits.blockbuster.model.BaseData;
import com.sciits.blockbuster.web.model.WebMbcDetails;

@Entity
@Table(name = "mbc_details")
public class MbcDetails extends BaseData {
	
	private static final long serialVersionUID = 5252390487367465535L;
	
	@Id
	@GeneratedValue
	@Column(name = "MBC_ID", length = 20, nullable = false)
	private Long mbcId;
	
	@Column(name = "LEGAL_NAME", length = 45, nullable = false)
	private String legalName;
	
	@Column(name = "MBC_UNIQUE_ID", length = 6, nullable = true)
	private String mbcUniqueId; 
	
	@Column(name = "TOTAL_SHARES", length = 1, nullable = false)
	private Long totalShares; 
	
	@Column(name = "STATUS", length = 1, nullable = false)
	private String status;
	
	@Column(name = "PHONE", length = 15, nullable = false)
	private String phone; 
	
	@Column(name = "FAX", length = 15, nullable = true)
	private String fax;
	
	@Column(name = "POC_EMAIL", length = 30, nullable = false)
	private String pocEmail;
	
	@Column(name = "WEBSITE", length = 30, nullable = true)
	private String website;
	
	@Column(name = "WRITTEN_CONFIRMATION", length = 250, nullable = false)
	private String writtenConfirmation;
	
	@Column(name = "RA_CONSENT_FLAG", length = 1, nullable = false)
	private String raConsentFlag;
	
	@Column(name = "FIN_REG_FLAG", length = 1, nullable = false)
	private String finRegFlag;
	
	@Column(name = "MBC_GROSS_ASSETS", length = 2, nullable = true)
	private BigDecimal mbcGrossAssets;
	
	@Column(name = "NUMBER_EMPLOYEES", length = 11, nullable = true)
	private Long numberEmployees;
	
	@Column(name = "DATE_TIME" ,nullable = false)
	private Date dateTime;
	
	@OneToOne
	private BusinessPurposeDetails businessPurposeDetails;
	
	@OneToOne
	private RegisteredAgentDetails registeredAgentDetails;
	
	@OneToOne
	private AddressDetails addressDetails;
	
	public MbcDetails(){}

	public MbcDetails(Long mbcId, String legalName, String mbcUniqueId, Long totalShares, String status, String phone,
			String fax, String pocEmail, String website, String businessPurpose_id, String writtenConfirmation,
			String raConsentFlag, String finRegFlag, BigDecimal mbcGrossAssets, Long numberEmployees, Date dateTime,
			BusinessPurposeDetails businessPurposeDetails, RegisteredAgentDetails registeredAgentDetails,
			AddressDetails addressDetails) {
		super();
		this.mbcId = mbcId;
		this.legalName = legalName;
		this.mbcUniqueId = mbcUniqueId;
		this.totalShares = totalShares;
		this.status = status;
		this.phone = phone;
		this.fax = fax;
		this.pocEmail = pocEmail;
		this.website = website;
		this.writtenConfirmation = writtenConfirmation;
		this.raConsentFlag = raConsentFlag;
		this.finRegFlag = finRegFlag;
		this.mbcGrossAssets = mbcGrossAssets;
		this.numberEmployees = numberEmployees;
		this.dateTime = dateTime;
		this.businessPurposeDetails = businessPurposeDetails;
		this.registeredAgentDetails = registeredAgentDetails;
		this.addressDetails = addressDetails;
	}

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

	public BusinessPurposeDetails getBusinessPurposeDetails() {
		return businessPurposeDetails;
	}

	public void setBusinessPurposeDetails(BusinessPurposeDetails businessPurposeDetails) {
		this.businessPurposeDetails = businessPurposeDetails;
	}

	public RegisteredAgentDetails getRegisteredAgentDetails() {
		return registeredAgentDetails;
	}

	public void setRegisteredAgentDetails(RegisteredAgentDetails registeredAgentDetails) {
		this.registeredAgentDetails = registeredAgentDetails;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	
	public WebMbcDetails getWebMbcDetails() {
		WebMbcDetails webMbcDetails = new WebMbcDetails();
		webMbcDetails.setMbcId(mbcId);
		webMbcDetails.setDateTime(dateTime);
		webMbcDetails.setFax(fax);
		webMbcDetails.setFinRegFlag(finRegFlag);
		webMbcDetails.setLegalName(legalName);
		webMbcDetails.setMbcGrossAssets(mbcGrossAssets);
		webMbcDetails.setMbcUniqueId(mbcUniqueId);
		webMbcDetails.setNumberEmployees(numberEmployees);
		webMbcDetails.setPhone(phone);
		webMbcDetails.setPocEmail(pocEmail);
		webMbcDetails.setRaConsentFlag(raConsentFlag);
		webMbcDetails.setStatus(status);
		webMbcDetails.setTotalShares(totalShares);
		webMbcDetails.setWebsite(website);
		webMbcDetails.setWrittenConfirmation(writtenConfirmation);
		
		if(businessPurposeDetails != null) {
			webMbcDetails.setBusinessPurpose(businessPurposeDetails.getBusinessPurpose());
		}
		
		if(addressDetails != null) {
			webMbcDetails.setWebAddressDetails(addressDetails.getAddressDetails());
		}
		
		if(registeredAgentDetails != null) {
			webMbcDetails.setWebRegistredAgentDetails(registeredAgentDetails.getRegistredAgentDetails());
		}
		return webMbcDetails;
	}
}
package com.sciits.blockbuster.dao.model;
// Generated Mar 14, 2017 4:58:39 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * MbcRegistrtionTbl generated by hbm2java
 */
@Entity
@Table(name = "MBC_REGISTRTION_TBL")
public class MbcRegistrtionTbl implements java.io.Serializable {

	private int mbcRegistrtionId;
	private UserTbl userTbl;
	private BusinessPurposeTbl businessPurposeTbl;
	private AddressDetailsTbl addressDetailsTbl;
	private String mbcLegalName;
	private String mbcPhone;
	private String mbcFax;
	private String mbcPocEmail;
	private String mbcWebUrl;
	private String mbcNumber;
	private BigDecimal registrationFeeAmt;
	private char registrationFeePaidFlag;
	private Date createdDatetime;

	public MbcRegistrtionTbl() {
	}

	public MbcRegistrtionTbl(int mbcRegistrtionId, BusinessPurposeTbl businessPurposeTbl, String mbcLegalName,
			String mbcPhone, String mbcFax, String mbcPocEmail, String mbcWebUrl, String mbcNumber,
			BigDecimal registrationFeeAmt, char registrationFeePaidFlag, Date createdDatetime) {
		this.mbcRegistrtionId = mbcRegistrtionId;
		this.businessPurposeTbl = businessPurposeTbl;
		this.mbcLegalName = mbcLegalName;
		this.mbcPhone = mbcPhone;
		this.mbcFax = mbcFax;
		this.mbcPocEmail = mbcPocEmail;
		this.mbcWebUrl = mbcWebUrl;
		this.mbcNumber = mbcNumber;
		this.registrationFeeAmt = registrationFeeAmt;
		this.registrationFeePaidFlag = registrationFeePaidFlag;
		this.createdDatetime = createdDatetime;
	}

	public MbcRegistrtionTbl(int mbcRegistrtionId, UserTbl userTbl, BusinessPurposeTbl businessPurposeTbl,
			AddressDetailsTbl addressDetailsTbl, String mbcLegalName, String mbcPhone, String mbcFax,
			String mbcPocEmail, String mbcWebUrl, String mbcNumber, BigDecimal registrationFeeAmt,
			char registrationFeePaidFlag, Date createdDatetime) {
		this.mbcRegistrtionId = mbcRegistrtionId;
		this.userTbl = userTbl;
		this.businessPurposeTbl = businessPurposeTbl;
		this.addressDetailsTbl = addressDetailsTbl;
		this.mbcLegalName = mbcLegalName;
		this.mbcPhone = mbcPhone;
		this.mbcFax = mbcFax;
		this.mbcPocEmail = mbcPocEmail;
		this.mbcWebUrl = mbcWebUrl;
		this.mbcNumber = mbcNumber;
		this.registrationFeeAmt = registrationFeeAmt;
		this.registrationFeePaidFlag = registrationFeePaidFlag;
		this.createdDatetime = createdDatetime;
	}

	@Id
	@GeneratedValue
	@Column(name = "MBC_REGISTRTION_ID", unique = true, nullable = false)
	public int getMbcRegistrtionId() {
		return this.mbcRegistrtionId;
	}

	public void setMbcRegistrtionId(int mbcRegistrtionId) {
		this.mbcRegistrtionId = mbcRegistrtionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY")
	public UserTbl getUserTbl() {
		return this.userTbl;
	}

	public void setUserTbl(UserTbl userTbl) {
		this.userTbl = userTbl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUSINESS_PURPOSE_ID", nullable = false)
	public BusinessPurposeTbl getBusinessPurposeTbl() {
		return this.businessPurposeTbl;
	}

	public void setBusinessPurposeTbl(BusinessPurposeTbl businessPurposeTbl) {
		this.businessPurposeTbl = businessPurposeTbl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_DETAILS_ID")
	public AddressDetailsTbl getAddressDetailsTbl() {
		return this.addressDetailsTbl;
	}

	public void setAddressDetailsTbl(AddressDetailsTbl addressDetailsTbl) {
		this.addressDetailsTbl = addressDetailsTbl;
	}

	@Column(name = "MBC_LEGAL_NAME", nullable = false, length = 45)
	public String getMbcLegalName() {
		return this.mbcLegalName;
	}

	public void setMbcLegalName(String mbcLegalName) {
		this.mbcLegalName = mbcLegalName;
	}

	@Column(name = "MBC_PHONE", nullable = false, length = 15)
	public String getMbcPhone() {
		return this.mbcPhone;
	}

	public void setMbcPhone(String mbcPhone) {
		this.mbcPhone = mbcPhone;
	}

	@Column(name = "MBC_FAX", nullable = false, length = 15)
	public String getMbcFax() {
		return this.mbcFax;
	}

	public void setMbcFax(String mbcFax) {
		this.mbcFax = mbcFax;
	}

	@Column(name = "MBC_POC_EMAIL", nullable = false, length = 30)
	public String getMbcPocEmail() {
		return this.mbcPocEmail;
	}

	public void setMbcPocEmail(String mbcPocEmail) {
		this.mbcPocEmail = mbcPocEmail;
	}

	@Column(name = "MBC_WEB_URL", nullable = false, length = 30)
	public String getMbcWebUrl() {
		return this.mbcWebUrl;
	}

	public void setMbcWebUrl(String mbcWebUrl) {
		this.mbcWebUrl = mbcWebUrl;
	}

	@Column(name = "MBC_NUMBER", unique = true, nullable = false, length = 50)
	public String getMbcNumber() {
		return this.mbcNumber;
	}

	public void setMbcNumber(String mbcNumber) {
		this.mbcNumber = mbcNumber;
	}

	@Column(name = "REGISTRATION_FEE_AMT", nullable = false, precision = 18)
	public BigDecimal getRegistrationFeeAmt() {
		return this.registrationFeeAmt;
	}

	public void setRegistrationFeeAmt(BigDecimal registrationFeeAmt) {
		this.registrationFeeAmt = registrationFeeAmt;
	}

	@Column(name = "REGISTRATION_FEE_PAID_FLAG", nullable = false, length = 1)
	public char getRegistrationFeePaidFlag() {
		return this.registrationFeePaidFlag;
	}

	public void setRegistrationFeePaidFlag(char registrationFeePaidFlag) {
		this.registrationFeePaidFlag = registrationFeePaidFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATETIME", nullable = false, length = 23)
	public Date getCreatedDatetime() {
		return this.createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

}

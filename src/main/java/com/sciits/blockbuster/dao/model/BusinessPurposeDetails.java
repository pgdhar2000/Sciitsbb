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
import com.sciits.blockbuster.web.model.WebBusinessPurposeDetails;


@Entity
@Table(name = "business_purpose_details")
public class BusinessPurposeDetails extends BaseData {
	private static final long serialVersionUID = 5252094386377465535L;
	
	@Id
	@GeneratedValue
	@Column(name = "BUSINESS_PURPOSE_ID", length = 11, nullable = false)
	private Long businessPurposeId;
	
	@Column(name = "BUSINESS_PURPOSE", length = 30, nullable = false)
	private String businessPurpose;
	
	public BusinessPurposeDetails() {}
	
	public BusinessPurposeDetails(Long businessPurposeId, String businessPurpose) {
		super();
		this.businessPurposeId = businessPurposeId;
		this.businessPurpose = businessPurpose;
	}

	public Long getBusinessPurposeId() {
		return businessPurposeId;
	}

	public void setBusinessPurposeId(Long businessPurposeId) {
		this.businessPurposeId = businessPurposeId;
	}

	public String getBusinessPurpose() {
		return businessPurpose;
	}

	public void setBusinessPurpose(String businessPurpose) {
		this.businessPurpose = businessPurpose;
	}
	
	public WebBusinessPurposeDetails getWebBusinessPurposeDetails() {
		WebBusinessPurposeDetails webBusinessPurposeDetails = new WebBusinessPurposeDetails();
		webBusinessPurposeDetails.setBusinessPurpose(businessPurpose);
		webBusinessPurposeDetails.setBusinessPurposeId(businessPurposeId);
		return webBusinessPurposeDetails;
	}
}
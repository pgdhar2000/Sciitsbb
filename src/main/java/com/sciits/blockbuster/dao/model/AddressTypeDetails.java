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


@Entity
@Table(name = "address_type_details")
public class AddressTypeDetails extends BaseData {
	private static final long serialVersionUID = 5252093486377465535L;
	
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_TYPE_ID", length = 11, nullable = false)
	private Long addressTypeId;
	
	@Column(name = "ADDRESS_TYPE_NAME", length = 25, nullable = false)
	private String addressTypeName;
	
	@Column(name = "ADDRESS_TYPE_DESC", length = 50, nullable = true)
	private String addressTypeDesc;
	
	
	public AddressTypeDetails() {}
	
	public AddressTypeDetails(Long addressTypeId, String addressTypeName, String addressTypeDesc) {
		super();
		this.addressTypeId = addressTypeId;
		this.addressTypeName = addressTypeName;
		this.addressTypeDesc = addressTypeDesc;
	}

	public Long getAddressTypeId() {
		return addressTypeId;
	}

	public void setAddressTypeId(Long addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public String getAddressTypeName() {
		return addressTypeName;
	}

	public void setAddressTypeName(String addressTypeName) {
		this.addressTypeName = addressTypeName;
	}

	public String getAddressTypeDesc() {
		return addressTypeDesc;
	}

	public void setAddressTypeDesc(String addressTypeDesc) {
		this.addressTypeDesc = addressTypeDesc;
	}
}
/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.validation.util;


import org.springframework.util.StringUtils;

import com.sciits.blockbuster.dao.model.UserDetails;
import com.sciits.blockbuster.dao.model.UserLoginTbl;
import com.sciits.blockbuster.pdfdoc.model.TransformationMemorandam;

public class ValidationUtils {

	private static final ValidationResponse SUCCESS = new ValidationResponse(true, null);

	//========================================================================
	
	public static ValidationResponse validateUser(UserDetails user) {

		if (StringUtils.isEmpty(user.getEmail())) {
			return new ValidationResponse(false, "User Email is empty");
		} else if (user.getPassword() == null ) {
			return new ValidationResponse(false, "Password is empty");
		} else if (user.getUserName() == null) {
			return new ValidationResponse(false, "user name is null");
		} else if (user.getFirstName() == null) {
			return new ValidationResponse(false, "first name is null");
		}else if (user.getLastName() == null) {
			return new ValidationResponse(false, "last name is null");
		}/*else if (user.getGender() == null) {
			return new ValidationResponse(false, "gender is null");
		}*/ else if (user.getPhoneNumber() == null) {
			return new ValidationResponse(false, "phone number is null");
		}
		return SUCCESS;
	}

	//========================================================================
	
	public static ValidationResponse validateLoginUser(UserLoginTbl userLoginTbl) {
		if (StringUtils.isEmpty(userLoginTbl.getUsername())) {
			return new ValidationResponse(false, "User name is empty");
		} else if (userLoginTbl.getPassword() == null ) {
			return new ValidationResponse(false, "Password is empty");
		}
		return SUCCESS;
	}

	//========================================================================
	
	/*public static ValidationResponse validateVendorEmails(List<VendorDetails> vendors, VendorDetails vendorDetails) {
		
		for(VendorDetails vendorListItem : vendors){

			if(vendorListItem.getVendorDetailsId()!=vendorDetails.getVendorDetailsId()) {

				if( vendorDetails.getToEmail()!=null && vendorDetails.getToEmail().equals(vendorListItem.getToEmail())){
									
					return new ValidationResponse(false, "To Email is already exists");
				}
			}
		}
		return SUCCESS;
	}*/

	//========================================================================
	
	
	
	public static ValidationResponse transformationMemorandam(TransformationMemorandam transformationMemorandam ){
		  
		  
		  if (StringUtils.isEmpty(transformationMemorandam.getMbcName())) {
		   return new ValidationResponse(false, "Transformation Memorandam MbcName is empty");
		  }else if (StringUtils.isEmpty(transformationMemorandam.getRegisteredAgentName())) {
		   return new ValidationResponse(false, "Transformation Memorandam RegisteredAgentName is empty");
		  }else if (StringUtils.isEmpty(transformationMemorandam.getRegisteredOfficeAddress())) {
		   return new ValidationResponse(false, "Transformation Memorandam Registered OfficeAddress is empty");
		  }else if (StringUtils.isEmpty(transformationMemorandam.getLocation())) {
		   return new ValidationResponse(false, "Transformation Memorandam Location is empty");
		  }else if (StringUtils.isEmpty(transformationMemorandam.getCountry())) {
		   return new ValidationResponse(false, "Transformation Memorandam Country is empty");
		  }else if (StringUtils.isEmpty(transformationMemorandam.getBusinessPurpose())) {
		   return new ValidationResponse(false, "Transformation Memorandam Business Purpose is empty");
		  }
		  return SUCCESS;
		 }
	
}	


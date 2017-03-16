/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.web.model;

import java.util.Date;

public class WebUserLoginDetails {

	private int userDetailsId;
	private String username;
	private Date lastLoginDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private int roleId;
	private String authCode;
	private String isSecondaryAuthorizationSaved;
	private String isDefaultPasswordChanged;

	public WebUserLoginDetails() {
	}

	public int getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getIsSecondaryAuthorizationSaved() {
		return isSecondaryAuthorizationSaved;
	}

	public void setIsSecondaryAuthorizationSaved(String isSecondaryAuthorizationSaved) {
		this.isSecondaryAuthorizationSaved = isSecondaryAuthorizationSaved;
	}

	public String getIsDefaultPasswordChanged() {
		return isDefaultPasswordChanged;
	}

	public void setIsDefaultPasswordChanged(String isDefaultPasswordChanged) {
		this.isDefaultPasswordChanged = isDefaultPasswordChanged;
	}


}

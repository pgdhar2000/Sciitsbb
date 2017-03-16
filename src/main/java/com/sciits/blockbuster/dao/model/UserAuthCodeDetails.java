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

@Entity
@Table(name = "user_auth_code_details")
public class UserAuthCodeDetails extends BaseData  {
	private static final long serialVersionUID = 4351672344043604871L;
	@Id
	@GeneratedValue
	@Column(name = "user_auth_code_details_id", length = 20, nullable = false)
	private Long userAuthId;
	
	/*@Column(name = "user_details_id", length = 20, nullable = false)
	private Long userDetailsId;*/
	@OneToOne
	UserDetails userDetails;
	
	@Column(name = "auth_code", length = 32, nullable = false)
	private String authCode;
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@Column(name = "login_timestamp", nullable = false)
	private Date loginTimestamp;
	
	@Column(name = "logout_timestamp", nullable = false)
	private Date logoutTimestamp;
	
	

	public UserAuthCodeDetails() {}
	
	public UserAuthCodeDetails(Long userAuthId, String authCode, String status, 
		Date loginTimestamp, Date logoutTimestamp) {
		super();
		this.userAuthId = userAuthId;
		this.authCode = authCode;
		this.status = status;
		this.loginTimestamp = loginTimestamp;
		this.logoutTimestamp = logoutTimestamp;
	}

	public Long getUserAuthId() {
		return userAuthId;
	}

	public void setUserAuthId(Long userAuthId) {
		this.userAuthId = userAuthId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLoginTimestamp() {
		return loginTimestamp;
	}

	public void setLoginTimestamp(Date loginTimestamp) {
		this.loginTimestamp = loginTimestamp;
	}

	public Date getLogoutTimestamp() {
		return logoutTimestamp;
	}

	public void setLogoutTimestamp(Date logoutTimestamp) {
		this.logoutTimestamp = logoutTimestamp;
	}
}
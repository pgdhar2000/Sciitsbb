/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.dao.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.sciits.blockbuster.model.BaseData;
import com.sciits.blockbuster.web.model.WebUserDetails;
import com.sciits.blockbuster.web.model.WebUserLoginDetails;

@Entity
@Table(name = "user_details")
public class UserDetails extends BaseData {
	private static final long serialVersionUID = -8643444207099891058L;

	@Id
	@GeneratedValue
	@Column(name = "user_details_id", length = 20, nullable = false)
	private Long userDetailsId;

	@Column(name = "user_name", length = 32, nullable = false)
	private String userName;

	@Column(name = "password", length = 150, nullable = false)
	private String password;

	@Column(name = "file_path", length = 250 , nullable = true)
	private String filePath;
	
	@OneToOne
	private RoleDetails roleDetails;

	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "middle_name", length = 50, nullable = true)
	private String middleName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Column(name = "date_of_birth", nullable = true)
	private Date dateOfBirth;
	
	@Column(name = "email", length = 150, nullable = false)
	private String email;

	@Column(name = "phone_number", length = 25, nullable = false)
	private String phoneNumber;
	
	@Column(name = "address_line1", length = 150, nullable = true)
	private String addressLine1;

	@Column(name = "address_line2", length = 150, nullable = true)
	private String addressLine2;

	@Column(name = "city", length = 100, nullable = true)
	private String city;

	@Column(name = "state", length = 100, nullable = true)
	private String state;

	@Column(name = "country", length = 5, nullable = true)
	private String country;

	@Column(name = "postal_code", length = 10, nullable = true)
	private String postalCode;
	
	@Column(name = "VZID", length = 50, nullable = true)
	private String VZID;

	@Column(name = "cc_address", length = 150, nullable = true)
	private String ccAddress;

	@Column(name = "status", length = 1, nullable = false)
	private String status = "1";

	@Column(name = "is_default_password_changed", length = 1, nullable = false)
	private String isDefaultPasswordChanged = "0";
	
	public String getIsDefaultPasswordChanged() {
		return isDefaultPasswordChanged;
	}

	public void setIsDefaultPasswordChanged(String isDefaultPasswordChanged) {
		this.isDefaultPasswordChanged = isDefaultPasswordChanged;
	}
	
	@Column(name = "is_secondary_authorization_saved", length = 1, nullable = false)
	private String isSecondaryAuthorizationSaved = "0";
	
	public String getIsSecondaryAuthorizationSaved() {
		return isSecondaryAuthorizationSaved;
	}

	public void setIsSecondaryAuthorizationSaved(String isSecondaryAuthorizationSaved) {
		this.isSecondaryAuthorizationSaved = isSecondaryAuthorizationSaved;
	}
	
	public UserDetails() {}
	
	public UserDetails(Long userDetailsId, String userName, String password, String filePath, RoleDetails roleDetails,
			String firstName, String middleName, String lastName, Date dateOfBirth, String email,
			String phoneNumber, String addressLine1, String addressLine2, String city, String state, String country,
			String postalCode, String status) {
		this.userDetailsId = userDetailsId;
		this.userName = userName;
		this.password = password;
		this.filePath = filePath;
		this.roleDetails = roleDetails;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.status = status;
	}

	public Long getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(Long userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDetails getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(RoleDetails roleDetails) {
		this.roleDetails = roleDetails;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getVZID() {
		return VZID;
	}

	public void setVZID(String vZID) {
		VZID = vZID;
	}

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getFullName() {
		StringBuilder sb = new StringBuilder();
		if (!StringUtils.isEmpty(firstName)) {
			sb.append(firstName);
		}
		if (!StringUtils.isEmpty(middleName)) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(middleName);
		}
		if (!StringUtils.isEmpty(lastName)) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			sb.append(lastName);
		}
		return sb.toString();
	}

	public WebUserDetails getWebUser() {
		WebUserDetails webUser = new WebUserDetails();
		webUser.setUserDetailsId(userDetailsId);
		webUser.setUserName(userName);
		webUser.setEmail(email);
		webUser.setFirstName(firstName);
		webUser.setMiddleName(middleName);
		webUser.setLastName(lastName);
		webUser.setDateOfBirth(dateOfBirth);
		webUser.setPhoneNumber(phoneNumber);
		webUser.setStatus(status);
		webUser.setAddressLine1(addressLine1);
		webUser.setAddressLine2(addressLine2);
		webUser.setCountry(country);
		webUser.setState(state);
		webUser.setCity(city);
		webUser.setPostalCode(postalCode);
		webUser.setRoleDetails(roleDetails);
		webUser.setVZID(VZID);
		webUser.setCcAddress(ccAddress);
		return webUser;
	}

	public WebUserLoginDetails getWebUserLoginDetails() {
		WebUserLoginDetails wuld = new WebUserLoginDetails();
		//wuld.setUserDetailsId(userDetailsId);
		wuld.setFirstName(firstName);
		wuld.setMiddleName(middleName);
		wuld.setLastName(lastName);
		//wuld.setRoleId(getRoleDetails().getRoleId());
		return wuld;
	}

	public void updateUserDetails(UserDetails oldUser, UserDetails updateUser) {
		oldUser.setUserName(updateUser.getUserName());
		oldUser.setEmail(updateUser.getEmail());
		oldUser.setPhoneNumber(updateUser.getPhoneNumber());
		oldUser.setFirstName(updateUser.getFirstName());
		oldUser.setMiddleName(updateUser.getMiddleName());
		oldUser.setLastName(updateUser.getLastName());
		oldUser.setDateOfBirth(updateUser.getDateOfBirth());
		oldUser.setAddressLine1(updateUser.getAddressLine1());
		oldUser.setAddressLine2(updateUser.getAddressLine2());
		oldUser.setPostalCode(updateUser.getPostalCode());
		oldUser.setState(updateUser.getState());
		oldUser.setCountry(updateUser.getCountry());
		oldUser.setCity(updateUser.getCity());
		oldUser.setVZID(updateUser.getVZID());
		oldUser.setCcAddress(updateUser.getCcAddress());
	}
}

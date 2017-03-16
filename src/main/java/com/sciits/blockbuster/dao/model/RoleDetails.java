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
@Table(name = "role_details")
public class RoleDetails extends BaseData {
	private static final long serialVersionUID = 5252093486377465535L;

	@Id
	@GeneratedValue
	@Column(name = "role_id", length = 20, nullable = false)
	private Long roleId;
	
	@Column(name = "role", length = 50, nullable = false)
	private String role;
	
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	public RoleDetails() {}

	public RoleDetails(Long roleId, String role, String status) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.status = status;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
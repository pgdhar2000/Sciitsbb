package com.sciits.blockbuster.notification.model;

public class RegistrationDetails {
	//Common Properties
	private String[] toRecipients;
	private String ccRecipients;
	
	public String[] getToRecipients() {
		return toRecipients;
	}
	public void setToRecipients(String[] toRecipients) {
		this.toRecipients = toRecipients;
	}
	public String getCcRecipients() {
		return ccRecipients;
	}
	public void setCcRecipients(String ccRecipients) {
		this.ccRecipients = ccRecipients;
	}
	private String name;
	private int phoneNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
}

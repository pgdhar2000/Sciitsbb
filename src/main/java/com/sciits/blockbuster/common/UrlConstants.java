/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.common;

public class UrlConstants {
	public class User {
		public static final String API_BASE = "api/user";
		public static final String GET_ALL_USERS = "/getall";
		public static final String SIGNUP = "/signup";
		public static final String LOGIN = "/login";
		public static final String LOGOUT = "/logout";
		public static final String CHANGE_PASSWORD = "/changepassword";
		public static final String FIRST_TIME_LOGIN_CHANGE_PASSWORD = "/firsttimelogin/changepassword";
		public static final String GET_USER = "/get";
		public static final String UPDATE_USER = "/update";
		public static final String DELETE_USER = "/delete";
		public static final String ACTIVATE_USER = "/activate";
		public static final String IS_USER_EXIST = "/isexist";
		public static final String PHOTO_UPLOAD = "/photoupload";
		public static final String RESET_PASSWORD = "/resetpassword";
		public static final String SECONDARY_AUTHORIZATION_DETAILS_QUESITIONS_GET = "secondaryauthorizationdetails/quesitions/get";
		public static final String USER_SECONDARY_AUTHORIZATION_DETAILS_GET = "usersecondaryauthorizationdetails/get";
		public static final String USER_SECONDARY_AUTHORIZATIOND_DETAILS_SAVE = "usersecondaryauthorizationdetails/save";
		public static final String USER_SECONDARY_AUTHORIZATIOND_DETAILS_UPDATE = "usersecondaryauthorizationdetails/update";
	}
	public class Incorporation {
		public static final String API_BASE = "api/incorporation";
		public static final String ADD = "/add";
		public static final String GET = "/get";
		public static final String GET_COUNTRIES = "/get/countries";
		public static final String GET_BUSINESS_PURPOSES = "/get/businesspurposes";
		public static final String GET_REGISTERD_AGENTS = "/get/registredagents";
		public static final String GET_INCORPORATIONS = "/get/incorporations";
	}
	
	public class Core{
		public static final String API_BASE = "api/core";
		public static final String GET_COUNTRIES = "/get/countries";
		public static final String GET_ADDRESS_TYPE_DETAILS = "/get/addressTypeDetails";
		public static final String GET_ROLES = "/get/roles";
	}
	
	
}

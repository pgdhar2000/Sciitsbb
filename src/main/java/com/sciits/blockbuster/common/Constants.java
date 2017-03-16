/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.common;

public class Constants {

	//LOCAL 
	public static final String DEPLOYMENT_FOLDER = "E:/BLOCKBUSTER/";
	//public static final String DEPLOYMENT_FOLDER = "C:/Program Files (x86)/Apache Software Foundation/Tomcat 7.0/webapps/";
	
	public static final String UPLOADS_FOLDER = DEPLOYMENT_FOLDER + "BLOCKBUSTER_UPLOADS";
	public static final String DOCUMENTS_FOLDER = UPLOADS_FOLDER + "DOCUMENTS";
	public static final String ACTIVE = "1";
	public static final String INACTIVE = "0";
	public static final String DATE_FORMAT = "MM-dd-yyyy";
	public static final String DATE_FORMAT_DB = "YYYY-MM-DD";
	public static final String DATE_FORMAT_UI = "MM-dd-yyyy hh:mm";

	public static final Long SUPER_USER = 1L;
	public static final Long REGISTERED_AGENT = 2L;
	public static final Long ROCA_USER = 3L;
	public static final Long IP_USER = 4L;
	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";

	public static class User {
		public static final String USER_SIGNUP = "User registration is successful";
		public static final String USER_LOGIN = "User login is successful";
		public static final String USER_ACCOUNT_INACTIVE = "User Inactive";
		public static final String USER_LOGIN_FAILED = "User login failed.Please try again";
		public static final String USER_LIST = "Users list";
		public static final String USER_ID_NULL = "User id  is null";
		public static final String INVALID_USER_ID = "Invalid User Id";
		public static final String USER_DETAILS = "User details";
		public static final String SECONDARY_USER_DETAILS = "Secondary Authorization quesitions";
		public static final String USER_UPDATED = "User is updated successfully";
		public static final String USER_DELETED = "User deleted successfully";
		public static final String USER_PHOTO_ADDED = "Image Added Successsfully";
		public static final String USER_PHOTO_UPLOAD_FOLDER = UPLOADS_FOLDER + "/user_photos/";
		public static final String USER_ACTIVATED = "User activated successfully";
		public static final String USER_SECONDARY_AUTHORIZATION_DETAILS_SAVE = "User secondary authorization added successfully";
		public static final String USER_SECONDARY_AUTHORIZATION_DETAILS_UPDATE = "User secondary authorization updated successfully";
		public static final String USER_SECONDARY_AUTHORIZATION_DETAILS = "User secondary authorization details";
		public static final String USER_SECONDARY_AUTHORIZATIONS_DETAILS_NOT_SUMBMITED = "User not sumbited secondary authorization details";
		public static final String USER_DETAILS_NOT_EXIST = "User details not exist";
		public static final String SECONDARY_AUTHORIZATIONS_DETAILS_NOT_AVAILABLE_IN_DATABASE = "Secondary authorization details not evailable in database";
		public static final String USER_DEFAULT_AUTHORIZATIONS_FLAG ="N";
		public static final String USER_PENDING_FOR_APPROVAL ="users pending for approval details";
	}
	public static class Incorporation {
		public static final String MBC_ID_NULL = "MBC id  is null";
		public static final String INVALID_MBC_ID = "Invalid MBC Id";
		public static final String MBC_DETAILS = "MBC details";
	}
	
	public static class PDFDocument {
		public static String[] PDF_DOC_TEMPLATES = null;
		public static final String TRANSFORMATION_MEMORANDAM = "Transformation Memorandam";
		public static final String TRANSFORMATION_APPROVAL_NOTICE = "Transformation Approval Notice";
	}
	
	public static class Notification {
	  public static String[] EMAIL_TEMPLATES = null;
	  public static final String REGISTRATION = "Registration";
	  public static final String FORGOT_PASSWORD = "Forgot Password";
	}
}
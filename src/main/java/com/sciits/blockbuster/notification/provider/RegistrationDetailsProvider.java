package com.sciits.blockbuster.notification.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sciits.blockbuster.common.Constants;
import com.sciits.blockbuster.email.EmailDetails;
import com.sciits.blockbuster.email.EmailManager;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.notification.model.RegistrationDetails;

public class RegistrationDetailsProvider {
	Logger log = Logger.getLogger(RegistrationDetailsProvider.class);
	private static RegistrationDetailsProvider instance = null;
	private String registrationTemplate = null;
	
	// ========================================================================
	
	public static synchronized RegistrationDetailsProvider getInstance() throws IOException {
		if(instance == null) {
			instance = new RegistrationDetailsProvider();
			instance.init();
		}
		return instance;
	}

	// ========================================================================
	
	private void init() throws IOException {
		Properties prop = new Properties();
		String propFileName = "notification-mail-templates.properties";
		InputStream inputStream;

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		// get the property value and print it out
		registrationTemplate = prop.getProperty("bb.notification.mail.registration.template");
	}
	
	// ========================================================================
	
	public String sendNotification(RegistrationDetails registrationDetails) throws BlockbusterException {
		String logTag = "sendNotification(): ";
		log.info("Entering into "+ logTag);
		String result = Constants.FAILURE;
		EmailDetails emailDetails = new EmailDetails();
		
		try {
			registrationTemplate.replaceAll("<user>", registrationDetails.getName());
			emailDetails.setSubject("Registration Details");
			emailDetails.setToRecipients(registrationDetails.getToRecipients());
			emailDetails.setCcRecipients(registrationDetails.getCcRecipients());
			emailDetails.setMessageContent(registrationTemplate);
			boolean isMailSent = EmailManager.getInstance().send(emailDetails);
			
			if(isMailSent) {
				result = Constants.SUCCESS;
			}
		} catch (Exception e) {
			throw new BlockbusterException(logTag + "Exception while sending the Registration notification, "+e);
		}
		return result;
	}
	
	// ========================================================================
}

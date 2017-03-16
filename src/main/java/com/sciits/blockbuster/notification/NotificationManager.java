/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.notification;

import org.apache.log4j.Logger;

import com.sciits.blockbuster.common.Constants;
import com.sciits.blockbuster.exception.BlockbusterException;
import com.sciits.blockbuster.notification.model.ForgotPasswordDetails;
import com.sciits.blockbuster.notification.model.RegistrationDetails;
import com.sciits.blockbuster.notification.provider.ForgotPasswordDetailsProvider;
import com.sciits.blockbuster.notification.provider.RegistrationDetailsProvider;

public class NotificationManager {
	Logger log = Logger.getLogger(NotificationManager.class);
	private static NotificationManager instance = null;

	// ========================================================================

	private NotificationManager() { }

	// ========================================================================

	public static synchronized NotificationManager getInstance() {
		if (instance == null) {
			instance = new NotificationManager();
		}
		return instance;
	}

	// ========================================================================

	public String sendNotification(String notificationType, Object notificationData) throws BlockbusterException {
		String logTag = "sendNotification(): ";
		log.info("Entering into "+logTag);
		String notificationResult = null;
		
		try {
			switch (notificationType) {
				case Constants.Notification.REGISTRATION:
					RegistrationDetails registrationDetails = (RegistrationDetails) notificationData;
					RegistrationDetailsProvider registrationDetailsProvider = RegistrationDetailsProvider.getInstance();
					notificationResult = registrationDetailsProvider.sendNotification(registrationDetails);
					break;
				case Constants.Notification.FORGOT_PASSWORD:
					ForgotPasswordDetails forgotPasswordDetails = (ForgotPasswordDetails) notificationData;
					ForgotPasswordDetailsProvider forgotPasswordDetailsProvider = ForgotPasswordDetailsProvider.getInstance();
					notificationResult = forgotPasswordDetailsProvider.sendNotification(forgotPasswordDetails);
					break;
				default:
					break;
			}
		} catch (Exception e) {
			throw new BlockbusterException("PROBLEM in the mathod sendNotification() "+e);
		}
		return notificationResult;
	}

	// ========================================================================
}
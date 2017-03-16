package com.sciits.blockbuster.notification.provider;

import com.sciits.blockbuster.notification.model.ForgotPasswordDetails;

public class ForgotPasswordDetailsProvider {
	private static ForgotPasswordDetailsProvider instance = null;

	// ========================================================================
	
	public static synchronized ForgotPasswordDetailsProvider getInstance() {
		if(instance == null) {
			instance = new ForgotPasswordDetailsProvider();
		}
		return instance;
	}

	// ========================================================================
	
	public String sendNotification(ForgotPasswordDetails forgotPasswordDetails) {
		return null;
	}
	
	// ========================================================================
}

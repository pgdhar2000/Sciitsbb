/*
 *@Author Jaya Prakash Manne 
 */
package com.sciits.blockbuster.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.sciits.blockbuster.exception.BlockbusterException;
public class EmailManager {
	Logger log = Logger.getLogger(EmailManager.class);
	private static Session session = null;
	private static String mailBoxUserName = "pqtsciits@gmail.com";
	private static String mailBoxPassword = "pqtsci@123";
	
	//========================================================================
	
	private static EmailManager instance = null;

	// ========================================================================

	private EmailManager() {
	}

	// ========================================================================

	public static synchronized EmailManager getInstance() {
		if (instance == null) {
			instance = new EmailManager();
		}
		return instance;
	}

	// ========================================================================
	
	public boolean send(EmailDetails emailDetails) throws BlockbusterException {
		String logTag = "send(): ";
		log.info("entering into "+logTag);
		boolean isMailSent = false;
		Address[] toAddresses = null;
		Address toAddress = null;
	    int toAddressCount = 0;
	    /*String[] toRecipients, String[] ccRecipients, String subject, String messageBody,
		String attachmentFilePath;*/
	    
	    Address[] ccAddresses = null;
		Address ccAddress = null;
	    int ccAddressCount = 0;
		
		try {
			if(emailDetails.getToRecipients() != null && emailDetails.getSubject() != null && emailDetails.getMessageContent() != null) {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				
				session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(mailBoxUserName, mailBoxPassword);
					}
				});
				
				MimeMessage message = new MimeMessage(session);
				
				//Setting From
				message.setFrom(new InternetAddress(mailBoxUserName));
				
				//Setting To
				toAddresses = new Address[emailDetails.getToRecipients().length];
		        for (int i = 0; i < emailDetails.getToRecipients().length; i++) {
		          if(emailDetails.getToRecipients()[i] != null) {
		            toAddress = new InternetAddress(emailDetails.getToRecipients()[i].trim());
		            toAddresses[toAddressCount] = toAddress;
		            toAddressCount++;
		          }
		        }
		        message.setRecipients(Message.RecipientType.TO, toAddresses);
		        //Setting CC
		        if(emailDetails.getCcRecipients() != null && emailDetails.getCcRecipients().trim().length() > 0) {
		        	String[] ccRecipients = emailDetails.getCcRecipients().trim().split(",");
		        	ccAddresses = new Address[ccRecipients.length];
			          
			        for (int i = 0; i < ccRecipients.length; i++) {
			          if(ccRecipients[i] != null && ccRecipients[i].trim().length() > 0) {
			            ccAddress = new InternetAddress(ccRecipients[i].trim());
			            ccAddresses[ccAddressCount] = ccAddress;
			            ccAddressCount++;
			          }
			        }
			        message.setRecipients(Message.RecipientType.CC, ccAddresses);
		        }
		        //Setting Subject
				message.setSubject(emailDetails.getSubject());

				// create MimeBodyPart object and set your message text
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(emailDetails.getMessageContent());
				Multipart multiPart = new MimeMultipart();
				multiPart.addBodyPart(messageBodyPart);

				if (emailDetails.getAttachmentFilePath() != null) {
					// create new MimeBodyPart object and set DataHandler object to this object
					MimeBodyPart attachmentMimeBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(emailDetails.getAttachmentFilePath());
					attachmentMimeBodyPart.setDataHandler(new DataHandler(source));
					
					attachmentMimeBodyPart.setFileName(getFileName(emailDetails.getAttachmentFilePath()));
					//create Multipart object and add MimeBodyPart objects to this object
					multiPart.addBodyPart(attachmentMimeBodyPart);
				}

				// Set the multiplart object to the message object
				message.setContent(multiPart);

				//send message
				Transport.send(message);
				isMailSent = true;
				log.info("message sent successfully");
			} else {
				log.error("Invalid Input"); 
			}
		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			throw new BlockbusterException(logTag + "Problem while sending the mail, "+e);
		} catch (Exception e) {
			throw new BlockbusterException(logTag + "Problem while sending the mail, "+e);
		}
		return isMailSent;
	}
	
	//========================================================================
	
	private String getFileName(String attachementFilePath) {
		return attachementFilePath.substring(attachementFilePath.lastIndexOf("/")+ 1, attachementFilePath.length());
	}
	
	//========================================================================
	

	
	public boolean sendEmailForRestPassword(EmailDetails emailDetails) throws BlockbusterException {
		String logTag = "sendEmailForRestPassword(): ";
		log.info("entering into "+logTag);
		boolean isMailSent = false;
		Address[] toAddresses = null;
		Address toAddress = null;
	    int toAddressCount = 0;
	    Address[] ccAddresses = null;
		Address ccAddress = null;
	    int ccAddressCount = 0;
		
		try {
			if(emailDetails.getToRecipients() != null && emailDetails.getSubject() != null && emailDetails.getMessageContent() != null) {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				
				session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(mailBoxUserName, mailBoxPassword);
					}
				});
				
				MimeMessage message = new MimeMessage(session);
				
				//Setting From
				message.setFrom(new InternetAddress(mailBoxUserName));
				
				//Setting To
				toAddresses = new Address[emailDetails.getToRecipients().length];
		        for (int i = 0; i < emailDetails.getToRecipients().length; i++) {
		          if(emailDetails.getToRecipients()[i] != null) {
		            toAddress = new InternetAddress(emailDetails.getToRecipients()[i].trim());
		            toAddresses[toAddressCount] = toAddress;
		            toAddressCount++;
		          }
		        }
		        message.setRecipients(Message.RecipientType.TO, toAddresses);
		        //Setting CC
		        if(emailDetails.getCcRecipients() != null && emailDetails.getCcRecipients().trim().length() > 0) {
		        	String[] ccRecipients = emailDetails.getCcRecipients().trim().split(",");
		        	ccAddresses = new Address[ccRecipients.length];
			          
			        for (int i = 0; i < ccRecipients.length; i++) {
			          if(ccRecipients[i] != null && ccRecipients[i].trim().length() > 0) {
			            ccAddress = new InternetAddress(ccRecipients[i].trim());
			            ccAddresses[ccAddressCount] = ccAddress;
			            ccAddressCount++;
			          }
			        }
			        message.setRecipients(Message.RecipientType.CC, ccAddresses);
		        }
		        //Setting Subject
				message.setSubject(emailDetails.getSubject());

				// create MimeBodyPart object and set your message text
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(emailDetails.getMessageContent());
				Multipart multiPart = new MimeMultipart();
				multiPart.addBodyPart(messageBodyPart);

				if (emailDetails.getAttachmentFilePath() != null) {
					// create new MimeBodyPart object and set DataHandler object to this object
					MimeBodyPart attachmentMimeBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(emailDetails.getAttachmentFilePath());
					attachmentMimeBodyPart.setDataHandler(new DataHandler(source));
					
					attachmentMimeBodyPart.setFileName(getFileName(emailDetails.getAttachmentFilePath()));
					//create Multipart object and add MimeBodyPart objects to this object
					multiPart.addBodyPart(attachmentMimeBodyPart);
				}

				// Set the multiplart object to the message object
				message.setContent(multiPart);

				//send message
				Transport.send(message);
				isMailSent = true;
				log.info("message sent successfully");
			} else {
				log.error("Invalid Input"); 
			}
		} catch (MessagingException e) {
			//throw new RuntimeException(e);
			throw new BlockbusterException(logTag + "Problem while sending the mail, "+e);
		} catch (Exception e) {
			throw new BlockbusterException(logTag + "Problem while sending the mail, "+e);
		}
		return isMailSent;
	}
	
	//======================================================================
}

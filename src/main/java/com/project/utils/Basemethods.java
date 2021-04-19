package com.project.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Basemethods {

	public static String getUser(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		return userName;
		
		
	} 

	// Get current date
	public static Date getDate() {

		return new Date();

}
	// Send mail to user
		protected static void sendMail(String email, String subject , String content) {

			java.util.Properties properties = new java.util.Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

			try {
				MimeMessage message = new MimeMessage(mailSession);

				message.setContent(content, "text/html");
				message.setSubject(subject);

				InternetAddress sender = new InternetAddress("transense.28@gmail.com", "Study Portal");
				InternetAddress receiver = new InternetAddress(email);
				message.setFrom(sender);
				message.setRecipient(Message.RecipientType.TO, receiver);
				message.saveChanges();

				javax.mail.Transport transport = mailSession.getTransport("smtp");
				transport.connect("smtp.gmail.com", 587, "transense.28@gmail.com" , "Vaibhavi@288");
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// Generate OTP
		protected static int generateOTP(int limit) {

	        int otp = 0;

	        if (limit > 5 || limit < 1)
	            limit = 3;

	        for (int i = 0; i < limit; i++) {

	            int x = new Random().nextInt(9);

	            if (x == 0 && i == 0)
	                i--;
	            else
	                otp = (otp * 10) + x;
	        }

	        return otp;
	    }
		
		// Generate MD5 (Used in passwords only)
		protected static String generateMD5(String str) throws NoSuchAlgorithmException{
			 
			MessageDigest md = MessageDigest.getInstance("MD5");
		        md.update(str.getBytes());
		        
		        byte byteData[] = md.digest();
		 
		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < byteData.length; i++) {
		         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		        }
		     
		        
		        //convert the byte to hex format method 2
		        StringBuffer hexString = new StringBuffer();
		    	for (int i=0;i<byteData.length;i++) {
		    		String hex=Integer.toHexString(0xff & byteData[i]);
		   	     	if(hex.length()==1) hexString.append('0');
		   	     	hexString.append(hex);
		    	}
		    	
		    	return hexString.toString();
		}
	}
	


package com.gset.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	
		public void SendEmail (String to , String body) {
			// Recipient's email ID needs to be mentioned.
	        
			 

		        // Sender's email ID needs to be mentioned
		        String from = "bpms@gsetco.com";

		        // Assuming you are sending email from through gmails smtp
		        String host = "mail.gsetco.com";

		        // Get system properties
		        Properties properties = System.getProperties();

		        // Setup mail server
		        properties.put("mail.smtp.host", host);
		        properties.put("mail.smtp.port", "25");
		        properties.put("mail.smtp.ssl.enable", "false");
		        properties.put("mail.smtp.auth", "true");

		        // Get the Session object.// and pass username and password
		        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

		            protected PasswordAuthentication getPasswordAuthentication() {

		                return new PasswordAuthentication("bpms@gsetco.com", "3*62fdcG");

		            }

		        });

		        // Used to debug SMTP issues
		        session.setDebug(true);

		        try {
		            // Create a default MimeMessage object.
		            MimeMessage message = new MimeMessage(session);

		            // Set From: header field of the header.
		            message.setFrom(new InternetAddress(from));

		            // Set To: header field of the header.
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		            // Set Subject: header field
		            message.setSubject("This is the Subject Line!");

		            // Now set the actual message
		            message.setText("This is actual message");
		            message.setContent( "<h1>This is actual message embedded in HTML tags</h1>",
		            		"text/html;charset=UTF-8");
		            System.out.println("sending...");
		            // Send message
		            Transport.send(message);
		            System.out.println("Sent message successfully....");
		        } catch (MessagingException mex) {
		            mex.printStackTrace();
		        }

		}
	
}

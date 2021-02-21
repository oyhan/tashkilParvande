package com.gset.kish.TashkilParvande.Models;


import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.gset.kish.TashkilParvande.LoggerDelegate;

public class SmsService {
	  private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

	public boolean SendSms(String mobileNumber, String content) throws Exception{
		
		 DefaultHttpClient httpClient = new DefaultHttpClient();
		 LOGGER.info("start sending sms to " +mobileNumber);
		 
		SendSmsModel sms = new SendSmsModel();
		sms.Content =content;
		sms.Recipient = mobileNumber;
		sms.Username = "PooyanSystem";
		sms.Password = "E6dn5QDC9m6WxMya12";
		
	
	    
		try {
			
			 //Define a postRequest request
	        HttpPost postRequest = new HttpPost("http://85.185.161.150:9501/api/sms/sendsms");
	         
	        //Set the API media type in http content-type header
	        postRequest.addHeader("Content-Type", "application/json;charset=UTF-8");
	         
	        
	        
	        String ssms = "{\"Username\":\"PooyanSystem\",\"Password\":\"E6dn5QDC9m6WxMya12\",\"Recipient\":\""+mobileNumber
	        		+"\",\"Content\":\""+content+"\"}";
	        
	        LOGGER.info("sms body is "+ssms);
	        //Set the request post body
	        StringEntity userEntity = new StringEntity(ssms,"UTF-8");
	        postRequest.setEntity(userEntity);
	        LOGGER.info("sms request is "+postRequest);
	        //Send the request; It will immediately return the response in HttpResponse object if any
	        HttpResponse response = httpClient.execute(postRequest);
	       

	        LOGGER.info("sms response is "+response);
	        
	        //verify the valid error code first
	        int statusCode = response.getStatusLine().getStatusCode();
	        
	        if (statusCode != 200 && statusCode !=201 ) 
	        {
	            throw new RuntimeException("Failed with HTTP error code : " + response);
	        }
	        return true;
		}
		
		finally  {
			 //Important: Close the connect
	        httpClient.getConnectionManager().shutdown();
		}
	}
}

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class SmsService {
	
	public boolean SendSms(String mobileNumber, String content) throws Exception{
		
		 DefaultHttpClient httpClient = new DefaultHttpClient();
		
		SendSmsModel sms = new SendSmsModel();
		sms.Content =content;
		sms.Recipient = mobileNumber;
		sms.Username = "PooyanSystem";
		sms.Password = "E6dn5QDC9m6WxMya12";
		 
	    StringWriter writer = new StringWriter();
	    JAXBContext jaxbContext = JAXBContext.newInstance(SendSmsModel.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.marshal(sms, writer);
	    
		try {
			
			 //Define a postRequest request
	        HttpPost postRequest = new HttpPost("http://85.185.161.150:9501/api/sms/sendsms");
	         
	        //Set the API media type in http content-type header
	        postRequest.addHeader("content-type", "application/xml");
	         
	        //Set the request post body
	        StringEntity userEntity = new StringEntity(writer.getBuffer().toString());
	        postRequest.setEntity(userEntity);
	          
	        //Send the request; It will immediately return the response in HttpResponse object if any
	        HttpResponse response = httpClient.execute(postRequest);
	         
	        //verify the valid error code first
	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != 201) 
	        {
	            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	        }
	        return true;
		}
		
		finally  {
			 //Important: Close the connect
	        httpClient.getConnectionManager().shutdown();
		}
	}
}

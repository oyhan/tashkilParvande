package com.gset.services;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FaraPayamakSmsService {

	
	public boolean SendSms(String Content , String phoneNumber) throws Exception {
		
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "username=GSETCO&password=9107&to="+phoneNumber+"&from=50004000407174&text="+Content+"&isflash=false");
		Request request = new Request.Builder()
		  .url("http://rest.payamak-panel.com/api/SendSMS/SendSMS")
		  .post(body)
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "c26ca3b0-9f44-3cdf-9da3-60c86a9f75b3")
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .build();

		Response response = client.newCall(request).execute();
		
		return response.isSuccessful();
	}
}

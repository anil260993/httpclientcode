package com.qa.client;



import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class GetmethodTest {
	
	//get method without header
	
	public CloseableHttpResponse getmethod_without_header(String url) throws ClientProtocolException, IOException {//get method without header
		CloseableHttpClient hc = HttpClients.createDefault();//create connection
		HttpGet hp=new HttpGet(url);//get connection
		CloseableHttpResponse response=	hc.execute(hp);//execute
		
		return response;
	}
//get method with header
	public CloseableHttpResponse getmethod_with_header(String url,HashMap<String,String>header_map ) throws ClientProtocolException, IOException {//get method without header
		CloseableHttpClient hc = HttpClients.createDefault();
		HttpGet hp=new HttpGet(url);
		
		//need to add this code for headers passing
		
		for(Map.Entry<String, String>entry:header_map.entrySet()) {
	hp.addHeader(entry.getKey(),entry.getValue());
			
		}
		
		
CloseableHttpResponse response=	hc.execute(hp);
		
		return response;
		
		
		
	}	

	
	//post method
	public CloseableHttpResponse postmethod(String url,String payload,HashMap<String,String>header_map) throws ClientProtocolException, IOException {
		CloseableHttpClient hc = HttpClients.createDefault();//creating connection
		HttpPost ph=new HttpPost(url);//creating post request
		ph.setEntity(new StringEntity(payload));//adding pay load
		//need to add this code for headers passing
		
				for(Map.Entry<String, String>entry:header_map.entrySet()) {
			ph.addHeader(entry.getKey(),entry.getValue());
					
				}
				
				
		CloseableHttpResponse response=	hc.execute(ph);
				
				return response;
				
		
	}
}
	


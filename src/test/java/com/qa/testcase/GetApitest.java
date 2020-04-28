package com.qa.testcase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.GetmethodTest;
import com.qa.data.User;
import com.qa.util.TestUtil;
//import org.codehaus.jackson.type.TypeReference;

public class GetApitest extends TestBase{
	
	TestBase tb;
	
	public GetApitest() throws IOException {
		super();
		
	}

	@BeforeTest
	public void setup() throws IOException {
		tb=new TestBase();
		 
		
		
		 
	}
	
	//@Test
	public void calling_getmethod_without_header() throws IOException {
		
		GetmethodTest gm=new GetmethodTest();
		CloseableHttpResponse response= gm.getmethod_without_header(p.getProperty("baseurl"));
		 //to get status code from json body
		 int responsecode=response.getStatusLine().getStatusCode();
			System.out.println("response code----->"+responsecode);
			Assert.assertEquals(responsecode, 200,"test code not 200");
			System.out.println();
			System.out.println();
		String res=	EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject js=new JSONObject(res);
		System.out.println("json response code ::"+js);
		//to get data from json body
		String perpagevalue=TestUtil.getValueByJPath(js, "/per_page");
		System.out.println("perpagevalue::"+perpagevalue);
		String lastname=TestUtil.getValueByJPath(js, "/data[5]/last_name");
		String id=TestUtil.getValueByJPath(js, "/data[5]/id");
		System.out.println();
		System.out.println();
		System.out.println("last name::"+lastname);
		System.out.println("id::"+id);
		System.out.println();
		System.out.println();
		//to get all headers
		 Header[] header=response.getAllHeaders();
		 HashMap<String,String> hm=new HashMap<String,String>();
		 for(Header a:header) {
			 hm.put(a.getName(), a.getValue());
		 }
			System.out.println("Header content::"+hm);
		 
		 
		 
		 
		
		
		
	}
	//@Test
	public void calling_getmethod_with_header() throws IOException {
		//passing headers with url
		HashMap<String,String> headermap=new HashMap<String,String>();
		headermap.put("content-type", "Application/json");
	//	headermap.put("username","xxx"); //if we need to pass any other parametrs we need to send like this
	//heradermap.put("Aut-token","xxx");
		
		
		
		
		
		GetmethodTest gm=new GetmethodTest();
		CloseableHttpResponse response= gm.getmethod_with_header(p.getProperty("baseurl"),headermap);
		 //to get status code from json body
		 int responsecode=response.getStatusLine().getStatusCode();
			System.out.println("response code----->"+responsecode);
			Assert.assertEquals(responsecode, 200,"test code not 200");
			System.out.println();
			System.out.println();
		String res=	EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject js=new JSONObject(res);
		System.out.println("json response code ::"+js);
		//to get data from json body
		String perpagevalue=TestUtil.getValueByJPath(js, "/per_page");
		System.out.println("perpagevalue::"+perpagevalue);
		String lastname=TestUtil.getValueByJPath(js, "/data[5]/last_name");
		String id=TestUtil.getValueByJPath(js, "/data[5]/id");
		System.out.println();
		System.out.println();
		System.out.println("last name::"+lastname);
		System.out.println("id::"+id);
		System.out.println();
		System.out.println();
		//to get all headers
		 Header[] header=response.getAllHeaders();
		 HashMap<String,String> hm=new HashMap<String,String>();
		 for(Header a:header) {
			 hm.put(a.getName(), a.getValue());
		 }
			System.out.println("Header content::"+hm);
			
	}
@Test
public void post_method() throws ClientProtocolException, IOException {
	HashMap<String,String> headermap_1=new HashMap<String,String>();
	headermap_1.put("content-type", "Application/json");
	
	//jackson api
	ObjectMapper mapper=new ObjectMapper();
	User user=new User("Anil","QA");//expected users object
	//object to json file(marshalling)
	mapper.writeValue(new File("/home/vassar/Videos/Cucumberprojects/Httpclient/src/main/java/com/qa/data/Demo.json"),user);
	//java object to json in string
	String user_json_to_string=mapper.writeValueAsString(user);
	
	GetmethodTest gm=new GetmethodTest();
	CloseableHttpResponse response= gm.postmethod(p.getProperty("posturl"),user_json_to_string, headermap_1);
	//status code  
	int responsecode=response.getStatusLine().getStatusCode();
		System.out.println("response code----->"+responsecode);
		Assert.assertEquals(responsecode, 201,"test code not 201");
	String res=	EntityUtils.toString(response.getEntity(), "UTF-8");
	JSONObject js=new JSONObject(res);
	System.out.println("json response code ::"+js);
	
	//json to java object(un marshalling)
	
	User userobject=mapper.readValue(res, User.class);//Actual user object 
	
	Assert.assertTrue(user.getName().equals(userobject.getName()));
	Assert.assertTrue(user.getJob().equals(userobject.getJob()));
	
	System.out.println(userobject.getCreatedAt());
	
}
}

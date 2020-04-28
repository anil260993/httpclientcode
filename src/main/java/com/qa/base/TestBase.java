package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
public static Properties p;
	public TestBase() throws IOException {
		 p=new Properties();
		 FileInputStream fis=new FileInputStream("/home/vassar/Videos/Cucumberprojects/Httpclient/src/main/java/com/qa/config/config.properties");
		p.load(fis);
		
	}
}

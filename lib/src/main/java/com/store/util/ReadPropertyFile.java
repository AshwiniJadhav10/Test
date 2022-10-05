package com.store.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	
	public String propData(String Key) throws IOException {
		
		FileInputStream fl=new FileInputStream("E:\\Study\\Selenium\\coreDemo\\lib\\src\\main\\java\\com\\TestData\\browser.properties");
		
		Properties pp=new Properties();
		
		pp.load(fl);
		  
		return pp.getProperty(Key);
		
		
	}

	public static void main(String[] args) throws IOException {
		ReadPropertyFile pp=new ReadPropertyFile();
		System.out.println(pp.propData("Browser"));

	}

}

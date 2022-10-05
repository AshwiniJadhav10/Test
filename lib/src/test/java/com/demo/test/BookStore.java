

package com.demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestData.StorePage;
import com.store.common.GlobalFunction;
import com.store.util.ReadPropertyFile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class BookStore {
	static GlobalFunction gl= new GlobalFunction();
	//static StorePage sp=new StorePage();
	ReadPropertyFile pp=new ReadPropertyFile();

	static WebDriver obj;
	
 @Test	(priority=1)
public void addBookInCollection() throws IOException, InterruptedException {
		gl.openUrl("Url");
		gl.waitUntil("xpath",StorePage.bookName);
		gl.click("xpath",StorePage.bookName);
		gl.click("id", "login");
		gl.enterText("id", "userName", pp.propData("Username"));
		gl.enterText("id", "password",pp.propData("Password") );
		gl.click("id", "login");
		Thread.sleep(2000);
		gl.scroll();
		gl.waitUntil("xpath",StorePage.addToYourCollection);
		gl.click("xpath", StorePage.addToYourCollection);
		gl.close();
	}

	
	@Test (priority=2)
	public void deleteBookFromCollection() throws IOException {
		gl.openUrl("Url1");
		gl.enterText("id", "userName", pp.propData("Username"));
		gl.enterText("id", "password",pp.propData("Password") );
		gl.click("id", "login");
		gl.scroll();
		//gl.waitUntil("xpath",StorePage.bookName);
		gl.click("id", "delete-record-undefined");
		gl.close();
	}
	  

}

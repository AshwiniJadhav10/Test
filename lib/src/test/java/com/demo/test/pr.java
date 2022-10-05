package com.demo.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pr {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Study\\Selenium\\coreDemo\\lib\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("userName")).sendKeys("demo.user");
		driver.findElement(By.id("password")).sendKeys("Demo@2022");
		driver.findElement(By.id("login")).click();
		//driver.navigate().to("https://demoqa.com/books");
		WebElement bt=driver.findElement(By.id("gotoStore"));
	//	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
	//	jsExecutor.executeScript("arguments[0].style.border='2px solid red'", bt); 
	//	Thread.sleep(1000);
		//bt.click();
		Point p=bt.getLocation();
		System.out.println(p.x);
		System.out.println(p.y);
	
		driver.close();
	
		

	}

}

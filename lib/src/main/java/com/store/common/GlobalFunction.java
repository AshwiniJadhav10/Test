package com.store.common;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.store.util.ReadPropertyFile;

public class GlobalFunction {
	
	static WebDriver driver;
	static DesiredCapabilities caps;
	
	WebDriverWait wait;
	//Actions act=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void openUrl(String url) throws IOException {
		//object created to use method of property file

		ReadPropertyFile pp=new ReadPropertyFile();
		//here 
		String Browser=pp.propData("Browser");
		
		//here we are comparing the browser name we have given in prop file is equals to user given browser name

		if(Browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Study\\Selenium\\Practice_Java_Programms\\lib\\geckodriver-v0.24.0-win64\\geckodriver.exe");

			driver =new FirefoxDriver();	
			driver.get(pp.propData(url));
			driver.manage().window().maximize();
			//	driver.close();
		}
		else if(Browser.equalsIgnoreCase("Chrome")) {//Equal ignore case is not case sensitive
			System.setProperty("webdriver.chrome.driver", "E:\\Study\\Selenium\\coreDemo\\lib\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(pp.propData(url));
			driver.manage().window().maximize();
			//driver.close();
		}
	}
	// this method collect element by using different locators
	public WebElement findElement(String loc_type, String loc_value) {
		WebElement element=null;
		switch(loc_type) {

		case "id":
			element=		driver.findElement(By.id(loc_value));
			break;

		case "name":
			element=		driver.findElement(By.name(loc_value));
			break;


		case"class":
			element=	driver.findElement(By.className(loc_value));
			break;

		case"xpath":
			element=	driver.findElement(By.xpath(loc_value));
			break;


		case"cssSelector":
			element=	driver.findElement(By.cssSelector(loc_value));
			break;


		case"linkText":
			element=	driver.findElement(By.linkText(loc_value));
			break;

		case"partialLinkText":
			element=		driver.findElement(By.partialLinkText(loc_value));
			break;

		case"tagName":
			element=		driver.findElement(By.tagName(loc_value));
			break;

		}
		return element;
	}

	// now here we already have the elemnts so we need to call that and use it 
	//its not needed to create object becoz we are calling it in non static area from non static area only
	public void enterText(String loc_type, String loc_value, String data  ) {
		//variable element have webelement and we can sendkey accordingly
		WebElement element=findElement(loc_type, loc_value);
		element.sendKeys(data);
	}

	public void click(String loc_type, String loc_value  ) {
		WebElement element=findElement(loc_type, loc_value);
		element.click();

	}
	
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	

	
public void mouseHover(String loc_type, String loc_value) {
	Actions act=new Actions(driver);
	WebElement menu=findElement(loc_type, loc_value);
	act.moveToElement(menu).contextClick(menu).build().perform();
}

public void getUrl(String url) {
	driver=new ChromeDriver();
	driver.navigate().to(url);
}

public void waitUntil(String loc_type, String loc_value) {
	wait = new WebDriverWait(driver,30);
	WebElement ele=findElement(loc_type, loc_value);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
}

public void refresh() {
	driver.navigate().refresh();
}

public void frame() {
	 WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0"));
	    driver.switchTo().frame(frame1);
	    //WebElement frame2 = driver.findElement(By.id("ad_iframe"));
	   // driver.switchTo().frame(frame2);
	    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
	    //driver.findElement(By.xpath("//button[text()='Add To Your Collection']")).click();
	    driver.switchTo().defaultContent();
}

public void disable() {
	caps = new DesiredCapabilities();
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
	caps.setCapability(ChromeOptions.CAPABILITY, options);
}

public void alert() {
	driver.switchTo().alert().accept();
}

public void close() {
	driver.close();
}

}

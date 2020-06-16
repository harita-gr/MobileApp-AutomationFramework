package Appium.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Calculator {
	
	static AppiumDriver<MobileElement> driver;  	//Specific for Appium Testing
	
   // WebDriver driver; // Selenium Webdriver
   // AndroidDriver driver; //Specific for Android
	
	public static void main(String[] args) throws InterruptedException{
		
		try {
			openCalculator();
		} catch (MalformedURLException e) {
			
			System.out.println(e.getCause());
			e.getMessage();
			e.printStackTrace();
			
		}

	}

	
	public static void openCalculator() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap =new DesiredCapabilities();
		//Mobile Properties
		cap.setCapability("deviceName","Redmi Note_7_Pro");
		cap.setCapability("udid","218bd41e");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","9 PKQ1.8.1203.001");
		//App Properties
		cap.setCapability("appPackage","com.miui.calculator");
		cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
		//cap.setCapability("automationName","UiAutomator2");
		
		URL url=new URL ("http://127.0.0.1:4723/wd/hub"); // URL of Appium Server
		
		//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
		driver = new AppiumDriver<MobileElement> (url,cap);
		System.out.println("Appium Application Started...");
		
		//Addition
		Thread.sleep(3000);
		MobileElement el1 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_2_s");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el2.click();
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.miui.calculator:id/btn_6_s");
		el3.click();
 
		MobileElement result = driver.findElementByClassName("android.widget.TextView");
		System.out.println("Result is: "+result.getText());
		
	}
}

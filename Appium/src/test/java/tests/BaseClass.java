package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	static AppiumDriver<MobileElement> driver;  
	
	@BeforeTest
	public void setUp()
	{
		try {
		DesiredCapabilities caps=new DesiredCapabilities();
		
		   //Ways to declare capabilities
		//caps.setCapability("platformName","Android");
		//caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");//Interface - CapabilityType
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //Interface - MobileCapabilityType
		
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9 PKQ1.8.1203.001");
		caps.setCapability(MobileCapabilityType.UDID, "218bd41e");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note_7_Pro");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		//caps.setCapability(MobileCapabilityType.APP, ""); //Give absolute path of app
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); // If running on browser
		
	
			
			URL url=new URL ("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement> (url,caps); // Parent for AndroidDriver & IOSDriver & WindowsDriver
//			driver = new AndroidDriver<MobileElement> (url,caps);
//			driver = new IOSDriver<MobileElement> (url,caps);
		} 
		
		catch (MalformedURLException e) {
			System.out.println("Casue is: "+e.getCause());
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void sampleTest()
	{
		System.out.println("Inside Sample Test");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
	
}

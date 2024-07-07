/*
 * package appiumMobileTesting; import java.net.MalformedURLException; import
 * java.net.URL; import io.appium.java_client.android.AndroidDriver; import
 * io.appium.java_client.android.options.UiAutomator2Options;
 * 
 * public class appiumTest1 {
 * 
 * public static void main(String[] args) throws MalformedURLException {
 * 
 * UiAutomator2Options options=new UiAutomator2Options()
 * .setUdid("R9TTC0M2REL").withBrowserName("Chrome");
 * 
 * AndroidDriver driver= new AndroidDriver(new
 * URL("http://127.0.0.1:4723"),options );
 * 
 * driver.get("http://google.com");
 * 
 * 
 * } }
 */

package appiumMobileTesting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Assert;
import java.time.Duration;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;

import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Base.base;

public class appiumTest1 extends base{
	
static AppiumDriver<MobileElement> driver;
	
		
		public static void LoginTest1() {
			
		
		MobileElement login=driver.findElement(By.xpath("//android.widget.TextView[@text=\"󰍂\"]"));
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MobileElement email=driver.findElementByAccessibilityId("input-email");
		
		email.sendKeys("sathyaHariram@gmail.com");
		
		MobileElement password=driver.findElementByAccessibilityId("input-password");
		password.sendKeys("Test@123");
		
		MobileElement FinalLogin=driver.findElement(By.xpath("//android.widget.TextView[@text=\"LOGIN\"]"));
		FinalLogin.click();
		System.out.println("LoginTest successfull");
		
		//MobileElement success=driver.findElement(By.xpath("android:id/alertTitle"));
		//Assert.assertEquals("Success", success.getText(), "validation failed");
		}	
		
		public static void scroll() {
		    Dimension size = appiumTest1.driver.manage().window().getSize();

		    int startX = size.width / 2;
		    int startY = (int) (size.height * 0.8);
		    int endY = (int) (size.height * 0.2);
		    int endX=(int) (size.height* 0.8);

		    TouchAction touchAction = new TouchAction(appiumTest1.driver);
		    touchAction.press(PointOption.point(startX, startY))
		               .waitAction()
		               .moveTo(PointOption.point(startX, endY))
		               .release()
		               .perform();
		}
		public static void SwipeRight() {
			MobileElement swipe=driver.findElement(By.xpath("//android.widget.TextView[@text=\"󰤼\"]"));
			swipe.click();
			System.out.println("ScrollTest successful");
			
		}
		public static void swipeVertically()  {
			//driver.findElementByAccessibilityId("Forms").click();
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"󰤼\"]")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Dimension windowsize=driver.manage().window().getSize();
			int screenHeight=windowsize.getHeight();
			int screenWidth=windowsize.getWidth();
			
			int xStartPoint=50*screenWidth/100;
			//int xStartPoint=512;
			//int xEndPoint=xStartPoint;
			int xEndPoint=840;
			//int yStartPoint=90*screenHeight/100;
			int yStartPoint=2030;
			//int yEndPoint=10*screenHeight/100;
			int yEndPoint=0;
			
			PointOption startPoint=new PointOption().withCoordinates(xStartPoint, yStartPoint);
			PointOption endPoint=new PointOption().withCoordinates(xEndPoint, yEndPoint);
			
		TouchAction touchAction=new TouchAction(driver);
		touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2))).moveTo(endPoint).release().perform();
		System.out.println("Successful");
		}
		
		public static void dragAndDrop() {
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"󰇛\"]")).click();
			
		}
		
		
		public static void Webdriverswipe() {
			driver.findElementByXPath("//android.widget.TextView[@text=\"󰤼\"]").click();
			AndroidElement list=(AndroidElement)driver.findElementByXPath("//android.widget.TextView[@text=\"󰤼\"]");
			
			//MobileElement listitem=(MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().description(\""\)"")"));
		}
		
	@Test
	public void execute() {
		LoginTest1();
	}
		
/*public static  void main(String[] args) throws MalformedURLException  {
	DesiredCapabilities cp=new DesiredCapabilities();
	
	cp.setCapability("deviceName", "R9TTC0M2REL");
	cp.setCapability("platformName","Android");
	cp.setCapability("platformVersion", "14");		
	
	cp.setCapability("appPackage", "com.wdiodemoapp");
	cp.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
	//cp.setCapability("automationName", "UiAutomator2"); 
	cp.setCapability("noReset", true); 
	//cp.setCapability("wait", 50000);
	//cp.setCapability("newCommandTimeout", 50000);
	
	
	driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cp);
	LoginTest1();
	swipeVertically();
	//scroll();
	//SwipeRight();
	//dragAndDrop();
}*/
}
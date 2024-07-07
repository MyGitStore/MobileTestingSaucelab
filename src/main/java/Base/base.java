package Base;

	import org.openqa.selenium.MutableCapabilities;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;

	import org.testng.annotations.AfterMethod;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import java.util.concurrent.TimeUnit;
	public class base {
	    protected RemoteWebDriver driver;

	 //   @Parameters("{browser}")
	    @BeforeClass
	    public void setup() throws MalformedURLException {
	        // Define Sauce Labs credentials
	        String sauceUsername = "oauth-sathyahariram-abc48";
	        String sauceAccessKey = "73dea4ec-fc2f-4124-92d9-3088d60c668f";

	        // Define Sauce Labs URL
	        String sauceUrl = "https://" + sauceUsername + ":" + sauceAccessKey + "@ondemand.saucelabs.com/wd/hub";

	        MutableCapabilities caps = new MutableCapabilities();
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("browserName", "Chrome");
	        caps.setCapability("appium:deviceName", "Samsung.*");
	        caps.setCapability("appium:automationName", "UiAutomator2");
	        MutableCapabilities sauceOptions = new MutableCapabilities();
	        sauceOptions.setCapability("appiumVersion", "latest");
	        sauceOptions.setCapability("username", "oauth-sathyahariram-abc48");
	        sauceOptions.setCapability("accessKey", "73dea4ec-fc2f-4124-92d9-3088d60c668f");
	        sauceOptions.setCapability("build", "<your build id>");
	        sauceOptions.setCapability("name", "<your test name>");
	        caps.setCapability("sauce:options", sauceOptions);

	        URL url = new URL("https://oauth-sathyahariram-abc48:73dea4ec-fc2f-4124-92d9-3088d60c668f@ondemand.us-west-1.saucelabs.com:443/wd/hub");
	        AndroidDriver driver = new AndroidDriver(url, caps);

	        try {
	            // Initialize RemoteWebDriver with Sauce Labs URL and capabilities
	            driver = (AndroidDriver) new RemoteWebDriver(new URL(sauceUrl), caps);
	            Thread.sleep(5000);
	           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5s000));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @AfterMethod
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


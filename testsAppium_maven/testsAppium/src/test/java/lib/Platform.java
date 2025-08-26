package lib;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {



    protected AndroidDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723";


    @Before
    public void setUp() throws Exception {

        String apkPlace = "C:\\Users\\Korsak\\Documents\\KURSES\\java_appium\\JavaAppium\\APKs\\org_wikipedia.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevices");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", apkPlace);


        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }

    @After
    public void tearDown() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }
}

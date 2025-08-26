package lib;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase{

    protected AndroidDriver driver;

    private static String AppiumURL = "http://127.0.0.1:4723";
    String apkPlace = "C:\\Users\\Korsak\\Documents\\KURSES\\java_appium\\JavaAppium\\APKs\\org_wikipedia.apk";

    private static final String PLATFORM_ANDROID = "android";


    @Before
    public void setUp() throws Exception {
      DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }

    @After
    public void tearDown() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform == null) {
            platform = "android"; // значение по умолчанию
        }
        if (platform.equals(PLATFORM_ANDROID)) {

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevices");
            capabilities.setCapability("platformVersion", "12.0");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("app", apkPlace);
        } else {
            throw new Exception("Cannot find platform. Now we have platform " + platform);
        }
        return capabilities;
    }
}

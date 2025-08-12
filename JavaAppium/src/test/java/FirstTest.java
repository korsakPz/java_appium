import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FirstTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevices");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "C:\\Users\\Korsak\\Documents\\KURSES\\java_appium\\JavaAppium\\APKs\\org_wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void firstTest() {

        WebElement element = driver.findElement(By.id("org.wikipedia:id/fragment_onboarding_skip_button"));
        element.click();

    }

}

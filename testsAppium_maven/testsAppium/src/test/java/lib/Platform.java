package lib;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Platform {

    private static String APPIUM_URL = "http://127.0.0.1:4723";
    String apkPlace = "C:\\Users\\Korsak\\Documents\\KURSES\\java_appium\\JavaAppium\\APKs\\org_wikipedia.apk";

    private static final String PLATFORM_ANDROID = "android";
    private static final String MOBILE_WEB_PLATFORM = "Mobile_web";

    // Проверка и установка платформы АНДРОИД
    public RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL(APPIUM_URL);

        if (this.isAndroid()) {
            return new AndroidDriver(URL, getAndroidDesiredCapabilities());
        } else {
            throw new Exception("Cannot need platform. Find another platform " + this.getPlatformVar());
        }

    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isMw() {
        return isPlatform(MOBILE_WEB_PLATFORM);
    }


    private DesiredCapabilities getAndroidDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevices");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", apkPlace);

        return capabilities;

    }

    private boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private String getPlatformVar() {
        return System.getenv("PLATFORM");
    }


}

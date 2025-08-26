package lib;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;


public class CoreTestCase{

    protected RemoteWebDriver driver;
    protected Platform Platform;


    @Before
    public void setUp() throws Exception {

        this.Platform = new Platform();
        driver = this.Platform.getDriver();


    }

    @After
    public void tearDown() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }


}

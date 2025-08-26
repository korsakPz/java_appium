package lib;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.rules.TestRule;


public class CoreTestCase{

    @Rule
    public TestRule allureRule = (TestRule) new AllureJunit4();

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

package lib;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.rules.TestRule;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.Listeners;


@Listeners(AllureJunit4.class)
@RunWith(JUnit4.class)
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

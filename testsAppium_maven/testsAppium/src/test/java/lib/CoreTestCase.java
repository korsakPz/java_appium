package lib;

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
        this.openWikiWebPageForMobileWeb();


    }

    @After
    public void tearDown() throws Exception{
        if (driver != null) {
            driver.quit();
        }
    }

    protected void openWikiWebPageForMobileWeb () {
        if (Platform.isMw()) {
            driver.get("https://en.m.wikipedia.org/");

        } else {
            System.out.println("Method openWikiWebPageForMobileWeb() do nothing for platform " + Platform.isMw());
        }
    }


}

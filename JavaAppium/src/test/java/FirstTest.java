import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class FirstTest {

    private AppiumDriver driver;

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


        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );


        waitForElementPresent(
                By.xpath("//*[contains(@text, 'Java (programming')]"),
                "----------Cannot find searching element by JAVA--------------- ",
                10
        );


    }

    @Test
    public void testCanselSearch() {

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

//        waitForElementPresentByLocators(
//                By.id("org.wikipedia:id/main_toolbar_wordmark"),
//                "------------------------Cannot search TOOLBAR --------------------",
//                5
//        );

        waitForElementNotPresent(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


    }

    @Test
    public void testCompareArticleTitle() {

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        WebElement title_element = waitForElementPresent(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "-------------Cannot find article title----------------------",
                10

        );
        String article_element = title_element.getAttribute("text");

        Assert.assertEquals(
                article_element,
                "Java (programming language)",
                "-----------We see unexpected Title-----------------"

        );
    }

    @Test
    public void testClearElement() {

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                5
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "---------------------Cannot search element CLOSE button------------------",
                5

        );
    }

    @Test
    public void testSwipeArticleList() {

        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        waitForElementPresent(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "-------------Cannot find article title----------------------",
                10

        );

        swipeUp(10000);


    }

    //********************************************Универсальные методы**************************************************************************************************

    private WebElement waitForElementPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);

    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
        element.clear();
        return element;
    }

    //---------------------------------------------------------Метод Свайп----------------------------------------------
    protected void swipeUp(int timeOfSwipe) {

        Dimension size = driver.manage().window().getSize();
        System.out.println("[DEBUG] Screen size: " + size); // Лог размеров экрана

        int centerX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        // Логируем координаты свайпа
        System.out.printf("[DEBUG] Swipe coordinates: from (X=%d, Y=%d) to (X=%d, Y=%d)%n",
                centerX, startY, centerX, endY);

        // 2. Создаем PointerInput (современная замена TouchAction)
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        System.out.println("[DEBUG] PointerInput created"); // Лог создания PointerInput

        // 3. Создаем последовательность действий
        Sequence swipe = new Sequence(finger, 0);
        System.out.println("[DEBUG] Sequence created"); // Лог создания Sequence

        // 4. Добавляем шаги свайпа:
        swipe.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(), centerX, startY));
        System.out.println("[DEBUG] Added move to start position");

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        System.out.println("[DEBUG] Added pointer down");

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(timeOfSwipe),
                PointerInput.Origin.viewport(), centerX, endY));
        System.out.println("[DEBUG] Added move to end position");

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        System.out.println("[DEBUG] Added pointer up");

        // 5. Выполняем свайп
        System.out.println("[DEBUG] Performing swipe...");
        driver.perform(Collections.singletonList(swipe));
        System.out.println("[DEBUG] Swipe performed successfully");

        // 6. Небольшая пауза для стабильности
        try {
            Thread.sleep(8000);
            System.out.println("[DEBUG] Post-swipe pause completed");
        } catch (InterruptedException ignored) {
            System.out.println("[WARN] Swipe pause interrupted");
        }

    }

    //------------------------------------------------------------------------------------------------------------------

}

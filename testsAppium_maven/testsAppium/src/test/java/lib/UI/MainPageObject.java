//package lib.UI;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.PointerInput;
//import org.openqa.selenium.interactions.Sequence;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.List;
//
//public class MainPageObject{
//    protected static AndroidDriver driver;
//
//    public MainPageObject(AndroidDriver driver) {
//        this.driver = driver;
//    }
//
//    //********************************************Универсальные методы**************************************************************************************************
//
//    public static WebElement waitForElementPresent(By by, String error_message, long timeOutInSecond) {
//        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSecond));
//        wait.withMessage(error_message + "\n");
//        return wait.until(
//                ExpectedConditions.presenceOfElementLocated(by)
//        );
//    }
//
//    public WebElement waitForElementPresent(By by, String error_message) {
//        return waitForElementPresent(by, error_message, 5);
//
//    }
//
//    public static WebElement waitForElementAndClick(By by, String error_message, long timeOutInSecond) {
//        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
//        element.click();
//        return element;
//    }
//
//    public static WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSecond) {
//        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
//        element.sendKeys(value);
//        return element;
//    }
//
//    public static boolean waitForElementNotPresent(By by, String error_message, long timeOutInSecond) {
//        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeOutInSecond));
//        wait.withMessage(error_message + "\n");
//        return wait.until(
//                ExpectedConditions.invisibilityOfElementLocated(by)
//        );
//    }
//
//    public WebElement waitForElementAndClear(By by, String error_message, long timeOutInSecond) {
//        WebElement element = waitForElementPresent(by, error_message, timeOutInSecond);
//        element.clear();
//        return element;
//    }
//
//    //---------------------------------------------------------Метод Свайп----------------------------------------------
//    public void swipeUp(int timeOfSwipe) {
//
////        return ((ContextAware) this.driver).context();
//        Dimension size = driver.manage().window().getSize();
//        System.out.println("[DEBUG] Screen size: " + size); // Лог размеров экрана
//
//        int centerX = size.width / 2;
//        int startY = (int) (size.height * 0.8);
//        int endY = (int) (size.height * 0.2);
//
//        // Логируем координаты свайпа
//        System.out.printf("[DEBUG] Swipe coordinates: from (X=%d, Y=%d) to (X=%d, Y=%d)%n",
//                centerX, startY, centerX, endY);
//
//        // 2. Создаем PointerInput (современная замена TouchAction)
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        System.out.println("[DEBUG] PointerInput created"); // Лог создания PointerInput
//
//        // 3. Создаем последовательность действий
//        Sequence swipe = new Sequence(finger, 0);
//        System.out.println("[DEBUG] Sequence created"); // Лог создания Sequence
//
//        // 4. Добавляем шаги свайпа:
//        swipe.addAction(finger.createPointerMove(Duration.ZERO,
//                PointerInput.Origin.viewport(), centerX, startY));
//        System.out.println("[DEBUG] Added move to start position");
//
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        System.out.println("[DEBUG] Added pointer down");
//
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(timeOfSwipe),
//                PointerInput.Origin.viewport(), centerX, endY));
//        System.out.println("[DEBUG] Added move to end position");
//
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        System.out.println("[DEBUG] Added pointer up");
//
//        // 5. Выполняем свайп
////        System.out.println("[DEBUG] Performing swipe...");
//        driver.perform(Collections.singletonList(swipe));
//        System.out.println("[DEBUG] Swipe performed successfully");
//
//        // 6. Небольшая пауза для стабильности
//        try {
//            Thread.sleep(8000);
//            System.out.println("[DEBUG] Post-swipe pause completed");
//        } catch (InterruptedException ignored) {
//            System.out.println("[WARN] Swipe pause interrupted");
//        }
//
//    }
//
//    //------------------------------------------------------------------------------------------------------------------
//
//    //------------------------Свайп до элемента ------------------------------------------------------------------------
//    public void swipeUpQuick() {
//        swipeUp(200);
//    }
//
//    public void swipeToFindElement(By by, String error_message, int max_swipes) {
//
//
//        int alredy_swiped = 0;
//        while (driver.findElements(by).size() == 0) {
//
//            if (alredy_swiped > max_swipes) {
//                waitForElementPresent(by, "--------------- Cannot find element by swipping up. \n " + error_message, 0);
//                return;
//            }
//
//            swipeUpQuick();
//            ++alredy_swiped;
//        }
//
//    }
//
//    //------------------------------------------------------------------------------------------------------------------
//
//    //----------------------------- Свайп влево ------------------------------------------------------------------------
//
//    public static void swipeElementToLeft(By by, String error_message) {
//
//        WebElement element = waitForElementPresent(by, error_message, 10);
//
//        int leftX = element.getLocation().getX();
//        int rightX = element.getLocation().getX() + element.getSize().getWidth();
//        int middleY = element.getLocation().getY() + element.getSize().getHeight() / 2;
//
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence swipe = new Sequence(finger, 1);
//
//        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), rightX, middleY));
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), leftX, middleY));
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        driver.perform(Collections.singletonList(swipe));
//
//    }
//
//    //---------------------------- Assert methods -----------------------------------------------------------
//
//    public static int getAmountOfElements(By by) {
////        List elements = driver.findElements(by);
////        return elements.size();
//
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//        try {
//            // Ждем появления хотя бы одного элемента
//            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
//
//            List<WebElement> elements = driver.findElements(by);
//            System.out.println("Found " + elements.size() + " elements with locator: " + by.toString());
//
//            // Дополнительная проверка видимости
//            int visibleCount = 0;
//            for (WebElement element : elements) {
//                if (element.isDisplayed()) {
//                    visibleCount++;
//                }
//            }
//            System.out.println("Visible elements: " + visibleCount);
//
//            return visibleCount > 0 ? visibleCount : elements.size();
//
//        } catch (TimeoutException e) {
//            System.out.println("No elements found within timeout with locator: " + by.toString());
//            return 0;
//        }
//
//    }
//
//    public static void assertElementNotPresent(By by, String errorMessage) {
//        int amountOfElements = getAmountOfElements(by);
//        if (amountOfElements > 0) {
//            String defaultMessage = "An element " + by.toString() + " supposed to be not present";
//            throw new AssertionError(defaultMessage + " " + errorMessage);
//
//        }
//    }
//
//    public static String waitForElementAndGetAttribute(By by, String attribute, String errorMessage, long timeoutInSecond) {
//        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSecond);
//        return element.getAttribute(attribute);
//    }
//}

package lib.UI;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class MainPageObject {
    protected static AndroidDriver driver;

    public MainPageObject(AndroidDriver driver) {
        this.driver = driver;
    }

    public static WebElement waitForElementPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(By, error_message, 5);
    }

    public static WebElement waitForElementAndClick(By by, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(By, error_message, timeOutInSecond);
        element.click();
        return element;
    }

    public static WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(By, error_message, timeOutInSecond);
        element.sendKeys(value);
        return element;
    }

    public static boolean waitForElementNotPresent(By by, String error_message, long timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond));
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeOutInSecond) {
        WebElement element = waitForElementPresent(By, error_message, timeOutInSecond);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe) {
        Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(timeOfSwipe), PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));

        try {
            Thread.sleep(8000);
        } catch (InterruptedException ignored) {}
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeToFindElement(By by, String error_message, int max_swipes) {
        int alredy_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alredy_swiped > max_swipes) {
                waitForElementPresent(By, "Cannot find element by swipping up. " + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++alredy_swiped;
        }
    }

    public static void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(By, error_message, 10);
        int leftX = element.getLocation().getX();
        int rightX = element.getLocation().getX() + element.getSize().getWidth();
        int middleY = element.getLocation().getY() + element.getSize().getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), rightX, middleY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), leftX, middleY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public static int getAmountOfElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
            List<WebElement> elements = driver.findElements(by);
            int visibleCount = 0;
            for (WebElement element : elements) {
                if (element.isDisplayed()) {
                    visibleCount++;
                }
            }
            return visibleCount > 0 ? visibleCount : elements.size();
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public static void assertElementNotPresent(By by, String errorMessage) {
        int amountOfElements = getAmountOfElements(by);
        if (amountOfElements > 0) {
            String defaultMessage = "An element " + by.toString() + " supposed to be not present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }

    public static String waitForElementAndGetAttribute(By by, String attribute, String errorMessage, long timeoutInSecond) {
        WebElement element = waitForElementPresent(By, errorMessage, timeoutInSecond);
        return element.getAttribute(attribute);
    }
}

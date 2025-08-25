package tests;

import lib.CoreTestCase;
import lib.UI.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class ChangeConditionTests extends CoreTestCase {

    @Test
    public void testBackgroundApp() {

        String nameFindLine = "Java";
        String nameArticle = "Java (programming language)";
        String searchLine = "Search Wikipedia";


        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '" + searchLine + "')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                nameFindLine,
                "--------------------------Cannot find field for JAVA -----------------------------------",
                15
        );


        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, '" + nameArticle + "')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

        driver.runAppInBackground(Duration.ofSeconds(4));

        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, '" + nameArticle + "')]"),
                "----------------------------Cannot find article after returning after background----------------------------------",
                5
        );


    }

    @Test
    public void testChangeScreenOrientationOnSearchResult() {

        String nameFindLine = "Java";
        String nameArticle = "Java (programming language)";
        String searchLine = "Search Wikipedia";


        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '" + searchLine + "')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                nameFindLine,
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '" + nameArticle + "')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
                "----------------------------Cannot find element WIDGET in search field - SEARCH WIKIPEDIA----------------------------------",
                15
        );

//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, '" + nameArticle + "')]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );

        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "text",
                "-----------Cannot find title of article ---------",
                15

        );

        driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);


        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "text",
                "-----------Cannot find title of article ---------",
                15

        );

        Assert.assertEquals(
                title_after_rotation,
                title_before_rotation,
                "Article title have been changed after screen rotation"

        );

        driver.rotate(ScreenOrientation.PORTRAIT);
        String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "text",
                "-----------Cannot find title of article ---------",
                15

        );

        Assert.assertEquals(
                title_after_second_rotation,
                title_before_rotation,
                "Article title have been changed after screen rotation"

        );
    }

}

package tests;

import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.MainPageObject;
import lib.UI.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyyListsTests extends CoreTestCase {

    @Test
    public void testSaveArticle() {

        String testSaveList = "testSaveList";
        String searchLine = "Search Wikipedia";
        String nameFindLine = "Java";
        String nameArticle = "Java (programming language)";

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeInSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");
        SearchPageObject.clickByElement(By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"));
        //String article_title = ArticlePageObject.getArticleTitle();


//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                "------------------Cannot find element SKIP BUTTON---------------------------",
//                5
//        );
//
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, '" + searchLine + "')]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );
//
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                nameFindLine,
//                "--------------------------Cannot find field for JAVA -----------------------------------",
//                5
//        );
//
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, '" + nameArticle + "')]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
//                "----------------------------Cannot find element WIDGET in search field - SEARCH WIKIPEDIA----------------------------------",
//                15
//        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---------------------------- Cannot find element SAVE on the bottom PANEL ----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_save"),
                "---------------------------- Cannot find element SAVE on the bottom PANEL dowble ----------------------------------",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Add to another reading list')]"),
                "---------------------------- Cannot find element SAVE on the bottom PANEL ----------------------------------",
                30
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Create new')]"),
                "---------------------------- Cannot find element SAVE on the bottom PANEL ----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                testSaveList,
                "---------------------- __Cannot send Name of this list__ value",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/text_input"),
                "---------------------------- Cannot find element OK  on the  PANEL ----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("android:id/button1"),
                "---------------------------- Cannot find element BACK arrow pictures ----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "---------------------------- Cannot find element BACK arrow pictures ----------------------------------",
                20
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_toolbar']//*[@content-desc='Navigate up']"),
                "---------------------------- Cannot find element BACK arrow  ----------------------------------",
                10
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "---------------------------- Cannot find element in the SAVED directory ----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("(//android.view.ViewGroup[@resource-id='org.wikipedia:id/item_title_container'])[2]//*[@text='testSaveList']"),
                "",
                5

        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/buttonView"),
                "-----------Go to BACK because need it----------------------",
                5

        );


        MainPageObject.swipeElementToLeft(
                By.id("org.wikipedia:id/page_list_item_title"),
                ""

        );

        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/reading_list_empty_text"),
                "----------Cannot find empty text ",
                5
        );


    }
}

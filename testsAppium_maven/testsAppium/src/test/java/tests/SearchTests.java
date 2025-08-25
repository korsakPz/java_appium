package tests;

import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.MainPageObject;
import lib.UI.SearchPageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeInSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java (programming");

    }

    @Test
    public void testCanselSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCanselSearch();
        SearchPageObject.waitForCancelButtonToDisappear();

    }




    @Test
    public void testClearElement() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeInSearchLine("Java");

//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                "------------------Cannot find element SKIP BUTTON---------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Java",
//                "--------------------------Cannot find field for JAVA -----------------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndClear(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Java",
//                5
//        );

        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "---------------------Cannot search element CLOSE button------------------",
                5

        );
    }


    @Test
    public void testSwipeToElementOnWindow() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeInSearchLine("Appium");
        SearchPageObject.clickByElement(By.id("org.wikipedia:id/page_list_item_title"));
        SearchPageObject.clickByElement(By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"));


        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        ArticlePageObject.swipeToFooter();


//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//                "------------------Cannot find element SKIP BUTTON---------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );
//
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Appium",
//                "--------------------------Cannot find field for JAVA -----------------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/page_list_item_title"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
//                "----------------------------Cannot find element WIDGET in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );

//        MainPageObject.swipeToFindElement(
//                By.xpath("//*[contains(@text, 'Content is available under')]"),
//                "--------------- Cannot find element in this article -----------------------------",
//                4
//        );


    }

    //------------------------------------------ Сохранить статью -----------------------------------------------------------------------------



    @Test
    public void testAmountOfNotEmptySearch() throws InterruptedException {


        String nameSearchLine = "Search Wikipedia";
        String nameFindLine = "Java";

        String elementlocator = "//*[contains(@resource-id, 'fragment_onboarding_skip_button')]";


        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '" + nameSearchLine + "')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                nameFindLine,
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']"),
                "--------Unexpected situation ---   ",
                25

        );


        // Пробуем разные локаторы
        By elementsLocator;
        int amountOfSearchResults = 0;

        // Вариант 1: По заголовкам (самый надежный)
        elementsLocator = By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title']");
        amountOfSearchResults = MainPageObject.getAmountOfElements(elementsLocator);

        // Если не нашли по заголовкам, пробуем другой вариант
        if (amountOfSearchResults == 0) {
            elementsLocator = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='org.wikipedia:id/search_results_list']//android.view.ViewGroup");
            amountOfSearchResults = MainPageObject.getAmountOfElements(elementsLocator);
        }

        // Если все еще не нашли, пробуем третий вариант
        if (amountOfSearchResults == 0) {
            elementsLocator = By.xpath("//*[contains(@resource-id, 'page_list_item')]");
            amountOfSearchResults = MainPageObject.getAmountOfElements(elementsLocator);
        }

        System.out.println("Total search results found: " + amountOfSearchResults);

        // Проверяем, что результаты не пустые
        Assert.assertTrue(

                amountOfSearchResults > 0,
                "We found too few results! Expected more than 0, but got: " + amountOfSearchResults

        );


    }

    @Test
    public void testAmountOfEmptySearch() {

        String nameSearchLine = "Search Wikipedia";
        String nameFindLine = "kjdsjhgfks";

        String elementlocator = "//*[contains(@text, 'No results')]";


        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, '" + nameSearchLine + "')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                nameFindLine,
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath(elementlocator),
                "--- Cannot find search empty element ----- " + elementlocator,
                15
        );

        MainPageObject.assertElementNotPresent(
                By.id(elementlocator),
                "---- We have found some results by request " + nameSearchLine
        );


    }

}

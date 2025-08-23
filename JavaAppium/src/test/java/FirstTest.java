import lib.CoreTestCase;
import lib.UI.MainPageObject;
import lib.UI.SearchPageObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;


public class FirstTest extends CoreTestCase {
    private MainPageObject MainPageObject;

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp(); // Это вызовет setUp() из CoreTestCase
        MainPageObject = new MainPageObject(driver);
    }


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
    public void testCompareArticleTitle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeInSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");
        SearchPageObject.clickByElement(By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"));

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


//        MainPageObject.waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Java",
//                "--------------------------Cannot find field for JAVA -----------------------------------",
//                5
//        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
//                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
//                5
//        );

        WebElement title_element = MainPageObject.waitForElementPresent(
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
    public void testSwipeArticleList() {

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
                "----------------------------Cannot find element WIDGET in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementPresent(
                By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                "-------------Cannot find article title----------------------",
                10

        );


    }

    @Test
    public void testSwipeToElementOnWindow() {
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "------------------Cannot find element SKIP BUTTON---------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Appium",
                "--------------------------Cannot find field for JAVA -----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/page_list_item_title"),
                "----------------------------Cannot find element in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"),
                "----------------------------Cannot find element WIDGET in search field - SEARCH WIKIPEDIA----------------------------------",
                5
        );

        MainPageObject.swipeToFindElement(
                By.xpath("//*[contains(@text, 'Content is available under')]"),
                "--------------- Cannot find element in this article -----------------------------",
                4
        );


    }

    //------------------------------------------ Сохранить статью -----------------------------------------------------------------------------

    @Test
    public void testSaveArticle() {

        String testSaveList = "testSaveList";
        String searchLine = "Search Wikipedia";
        String nameFindLine = "Java";
        String nameArticle = "Java (programming language)";


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


    //+++++++++++++++++++++++++++++++++ Тест с поворотом экрана ++++++++++++++++++++++++++++++++++++++++++++++++++++
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


}

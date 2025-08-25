package tests;

import lib.CoreTestCase;
import lib.UI.ArticlePageObject;
import lib.UI.SearchPageObject;
import lib.UI.factory.ArticlePageObjectFactory;
import lib.UI.factory.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;


public class ArticleTests extends CoreTestCase {

    @Test
    public void testCompareArticleTitle() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeInSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java (programming language)");
        SearchPageObject.clickByElement(By.xpath("//android.widget.ImageView[@content-desc=\"Close\"]"));

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String article_element = ArticlePageObject.getArticleTitle();
        Assert.assertEquals(
                article_element,
                "Java (programming language)",
                "-----------We see unexpected Title-----------------"

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


}

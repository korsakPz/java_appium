package lib.UI;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_SCIP_ELEMENT = "org.wikipedia:id/fragment_onboarding_skip_button",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text, '{SUBSTRING}')]",
            SEARCH_CANCEL_BUTTON = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";


    public SearchPageObject(AndroidDriver driver) {

        super(driver);

    }
//++++++++++++++++++++++++++++++++++++++++++++++++++ Метод шаблонов ++++++++++++++++++++++++++++++++++++++++++++++++++
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    //++++++++++++++++++++++++++++++++++++++++++++++ Метод шаблонов +++++++++++++++++++++++++++++++++++++++++++++++++

    public void initSearchInput() {
        this.waitForElementAndClick(
                By.id(SEARCH_SCIP_ELEMENT),
                "---Cannot find search element ---------",
                15
        );


        this.waitForElementAndClick(
                By.xpath(SEARCH_INIT_ELEMENT),
                "--- Cannot find element SEARCH WIKIPEDIA --------",
                5
        );

        this.waitForElementPresent(
                By.xpath(SEARCH_INIT_ELEMENT),
                " ----------- Cannot search element -------------",
                5
        );
    }

    public void typeInSearchLine(String search_line) {
        this.waitForElementAndSendKeys(
                By.id(SEARCH_INPUT),
                search_line,
                "------ Cannot find input line -----",
                5
        );
    }


    public void waitForSearchResult(String substring) {
        String search_result_line = getResultSearchElement(substring);

        this.waitForElementPresent(
                By.xpath(search_result_line),
                "------ Cannot find element present with substring ------ " + substring,
                15

        );
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_line = getResultSearchElement(substring);

        this.waitForElementAndClick(
                By.xpath(search_result_line),
                "------ Cannot find and click search result with substring ------ " + substring,
                10

        );
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(
                By.xpath(SEARCH_CANCEL_BUTTON),
                "---- Cannot find search cancel button -------",
                15
        );

    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(
                By.xpath(SEARCH_CANCEL_BUTTON),
                "---- Search cancel button is still present -------",
                15
        );

    }

    public void clickCanselSearch() {
        this.waitForElementAndClick(
                By.xpath(SEARCH_CANCEL_BUTTON),
                "---- Cannot find click search button -------",
                5
        );
    }

    public void clickByElement(By by) {
        this.waitForElementAndClick(
                by,
                "------ Cannot search click element  --------",
                5

        );
    }


}

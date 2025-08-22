package lib.UI;

import io.appium.java_client.android.AndroidDriver;

public class SearchPageObject extends MainPageObject{

    private static final String
        SEARCH_SCIP_ELEMENT = "org.wikipedia:id/fragment_onboarding_skip_button",
        SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
        SEARCH_INPUT = "org.wikipedia:id/search_src_text";


    public SearchPageObject(AndroidDriver driver) {
        super(driver);
    }
}

package lib.UI;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
            TITLE = "//*[contains(@text, 'Java (programming language)')]",
            FOOTER_ELEMENT = "//*[contains(@text, 'Content is available under')]";;

    public ArticlePageObject(AndroidDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement() {

        return this.waitForElementPresent(
                By.xpath(TITLE),
                "-------------------- Cannot find article title on page ----------",
                5);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {

        this.swipeToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "",
                5
        );
    }
}

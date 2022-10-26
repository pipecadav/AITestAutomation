package com.intertec.userinterface.pages;

import com.intertec.driver.PageObject;
import com.intertec.userinterface.components.SearchHeader;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AmazonPage extends PageObject {

    @FindBy(id = "nav-search")
    private WebElement searchHeaderContainer;

    SearchHeader searchHeader = new SearchHeader(searchHeaderContainer);

    public void openAmazonPage(String url){
        openPage(url);
    }
    public void searchForProduct(String keyword) {
        waitForElementTobeClickable(searchHeader.getSearchTextBox(), 1000L);
        searchHeader.getSearchTextBox().clear();
        searchHeader.getSearchTextBox().click();
        searchHeader.getSearchTextBox().sendKeys(keyword);
        searchHeader.getSearchSubmitButton().click();
        waitForPageToLoad();
    }
}

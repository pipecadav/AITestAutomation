package com.udea.userinterface.pages;

import com.udea.driver.PageObject;
import com.udea.userinterface.components.SearchHeader;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AmazonPage extends PageObject {

    @FindBy(id = "nav-search")
    private WebElement searchHeaderContainer;

    @FindBy(id = "nav-cart")
    private WebElement cartIcon;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement sideMenu;

    @FindBy(id = "hmenu-customer-name")
    private WebElement customerName;

    @FindBy(css = "#nav-xshop-container a[data-csa-c-slot-id= 'nav_cs_0']")
    private WebElement todaysDeals;

    @FindBy(css = ".glow-toaster input[data-action-type = 'DISMISS']")
    private WebElement toaster;


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

    public void clickOnCart(){
        waitForElementTobeClickable(cartIcon, 1000L);
        cartIcon.click();
    }

    public void clickOnSideMenu(){
        waitForElementTobeClickable(sideMenu, 1000L);
        sideMenu.click();
        waitForElementTobeClickable(customerName, 1000L);
    }

    public void isHelloMessageDisplayed(){
        Assertions.assertThat(customerName.isDisplayed())
                .describedAs("Customer name was not displayed")
                .isTrue();
    }

    public void clickOnTodaysDeals() {
        waitForElementTobeClickable(todaysDeals, 1000L);
        todaysDeals.click();
    }

}

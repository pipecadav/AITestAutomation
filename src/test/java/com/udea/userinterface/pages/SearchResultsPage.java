package com.udea.userinterface.pages;

import com.udea.driver.PageObject;
import com.udea.userinterface.components.SearchHeader;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class SearchResultsPage extends PageObject {

    @FindBy(id = "nav-search")
    private WebElement searchHeaderContainer;

    @FindBy(css = "span[data-component-type='s-result-info-bar']")
    private WebElement resultsInfoBanner;

    @FindBy(css = ".s-result-item.s-asin")
    private List<WebElement> listOfItems;

    @FindBy(css = ".s-pagination-strip")
    private WebElement paginationStrip;

    @FindBy(css = ".s-pagination-strip .s-pagination-item")
    private List<WebElement> paginationStripItems;

    private String selectedProductTitle;

    SearchHeader searchHeader = new SearchHeader(searchHeaderContainer);

    public void isResultsPageDisplayed() {
        Assertions.assertThat(resultsInfoBanner.isDisplayed())
                .describedAs("Results Page was not displayed")
                .isTrue();
    }

    public void selectByVisiblePageNumber(String pageNumber){
        scrollToElement(paginationStrip);
        paginationStripItems
                .stream()
                .filter(page -> page
                        .getText()
                        .trim()
                        .equals(pageNumber))
                .findFirst()
                .get()
                .click();
        waitForPageToLoad();
    }

    public void selectItemOptionByIndex(String itemNumber){
        WebElement selectedItem = listOfItems
                .stream()
                .filter(item ->
                        item
                        .getAttribute("data-index")
                        .equals(itemNumber))
                .findFirst()
                .get();
        selectedProductTitle = selectedItem.findElement(By.cssSelector("h2 span")).getText();
        selectedItem.findElement(By.tagName("img")).click();
        waitForPageToLoad();
    }
}

package com.udea.userinterface.pages;

import com.udea.driver.PageObject;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class DealsPage extends PageObject {

    @FindBy(css = "[data-id = 'deals-header'] h1")
    private WebElement dealsHeader;

    public void isTodaysDealsPageDisplayed(String PageTitle) {
        Assertions.assertThat(dealsHeader.getText())
                .describedAs("Today's Deals page is not visible")
                .isEqualTo(PageTitle);
    }



}

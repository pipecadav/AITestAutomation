package com.udea.userinterface.pages;

import com.udea.driver.PageObject;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartPage extends PageObject{

    @FindBy(css = "#sc-active-cart h2")
    private WebElement cartEmptyMessage;

    public void isCartEmptyMessageDisplayed(){
        Assertions.assertThat(cartEmptyMessage.isDisplayed())
                .describedAs("Cart was not displayed")
                .isTrue();
    }

}
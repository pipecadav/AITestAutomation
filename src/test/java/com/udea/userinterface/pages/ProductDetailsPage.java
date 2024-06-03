package com.udea.userinterface.pages;

import com.udea.driver.PageObject;
import com.udea.userinterface.components.BuyingOptions;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Getter
public class ProductDetailsPage extends PageObject {

    @FindBy(css = "#all-offers-display #aod-container")
    private WebElement buyingOptionsContainer;

    @FindBy(id = "productTitle")
    private WebElement productTitleText;

    @FindBy(id = "addToCart")
    private WebElement addToCartContainer;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id = "outOfStock")
    private WebElement isOutOfStockContainer;

    @FindBy(id = "nav-flyout-ewc")
    private WebElement cartSideBanner;


    BuyingOptions buyingOptions = new BuyingOptions(buyingOptionsContainer);

    public void isProductDetailsPageDisplayed(String productTitle) {
        Assertions.assertThat(productTitleText.getText())
                .describedAs("Product Title doesn't match the selected product")
                .isEqualTo(productTitle);
    }

    public void isProductAvailableForPurchase(){
        Assertions.assertThat(isOutOfStockContainer.isDisplayed())
                .describedAs("The product is out of Stock")
                .isFalse();
    }

    public void isProductAddedToTheCart(){
        Assertions.assertThat(cartSideBanner.isDisplayed())
                .describedAs("Cart Item was not added")
                .isTrue();
    }

    public void addItemToCart(){
        waitForElementTobeClickable(addToCartButton, 5000L);
        addToCartButton.click();
    }






}

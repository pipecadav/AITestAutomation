package com.udea.stepdefinitions;

import com.udea.driver.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;

public class Test0 {
    WebDriver driver = Context.driver;

    @Given("I go into 'amazon' marketplace")
    public void i_go_into_amazon_marketplace() {
        driver.get("https://www.amazon.com");
    }

    @When("I click on the cart")
    public void i_click_on_the_cart() {
        driver.findElement(By.id("nav-cart")).click();
    }

    @Then("I should see the cart page with an empty cart message")
    public void i_should_see_the_cart_page_with_an_empty_cart_message() {
        String cartMessage = driver.findElement(By.cssSelector("div.sc-your-amazon-cart-is-empty")).getText();
        if (cartMessage.contains("Your Amazon Cart is empty")) {
            System.out.println("Cart is empty as expected.");
        } else {
            System.out.println("Cart is not empty.");
        }
    }
}

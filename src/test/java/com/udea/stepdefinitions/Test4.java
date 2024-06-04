package com.udea.stepdefinitions;

import com.udea.driver.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;

public class Test4 {
    WebDriver driver = Context.driver;

    @Given("I go into 'amazon' marketplace")
    public void i_go_into_amazon_marketplace() {
        driver.get("https://www.amazon.com");
    }

    @When("I click on Today's deals")
    public void i_click_on_todays_deals() {
        driver.findElement(By.linkText("Today's Deals")).click();
    }

    @Then("I should see a page with the deals of the day")
    public void i_should_see_a_page_with_the_deals_of_the_day() {
        WebElement dealsPage = driver.findElement(By.cssSelector("div#widgetContent"));
        if (dealsPage.isDisplayed()) {
            System.out.println("Deals of the day page is displayed.");
        } else {
            System.out.println("Deals of the day page is not displayed.");
        }
    }
}

package com.udea.stepdefinitions;

import com.udea.driver.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;

public class Test3 {
    WebDriver driver = Context.driver;

    @When("I search for 'Nintendo'")
    public void i_search_for_Nintendo() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nintendo");
        searchBox.submit();
    }

    @Then("I should see a page with results for the matching criteria")
    public void i_should_see_a_page_with_results_for_the_matching_criteria() {
        WebElement results = driver.findElement(By.cssSelector("div.s-main-slot"));
        if (results.isDisplayed()) {
            System.out.println("Results page is displayed.");
        } else {
            System.out.println("Results page is not displayed.");
        }
    }
}

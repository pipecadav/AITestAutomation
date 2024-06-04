package com.udea.stepdefinitions;

import com.udea.driver.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.*;

import java.util.List;

public class Test1 {
    WebDriver driver = Context.driver;


    @When("I search for 'Alexa'")
    public void i_search_for_Alexa() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Alexa");
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

    @When("I navigate to page number 2")
    public void i_navigate_to_page_number_2() {
        WebElement page2 = driver.findElement(By.cssSelector("a.s-pagination-item:nth-child(3)"));
        page2.click();
    }

    @When("I select item 3 from the list")
    public void i_select_item_3_from_the_list() {
        List<WebElement> items = driver.findElements(By.cssSelector("div.s-main-slot div.s-result-item"));
        if (items.size() >= 3) {
            items.get(2).findElement(By.cssSelector("h2 a")).click();
        } else {
            System.out.println("Less than 3 items found.");
        }
    }

    @Then("I should be redirected to the product details")
    public void i_should_be_redirected_to_the_product_details() {
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        if (productTitle.isDisplayed()) {
            System.out.println("Product details page is displayed.");
        } else {
            System.out.println("Product details page is not displayed.");
        }
    }
}

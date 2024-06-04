package com.udea.stepdefinitions;

import com.udea.driver.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;

public class Test2 {
    WebDriver driver = Context.driver;

    @When("I click on the side menu called All")
    public void i_click_on_the_side_menu_called_All() {
        driver.findElement(By.id("nav-hamburger-menu")).click();
    }

    @Then("I should see a side menu with a hello message at the top of the menu")
    public void i_should_see_a_side_menu_with_a_hello_message_at_the_top_of_the_menu() {
        WebElement helloMessage = driver.findElement(By.cssSelector("div.hmenu-header"));
        if (helloMessage.getText().contains("Hello")) {
            System.out.println("Hello message is displayed at the top of the side menu.");
        } else {
            System.out.println("Hello message is not displayed at the top of the side menu.");
        }
    }
}

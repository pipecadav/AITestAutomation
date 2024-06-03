package com.udea.stepdefinitions;

import com.udea.userinterface.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {

    AmazonPage amazonPage = new AmazonPage();

    CartPage cartPage = new CartPage();

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    DealsPage dealsPage = new DealsPage();

    @Given("I go into {string} marketplace")
    public void iGoIntoNMarketplace(String page) {
        amazonPage.openAmazonPage(System.getProperty(page));
    }


    @When("I search for {string}")
    public void iSearchForAlexa(String keyword) {
        amazonPage.searchForProduct(keyword);
    }


    @Then("I should see a page with results for the matching criteria")
    public void iShouldSeeAPageWithResultsForTheMatchingCriteria() {
        searchResultsPage.isResultsPageDisplayed();
    }

    @When("I navigate to page number {int}")
    public void iNavigateToPageNumber(int pageNumber) {
        searchResultsPage.selectByVisiblePageNumber(Integer.toString(pageNumber));
    }


    @And("I select item {int} from the list")
    public void iSelectItemFromTheList(int itemNumber) {
        searchResultsPage.selectItemOptionByIndex(Integer.toString(itemNumber));
    }


    @Then("I should be redirected to the product details")
    public void iShouldBeRedirectedToTheProductDetails() {
        productDetailsPage.isProductDetailsPageDisplayed(searchResultsPage.getSelectedProductTitle());
    }


    @And("I should be able to add the product to the cart")
    public void iShouldBeAbleToAddTheProductToTheCart() {
        productDetailsPage.isProductAvailableForPurchase();
        productDetailsPage.addItemToCart();
        productDetailsPage.isProductAddedToTheCart();

    }


    @When("I click on the cart")
    public void iClickOnTheCart() {
        amazonPage.clickOnCart();
    }


    @Then("I should the cart page with an empty cart message")
    public void iShouldTheCartPage() {
        cartPage.isCartEmptyMessageDisplayed();
    }

    @When("I click on the side menu called All")
    public void iClickOnTheSideMenuCalledAll() {
        amazonPage.clickOnSideMenu();
    }

    @Then("I should see a side menu with a hello message at the top of the menu")
    public void iShouldSeeASideMenuWithAHelloMessageAtTheTopOfTheMenu() {
        amazonPage.isHelloMessageDisplayed();
    }

    @When("I click on Today's deals")
    public void iClickOnTodaySDeals() {
        amazonPage.clickOnTodaysDeals();
    }

    @Then("I should see a page with the deals of the day")
    public void iShouldSeeAPageWithTheDealsOfTheDay() {
        dealsPage.isTodaysDealsPageDisplayed("Today's Deals");
    }
}

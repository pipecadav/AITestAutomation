package com.udea.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.udea.userinterface.pages.AmazonPage;
import com.udea.userinterface.pages.ProductDetailsPage;
import com.udea.userinterface.pages.SearchResultsPage;

public class AmazonSteps {

    AmazonPage amazonPage = new AmazonPage();

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

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


}

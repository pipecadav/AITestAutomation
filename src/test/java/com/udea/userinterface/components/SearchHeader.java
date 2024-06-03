package com.udea.userinterface.components;

import com.udea.driver.WebComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchHeader extends WebComponent {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchSubmitButton;

    public SearchHeader(WebElement container) {
        super(container);
    }
}

package com.udea.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class WebComponent extends PageObject {

    private WebElement container;

    public WebComponent(WebElement container) {
        this.container = container;
        PageFactory.initElements(new DefaultElementLocatorFactory(container), this);

    }
}

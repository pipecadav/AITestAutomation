package com.udea.userinterface.components;

import com.udea.driver.WebComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class BuyingOptions extends WebComponent {

    public BuyingOptions(WebElement container) {
        super(container);
    }
}

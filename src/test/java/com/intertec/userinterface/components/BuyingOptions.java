package com.intertec.userinterface.components;

import com.intertec.driver.WebComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class BuyingOptions extends WebComponent {

    public BuyingOptions(WebElement container) {
        super(container);
    }
}

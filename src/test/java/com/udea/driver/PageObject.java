package com.udea.driver;

import lombok.Getter;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
@Slf4j
public class PageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageObject() {
        PageFactory.initElements(Context.driver, this);
        this.driver = Context.driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        this.wait = new WebDriverWait(Context.driver, Duration.ofMillis(10000));
    }

    public void openPage(String url) {
        driver.get(url);
        waitForPageToLoad();
    }

    public void waitForPageToLoad(){
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement waitForElementTobeClickable(WebElement element, Long millis){
        try{
            return new WebDriverWait(driver, Duration.ofMillis(millis)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException elementIsNotClickable){
            log.error("Element is not clickable. Please review and try again");
            return null;
        }
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}

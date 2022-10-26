package com.intertec.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Context {

    public static WebDriver driver;

    public static void setDriver(String browser){
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
                break;
        }
    }

}

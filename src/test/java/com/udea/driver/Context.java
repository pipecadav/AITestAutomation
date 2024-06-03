package com.udea.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("remote-allow-origins=*","test-type", "no-sandbox", "ignore-certificate-errors", "--window-size=1000,800",
                        "disable-infobars", "disable-gpu", "disable-default-apps", "disable-popup-blocking",
                        "--user-data-dir=C:/Users/cadav/AppData/Local/Google/Chrome/User Data/Default");
                driver =  new ChromeDriver(options);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
                break;
        }
    }

}

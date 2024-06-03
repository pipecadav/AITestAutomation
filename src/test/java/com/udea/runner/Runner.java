package com.udea.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-html-report"},
        glue = {"com.udea"},
        features = {"src/test/resources/features"}
        //tags = "@Test-4"
)
public class Runner {

}

package com.intertec.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-html-report"},
        glue = {"com.intertec"},
        features = {"src/test/resources/features"}
)
public class Runner {

}

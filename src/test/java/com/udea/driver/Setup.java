package com.udea.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Setup {

    @Before
    public void setup(){
        Context.setDriver(System.getProperty("driver"));
    }

    @After
    public void tearDown(){
        if(Context.driver != null){
            Context.driver.close();
            Context.driver.quit();
            Context.driver = null;
        }
    }




}

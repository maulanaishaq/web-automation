package com.mycompany.tests;

import com.mycompany.driver.DriverFactory;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    @Step("Start test - set up browser")
    public void setUp(@Optional("chrome") String browser){
        DriverFactory.createDriver(browser);
    }


    @AfterMethod(alwaysRun = true)
    @Step("Tear down - quit browser")
    public void tearDown(){
        DriverFactory.quitDriver();
    }



}

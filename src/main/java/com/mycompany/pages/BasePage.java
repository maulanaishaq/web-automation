package com.mycompany.pages;

import com.mycompany.driver.DriverFactory;
import com.mycompany.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    public BasePage(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WaitUtils(driver);
    }

    public String getTitle(){
        return driver.getTitle();
    }


}

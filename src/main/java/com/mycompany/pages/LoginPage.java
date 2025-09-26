package com.mycompany.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[text()='Logged In Successfully']")
    private WebElement loginSuccessTxt;

    @FindBy(id = "error")
    private WebElement errorMessageTxt;

    public LoginPage open(String url){
        driver.get(url);
        return this;
    }

    @Step("Login with user{0}")
    public void login(String username, String password){
        wait.waitForElementToBeVisible(usernameInput).sendKeys(username);
        wait.waitForElementToBeVisible(passwordInput).sendKeys(password);
        wait.waitForElementToBeVisible(submitButton).click();
    }



    public String getMessageSuccessLogin(){
        return loginSuccessTxt.getText();
    }

    public String getErrorMessageLogin(){
        return errorMessageTxt.getText();
    }





}

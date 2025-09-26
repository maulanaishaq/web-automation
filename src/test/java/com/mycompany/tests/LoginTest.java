package com.mycompany.tests;

import com.mycompany.pages.LoginPage;
import com.mycompany.utils.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login")
public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Verify login success with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open login page and attempt login with valid credentials")
    public void loginSucessTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.open("https://practicetestautomation.com/practice-test-login/");
        loginPage.login("student","Password123");
        String actual = loginPage.getMessageSuccessLogin();
        Assert.assertEquals(actual, "Logged In Successfully");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, description = "Verify login error with invalid username credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Open login page and attempt login with invalid credentials username")
    public void loginErrorUsernameTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.open("https://practicetestautomation.com/practice-test-login/");
        loginPage.login("incorrectUser ","Password123");
        String actual = loginPage.getErrorMessageLogin();
        Assert.assertEquals(actual, "Your username is invalid!");
    }




}

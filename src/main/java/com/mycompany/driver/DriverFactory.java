package com.mycompany.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void createDriver(String browser){
        if (driver.get() != null) return;

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized");
                driver.set(new ChromeDriver(co));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                driver.set(new FirefoxDriver(fo));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions eo = new EdgeOptions();
                driver.set(new EdgeDriver(eo));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);

        }
    }

    public static void quitDriver(){
        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }



    }



}

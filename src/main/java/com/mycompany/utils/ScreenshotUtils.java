package com.mycompany.utils;

import com.mycompany.driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.ByteArrayInputStream;
import java.io.File;

public class ScreenshotUtils {
    public static byte[] takeScreenshotBytes() {
        try {
            WebDriver driver = DriverFactory.getDriver();
            TakesScreenshot ts = (TakesScreenshot) driver;
            return ts.getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            return null;
        }
    }

    public static String takeScreenshotFile(String name) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/target/screenshots/" + name;
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            return dest.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    public static void attachScreenshotToAllure(String name) {
        byte[] bytes = takeScreenshotBytes();
        if (bytes != null) {
            Allure.addAttachment(name, new ByteArrayInputStream(bytes));
        }
    }
}

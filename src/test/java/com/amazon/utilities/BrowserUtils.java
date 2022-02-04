package com.amazon.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {

    public static WebElement getTextWebelement(String text){
       WebElement webElement= Driver.get().findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
        return webElement;
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static String getScreenshot(String name) {

        TakesScreenshot ts = (TakesScreenshot) Driver.get();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/Screenshots/" + name + ".png";
        File finalDestination = new File(target);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

}

package com.amazon.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private Driver() {

    }
    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    public static WebDriver get() {

        if (driver.get() == null) {

            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver.set(new SafariDriver());
                    break;
                case "remote_chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("platform", Platform.ANY);
                    try {
                        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
        }
        return driver.get();
    }
    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
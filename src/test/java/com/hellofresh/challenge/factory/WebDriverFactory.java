package com.hellofresh.challenge.factory;

import com.hellofresh.challenge.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WebDriverFactory {
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String GOOGLE_CHROME_BROWSER_NAME = "google_chrome";

    @Autowired
    @ChromeDriverPath
    private String chromeDriverPath;

    @Autowired
    @ImplicitWait
    private int implicitWait;

    @Autowired
    @Headless
    private boolean headless;

    @Autowired
    @Sleep
    private int sleep;

    @Autowired
    @TimeOut
    private int timeout;

    @Autowired
    @BrowserName
    private String browser;

    private static WebDriver driver;

    public WebDriver getWebDriver() {
        if (GOOGLE_CHROME_BROWSER_NAME.equals(browser)) {
            System.setProperty(CHROME_PROPERTY, chromeDriverPath);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--window-size=1600,800");
            chromeOptions.addArguments("--allow-insecure-localhost");
            if (headless) {
                chromeOptions.addArguments("--headless", "--no-sandbox", "--single-process");
            }
            driver = new ChromeDriver(chromeOptions);
        }
        applyConfigs();
        return driver;
    }

    public WebDriver getWebDriver(String url, DesiredCapabilities capabilities) {
        try {
            driver = new RemoteWebDriver(new java.net.URL(url), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        applyConfigs();
        return driver;
    }

    private void applyConfigs() {
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    public WebDriverWait getWebDriverWait(WebDriver driver) {
       return new WebDriverWait(driver, timeout , sleep);
    }
}

package com.hellofresh.challenge.rule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Slf4j
public class ScreenShotOnFailureRule extends TestWatcher {
    @Setter
    private WebDriver driver;

    @Override
    protected void failed(Throwable e, Description description) {
        log.info("Test "+description+" has failed, performing screenshot of the page state");
        String timestamp = String.valueOf(new Date().getTime());
        String testName = description.getDisplayName();
        String fileName = testName+timestamp;
        new File("target/surefire-reports/").mkdirs();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        driver.close();
    }
}
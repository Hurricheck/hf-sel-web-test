package com.hellofresh.challenge.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class MainPage extends AbstractPage{
    private final static String LOGIN_CLASS_NAME = "login";

    @FindBy(className = LOGIN_CLASS_NAME)
    private WebElement loginButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        log.info("Clicking login button");
        loginButton.click();

    }

    public SignInPage goToSignInPage(){
        clickLoginButton();
        return new SignInPage(driver);
    }
}

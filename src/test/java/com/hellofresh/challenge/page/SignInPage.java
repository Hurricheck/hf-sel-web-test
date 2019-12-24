package com.hellofresh.challenge.page;

import com.hellofresh.challenge.entity.HFUser;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class SignInPage extends AbstractPage {
    private static final String INPUT_EMAIL_CREATE_ID = "email_create";
    private static final String SUBMIT_CREATE_ID = "SubmitCreate";
    private static final String INPUT_EMAIL_ID = "email";
    private static final String INPUT_PASSWORD_ID = "passwd";
    private static final String SUBMIT_LOGIN_BUTTON_ID = "SubmitLogin";


    @FindBy(id = INPUT_EMAIL_CREATE_ID)
    private WebElement inputCreateEmail;

    @FindBy(id = SUBMIT_CREATE_ID)
    private WebElement submitCreate;

    @FindBy(id = INPUT_EMAIL_ID)
    private WebElement inputEmail;

    @FindBy(id = INPUT_PASSWORD_ID)
    private WebElement inputPassword;

    @FindBy(id = SUBMIT_LOGIN_BUTTON_ID)
    private WebElement loginButton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCreateEmail(String emailValue) {
        log.info("Inputing email value = {}", emailValue);
        inputCreateEmail.sendKeys(emailValue);
    }

    public void submitAccountCreation() {
        log.info("Clicking submitButton");
        submitCreate.click();

    }

    public void setEmail(String email) {
        log.info("Inputing email value = {}", email);
        inputEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        log.info("inputing password");
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        log.info("Clicking logInDefaultAccount button");
        loginButton.click();
    }

    public void signIn(HFUser hfUser) {
        setEmail(hfUser.getUserEmail());
        setPassword(hfUser.getUserPassword());
        clickLoginButton();
    }

    public NewAccountPage goToNewAccountPage(String email) {
        setCreateEmail(email);
        submitAccountCreation();
        return new NewAccountPage(driver);
    }
}

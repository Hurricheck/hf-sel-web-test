package com.hellofresh.challenge;

import com.hellofresh.challenge.config.SeleniumConfig;
import com.hellofresh.challenge.factory.UniqueEmailFactory;
import com.hellofresh.challenge.factory.WebDriverFactory;
import com.hellofresh.challenge.entity.HFUser;
import com.hellofresh.challenge.page.MainPage;
import com.hellofresh.challenge.page.MyAccountPage;
import com.hellofresh.challenge.page.SignInPage;
import com.hellofresh.challenge.rule.ScreenShotOnFailure;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class BasicTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigurableApplicationContext context;
    protected HFUser hfUser;

    protected UniqueEmailFactory uniqueEmailFactory = new UniqueEmailFactory();


    @Rule
    public ScreenShotOnFailure failure;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(SeleniumConfig.class);
        WebDriverFactory webDriverFactory = (WebDriverFactory) context.getBean("webDriverFactory");
        log.info("Creating WebDriver");
        driver = webDriverFactory.getWebDriver((String) context.getBean("browserName"));
        log.info("WebDriver created = {}", driver);
        log.info("Creating Wait element");
        wait = webDriverFactory.getWebDriverWait(driver);
        log.info("Waiter created = {}", wait);
        log.info("Obtaining user data");
        hfUser = context.getBean("HFUser", HFUser.class);
        log.info("Navigating to the home page");
        driver.get((String) context.getBean("homePage"));
        failure = new ScreenShotOnFailure(driver);
    }

    @After
    public void destroyThings() {
        log.info("Closing driver = {}", driver);
        driver.close();
        context.close();
    }


    MyAccountPage logInDefaultAccount(HFUser hfUser) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(hfUser);
        return new MyAccountPage(driver);
    }
}

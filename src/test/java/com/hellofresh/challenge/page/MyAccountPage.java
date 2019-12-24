package com.hellofresh.challenge.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends AbstractPage {
    private static final String ACCOUNT_CLASSNAME = "account";
    private static final String INFO_ACCOUNT_CLASSNAME = "info-account";
    private static final String LOGOUT_CLASSNAME = "logout";

    private static final String WOMEN_LINK_TEST = "Women";

    @Getter
    @FindBy(className = ACCOUNT_CLASSNAME)
    private WebElement account;

    @Getter
    @FindBy(className = INFO_ACCOUNT_CLASSNAME)
    private WebElement infoAccount;

    @Getter
    @FindBy(className = LOGOUT_CLASSNAME)
    private WebElement logout;

    @FindBy(linkText = WOMEN_LINK_TEST)
    private WebElement womenLink;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWomenLink() {
        womenLink.click();
    }

    public WomenPage goToWomenPage() {
        clickWomenLink();
        return new WomenPage(driver);
    }
}

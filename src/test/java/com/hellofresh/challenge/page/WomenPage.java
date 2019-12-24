package com.hellofresh.challenge.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class WomenPage extends AbstractPage {
    private static final String SLEEVE_T_SHIRTS_XPATH = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li";

    @FindBy(xpath = SLEEVE_T_SHIRTS_XPATH)
    private WebElement sleeveTShirtsElement;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSleeveTShirt() {
        log.info("Clicking Women Faded Short Sleeve T-shirts ancestor");
        sleeveTShirtsElement.click();
    }
}

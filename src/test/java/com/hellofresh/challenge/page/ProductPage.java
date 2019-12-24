package com.hellofresh.challenge.page;

import com.hellofresh.challenge.factory.WebDriverFactory;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {
    private static final String SUBMIT_BUTTON_NAME = "Submit";
    private static final String PROCEED_TO_CHECKOUT_BUTTON_XPATH = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']";

    @FindBy(name = SUBMIT_BUTTON_NAME)
    private WebElement submitButton;

    @Getter
    @FindBy(xpath = PROCEED_TO_CHECKOUT_BUTTON_XPATH)
    private WebElement proceedToCheckoutButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickProceedToCheckoutButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROCEED_TO_CHECKOUT_BUTTON_XPATH)));
        proceedToCheckoutButton.click();
    }

    public ShoppingCartPage goToShoppingCart(WebDriverWait wait) {
        clickSubmitButton();
        clickProceedToCheckoutButton(wait);
        return new ShoppingCartPage(driver);
    }
}

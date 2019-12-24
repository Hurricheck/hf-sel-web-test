package com.hellofresh.challenge.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class ShoppingCartPage extends AbstractPage {
    private static final String PROCESS_ADDRESS_NAME = "processAddress";
    private static final String PROCESS_CARRIER_NAME = "processCarrier";
    private static final String PROCEED_TO_CHECKOUT_XPATH = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']";
    private static final String TERMS_AGREEMENT_ID = "uniform-cgv";

    @FindBy(xpath = PROCEED_TO_CHECKOUT_XPATH)
    private WebElement proceedToCheckoutButton;

    @FindBy(name = PROCESS_ADDRESS_NAME)
    private WebElement processAddressButton;

    @FindBy(name = PROCESS_CARRIER_NAME)
    private WebElement processCarrierButton;

    @FindBy(id = TERMS_AGREEMENT_ID)
    private WebElement agreementCheckbox;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutButton() {
        log.info("Clicking proceed to checkout button");
        proceedToCheckoutButton.click();
    }

    public void clickProcessAddressButtonWithWaiter(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PROCESS_ADDRESS_NAME)));
        log.info("Clicking process address button");
        processAddressButton.click();
    }

    public void clickAcceptAgreementTermsCheckboxWithWaiter(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(TERMS_AGREEMENT_ID)));
        agreementCheckbox.click();
    }

    public void clickProcessCarrierButtonWithWaiter(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(PROCESS_CARRIER_NAME)));
        log.info("Clicking process carrier button");
        processCarrierButton.click();
    }

    public PaymentPage handleShoppingCartProcesses(WebDriverWait wait) {
        clickProceedToCheckoutButton();
        clickProcessAddressButtonWithWaiter(wait);
        clickAcceptAgreementTermsCheckboxWithWaiter(wait);
        clickProcessCarrierButtonWithWaiter(wait);
        return new PaymentPage(driver);
    }

}

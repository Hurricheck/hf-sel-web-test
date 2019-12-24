package com.hellofresh.challenge.page;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class PaymentPage extends AbstractPage {
    private static final String BANKWIRE_PAYMENT_CLASSNAME = "bankwire";
    private static final String CART_NAVIGATION_XPATH = "//*[@id='cart_navigation']/button";

    private static final String STEP_BY_STEP_DONE_FOUR_XPATH = "//li[@class='step_done step_done_last four']";
    private static final String LAST_STEP_XPATH = "//li[@id='step_end' and @class='step_current last']";
    private static final String CHEQUE_INTEND_XPATH = "//*[@class='cheque-indent']/strong";

    @FindBy(className = BANKWIRE_PAYMENT_CLASSNAME)
    private WebElement bankwirePaymentButton;

    @FindBy(xpath = CART_NAVIGATION_XPATH)
    private WebElement cartNavigation;

    @Getter
    @FindBy(xpath = STEP_BY_STEP_DONE_FOUR_XPATH)
    private WebElement fourStepsCompleted;

    @Getter
    @FindBy(xpath = LAST_STEP_XPATH)
    private WebElement lastStepIP;

    @Getter
    @FindBy(xpath = CHEQUE_INTEND_XPATH)
    private WebElement chequeInted;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBankwirePaymentButton() {
        log.info("Clicking element = {}", bankwirePaymentButton);
        bankwirePaymentButton.click();
    }

    public void clickCartNavigationButton() {
        log.info("Clicking element = {}", cartNavigation);
        cartNavigation.click();
    }
}

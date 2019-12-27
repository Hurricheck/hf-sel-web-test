package com.hellofresh.challenge;

import com.hellofresh.challenge.page.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@Slf4j
public class TestCheckOut extends BasicTest {
    private static final String ORDER_CONFIRMATION_HEADER = "ORDER CONFIRMATION";

    @Test
    public void checkoutTest() {
        MyAccountPage myAccountPage = logInDefaultAccount(hfUser);
        WomenPage womenPage = myAccountPage.goToWomenPage();
        womenPage.clickSleeveTShirt();
        womenPage.clickSleeveTShirt();
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = productPage.goToShoppingCart(wait);
        PaymentPage paymentPage = shoppingCartPage.handleShoppingCartProcesses(wait);
        paymentPage.clickBankwirePaymentButton();
        paymentPage.clickCartNavigationButton();
        assertTrue(paymentPage.checkIfHeadingEquals(ORDER_CONFIRMATION_HEADER));
        assertTrue(paymentPage.getFourStepsCompleted().isDisplayed());
        assertTrue(paymentPage.getLastStepIP().isDisplayed());
        assertTrue(paymentPage.getChequeInted().getText().contains("Your order on My Store is complete."));
        assertTrue(paymentPage.checkIfURLContains("controller=order-confirmation"));
    }
}

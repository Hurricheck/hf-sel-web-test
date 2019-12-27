package com.hellofresh.challenge;

import com.hellofresh.challenge.page.MainPage;
import com.hellofresh.challenge.page.MyAccountPage;
import com.hellofresh.challenge.page.NewAccountPage;
import com.hellofresh.challenge.page.SignInPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@Slf4j
public class AuthTest extends BasicTest {
    private static final String MY_ACCOUNT_HEADER = "MY ACCOUNT";
    private static final String ORDER_CONFIRMATION_HEADER = "ORDER CONFIRMATION";
    private static final String ACCOUNT_WELCOME_MESSAGE = "Welcome to your account.";

    // the values used to create a new user could've been provided as a single POJO
    @Test
    public void signInTest() {
        MainPage mainPage = new MainPage(driver);
        SignInPage signInPage = mainPage.goToSignInPage();
        String email = uniqueEmailFactory.getFakeEmail();
        String name = "Firstname";
        String surname = "Lastname";
        NewAccountPage newAccountPage = signInPage.goToNewAccountPage(email);
        newAccountPage.setCustomerFirstName(name);
        newAccountPage.setCustomerLastname(surname);
        newAccountPage.setPassword("Qwerty");
        newAccountPage.setDateOfBirth(1,1, 2000);
        newAccountPage.setCompany("Company");
        newAccountPage.setAddress1("Qwerty, 123");
        newAccountPage.setAddress2("zxcvb");
        newAccountPage.setCity("Qwerty");
        newAccountPage.setState("Colorado");
        newAccountPage.setPostcode("12345");
        newAccountPage.setOther("Qwerty");
        newAccountPage.setPhone("12345123123");
        newAccountPage.setMobilePhone("12345123123");
        newAccountPage.setAlias("hf");
        newAccountPage.clickSubmitButton();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.checkIfHeadingEquals(MY_ACCOUNT_HEADER));
        assertEquals(myAccountPage.getAccount().getText(), name + " " + surname);
        assertTrue(myAccountPage.getInfoAccount().getText().contains(ACCOUNT_WELCOME_MESSAGE));
        assertTrue(myAccountPage.getLogout().isDisplayed());
    }

    @Test
    public void logInTest() {
        String fullName = "Joe Black";
        MyAccountPage myAccountPage = logInDefaultAccount(hfUser);
        assertTrue(myAccountPage.checkIfHeadingEquals(MY_ACCOUNT_HEADER));
        assertEquals(myAccountPage.getAccount().getText(), fullName);
        assertTrue(myAccountPage.getInfoAccount().getText().contains(ACCOUNT_WELCOME_MESSAGE));
        assertTrue(myAccountPage.getLogout().isDisplayed());
        assertTrue(myAccountPage.checkIfURLContains("controller=my-account"));
    }
}

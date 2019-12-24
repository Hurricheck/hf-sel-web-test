package com.hellofresh.challenge.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

@Slf4j
public class NewAccountPage extends AbstractPage{

    private static final String MRS_GENDER_ID = "id_gender2";
    private static final String CUSTOMER_FIRSTNAME_ID = "customer_firstname";
    private static final String CUSTOMER_LASTNAME_ID = "customer_lastname";
    private static final String PASSWORD_ID = "passwd";
    private static final String DOB_DAY_ID = "days";
    private static final String DOB_MONTH_ID = "months";
    private static final String DOB_YEAR_ID = "years";
    private static final String COMPANY_ID = "company";
    private static final String ADDRESS1_ID = "address1";
    private static final String ADDRESS2_ID = "address2";
    private static final String CITY_ID = "city";
    private static final String STATE_ID = "id_state";
    private static final String POSTCODE_ID = "postcode";
    private static final String OTHER_ID = "other";
    private static final String PHONE_ID = "phone";
    private static final String MOBILE_PHONE_ID = "phone_mobile";
    private static final String ALIAS_ID = "alias";
    private static final String SUBMIT_ACCOUNT_BUTTON_ID = "submitAccount";

    @FindBy(id = MRS_GENDER_ID)
    private WebElement selectMrsGender;

    @FindBy(id = CUSTOMER_FIRSTNAME_ID)
    private WebElement inputCustomerFirstname;

    @FindBy(id = CUSTOMER_LASTNAME_ID)
    private WebElement inputCustomerLastname;

    @FindBy(id = PASSWORD_ID)
    private WebElement inputPassword;

    @FindBy(id = DOB_DAY_ID)
    private WebElement selectDateOfBirthDays;

    @FindBy(id = DOB_MONTH_ID)
    private WebElement selectDateOfBirthMonths;

    @FindBy(id = DOB_YEAR_ID)
    private WebElement selectDateOfBirthYears;

    @FindBy(id = COMPANY_ID)
    private WebElement inputCompany;

    @FindBy(id = ADDRESS1_ID)
    private WebElement inputAddress1;

    @FindBy(id = ADDRESS2_ID)
    private WebElement inputAddress2;

    @FindBy(id = CITY_ID)
    private WebElement inputCity;

    @FindBy(id = STATE_ID)
    private WebElement selectState;

    @FindBy(id = POSTCODE_ID)
    private WebElement inputPostcode;

    @FindBy(id = OTHER_ID)
    private WebElement inputOther;

    @FindBy(id = PHONE_ID)
    private WebElement inputPhone;

    @FindBy(id = MOBILE_PHONE_ID)
    private WebElement inputMobilePhone;

    @FindBy(id = ALIAS_ID)
    private WebElement inputAlias;

    @FindBy(id = SUBMIT_ACCOUNT_BUTTON_ID)
    private WebElement submitAccountButton;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMrsGender() {
        log.info("Select MRS Gender");
        selectMrsGender.click();
    }

    public void setCustomerFirstName(String customerFirstName) {
        log.info("Inputing customer first name = {}", customerFirstName);
        inputCustomerFirstname.sendKeys(customerFirstName);
    }

    public void setCustomerLastname(String customerLastName) {
        log.info("Inputing customer last name = {}", customerLastName);
        inputCustomerLastname.sendKeys(customerLastName);
    }

    public void setPassword(String password) {
        log.info("Inputing password");
        inputPassword.sendKeys(password);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        log.info("Setting the date of birth value = {}", dateOfBirth);
        int days = dateOfBirth.getDay();
        int months = dateOfBirth.getMonth();
        int year = dateOfBirth.getYear();
    }

    public void setDateOfBirth(int day, int month, int year) {
        setSelectDateOfBirthDay(day);
        setSelectDateOfBirthMonth(month);
        setSelectDateOfBirthYear(year);
    }

    public void setSelectDateOfBirthDay(int day) {
        log.info("Set Day of Birth to value = {}", day);
        this.selectValue(selectDateOfBirthDays, String.valueOf(day));
    }

    public void setSelectDateOfBirthMonth(int month) {
        log.info("Set Month of Birth to value = {}", month);
        this.selectValue(selectDateOfBirthMonths, String.valueOf(month));
    }

    public void setSelectDateOfBirthYear(int year) {
        log.info("Set Year of Birth to value = {}", year);
        this.selectValue(selectDateOfBirthYears, String.valueOf(year));
    }

    public void setCompany(String company) {
        log.info("Set Company value = {}", company);
        inputCompany.sendKeys(company);
    }

    public void setAddress1(String address1) {
        log.info("Set Address1 value = {}", address1);
        inputAddress1.sendKeys(address1);
    }

    public void setAddress2(String address2) {
        log.info("Set Address1 value = {}", address2);
        inputAddress2.sendKeys(address2);
    }

    public void setCity(String city) {
        log.info("Set City value = {}", city);
        inputCity.sendKeys(city);
    }

    public void setState(String state) {
        log.info("Set State value = {}", state);
        Select select = new Select(selectState);
        select.selectByVisibleText(state);
    }

    public void setPostcode(String postcode) {
        log.info("Inputing postcode value = {}", postcode);
        inputPostcode.sendKeys(postcode);
    }

    public void setOther(String other) {
        log.info("Inputing other value = {}", other);
        inputOther.sendKeys(other);
    }

    public void setPhone(String phone) {
        log.info("Inputing phone value = {}", phone);
        inputPhone.sendKeys(phone);
    }

    public void setMobilePhone(String mobilePhone) {
        log.info("Inputing mobilePhone value = {}", mobilePhone);
        inputMobilePhone.sendKeys(mobilePhone);
    }

    public void setAlias(String alias) {
        log.info("Inputing alias value = {}", alias);
        inputAlias.sendKeys(alias);
    }

    public void clickSubmitButton() {
        submitAccountButton.click();
    }


}

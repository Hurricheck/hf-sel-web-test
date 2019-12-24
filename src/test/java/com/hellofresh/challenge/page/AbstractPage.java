package com.hellofresh.challenge.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Slf4j
public abstract class AbstractPage {
    protected static final String HEADER_CSS_SELECTOR = "h1";

    @FindBy(css = HEADER_CSS_SELECTOR)
    protected WebElement heading;

    protected WebDriver driver;

    public String getHeading() {
        String headerText = heading.getText();
        log.info("Requested the heading text = {}", headerText);
        return headerText;
    }

    protected void selectValue(WebElement element, String value) {
        element.click();
        Select select = new Select(element);
        select.selectByValue(String.valueOf(value));
    }

    public boolean checkIfURLContains(String value) {
        return driver.getCurrentUrl().contains(value);
    }

    public boolean checkIfHeadingEquals(String value) {
        return this.getHeading().equals(value);
    }


}

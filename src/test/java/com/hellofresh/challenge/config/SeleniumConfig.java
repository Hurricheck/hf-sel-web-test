package com.hellofresh.challenge.config;

import com.hellofresh.challenge.annotation.*;
import com.hellofresh.challenge.factory.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Slf4j
@Configuration
@Import(UserConfig.class)
@PropertySource("classpath:properties/test.properties")
@ComponentScan(basePackages = "com.hellofresh.challenge")
public class SeleniumConfig {

    @Value("${path.chromedriver}")
    private String chromeDriverPath;

    @Value("${waiting.implicitwait}")
    private int implicitWait;

    @Value("${waiting.timeout}")
    private int timeout;

    @Value("${waiting.sleep}")
    private int sleep;

    @Value("${webdriver.headless}")
    private boolean headless;

    @Value("${webdriver.browser}")
    private String browserName;

    @Value("${webdriver.homePage}")
    private String homePage;

    @Bean
    @ChromeDriverPath
    public String chromeDriverPath() {
        return chromeDriverPath;
    }

    @Bean
    @ImplicitWait
    public int implicitWait() {
        return implicitWait;
    }

    @Bean
    @TimeOut
    public int timeout() {
        return timeout;
    }

    @Bean
    @Sleep
    public int sleep() {
        return sleep;
    }

    @Bean
    @Headless
    public boolean headless() {
        return headless;
    }

    @Bean
    @BrowserName
    public String browserName() {
        return browserName;
    }

    @Bean
    public String homePage() {
        return homePage;
    }

    @Bean
    public WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }
}

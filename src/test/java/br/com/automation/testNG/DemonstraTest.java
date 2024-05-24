package br.com.automation.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DemonstraTest {
    WebDriver driver;
    static final Logger log = LoggerFactory.getLogger(DemonstraTest.class);
    String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeTest
    public void setup() {
        try {
            log.info("Setting up WebDriver");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920x1080");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            log.info("WebDriver setup completed successfully");
        } catch (Exception e) {
            log.error("Error setting up WebDriver", e);
            throw new RuntimeException("Failed to setup WebDriver", e);
        }
    }

    @Test
    public void validaHome() {
        try {
            log.info("Navigating to {}", sutUrl);
            driver.get(sutUrl);
            String currentTitle = driver.getTitle();
            String expectedTitle = "Selenium WebDriver";
            log.debug("The title of {} is {}", sutUrl, currentTitle);
            Assert.assertTrue(currentTitle.contains(expectedTitle), "The Title is like that: " + currentTitle);
            log.info("Test validaHome passed");
        } catch (Exception e) {
            log.error("Error during validaHome test", e);
            throw e;
        }
    }

    @AfterTest
    void teardown() {
        if (driver != null) {
            log.info("Tearing down WebDriver");
            driver.quit();
        }
    }
}

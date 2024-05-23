package br.com.automation.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BasicTest {
    WebDriver driver;
    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeSuite
    public void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setUPTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();

    }

    @AfterTest
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validaHome() {
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(sutUrl);
        String currentTitle = driver.getTitle();
        String expectedTitle = "Selenium WebDriver";
        log.debug("The title of {} is {}", sutUrl, currentTitle);
        Assert.assertTrue(currentTitle.contains(expectedTitle), "The Title is like that: " + currentTitle);





    }
}

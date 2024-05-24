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

import java.util.concurrent.TimeUnit;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class DemonstraTest {
    WebDriver driver;
    static final Logger log = getLogger(lookup().lookupClass());
    String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeTest
    public void setup() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void validaHome() {

        driver.get(sutUrl);
        String currentTitle = driver.getTitle();
        String expectedTitle = "Selenium WebDriver";
        log.debug("The title of {} is {}", sutUrl, currentTitle);
        Assert.assertTrue(currentTitle.contains(expectedTitle), "The Title is like that: " + currentTitle);


    }

    @AfterTest
    void teardown() {
        if (driver != null){
            driver.quit();
        }

    }
}


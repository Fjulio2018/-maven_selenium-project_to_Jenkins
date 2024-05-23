package br.com.automation.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

public class DemonstraTest {
    WebDriver driver;
    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeSuite
    public void setUpClass(){
        WebDriverManager.chromedriver().browserVersion("125.0.6422.76").setup();

    }

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


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

    @AfterTest
    void teardown() {
        driver.quit();
    }
}





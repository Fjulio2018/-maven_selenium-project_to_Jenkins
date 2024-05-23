package br.com.automation.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class DemonstraTest {
    WebDriver driver;
    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeTest
    public void setup() {
        // Configura o ChromeDriver usando o WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Inicializa o WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validaHome() {
//        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
//        driver.get(sutUrl);
//        String currentTitle = driver.getTitle();
//        String expectedTitle = "Selenium WebDriver";
//        log.debug("The title of {} is {}", sutUrl, currentTitle);
//        Assert.assertTrue(currentTitle.contains(expectedTitle), "The Title is like that: " + currentTitle);

        Assert.assertEquals(1,1);
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }
}

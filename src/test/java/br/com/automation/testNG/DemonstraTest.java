package br.com.automation.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;

public class DemonstraTest {
    WebDriver driver;
    static final Logger log = getLogger(lookup().lookupClass());

    @BeforeSuite
    public void setUpClass(){
        // Define o caminho do ChromeDriver manualmente
        System.setProperty("webdriver.chrome.driver", "/var/jenkins_home/workspace/Pipe Mvn Project/maven_selenium-project/chromedriver-win64/chromedriver.exe");


        // Opcional: configura o ChromeDriver automaticamente, se necessário
        // WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        // Maximiza a janela do navegador
        driver.manage().window().maximize();
    }

    @Test
    public void validaHome() {
        String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
        try {
            driver.get(sutUrl);
            String currentTitle = driver.getTitle();
            String expectedTitle = "Selenium WebDriver";
            log.debug("The title of {} is {}", sutUrl, currentTitle);
            Assert.assertTrue(currentTitle.contains(expectedTitle), "The Title is like that: " + currentTitle);
        } catch (Exception e) {
            log.error("An error occurred while validating home page: {}", e.getMessage());
            Assert.fail("An error occurred while validating home page: " + e.getMessage());
        }
    }

    @AfterTest
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

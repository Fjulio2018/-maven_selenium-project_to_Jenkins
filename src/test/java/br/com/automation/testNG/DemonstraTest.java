package br.com.automation.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemonstraTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.navigate().to("https://teststore.automationtesting.co.uk/index.php/");
        driver.manage().window().maximize();


    }

    @Test
    public void validaHome() {
        Assert.assertEquals(1, 1);

    }
}

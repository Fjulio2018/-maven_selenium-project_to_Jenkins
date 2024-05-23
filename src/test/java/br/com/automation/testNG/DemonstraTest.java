package br.com.automation.testNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemonstraTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){




    }

    @Test
    public void validaHome(){
        Assert.assertEquals(1,1);

    }
}

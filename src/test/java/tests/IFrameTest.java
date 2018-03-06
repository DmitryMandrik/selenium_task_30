package tests;

import drivers.Chrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameTest {
    private WebDriver driver;

    @BeforeClass
    public void getBrowser() {
        driver = Chrome.initChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    void switchToIFrame() {
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement body = driver.findElement(By.cssSelector("#tinymce"));
        body.clear();
        String text1 = "Hello World";
        body.sendKeys(text1);
        Assert.assertEquals(text1, body.getText());
        driver.switchTo().defaultContent();
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}

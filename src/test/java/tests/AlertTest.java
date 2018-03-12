package tests;

import drivers.Chrome;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest {
    private WebDriver driver;

    @BeforeClass
    public void getBrowserAndNavigate() {
        driver = Chrome.initChromeDriver();
        driver.navigate().to(AlertPage.URL);
    }

    @Test
    void testAlert() {
        AlertPage alertPage = new AlertPage();
        driver.findElement(alertPage.alertButton).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Alert error");
        }
        Assert.assertEquals(driver.findElement(alertPage.result).getText(), "You successfuly clicked an alert");
    }

    @Test
    void testConfirm() {
        AlertPage alertPage = new AlertPage();
        driver.findElement(alertPage.confirmAlertButton).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Alert error");
        }
        Assert.assertEquals(driver.findElement(alertPage.result).getText(), "You clicked: Ok");
    }

    @Test
    void testPrompt() {
        AlertPage alertPage = new AlertPage();
        driver.findElement(alertPage.promptAlertButton).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("Some text");
            alert.accept();
        } catch (Exception e) {
            System.out.println("Alert error");
        }
        Assert.assertEquals(driver.findElement(alertPage.result).getText(), "You entered: Some text");
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}

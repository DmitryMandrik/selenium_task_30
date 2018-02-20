package tests;

import drivers.Chrome;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class Login {

    private WebDriver driver;

    @BeforeClass
    public void getBrowser() {
        driver = Chrome.initChromeDriver();
    }

    @Test
    public void logIn() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        driver.navigate().to(loginPage.URL);
        new WebDriverWait(driver, 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(loginPage.email).sendKeys("EugenBorisik");
        driver.findElement(loginPage.password).sendKeys("qwerty12345");
        Thread.sleep(1000);
        driver.findElement(loginPage.submit).click();
        HomePage homePage = new HomePage();
        (new WebDriverWait(driver, 7)).until(ExpectedConditions.presenceOfElementLocated(homePage.signOut));
        Assert.assertEquals(homePage.title, driver.getTitle());
    }

    @Test
    public void openOfficeTab() {
        HomePage homePage = new HomePage();
        driver.findElement(homePage.officeTab).click();
        (new WebDriverWait(driver, 15, 2700)).until(ExpectedConditions.presenceOfElementLocated(homePage.searchByOffice));
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}

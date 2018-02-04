package tests;

import drivers.Chrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Login {

    private WebDriver driver;

    @BeforeMethod
    public void getBrowser() {
        driver = Chrome.initChromeDriver();
    }

    @Test
    public void logIn(){
        LoginPage loginPage = new LoginPage();
        driver.findElement(loginPage.email).sendKeys("ah@ah.com");
        driver.findElement(loginPage.password).sendKeys("ah@ah.com");
        driver.findElement(loginPage.submit).click();
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}

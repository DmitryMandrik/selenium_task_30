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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    private WebDriver driver;

    @DataProvider
    private Object[][] getLoginAndPass() {
        BufferedReader in;
        List<String[]> cartFilesList = new ArrayList<>();

        try {
            in = new BufferedReader(new FileReader("/Users/dmitrymandrik/Documents/training/selenium-project/src/test/datasets/credentials.txt"));
            String str;

            while ((str = in.readLine()) != null) {
                String[] str_arr = str.split(", ");
                cartFilesList.add(str_arr);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cartFilesList.toArray(new Object[0][]);
    }

    @BeforeMethod
    public void getBrowser() {
        driver = Chrome.initChromeDriver();
    }

    @Test(dataProvider = "getLoginAndPass")
    public void logInValidCreds(String login, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        driver.navigate().to(loginPage.URL);
        new WebDriverWait(driver, 5).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(loginPage.email).sendKeys(login);
        driver.findElement(loginPage.password).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(loginPage.submit).click();
        HomePage homePage = new HomePage();
        (new WebDriverWait(driver, 7)).until(ExpectedConditions.presenceOfElementLocated(homePage.signOut));
        Assert.assertEquals(homePage.title, driver.getTitle());
    }

    @Test(enabled = false)
    public void openOfficeTab() {
        HomePage homePage = new HomePage();
        driver.findElement(homePage.officeTab).click();
        (new WebDriverWait(driver, 15, 2700)).until(ExpectedConditions.presenceOfElementLocated(homePage.searchByOffice));
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}

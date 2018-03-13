package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public final String URL = "https://192.168.100.26/ ";
    public final By email = By.cssSelector("#Username");
    public final By password = By.id("Password");
    public final By submit = By.id("SubmitButton");
    public final By rememberCheckbox = By.cssSelector(".remember-chBox");
}

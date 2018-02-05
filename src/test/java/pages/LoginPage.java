package pages;

import org.openqa.selenium.By;

public class LoginPage{

    public static final String URL = "https://192.168.100.26/ ";
    public By email = new By.ByCssSelector("#Username");
    public By password = new By.ByCssSelector("#Password");
    public By submit = new By.ByCssSelector("#SubmitButton");

}

package pages;

import org.openqa.selenium.By;

public class LoginPage{

    public static final String URL = "https://app.wheniwork.net";
    public By email = new By.ByCssSelector("#email");
    public By password = new By.ByCssSelector("#password");
    public By submit = new By.ByCssSelector(".btn.btn-primary.btn-login.btn-md.btn-block");

}

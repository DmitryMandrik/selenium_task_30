package pages;

import org.openqa.selenium.By;

public class AlertPage {
    public static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    public final By result = By.cssSelector("#result");
    public final By alertButton = By.xpath("//button[text()='Click for JS Alert']");
    public final By confirmAlertButton = By.xpath("//button[text()='Click for JS Confirm']");
    public final By promptAlertButton = By.xpath("//button[text()='Click for JS Prompt']");
}

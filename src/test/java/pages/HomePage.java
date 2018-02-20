package pages;

import org.openqa.selenium.By;

public class HomePage {

    public final String title = "RMSys - Home";
    public final By officeTab = By.id("officeMenu");
    public final By signOut = By.linkText("Sign Out");
    public final By searchByOffice = By.xpath("//script[contains(., 'Search by office')]");
}

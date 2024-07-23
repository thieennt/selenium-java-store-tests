package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class YourAccountPage extends BasePage {

    public WebDriver driver;

    public YourAccountPage() throws IOException {
        super();
    }

    By heading = By.cssSelector("h1");
    By signOut = By.cssSelector(".page-footer [href]");

    public WebElement getHeading() throws IOException {
        this.driver = getDriver();
        return driver.findElement(heading);
    }

    public WebElement getSignOutBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(signOut);
    }
}

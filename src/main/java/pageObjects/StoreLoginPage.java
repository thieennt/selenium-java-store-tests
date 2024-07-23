package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreLoginPage extends BasePage {

    public WebDriver driver;

    public StoreLoginPage() throws IOException {
        super();
    }

    By email = By.cssSelector("input#field-email");
    By password = By.cssSelector("input#field-password");
    By loginBtn = By.cssSelector("button#submit-login");
    By createAccountLink = By.linkText("No account? Create one here");

    public WebElement getEmail() throws IOException {
        this.driver = getDriver();
        return driver.findElement(email);
    }

    public WebElement getPassword() throws IOException {
        this.driver = getDriver();
        return driver.findElement(password);
    }

    public WebElement getLoginBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loginBtn);
    }

    public WebElement getCreateAccountLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(createAccountLink);
    }
}

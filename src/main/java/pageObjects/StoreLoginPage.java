package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreLoginPage {

    public WebDriver driver;

    public StoreLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.cssSelector("input#field-email");
    By password = By.cssSelector("input#field-password");
    By loginBtn = By.cssSelector("button#submit-login");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }
}

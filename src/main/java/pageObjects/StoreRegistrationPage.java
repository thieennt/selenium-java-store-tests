package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreRegistrationPage extends BasePage {

    public WebDriver driver;

    public StoreRegistrationPage() throws IOException {
        super();
    }

    By socialTitleMr = By.id("field-id_gender-1");
    By socialTitleMrs = By.id("field-id_gender-2");
    By firstName = By.id("field-firstname");
    By lastName = By.id("field-lastname");
    By email = By.id("field-email");
    By password = By.id("field-password");
    By birthdate = By.id("field-birthday");
    By agreeTermsCheckbox = By.cssSelector("[name='psgdpr']");
    By submitButton = By.xpath("//button[@type='submit']");

    public WebElement getSocialTitleMr() throws IOException {
        this.driver = getDriver();
        return driver.findElement(socialTitleMr);
    }

    public WebElement getSocialTitleMrs() throws IOException {
        this.driver = getDriver();
        return driver.findElement(socialTitleMrs);
    }

    public WebElement getFirstName() throws IOException {
        this.driver = getDriver();
        return driver.findElement(firstName);
    }

    public WebElement getLastName() throws IOException {
        this.driver = getDriver();
        return driver.findElement(lastName);
    }

    public WebElement getEmail() throws IOException {
        this.driver = getDriver();
        return driver.findElement(email);
    }

    public WebElement getPassword() throws IOException {
        this.driver = getDriver();
        return driver.findElement(password);
    }

    public WebElement getBirthdate() throws IOException {
        this.driver = getDriver();
        return driver.findElement(birthdate);
    }

    public WebElement getAgreeTermsCheckbox() throws IOException {
        this.driver = getDriver();
        return driver.findElement(agreeTermsCheckbox);
    }

    public WebElement getSubmitButton() throws IOException {
        this.driver = getDriver();
        return driver.findElement(submitButton);
    }
}

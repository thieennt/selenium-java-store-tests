package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreRegistrationPage {
    public WebDriver driver;

    public StoreRegistrationPage(WebDriver driver) {
        this.driver = driver;
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

    public WebElement getSocialTitleMr() {
        return driver.findElement(socialTitleMr);
    }

    public WebElement getSocialTitleMrs() {
        return driver.findElement(socialTitleMrs);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }

    public WebElement getLastName() {
        return driver.findElement(lastName);
    }

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getBirthdate() {
        return driver.findElement(birthdate);
    }

    public WebElement getAgreeTermsCheckbox() {
        return driver.findElement(agreeTermsCheckbox);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }
}

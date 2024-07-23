package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class StoreSearchPage extends BasePage {

    public WebDriver driver;

    By searchBox = By.cssSelector("input[name='s']");
    By productName = By.cssSelector(".h3.product-title>a");

    public StoreSearchPage() throws IOException {
        super();
    }

    public void enterSearchTermAndSubmit(String searchTerm) throws IOException {
        this.driver = getDriver();
        driver.findElement(searchBox).sendKeys(searchTerm + Keys.ENTER);
    }

    public String getFirstProductName() throws IOException {
        this.driver = getDriver();
        return driver.findElement(productName).getText();
    }

}

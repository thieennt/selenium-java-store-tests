package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class StoreSearchPage {
    public WebDriver driver;

    By searchBox = By.cssSelector("input[name='s']");
    By productName = By.cssSelector(".h3.product-title>a");

    public StoreSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTermAndSubmit(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm + Keys.ENTER);
    }

    public String getFirstProductName() {
        return driver.findElement(productName).getText();
    }

}

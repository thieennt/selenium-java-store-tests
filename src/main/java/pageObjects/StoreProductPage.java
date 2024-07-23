package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class StoreProductPage extends BasePage {
    public WebDriver driver;

    By sizeOption = By.cssSelector("[aria-label='Size']");
    By quantityIncrease = By.cssSelector(".touchspin-up");
    By quantityDecrease = By.cssSelector(".touchspin-down");
    By addToCartBtn = By.cssSelector("[data-button-action]");
    By homepageLink = By.xpath("//span[.='Home']");

    public StoreProductPage() throws IOException {
        super();
    }

    public WebElement getSizeOption() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sizeOption);
    }

    public WebElement getQuantIncrease() throws IOException {
        this.driver = getDriver();
        return driver.findElement(quantityIncrease);
    }

    public WebElement getQuantDecrease() throws IOException {
        this.driver = getDriver();
        return driver.findElement(quantityDecrease);
    }

    public WebElement getAddToCartBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(addToCartBtn);
    }

    public WebElement getHomepageLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(homepageLink);
    }
}

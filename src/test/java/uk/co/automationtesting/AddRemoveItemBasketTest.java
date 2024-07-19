package uk.co.automationtesting;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;
import java.time.Duration;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends BasePage {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }

    @Test
    public void addRemoveItem() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage(driver);

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreHomepage shopHome = new StoreHomepage(driver);
        shopHome.getProdOne().click();

        // creating an object of the shop products page (when a product has been selected)
        StoreProductPage shopProd = new StoreProductPage(driver);
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantIncrease().click();
        shopProd.getAddToCartBtn().click();

        // creating an object of the cart content panel (once an item was added)
        StoreContentPanel cPanel = new StoreContentPanel(driver);
        cPanel.getContinueShopBtn().click();
        shopProd.getHomepageLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();
        cPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.getDeleteItemTwo().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

        System.out.println(cart.getTotalAmount().getText());

        Assert.assertEquals(cart.getTotalAmount().getText(), "$45.2");

    }
}

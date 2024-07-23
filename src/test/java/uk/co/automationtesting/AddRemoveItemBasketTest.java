package uk.co.automationtesting;

import base.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void addRemoveItem() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage();

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreHomepage shopHome = new StoreHomepage();
        shopHome.getProdOne().click();

        // creating an object of the shop products page (when a product has been selected)
        StoreProductPage shopProd = new StoreProductPage();
        Select option = new Select(shopProd.getSizeOption());
        option.selectByVisibleText("M");
        shopProd.getQuantIncrease().click();
        shopProd.getAddToCartBtn().click();

        // creating an object of the cart content panel (once an item was added)
        StoreContentPanel cPanel = new StoreContentPanel();
        cPanel.getContinueShopBtn().click();
        shopProd.getHomepageLink().click();
        shopHome.getProdTwo().click();
        shopProd.getAddToCartBtn().click();
        cPanel.getCheckoutBtn().click();

        // creating an object for the shopping cart page and deleting item 2
        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        // using a wait to ensure the deletion has token place
        waitForElementInvisible(cart.getDeleteItemTwo(), 10);

        // printing the total amount to console
        System.out.println(cart.getTotalAmount().getText());

    }
}

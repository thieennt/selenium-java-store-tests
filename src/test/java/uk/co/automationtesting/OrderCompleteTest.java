package uk.co.automationtesting;

import base.ExtentManager;
import base.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException {
        super();
    }

    @Test
    public void endToEndTest() throws InterruptedException, IOException {

        ExtentManager.log("Starting OrderCompleteTest...");

        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage();

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();
        ExtentManager.pass("Have successfully reached store homepage");

        // creating an object of the test store homepage
        StoreHomepage storeHome = new StoreHomepage();
        storeHome.getProdTwo().click();
        ExtentManager.pass("Have successfully clicked on product");

        // creating an object of the shop products page (when a product has been selected)
        StoreProductPage storeProd = new StoreProductPage();
        ExtentManager.pass("Have successfully reached shop product page");
        Select option = new Select(storeProd.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Have successfully selected product size");
        storeProd.getQuantIncrease().click();
        ExtentManager.pass("Have successfully clicked product quantity");
        storeProd.getAddToCartBtn().click();
        ExtentManager.pass("Have successfully added item to cart");

        Thread.sleep(5000);

        // creating an object of the cart content panel (once an item was added)
        StoreContentPanel cPanel = new StoreContentPanel();
        cPanel.getCheckoutBtn().click();

        // creating an object of the shopping cart page (all items selected)
        ShoppingCart cart = new ShoppingCart();
        ExtentManager.pass("Have successfully reached the shopping cart page");
        cart.getHavePromo().click();
        ExtentManager.pass("Have successfully selected the promo");
        cart.getPromoTextbox().sendKeys("20OFF");
        cart.getPromoAddBtn().click();
        ExtentManager.pass("Have successfully added the promo");
        Thread.sleep(5000);
        cart.getProceedCheckoutBtn().click();
        ExtentManager.pass("Have successfully clicked the checkout button");

        // creating an object of the order personal information page
        OrderFormPersInfo pInfo = new OrderFormPersInfo();
        pInfo.getGenderMr().click();
        pInfo.getFirstNameField().sendKeys("John");
        pInfo.getLastnameField().sendKeys("Smith");
        pInfo.getEmailField().sendKeys("john@test.com");
        pInfo.getTermsConditionsCheckbox().click();
        pInfo.getContinueBtn().click();
        ExtentManager.pass("Have successfully entered customer details");

        // creating an object of the order delivery info page
        OrderFormDelivery orderDelivery = new OrderFormDelivery();
        orderDelivery.getAddressField().sendKeys("123 Main Street");
        orderDelivery.getCityField().sendKeys("Houston");
        Select state = new Select(orderDelivery.getStateDropdown());
        state.selectByVisibleText("Texas");
        orderDelivery.getPostcodeField().sendKeys("77021");
        orderDelivery.getContinueBtn().click();
        ExtentManager.pass("Have successfully entered delivery info");

        // creating an object of the shipping method page
        OrderFormShippingMethod shipMethod = new OrderFormShippingMethod();
        shipMethod.getDeliveryMsgTextbox().sendKeys("If I am not in, please leave my delivery on my porch.");
        shipMethod.getContinueBtn().click();
        ExtentManager.pass("Have successfully selected the shipping method");

        // creating an object of the payment options page
        OrderFormPayment orderPay = new OrderFormPayment();
        orderPay.getPayByCheckRadioBtn().click();
        orderPay.getTermsConditionsCheckbox().click();
        orderPay.getOrderBtn().click();
        ExtentManager.pass("Have successfully ordered");
    }
}

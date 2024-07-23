package uk.co.automationtesting;

import base.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.StoreSearchPage;

import java.io.IOException;

public class StoreSearchTest extends Hooks {

    public StoreSearchTest() throws IOException {
        super();
    }

    @Test
    public void testSearchProductUsingEnterKey() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage();

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreSearchPage searchPage = new StoreSearchPage();
        searchPage.enterSearchTermAndSubmit("T-shirt");

        String productName = searchPage.getFirstProductName();
        Assert.assertTrue(productName.contains("T-Shirt"), "Product name does not contain 'T-shirt'");
    }

}

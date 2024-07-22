package uk.co.automationtesting;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.StoreSearchPage;

import java.io.IOException;

public class StoreSearchTest extends BasePage {

    public StoreSearchTest() throws IOException {
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
    public void testSearchProductUsingEnterKey() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage(driver);

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreSearchPage searchPage = new StoreSearchPage(driver);
        searchPage.enterSearchTermAndSubmit("T-shirt");

        String productName = searchPage.getFirstProductName();
        Assert.assertTrue(productName.contains("T-Shirt"), "Product name does not contain 'T-shirt'");
    }

}

package uk.co.automationtesting;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.StoreHomepage;
import pageObjects.StoreLoginPage;

import java.io.IOException;

public class StoreLoginTest extends BasePage {

    public StoreLoginTest() throws IOException {
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
    public void login() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage(driver);

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreHomepage shopHome = new StoreHomepage(driver);
        shopHome.getSigninBtn().click();

        // Login
        StoreLoginPage loginPage = new StoreLoginPage(driver);
        loginPage.getEmail().sendKeys("test@test.com");
        loginPage.getPassword().sendKeys("test123");
        loginPage.getLoginBtn().click();

        System.out.println("Login successfully!");

    }
}

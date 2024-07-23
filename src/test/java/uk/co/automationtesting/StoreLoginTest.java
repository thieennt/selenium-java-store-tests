package uk.co.automationtesting;

import base.Hooks;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.StoreHomepage;
import pageObjects.StoreLoginPage;

import java.io.IOException;

public class StoreLoginTest extends Hooks {

    public StoreLoginTest() throws IOException {
        super();
    }

    @Test
    public void login() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage();

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreHomepage shopHome = new StoreHomepage();
        shopHome.getSigninBtn().click();

        // Login
        StoreLoginPage loginPage = new StoreLoginPage();
        loginPage.getEmail().sendKeys("test@test.com");
        loginPage.getPassword().sendKeys("test123");
        loginPage.getLoginBtn().click();

        System.out.println("Login successfully!");

    }
}

package uk.co.automationtesting;

import base.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.StoreHomepage;
import pageObjects.StoreLoginPage;
import pageObjects.StoreRegistrationPage;

import java.io.IOException;

public class StoreRegistrationTest extends BasePage {

    public StoreRegistrationTest() throws IOException {
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
    public void registration() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage(driver);

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreHomepage shopHome = new StoreHomepage(driver);
        shopHome.getSigninBtn().click();
        StoreLoginPage loginPage = new StoreLoginPage(driver);
        loginPage.getCreateAccountLink().click();

        // registration
        StoreRegistrationPage registrationPage = new StoreRegistrationPage(driver);
        registrationPage.getSocialTitleMrs().click();
        registrationPage.getFirstName().sendKeys("Tia");
        registrationPage.getLastName().sendKeys("Nguyen");
        registrationPage.getEmail().sendKeys("tia@test.com");
        registrationPage.getPassword().sendKeys("tia123");
        registrationPage.getBirthdate().sendKeys("01/01/2000");
        registrationPage.getAgreeTermsCheckbox().click();
        registrationPage.getSubmitButton().click();

    }
}

package uk.co.automationtesting;

import base.Hooks;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.StoreHomepage;
import pageObjects.StoreLoginPage;

import java.io.FileInputStream;
import java.io.IOException;


public class LoginTestUsingExcelData extends Hooks {

    public LoginTestUsingExcelData() throws IOException {
        super();
    }

    @Test
    public void loginUsingExcelData() throws IOException {
        // creating an object of the automationtesting.co.uk webpage
        Homepage home = new Homepage();

        // handle cookie prompt
        home.getCookie().click();
        home.getTestStoreLink().click();

        // creating an object of the test store homepage
        StoreHomepage shopHome = new StoreHomepage();
        shopHome.getSigninBtn().click();

        FileInputStream workbookLocation = new FileInputStream(System.getProperty("user.dir") +
                "src/main/java/resources/credentials.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(workbookLocation);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row1 = sheet.getRow(1);
        Cell cellR1C0 = row1.getCell(0);
        Cell cellR1C1 = row1.getCell(1);

        String emailRow1 = cellR1C0.toString();
        String passWordRow1 = cellR1C1.toString();

        // Login
        StoreLoginPage loginPage = new StoreLoginPage();
        loginPage.getEmail().sendKeys(emailRow1);
        loginPage.getPassword().sendKeys(passWordRow1);
        loginPage.getLoginBtn().click();

        // Sign out
//        YourAccountPage yourAccount = new YourAccountPage();
//        try {
//            yourAccount.getSignOutBtn().click();
//            ExtentManager.pass("user HAS signed in");
//        } catch (Exception e) {
//            ExtentManager.fail("user could NOT sign in");
//            Assert.fail();
//        }
    }
}

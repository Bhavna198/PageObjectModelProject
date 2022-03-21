package com.bridgelabz.pomFramework;

import com.bridgelabz.fb.base.BaseClass;
import com.bridgelabz.fb.page.HomePage;
import com.bridgelabz.fb.page.LoginPage;
import com.bridgelabz.fb.utility.test.UtilityClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseClass {

    // creating object of class
    LoginPage loginPage;
    HomePage homepage;
    String sheetName = "Sheet1";


    Logger log = Logger.getLogger(LoginPageTest.class);
    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        intialization();
        loginPage= new LoginPage();

    }

   @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage = new LoginPage();
        String loginPageTitle = loginPage.verifyPageTitle();
        Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
        log.info("Validate the Title page");
    }

    @Test(priority = 2)
    public void loginTest() {
        loginPage = new LoginPage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = UtilityClass.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData")
    public void multipleLoginTest(String userName, String pass) throws InterruptedException {
        loginPage.loginMultipleAccounts(userName, pass);
        Thread.sleep(1000);
        log.info("login successful with username: " + userName);
    }

    @AfterMethod
    public void tearDown() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        log.info("browser is closed");

    }
}
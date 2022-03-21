package com.bridgelabz.pomFramework;

import com.bridgelabz.fb.base.BaseClass;
import com.bridgelabz.fb.page.HomePage;
import com.bridgelabz.fb.page.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        intialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        homePage.verifyHomePageTitle();
    }

    @Test(priority = 2)
    public void verifyClickOnProfileTest() throws InterruptedException {
        homePage.clickOnProfile();
        Thread.sleep(5000);
    }

    /* @Test(priority = 3)
     public void verifyFriendsPageTest() {
         homePage.clickOnFriendsLink();
     }

     @Test(priority = 4)
     public void verifySavedPageTest() {
         homePage.clickOnSavedLink();
     }*/
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


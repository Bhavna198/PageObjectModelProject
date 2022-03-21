package com.bridgelabz.pomFramework;

import com.bridgelabz.fb.base.BaseClass;
import com.bridgelabz.fb.page.HomePage;
import com.bridgelabz.fb.page.LoginPage;
import com.bridgelabz.fb.page.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Base64;

public class RegisterPageTest extends BaseClass {

    RegisterPage registerPage;
    LoginPage loginPage;
    HomePage homePage;

    public RegisterPageTest(){
        super();
    }


    @BeforeMethod
    public void setUp() {
        intialization();

    }
    /* @Test(priority = 1)
     public void RegisterPageTitleTest {
         registerPage = new RegisterPage();
         String RegisterPageTitle = registerPage.validateRegisterPageTitle();
         Assert.assertEquals(RegisterPageTitle, "Facebook – log in or sign up", RegisterPageTitle);
     }*/
    @Test
    public void RegisterTest() {
        registerPage = new RegisterPage();
        registerPage.RegisterPage(properties.getProperty("firstname"), properties.getProperty("lastname"),properties.getProperty("reg_email"), properties.getProperty("pass"), properties.getProperty("birthday_day"), properties.getProperty("birthday_month"), properties.getProperty("birthday_year"), properties.getProperty("sex"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}



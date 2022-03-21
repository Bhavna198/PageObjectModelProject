package com.bridgelabz.fb.page;

import com.bridgelabz.fb.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    /* Page Factory --OR Object Repository*/
    // declaration
    /* username using ID property*/
    @FindBy(id = "email")
            WebElement username;

    @FindBy(xpath = "//input[@id='pass']")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(xpath = "//a[@id='u_0_2_k+']")
    WebElement CreateAccount;

    public LoginPage() {


        PageFactory.initElements(driver, this);
    }

    public String verifyPageTitle() {

        return driver.getTitle();
    }

    public HomePage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
        return new HomePage();

    }

    public void loginMultipleAccounts(String userName2, String password2) {
        // TODO Auto-generated method stub
        username.sendKeys(userName2);
        password.sendKeys(password2);
        loginButton.click();

    }
}
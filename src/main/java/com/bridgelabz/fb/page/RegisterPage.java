package com.bridgelabz.fb.page;

import com.bridgelabz.fb.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {

    @FindBy(linkText = "Create New Account")
    WebElement CreateNewAccount;

    @FindBy(name = "firstname")
    WebElement firstname;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "reg_email__")
    WebElement reg_email;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(name = "birthday_day")
    WebElement birthday_day;

    @FindBy(name = "birthday_month")
    WebElement birthday_month;

    @FindBy(name = "birthday_year")
    WebElement birthday_year;

    @FindBy(name = "sex")
    WebElement sex;

    @FindBy(name = "websubmit")
    WebElement submit;

    public void ResisterPage() {

        PageFactory.initElements(driver, this);
    }

    public void RegisterPage(String firstname, String lastname, String reg_email, String pass, String birthday_day, String birthday_month, String birthday_year, String sex) {
        CreateNewAccount.click();
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.reg_email.sendKeys(reg_email);
        this.pass.sendKeys(pass);
        this.birthday_day.sendKeys(birthday_day);
        this.birthday_month.sendKeys(birthday_month);
        this.birthday_year.sendKeys(birthday_year);
        this.sex.sendKeys(sex);
        submit.click();


    }
}

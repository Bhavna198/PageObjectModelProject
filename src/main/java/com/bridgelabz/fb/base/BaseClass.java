package com.bridgelabz.fb.base;

import com.bridgelabz.fb.utility.test.UtilityClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    /* Properties is global variable*/
    public static Properties properties;

    /*create constructor class and read the properties*/
    public BaseClass() {

        /* read the properties and initialing the properties variable*/

        properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(
                    "C:\\Users\\bhava\\IdeaProjects\\POMFrameworkProject\\src\\main\\java\\com\\bridgelabz\\fb\\config\\config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void intialization() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

        }
        else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        /* if we want change pageLoadTimeout time and implicitlyWait  that time change  below script code.
         so in that situation we will create a utility class  and define the  IMPLICIT_WAIT_TIME  andPAGE_LOAD_TIME
          value and use to (UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
         */
        driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGE_LOAD_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

        /* launch the browser*/
        driver.get(properties.getProperty("url"));
    }
}


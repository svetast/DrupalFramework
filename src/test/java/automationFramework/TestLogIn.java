package automationFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogIn {
    private final static String URL =
            "https://www.drupal.org/user/login?destination=home";


    static WebDriver driver;
    pageObjects.BasePage BasePage;
    pageObjects.LoginPage LoginPage;
    pageObjects.ErrorPage ErrorPage;

    @BeforeMethod

    public void beforeMethod() {


        driver = new FirefoxDriver ();
        driver.manage ().timeouts ().implicitlyWait (20, TimeUnit.SECONDS);
        driver.get (URL);

        BasePage = PageFactory.initElements (driver, pageObjects.BasePage.class);
        LoginPage = PageFactory.initElements (driver, pageObjects.LoginPage.class);
        ErrorPage = PageFactory.initElements (driver, pageObjects.ErrorPage.class);


    }


    @Test
    public void inputSuccess() {
        BasePage.loginAction ("oa.org.ua", "12345Q");
        BasePage.checkPassResult ();

    }

    @Test
    public void inputEmptyPassword() throws Exception {
        BasePage.loginAction ("oa.org.ua", "");
        BasePage.checkFailResult ();

    }

    @Test
    public void inputEmptyLogin() throws Exception {
        BasePage.loginAction ("", "12345Q");
        BasePage.checkFailResult ();
    }

    @Test
    public void inputEmptyLoginPassword() throws Exception {
        BasePage.loginAction ("", "");
        BasePage.checkFailResult ();


    }

    @Test
    public void inputUnSuccess() throws Exception {
        BasePage.loginAction ("rama", "12345");
        BasePage.checkFailResult ();


    }


    @AfterMethod

    public void afterMethod() {
        driver.quit ();

    }

}




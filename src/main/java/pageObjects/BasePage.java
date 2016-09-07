package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class BasePage {


    WebDriver driver;
    @FindBy (id = "page-title")
    private WebElement pageTitle;
    @FindBy (id = "edit-pass")
    private WebElement password;
    @FindBy (id = "edit-submit")
    private WebElement submit;
    @FindBy (id = "edit-name")
    private WebElement login;


    public BasePage(WebDriver driver)

    {

        this.driver = driver;

    }

    public void loginAction(String usernameKey, String passwordKey) {

        login.sendKeys (usernameKey);

        password.sendKeys (passwordKey);

        submit.click ();

    }


    public void checkPassResult() {
        assertEquals ("Drupal - Open Source CMS | Drupal.org", driver.getTitle ());

    }

    public void checkFailResult() {
        assertEquals ("Log in | Drupal.org", driver.getTitle ());


    }
}


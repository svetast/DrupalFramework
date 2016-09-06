package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {


    final WebDriver driver;
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
}


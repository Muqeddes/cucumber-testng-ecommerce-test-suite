package ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerce.utilities.AppConfig;
import ecommerce.utilities.TestHelper;

public class LoginPage {

    WebDriver driver;
    TestHelper testHelper;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testHelper=new TestHelper(driver);
    }

    @FindBy(id = "user-name")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = ".title")
    WebElement pageTitle;

    public void login(){
        testHelper.waitForElementPresent(userNameField);
        userNameField.sendKeys(AppConfig.readFromConfig("username"));
        testHelper.waitForElementPresent(passwordField);
        passwordField.sendKeys(AppConfig.readFromConfig("password"));
        loginButton.click();
        testHelper.sleep(1);
    }

    public boolean verifyLogin() {
        testHelper.waitForElementPresent(pageTitle);
        if (pageTitle.isDisplayed()) {
            System.out.println("Login Successfully!!");
            return true;
        } else {
            System.out.println("Login failed!!!");
            return false;
        }
    }


}

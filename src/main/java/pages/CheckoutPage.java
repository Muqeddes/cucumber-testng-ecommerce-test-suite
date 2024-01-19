package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestHelper;

public class CheckoutPage { WebDriver driver;
    TestHelper testHelper;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testHelper=new TestHelper(driver);
    }

    @FindBy(id="first-name")
    WebElement firstNameField;
    @FindBy(id="last-name")
    WebElement lastNameField;
    @FindBy (name="postalCode")
    WebElement zipCodeField;
    @FindBy (id="continue")
    WebElement continueButton;
    @FindBy (xpath = "//span[contains(text(),'Checkout: Overview')]")
    WebElement verifyInfoFilled;
    @FindBy(id="finish")
    WebElement finishButton;
    @FindBy (xpath = "//h2[contains(text(),'Thank you for your order!')]")
    WebElement orderSuccessMessage;

    public void checkoutFillInfo(){
        testHelper.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(testHelper.generateFirstName());
        testHelper.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(testHelper.generateLastName());
        testHelper.waitForElementPresent(lastNameField);
        testHelper.sleep(1);
        zipCodeField.sendKeys(testHelper.generateZipCode());
        testHelper.sleep(1);
        continueButton.click();
        testHelper.sleep(1);
    }
    public boolean verifyInfoFilledSuccessfully() {
        testHelper.waitForElementPresent(verifyInfoFilled);
        if (verifyInfoFilled.isDisplayed()) {
            System.out.println("Checkout information is filled successfully!!");
            return true;
        } else {
            System.out.println("Filling checkout information is failed!!!");
            return false;
        }
    }
    public void checkoutFinish(){
        Actions actions= new Actions(driver);
        testHelper.waitForElementPresent(finishButton);
        actions.scrollToElement(finishButton).click(finishButton).build().perform();
        testHelper.sleep(1);
    }
    public boolean verifyOrderSuccessfully() {
        testHelper.waitForElementPresent(orderSuccessMessage);
        if (orderSuccessMessage.isDisplayed()) {
            System.out.println("Order is placed successfully!!");
            return true;
        } else {
            System.out.println("Placing order is failed!!!");
            return false;
        }

    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestHelper;

public class ShoppingCartPage {
    WebDriver driver;
    TestHelper testHelper;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testHelper=new TestHelper(driver);
    }

    @FindBy (name="remove-sauce-labs-backpack")
    WebElement removeBackpack;
    @FindBy(id="continue-shopping")
    WebElement continueShoppingButton;
    @FindBy (id="checkout")
    WebElement checkoutButton;



    public void removeBackpackFromCart(){
        testHelper.waitForElementPresent(removeBackpack);
        removeBackpack.click();
    }
    public void continueShopping(){
        testHelper.waitForElementPresent(continueShoppingButton);
        continueShoppingButton.click();
    }
    public void clickOnCheckout(){
        testHelper.waitForElementPresent(checkoutButton);
        testHelper.sleep(1);
        checkoutButton.click();
        testHelper.sleep(1);
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.TestHelper;

public class ProductsPage {
    WebDriver driver;
    TestHelper testHelper;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        testHelper = new TestHelper(driver);
    }

    @FindBy(css = ".product_sort_container")
    WebElement productSort;
    @FindBy(css = ".active_option")
    WebElement sortedActiveOption;
    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
    WebElement backpackLink;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackpack;
    @FindBy(id = "back-to-products")
    WebElement backToProducts;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addJacket;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCart;
    @FindBy(css = ".shopping_cart_badge")
    WebElement cartItemNumber;


    public void sortProduct() {
        testHelper.waitForElementPresent(productSort);
        productSort.click();
        Select select = new Select(productSort);
        select.selectByValue("hilo");
        testHelper.sleep(1);
    }

    public boolean verifyProductSorted() {
        testHelper.waitForElementPresent(sortedActiveOption);
        String activeOption = sortedActiveOption.getText();
        if (activeOption.equalsIgnoreCase("Price (high to low)")) {
            System.out.println("Price is sorted High to Low successfully!!");
            return true;
        } else {
            System.out.println("Price is not sorted successfully!!");
            return false;
        }

    }


    public void clickOnBackpack() {
        testHelper.waitForElementPresent(backpackLink);
        backpackLink.click();

    }

    public void addBackpackToCart() {
        testHelper.waitForElementPresent(addToCartBackpack);
        addToCartBackpack.click();
    }

    public void backToProductsPage() {
        testHelper.waitForElementPresent(backToProducts);
        backToProducts.click();
    }

    public void addTShirtToCart() {
        testHelper.waitForElementPresent(addTShirt);
        addTShirt.click();
    }

    public void clickOnShoppingCart() {
        testHelper.waitForElementPresent(shoppingCart);
        shoppingCart.click();
    }

    public void addJacketToCart() {
        testHelper.waitForElementPresent(addJacket);
        addJacket.click();
    }

    public boolean verifyProductAddedSuccessfully() {
        testHelper.waitForElementPresent(cartItemNumber);
        int itemNumber = Integer.parseInt(cartItemNumber.getText());

        if (itemNumber > 0) {
            System.out.println("Product is added successfully!!");
            return true;
        } else {
            System.out.println("Product is not added!!");
            return false;
        }
    }


}

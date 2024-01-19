package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import utilities.AppConfig;
import utilities.TestBase;

public class CucumberSteps extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @Before ("@LoginToCheckout")
    public void setup() {
        browserSetupHeadless(AppConfig.readFromConfig("url"));
//        browserSetUp(AppConfig.readFromConfig("url"));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    //Login Test

    @When("User enter valid credentials")
    public void userEnterValidCredentials() {
        loginPage.login();
    }

    @Then("Products page should be displayed")
    public void websiteProductsPageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.verifyLogin());
    }

    // Sort product by price

    @When("User select High to Low sorting option")
    public void userSelectHighToLowSortingOption() {
        productsPage.sortProduct();
    }

    @Then("Products should be sorted by price from the highest to lowest")
    public void productsShouldBeSortedByPriceFromTheHighestToLowest() {
        Assert.assertTrue(productsPage.verifyProductSorted());
    }

    // Add products to the shopping cart

    @When("User add product to shopping cart")
    public void userAddProductToShoppingCart() {
        productsPage.addBackpackToCart();
        productsPage.addJacketToCart();
    }

    @Then("Products should be added to the shopping cart")
    public void productsShouldBeAddedToTheShoppingCart() {
        Assert.assertTrue(productsPage.verifyProductAddedSuccessfully());
    }

    //Placing the order

    @Given("User is on the checkout page")
    public void userIsOnTheCheckoutPage() {
        productsPage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckout();
    }

    @When("User fill information")
    public void userFillInformation() {
        checkoutPage.checkoutFillInfo();
    }

    @And("User click on the finish button")
    public void userClickOnTheFinishButton() {
        checkoutPage.checkoutFinish();
    }

    @Then("The order should be placed")
    public void theOrderShouldBePlaced() {
        Assert.assertTrue(checkoutPage.verifyOrderSuccessfully());
    }

    @After("@LoginToCheckout")
    public void tearDown() {
        closeBrowser();
    }


}

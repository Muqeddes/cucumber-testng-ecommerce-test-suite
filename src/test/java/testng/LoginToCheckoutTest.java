package testng;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ecommerce.pages.CheckoutPage;
import ecommerce.pages.LoginPage;
import ecommerce.pages.ProductsPage;
import ecommerce.pages.ShoppingCartPage;
import ecommerce.utilities.AppConfig;
import ecommerce.utilities.TestBase;
import ecommerce.utilities.TestResultListener;

@Listeners(TestResultListener.class)
public class LoginToCheckoutTest extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;


    @BeforeClass
    public void setUp(ITestContext context) {
//        browserSetUp(AppConfig.readFromConfig("url"));
        browserSetupHeadless(AppConfig.readFromConfig("url"));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        context.setAttribute("driver", driver);
    }

    @Test
    public void loginTest() {
        loginPage.login();
        Assert.assertTrue(loginPage.verifyLogin());
    }

    @Test(dependsOnMethods = "loginTest")
    public void sortProductTest() {
        productsPage.sortProduct();
        Assert.assertTrue(productsPage.verifyProductSorted());

    }

    @Test(dependsOnMethods = "sortProductTest")
    public void addProductToCartTest() {
        productsPage.addBackpackToCart();
        productsPage.addTShirtToCart();

        Assert.assertTrue(productsPage.verifyProductAddedSuccessfully());
    }

    @Test(dependsOnMethods = "addProductToCartTest")
    public void placingOrderTest() {
        productsPage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckout();
        checkoutPage.checkoutFillInfo();
        checkoutPage.checkoutFinish();

        Assert.assertTrue(checkoutPage.verifyOrderSuccessfully());

    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

}

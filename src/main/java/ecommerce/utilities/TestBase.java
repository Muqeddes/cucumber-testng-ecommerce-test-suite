package ecommerce.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public WebDriver driver;
    public void browserSetUp(String url) {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }
    public void browserSetupHeadless(String url) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless=new");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);

    }


    public void closeBrowser() {
        driver.close();
        driver.quit();
    }


}

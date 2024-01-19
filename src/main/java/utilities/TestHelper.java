package utilities;

import com.github.javafaker.Faker;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestHelper {
   WebDriver driver;
   Faker faker=new Faker();


    public TestHelper(WebDriver driver) {

        this.driver = driver;

    }

    private final int timeout= Integer.parseInt (AppConfig.readFromConfig("timeout"));

    // Date-time
    public String currentDate(){
        DateTime today=new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        return  today.toString(formatter);
    }

    public  String timeStamp(){
        DateTime currentTime=new DateTime();
        DateTimeFormatter formatter=DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss");
        return currentTime.toString(formatter);
    }

    //Wait

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAlertPresent() {
        WebDriverWait wai = new WebDriverWait(driver, Duration.ofSeconds (timeout));
        wai.until(ExpectedConditions.alertIsPresent());
    }

    public void sleep(int second){
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Js
    public void javaScriptClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", element);
    }

    //Generate fake data
    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateZipCode(){
        return faker.address().zipCode();
    }




    


}

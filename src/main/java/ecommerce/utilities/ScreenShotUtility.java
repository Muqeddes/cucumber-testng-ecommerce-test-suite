package ecommerce.utilities;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class ScreenShotUtility {
    public void takeScreenshot(String folder, String fileName, WebDriver driver) {
        TestHelper testHelper=new TestHelper(driver);

        fileName = fileName + "-" + testHelper.timeStamp();
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(imageFile, new File(folder + File.separator + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

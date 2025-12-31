package Utils;

import Constants.FramworkConstants;
import com.marsdevs.Driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private ScreenshotUtils(){}

    public static String getBase64Image(){

        //WebDriverWait wait = DriverManager.getDriver(); // adjust based on your setup


        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }


    public static void saveScreenshot(String fileName) throws IOException {

        File src = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        File dest = new File(
                FramworkConstants.getScreenshotPath()
                        + fileName + "_" + System.currentTimeMillis() + ".png"
        );

        FileUtils.copyFile(src, dest);
    }

}

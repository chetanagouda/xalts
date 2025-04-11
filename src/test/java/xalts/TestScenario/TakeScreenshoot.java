package xalts.TestScenario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshoot {
	public static void takeScreenshot(WebDriver driver, String methodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "screenshots/" + methodName + "_" + timeStamp + ".png";

        File destFile = new File(filename);
        destFile.getParentFile().mkdirs(); // Create directories if not exist

        try {
            Files.copy(srcFile.toPath(), destFile.toPath());
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

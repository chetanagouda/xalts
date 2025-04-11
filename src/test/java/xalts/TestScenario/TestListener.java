package xalts.TestScenario;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import xalts.xalts.PageObject;

public class TestListener implements ITestListener{
	@Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((PageObject) ((TestScenario) testClass).pageobj).getDriver();

        TakeScreenshoot.takeScreenshot(driver, result.getName());
    }
}

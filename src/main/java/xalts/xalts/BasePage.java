package xalts.xalts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	//initializing the WebDriver
	WebDriver driver;
	//Constructor
	public BasePage(WebDriver driver) {
		this.driver=driver;
		//Using pageFactory we initialize the all elements
		PageFactory.initElements(driver, this);
	}
	//navigating to a URL
	public void goToURL(String url) {
		driver.get(url);
	}
}
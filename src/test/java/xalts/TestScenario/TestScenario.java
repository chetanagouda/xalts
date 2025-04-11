package xalts.TestScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import xalts.xalts.PageObject;

@Listeners(TestListener.class) //This is connect to Listeners TestNG.
public class TestScenario {
	WebDriver driver;
	PageObject pageobj;
	
	@BeforeTest
	public void setup() {
		//Initialize the ChromeDriver
		driver=new ChromeDriver();
		//Initialize the PageObject class
		pageobj= new PageObject(driver);
		//Maximize the window
		driver.manage().window().maximize();
		pageobj.navigateToxalts();
	}
	@Test
	public void SignIn() {
		pageobj.SingIn_invalidmail("testuser","Testuser@123");
		pageobj.Sign_validcredentail("testuser1234@example.com","Testuser@123");
	}
	@Test
	public void SignOut() {
		pageobj.Sign_out();
	}
	@Test
	public void SignUp() {
		pageobj.Sign_Upwithinvalidmail("testuser", "testuser@123");
		pageobj.Sign_Upwithexistingmail("testuser123@example.com","Testuser@123");
		pageobj.Sign_Up();
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
}

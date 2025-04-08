package xalts.xalts;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject extends BasePage {

	public PageObject(WebDriver driver) {
		//Define the constructor
		super(driver);
		
	}
	//Locate the Elements
	@FindBy(xpath="//*[contains(text(),'Sign In')]")
	WebElement Sign_in;
	@FindBy(xpath="//label[contains(text(),'E-Mail')]/following-sibling::div//input")
	WebElement Email;
	@FindBy(xpath="//label[contains(text(),'Password')]/following-sibling::div//input[1]")
	WebElement Password;
	@FindBy(xpath="//*[contains(text(),'Confirm Password')]/following-sibling::div//input")
	WebElement Confirm_password;
	@FindBy(xpath="//*[contains(text(),'Sign Up')]")
	WebElement Sign_Up;
	@FindBy(xpath="//*[contains(text(),'Already have an account? Click here to sign in.')]")
	WebElement Already_sign_in;
	@FindBy(xpath="//*[contains(text(),'Sign Out')]")
	WebElement Sign_Out;
	
	public void navigateToxalts() {
		goToURL("https://xaltsocnportal.web.app/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));	
    }
	
	//Scenario 1: Sign IN
	//Failure 1.1: Sign-In with Invalid email.
	public void SingIn_invalidmail(String invalid_email,String password) {
		Sign_in.click();
		Already_sign_in.click();
		Email.sendKeys(invalid_email);
		Password.sendKeys(password);
		
		WebElement signInButton = Sign_in;
		//Verify if Sign In button is disabled
		if (!signInButton.isEnabled()) {
		    System.out.println("PASS: Sign-In button is disabled for invalid email.");
		    
		} else {
		    System.out.println("FAIL: Sign-In button is enabled for invalid email.");
		}
	}
	//Success 1.2: Sign-In with valid Credentials.
		public void Sign_validcredentail(String valid_email, String password) {
			driver.navigate().refresh();
			Already_sign_in.click();
			Email.sendKeys(valid_email);
			Password.sendKeys(password);
			Sign_in.click();
			System.out.println("Sign In Sucessfull.");
		}
		
	//Scenario 2: Sign Out
	//Success 2.1:User can sing out successfully.
		public void Sign_out() {
			//Wait for 10 seconds to element appear on the screen.
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(Sign_Out));
			Sign_Out.click();
			System.out.println("Sign Out Successfull.");
		}	
		
	//Scenario 3: Sign Up
		//Failure 3.1: Sign UP with invalid email and invalid password formate
	public void Sign_Upwithinvalidmail( String invalid_email,String invalid_password) {
		Sign_in.click();
		Email.sendKeys(invalid_email);
		Password.sendKeys(invalid_password);
		Confirm_password.sendKeys(invalid_password);
		WebElement signUpButton = Sign_Up;
		//Verify if it's disabled
		if (!signUpButton.isEnabled()) {
		    System.out.println("PASS: Sign-Up button is disabled for invalid email & invalid password(missing requirment).");
		    
		} else {
		    System.out.println("FAIL: Sign-Up button is enabled for invalid email & invalid password(missing requirment).");
		}
	}
	//Failure 3.2: Sign Up with existing email.
	public void Sign_Upwithexistingmail(String email,String pass) {
		driver.navigate().refresh();
		Email.sendKeys(email);
		Password.sendKeys(pass);
		Confirm_password.sendKeys(pass);
		Sign_Up.click();
		
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.alertIsPresent());

		    Alert alert = driver.switchTo().alert();
		    String alertText = alert.getText();
		    System.out.println("Alert message: " + alertText);
		    //accept the alert
		    alert.accept();
		} catch (NoAlertPresentException e) {
		    System.out.println("No alert present. Sign-up might have succeeded.");
		}	
	}
	//Success 3.3: Sign Up with valid credentials.
	public void Sign_Up() {
		driver.navigate().refresh();
		 // Generate a unique email address
	    String timestamp = String.valueOf(System.currentTimeMillis());
	    String uniqueEmail = "testuser" + timestamp + "@example.com";
	    // Define password that meets the criteria
	    String password = "Test@1234";
	    // Fill the form
	    Email.sendKeys(uniqueEmail);
	    Password.sendKeys(password);
	    Confirm_password.sendKeys(password);
	    Sign_Up.click();
	    System.out.println("Sign Up sucessfull.");
	}
	}

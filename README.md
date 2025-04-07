# Automation Testing Project using POM Framework, Selenium, and TestNG

## Project Overview
This project demonstrates the use of the Page Object Model (POM) design pattern for automating UI test cases using Selenium and TestNG. The project includes:
- **BasePage Class**: Provides core functionality like WebDriver initialization, page element setup using `PageFactory`, and basic browser actions.
- **PageObject Class**: Contains web elements and methods for specific pages.
- **TestScenario class**: Includes test cases written using TestNG.

## Prerequisites
1. Java JDK (version 8 or above)
2. Maven (for dependency management)
3. Selenium WebDriver
4. TestNG
5. IDE (e.g.Eclipse)
6. Web browser (e.g., Chrome)
7. Browser driver (e.g., chromedriver for Chrome)

## Project Structure
-src
  -main
     -java
       -xalts
         -xalts
           -BasePage.java
           -PageObject.java

  -test
     -java
       -xalts
         -TestScenario
	          -TestScenario.java

-pom.xml # Maveen configuration file for managing dependencies(selenium-java , testng)

 
## Key Files	
1. **BasePage.java**:
	-Location: `\src\main\java\xalts\xalts/`
   	- Purpose:
     	- Initializes the WebDriver instance.
     	- Sets up page elements using `PageFactory`.
     	- Includes reusable methods like:
       		- `goToURL(String url)`: Navigates to the specified URL.

2. **PageObject.java**:
     -Location: `\src\main\java\xalts\xalts/`
	  - Extend `BasePage.java` to inherit WebDriver and common methods.
   	- Define page-specific web elements and actions.

4. **TestScenario.java**:
	- Location: `src\test\java\xalts\TestScenario/`
   - Purpose:
     - Use TestNG to define test methods (`@Test`).

4.**pom.xml**:
	-Selenium
	-TestNG

## How to Run the Tests
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Ensure all dependencies are installed by running.
4. Run the test suite:
	-- From the IDE: Right-click on the `TestClass.java` file and select "Run" or "Run as TestNG Test."
	- From the command line:
		mvn test

## Tools and Technologies
- **Selenium WebDriver**: For automating browser interactions.
- **Maven**: This is for managing dependencies and building execution.
-**TestNG**: For defining and running tests using annotations (@Test, @BeforeTest, @AfterTest) but without the testng.xml file.
- **Java**: Programming language used for scripting.
  
## Credential Management
-**Email** : testusers@example.com
-**Password** : TestUser@123
  

## Author
Chetana Gouda

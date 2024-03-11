package in.automateORM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPageTest 
{
	private WebDriver driver;
	
	BaseClass login = new BaseClass();
	private loginPage lp;
	public String dashboardUrl = "index.php/dashboard/index";
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		lp = new loginPage(driver);
		// To be read from config file. 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// --------------------- Positive Cases ------------------ // 

	@Test(priority = 1)
	private void normalLogin1(){
		lp.enterUsername("admin");
		lp.enterPassword("admin123");
		lp.clickSubmit();
		// To be read from config file, base url. 
		Assert.assertTrue("Failed: normalLogin1-TC 1",driver.getCurrentUrl().contains(dashboardUrl));
	}
	
	@Test(priority = 2)
	private void lowercaseLogin() {
		lp.enterUsername("admin");
		lp.enterPassword("admin123");
		lp.clickSubmit();
		Assert.assertTrue("Failed: lowercaseLogin-TC 2",driver.getCurrentUrl().contains(dashboardUrl));
	}
	
	@Test(priority = 3)
	private void uppercaseLogin() {
		lp.enterUsername("ADMIN");
		lp.enterPassword("admin123");
		lp.clickSubmit();
		Assert.assertTrue("Failed: uppercaseLogin-TC 3",driver.getCurrentUrl().contains(dashboardUrl));
	}

	// --------------------- Negative Cases ------------------ //
	
	@Test(priority = 4)
	private void invalidUsername() {
		lp.enterUsername("adminin");
		lp.enterPassword("admin123");
		lp.clickSubmit();
		Assert.assertTrue("Failed: invalidUsername-TC 4",driver.findElement(lp.invalidCred).isDisplayed());
	}
	
	@Test(priority = 5)
	private void invalidPassword() {
		lp.enterUsername("admin");
		lp.enterPassword("admin123123");
		lp.clickSubmit();
		Assert.assertTrue("Failed: invalidPassword-TC 5",driver.findElement(lp.invalidCred).isDisplayed());
	}	
	
	@Test(priority = 6)
	private void emptyUsername() {
		lp.enterUsername("");
		lp.enterPassword("admin123");
		lp.clickSubmit();
		Assert.assertTrue("Failed: emptyUsername", driver.findElement(lp.requiredUsername).isDisplayed());
	}
	
	
	@Test(priority = 7)
	private void emptyPassword() {
		lp.enterUsername("admin");
		lp.enterPassword("");
		lp.clickSubmit();
		Assert.assertTrue("Failed: emptyPassword", driver.findElement(lp.requiredPassword).isDisplayed());
	}

	
	// ---------------------- End of Test Cases ----------------------
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}	


package in.automateORM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class logoutTest {

private WebDriver driver;
private logoutPage logout;
private loginPage login;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		logout = new logoutPage(driver);
		login = new loginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test 
	public void logout() {
		
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickSubmit();
		logout.clickIconDropdown();
		logout.clickLogoutOption();
		Assert.assertTrue("Logout failed !",driver.getCurrentUrl().contains(login.loginUrl));	
		
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}

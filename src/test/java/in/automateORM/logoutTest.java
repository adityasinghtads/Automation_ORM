package in.automateORM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class logoutTest {
private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test 
	public void logout() {
		
		loginPageTest aa =  new loginPageTest();
		aa.performLogin("admin", "admin123", driver);
		
		WebElement iconDrop = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i"));
		
		iconDrop.click();
		WebElement logoutOption = driver.findElement(By.partialLinkText("Log"));
		logoutOption.click();
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue("Logout failed !",currentURL.contains("web/index.php/auth/login"));
	
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	/*----Improvement Point----- */
	
	public void explicitWaitFunction() {
		// Creating this as we need to improve to explicit wait as it will give better control over.
		// To be implemented in future. 
	}
	
}

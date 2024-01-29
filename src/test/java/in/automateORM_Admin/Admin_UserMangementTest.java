package in.automateORM_Admin;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import in.automateORM.loginPageTest;
import in.automateORM.sideMenuTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_UserMangementTest {
	
	private WebDriver driver;
	loginPageTest login = new loginPageTest();
	sideMenuTest navigate = new sideMenuTest();
	
	
	
	private void GoToAdminPage() {
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
		search.sendKeys("Admin");
		WebElement seach_Admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a"));
		seach_Admin.click();
		
		if(driver.getCurrentUrl()!="https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers") {
			System.out.print("Not in desired URL");
		}
		
	}
	
	@BeforeClass
	public void setup() throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// -------  User Logged in  -------
		login.performLogin("Admin", "admin123", driver);
		GoToAdminPage();
		
	}
	

	@Test
	public void ums_test() {
		WebElement sysUsers = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5"));
		Assert.assertTrue("Not found",sysUsers.isDisplayed());
		
	}
	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}

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

import in.automateORM.BaseClass;
import in.automateORM.loginPage;
import in.automateORM.loginPageTest;
import in.automateORM.sideMenuTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_UserMangementTest {
	
	private WebDriver driver;
	BaseClass login = new BaseClass();
	sideMenuTest navigate = new sideMenuTest();	
	
	// *********** To be moved to base class ***********
	
	private void GoToAdminPage() {
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
		search.sendKeys("Admin");
		WebElement seach_Admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a"));
		seach_Admin.click();
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
	
	// ############# Positive cases for UserManagement #############
	
	@Test
	private void ums_test() {
		// Checking Current page is admin -> UMS page.
		
		WebElement sysUsers = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5"));
		Assert.assertTrue("Not found",sysUsers.isDisplayed());
		
		//Redirecting to users in UMS and checking URL 
		WebElement UM_dropdown = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span"));
		UM_dropdown.click();
		WebElement Users = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li"));
		Users.click();
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		Assert.assertTrue("Not on Users URL",currentURL!=expectedURL);
		
	}

	//Making a common method for declaring web elements to move to base class

	@Test
	private void createUser_1() {
		// Adding a new user 
		
		
	}
	
	public void createUser_2() {
		
	}
	
	// ############# Negative cases for UserManagement #############
	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}

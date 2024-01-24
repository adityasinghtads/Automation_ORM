package in.automateORM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sideMenuTest {
	
	private WebDriver driver;
	loginPageTest login = new loginPageTest();
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.performLogin("Admin", "admin123", driver);
	}
	
	@Test(priority=1)
	public void default_sideMenuOpen() {
		WebElement checkMenu = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
		Assert.assertTrue("Unable to open Side Menu Bar ", checkMenu.isDisplayed());
		
	}
	
	 @Test(priority=2)
	public void searchInSideMenu() {
		 
		 WebElement searchOption = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input"));
		 searchOption.sendKeys("Performance");
		 WebElement clickPerf = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span"));
		 clickPerf.click();
		 String currentUrl = driver.getCurrentUrl();
		 Assert.assertTrue("Not redirected",currentUrl.contains("performance/searchEvaluatePerformanceReview"));
		 driver.navigate().back();
		 
	}
	 @Test(priority=3)
	public void openSideMenu() {
		 	
			WebElement openSideMenu =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button/i"));
			openSideMenu.click();
			//Click to open the side menu 
			openSideMenu.click();
			//Click to close the side menu
	}
	 
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	 
}
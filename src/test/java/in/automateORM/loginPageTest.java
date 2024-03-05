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

public class loginPageTest 
{
	private WebDriver driver;
	
	BaseClass login = new BaseClass();
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// --------------------- Positive Cases ------------------ // 

	 @Test(priority = 1)
	private void normalLogin() {
		 
		login.performLogin("Admin","admin123", driver);
		String currentUrl ;
		currentUrl = driver.getCurrentUrl();
		currentUrl.contains("index.php/dashboard/index");
		Assert.assertTrue("Login:Failed : Dashboard is not displayed.",currentUrl.contains(currentUrl));
		System.out.println("Normal Login - Passed");

	}
	
	@Test(priority = 2)
	private void lowercaseLogin() {
		
		login.performLogin("admin","admin123", driver);
		
		String currentUrl ;
		currentUrl = driver.getCurrentUrl();
		currentUrl.contains("index.php/dashboard/index");
		Assert.assertTrue("Login:Failed : Dashboard is not displayed.",currentUrl.contains(currentUrl));
		System.out.println("Normal Login - Passed");
		
	}
	
	@Test(priority = 3)
	private void uppercaseLogin() {
			
		login.performLogin("ADMIN","admin123", driver);
		
		String currentUrl ;
		currentUrl = driver.getCurrentUrl();
		currentUrl.contains("index.php/dashboard/index");
		Assert.assertTrue("Login:Failed : Dashboard is not displayed.",currentUrl.contains(currentUrl));
		System.out.println("Normal Login - Passed");
	}
	
	
	// --------------------- Negative Cases ------------------ // 
	
	
	@Test(priority = 4)
	private void invalidUsername() {
		
		login.performLogin("adminin","admin123", driver);
		
		WebElement invalidCred = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",invalidCred.isDisplayed());
		System.out.println(" Invalid Username Not allowed - Passed");
		
	}
	
	@Test(priority = 5)
	private void invalidPassword() {
		
		login.performLogin("admin","admin123123", driver);
	
		WebElement invalidCred = driver.findElement(By.xpath("//div//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",invalidCred.isDisplayed());
		System.out.println(" Invalid password Not allowed - Passed");
			
	}	
	
	@Test(priority = 6)
	private void emptyUsername() {
		
		login.performLogin("","admin123", driver);
		
		WebElement required = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",required.isDisplayed());
		System.out.println(" empty username Not allowed - Passed");
		
	}
	

	@Test(priority = 7)
	private void emptyPassword() {
		
		login.performLogin("admin","", driver);
		
		WebElement requiredPass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",requiredPass.isDisplayed());
		System.out.println(" empty username Not allowed - Passed");
		
	}
	
	@Test(priority = 8)
	private void emptyCred() {
		login.performLogin("admin","", driver);

		WebElement requiredPass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",requiredPass.isDisplayed());
		System.out.println(" empty username Not allowed - Passed");
		
	}
	
	// ---------------------- End of Test Cases ----------------------
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}	


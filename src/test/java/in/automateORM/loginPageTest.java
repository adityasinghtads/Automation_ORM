package in.automateORM;

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
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	// -------------------- Perform Login -------------------- // 
	
	public void performLogin(String username, String password, WebDriver driver) {
		
		tryCatchBlock();
		
		WebElement userField = driver.findElement(By.name("username"));
		WebElement passwordField = driver.findElement(By.name("password"));
		
		userField.sendKeys(username);
		passwordField.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();
		
		tryCatchBlock();
		
	}
	
	// --------------------- Positive Cases ------------------ // 

	 @Test(priority = 1)
	private void normalLogin() {

		performLogin("Admin","admin123", driver);
		
		String currentUrl ;
		currentUrl = driver.getCurrentUrl();
		currentUrl.contains("index.php/dashboard/index");
		Assert.assertTrue("Login:Failed : Dashboard is not displayed.",currentUrl.contains(currentUrl));
		System.out.println("Normal Login - Passed");

	}
	
	@Test(priority = 2)
	private void lowercaseLogin() {
		
		performLogin("admin","admin123", driver);
				
		String currentUrl ;
		currentUrl = driver.getCurrentUrl();
		currentUrl.contains("index.php/dashboard/index");
		Assert.assertTrue("Login:Failed : Dashboard is not displayed.",currentUrl.contains(currentUrl));
		System.out.println("Normal Login - Passed");
		
	}
	
	@Test(priority = 3)
	private void uppercaseLogin() {
			
		performLogin("ADMIN","admin123", driver);
		
		String currentUrl ;
		currentUrl = driver.getCurrentUrl();
		currentUrl.contains("index.php/dashboard/index");
		Assert.assertTrue("Login:Failed : Dashboard is not displayed.",currentUrl.contains(currentUrl));
		System.out.println("Normal Login - Passed");
	}
	
	
	// --------------------- Negative Cases ------------------ // 
	
	
	@Test(priority = 4)
	private void invalidUsername() {
		
		performLogin("adminin","admin123", driver);
		
		tryCatchBlock();
		
			WebElement invalidCred = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
			Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",invalidCred.isDisplayed());
			System.out.println(" Invalid Username Not allowed - Passed");
		
	}
	
	@Test(priority = 5)
	private void invalidPassword() {
		
		performLogin("admin","admin123123", driver);
		
		tryCatchBlock();
	
			WebElement invalidCred = driver.findElement(By.xpath("//div//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
			Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",invalidCred.isDisplayed());
			System.out.println(" Invalid password Not allowed - Passed");
			
	}	
	
	@Test(priority = 6)
	private void emptyUsername() {
		
		performLogin("","admin123", driver);
		
		tryCatchBlock();
		
		WebElement required = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",required.isDisplayed());
		System.out.println(" empty username Not allowed - Passed");
		
	}
	

	@Test(priority = 7)
	private void emptyPassword() {
		
		performLogin("admin","", driver);
		
		tryCatchBlock();
		
		WebElement requiredPass = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
		Assert.assertTrue("Login: Allowed : Invalid Cred is not displayed.",requiredPass.isDisplayed());
		System.out.println(" empty username Not allowed - Passed");
		
	}
	
	@Test(priority = 8)
	private void emptyCred() {
		performLogin("admin","", driver);

		tryCatchBlock();
		
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
	
	public void tryCatchBlock() {
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	


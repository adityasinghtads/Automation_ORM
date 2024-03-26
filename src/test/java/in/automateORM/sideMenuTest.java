package in.automateORM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sideMenuTest {
	
	private WebDriver driver;
	BaseClass login = new BaseClass();
	private sideMenu sideMenu;

	
	@BeforeClass
	public void setUp() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		sideMenu = new sideMenu(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.performLogin("Admin", "admin123", driver);
	}
	
	@Test(priority=1)
	public void default_sideMenuOpen() {
		Assert.assertTrue("Unable to open Side Menu Bar ",driver.findElement(sideMenu.checkMenu).isDisplayed());
	}
	
	 @Test(priority=2)
	public void searchInSideMenu() {

		sideMenu.enterSearchOption("Performance");
		sideMenu.clickOption();
		Assert.assertTrue("Not redirected",driver.getCurrentUrl().contains(sideMenu.performanceUrl));
		driver.navigate().back();

	}
	 @Test(priority=3)
	public void openSideMenu() {
		 	
			sideMenu.clickOpenSideMenu();
			sideMenu.clickOpenSideMenu();

	}
	 
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
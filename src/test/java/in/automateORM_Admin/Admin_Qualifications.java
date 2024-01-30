package in.automateORM_Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin_Qualifications {
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void TestCases() {
		
	}
	
	@AfterClass
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}

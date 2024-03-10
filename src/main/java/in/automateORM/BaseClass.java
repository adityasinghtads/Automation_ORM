package in.automateORM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

	//private loginPage login = new loginPage();
	
	// ############ Perform Login Function ###############
	
	public void performLogin(String username, String password, WebDriver driver) {

		WebElement userField = driver.findElement(By.name("username"));
		WebElement passwordField = driver.findElement(By.name("password"));

		userField.sendKeys(username);
		passwordField.sendKeys(password);

		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();

	}

}

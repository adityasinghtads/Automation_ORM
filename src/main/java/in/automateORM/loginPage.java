package in.automateORM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    private final WebDriver driver;

    //Constructor 
    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public String loginUrl = "web/index.php/auth/login";

    // Web Elements - Login Creds
    public final By userField = By.name("username");
    public final By passwordField = By.name("password");
    public final By submitButton = By.cssSelector("button[type='submit']");
   
    // Web Elements - Error Msgs 
    public final By invalidCred = By.xpath("//*[@id=\\\"app\\\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    public final By requiredUsername = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    public final By requiredPassword =  By.xpath("//*[@id=\\\"app\\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");

    // Actions with Web Elements 
    public void enterUsername(String username){
        driver.findElement(userField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

}

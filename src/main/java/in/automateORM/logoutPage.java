package in.automateORM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logoutPage {
    private final WebDriver driver;

    //Constructor 

    public logoutPage(WebDriver driver){
        this.driver = driver;
    }

    // Web Elements-Logout page..

    public final By iconDrop =  By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i");
    public final By logoutOption = By.partialLinkText("Log");


    // Actions to perform.. 

    public void clickIconDropdown(){
        driver.findElement(iconDrop).click();
    }

    public void clickLogoutOption(){
        driver.findElement(logoutOption).click();
    }

}

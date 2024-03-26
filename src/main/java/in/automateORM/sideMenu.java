package in.automateORM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sideMenu {
    private final WebDriver driver;

    //Constructor 
    public sideMenu(WebDriver driver){
        this.driver = driver;
    }

    // URLS - Redirection 

    public String performanceUrl = "performance/searchEvaluatePerformanceReview";

    //Web Elements - Side Menu 

    public final By checkMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span");
    public final By seachOption = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input");
    public final By clickOption = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span");
    public final By openSideMenu = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button/i");

    // Actions to perform 

    public void enterSearchOption(String searchKey){
        driver.findElement(seachOption).sendKeys(searchKey);
    }

    public void clickOption(){
        driver.findElement(clickOption).click();
    }

    public void clickOpenSideMenu(){
        driver.findElement(openSideMenu).click();
    }

    
}

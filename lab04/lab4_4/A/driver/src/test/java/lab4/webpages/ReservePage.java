package lab4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;


public class ReservePage {
    @FindBy(className="table") 
    private WebElement options;

    @FindBy(css="h3")
    private WebElement pageTitle;

    public void chooseFlight(int num){
        this.options.findElement(By.cssSelector("tr:nth-child("+num+") .btn")).click();
    }

    public String thisTitle(){
        return pageTitle.getText();
    }
    
}

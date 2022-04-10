package lab4.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class ConfirmationPage {
    @FindBy(css="tr:nth-child(2) > td:nth-child(2)")
    private WebElement status;


    public String getStatus(){
        return status.getText();
    }
    
}

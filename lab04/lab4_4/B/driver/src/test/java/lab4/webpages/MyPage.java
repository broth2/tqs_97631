package lab4.webpages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class MyPage {
    @FindBy(name="fromPort") 
    private WebElement departure;
    
    @FindBy(name="toPort") 
    private WebElement destination;
    
    @FindBy(className="btn-primary") 
    private WebElement submit;


    public void findFlights(String from, String to){
        this.departure.findElement(By.xpath(String.format("//option[. = '%s']", from))).click();
        this.destination.findElement(By.xpath(String.format("//option[. = '%s']", to))).click();
        this.submit.click();
    }
    
}

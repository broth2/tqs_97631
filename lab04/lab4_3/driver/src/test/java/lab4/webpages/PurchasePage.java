package lab4.webpages;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class PurchasePage {
    @FindBy(css="p:nth-child(2)") 
    private WebElement airline;

    @FindBy(css="p:nth-child(3)") 
    private WebElement flightNumber;

    @FindBy(css="p:nth-child(4)") 
    private WebElement price;

    @FindBy(css="p:nth-child(5)") 
    private WebElement fees;

    @FindBy(name="inputName") private WebElement nameInput;
    @FindBy(name="address") private WebElement addressInput;
    @FindBy(name="city") private WebElement cityInput;
    @FindBy(name="state") private WebElement stateInput;
    @FindBy(name="zipCode") private WebElement zipCodeInput;
    @FindBy(name="cardType") private WebElement creditCardTypeInput;
    @FindBy(name="creditCardNumber") private WebElement creditCardNumberInput;
    @FindBy(name="nameOnCard") private WebElement nameOnCardInput;
    @FindBy(className="btn-primary") private WebElement submitBtn;


    public ArrayList<String> getHeaderData(){
        ArrayList<String> data = new ArrayList<>();
        Collections.addAll(data, airline.getText(), flightNumber.getText(), price.getText(), fees.getText());
        return data;
    }

    public void fillForm(String name, String address, String city, String state, String zipCode, String creditCardType, Integer creditCardNum, String cardName) {
        fillTextInput(nameInput, name);
        fillTextInput(addressInput, address);
        fillTextInput(cityInput, city);
        fillTextInput(stateInput, state);
        fillTextInput(zipCodeInput, zipCode);
        creditCardTypeInput.findElement(By.xpath("//option[. = '"+creditCardType+"']")).click();
        fillTextInput(creditCardNumberInput, creditCardNum.toString());
        fillTextInput(nameOnCardInput, cardName);
    
        submitBtn.click();
      }
    
      private void fillTextInput (WebElement element, String content) {
        element.clear();
        element.sendKeys(content);
      }
    
}

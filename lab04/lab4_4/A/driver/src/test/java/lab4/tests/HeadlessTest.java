package lab4.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;	

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import lab4.webpages.*;

import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

import io.github.bonigarcia.seljup.Arguments;
import org.openqa.selenium.JavascriptExecutor;
import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(SeleniumJupiter.class)
public class HeadlessTest {
    
    @Test 
    public void headlessBrowserTest(){
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new HtmlUnitDriver();
        // JavascriptExecutor js=(JavascriptExecutor) driver;
        // Map<String, Object> vars = new HashMap<String, Object>();

        //setup
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1314, 741));



        //home
        MyPage myPage = PageFactory.initElements(driver,MyPage.class);
        myPage.findFlights("Paris", "Rome");
        assertThat(driver.getTitle()).isEqualTo("BlazeDemo - reserve");




        //reserve
        ReservePage reservePage = PageFactory.initElements(driver, ReservePage.class);
        assertThat(reservePage.thisTitle()).isEqualTo("Flights from Paris to Rome:");
        reservePage.chooseFlight(1);
        
        
        
        // //purchase
        PurchasePage purchasePage = PageFactory.initElements(driver, PurchasePage.class);
        assertThat(purchasePage.getHeaderData(), not(IsEmptyCollection.empty()));
        assertThat(purchasePage.getHeaderData(), hasSize(4));
        assertThat(purchasePage.getHeaderData(), containsInAnyOrder("Airline: United", "Flight Number: UA954", "Price: 400", "Arbitrary Fees and Taxes: 514.76"));
        purchasePage.fillForm("Nuno", "Rua s tiago", "Lobao", "Aveiro", "4505", "Visa", 1234, "NunoFahla");
        



        // //confirmation
        ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
        assertThat(confirmationPage.getStatus()).isEqualTo("PendingCapture");
    }
}

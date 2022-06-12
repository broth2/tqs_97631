/*
 * (C) Copyright 2020 Boni Garcia (https://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia;

import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private WebDriver driver;


    @Given("I am on the BlazeDemo Homepage")
    public void homepage() {
        System.out.println("\n\n\nn\n\n\nn\n\n\nn\n\n\n");
        this.driver.get("https://blazedemo.com/");
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
      }

    @Then("the header is {string}")
    public void checkTitle(String title){
        //String title = driver.getTitle();
        assertEquals(title, "BlazeDemo");
        assertEquals(title, driver.getTitle());
    }


    @When("I choose departure {string}")
    public void departure(String dep) {
        driver.findElement(By.name("fromPort")).click();
        {
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = '" + dep + "']")).click();
        }
    }

    @Then("departure is {string}")
    public void departureis(String dep) {
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            String value = element.getAttribute("value");
            String locator = String.format("option[@value='%s']", value);
            String selectedText = element.findElement(By.xpath(locator)).getText();
            assertEquals(selectedText, dep);
        }
    }

    @When("I choose destination {string}")
    public void destination(String des) {
        driver.findElement(By.name("fromPort")).click();
        {
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = '" + des + "']")).click();
        }
    }

    @Then("destination is {string}")
    public void destinationis(String des) {
        {
            WebElement element = driver.findElement(By.name("toPort"));
            String value = element.getAttribute("value");
            String locator = String.format("option[@value='%s']", value);
            String selectedText = element.findElement(By.xpath(locator)).getText();
            assertEquals(selectedText, des);
        }
    }

    @When("I find flights")
    public void findFlight(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("the page title is {string}")
    public void pageTitle1(String string) {
        assertEquals(driver.getTitle(), string);
    }

    @When("I choose any flight, such as {int}")
    public void choseFlight(int pos){
        driver.findElement(By.cssSelector("tr:nth-child("+ pos +") .btn")).click();
    }

    @Then("the page title becomes {string}")
    public void pageTitle2(String string) {
        assertEquals(driver.getTitle(), string);
    }

    @When("I purchase flights")
    public void purchaseFlight(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("the title is {string}")
    public void pageTitle3(String string) {
        assertEquals(driver.getTitle(), string);
    }

    @After
    public void quite() {
        this.driver.quit();
    }



}

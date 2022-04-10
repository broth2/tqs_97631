package lab4;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

class HelloWorldChromeJupiterTest {

    // static final Logger log = getLogger(lookup().lookupClass());

    // WebDriver driver;

    // @BeforeAll
    // static void setupClass() {
    //     WebDriverManager.chromedriver().setup();
    // }

    // @BeforeEach
    // void setup() {
    //     driver = new ChromeDriver();
    // }

    // @AfterEach
    // void teardown() {
    //     driver.quit();
    // }

    // @Test
    // void test() {
    //     // Exercise
    //     String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
    //     driver.get(sutUrl);
    //     String title = driver.getTitle();
    //     System.out.println("\n\n\n\n\n");
    //     System.out.printf("The title of {%s} is {%s}\n", sutUrl, title);
    //     System.out.println("\n\n\n\n\n");

    //     // Verify
    //     assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    // }

}
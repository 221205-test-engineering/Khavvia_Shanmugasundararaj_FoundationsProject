package dev.khavvia.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/dev/khavvia/features", glue = "dev.khavvia.steps")
public class TestcasesRunner {
    public static WebDriver test_driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        test_driver = new ChromeDriver();
    }

    @AfterClass
    public static void teardown(){
        test_driver.quit();
    }
}

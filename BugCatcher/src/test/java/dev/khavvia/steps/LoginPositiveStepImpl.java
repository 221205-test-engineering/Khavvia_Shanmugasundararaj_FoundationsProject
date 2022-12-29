package dev.khavvia.steps;

import dev.khavvia.runners.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginPositiveStepImpl {
    public static WebDriver driver = LoginRunner.driver;
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        WebElement username_field = driver.findElement(By.name("username"));
        username_field.sendKeys("g8tor");
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        WebElement password_field = driver.findElement(By.name("pass"));
        password_field.sendKeys("chomp!");
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() throws InterruptedException{
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(2000);
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string) {
        assertEquals("Manager Home", driver.findElement(By.xpath("//h1")).getText());
    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string, String string2) {
        assertEquals("Patty Pastiche", driver.findElement(By.xpath("//p")).getText().substring(8));
    }

}

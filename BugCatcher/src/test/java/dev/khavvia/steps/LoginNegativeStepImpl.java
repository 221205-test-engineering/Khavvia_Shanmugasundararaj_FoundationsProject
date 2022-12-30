package dev.khavvia.steps;

import dev.khavvia.runners.DefectRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;


public class LoginNegativeStepImpl {
    public static WebDriver defect_driver = DefectRunner.defect_driver;/*************************/

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        WebElement username_field = defect_driver.findElement(By.name("username"));
        username_field.sendKeys("g8tor");
    }
    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        WebElement password_field = defect_driver.findElement(By.name("pass"));
        password_field.sendKeys("chomp!!");
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        String text = defect_driver.switchTo().alert().getText();
        assertEquals("Wrong password for User", text);
        defect_driver.switchTo().alert().accept();
    }

    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        WebElement username_field = defect_driver.findElement(By.name("username"));
        username_field.sendKeys("sicEmDawgs");
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        WebElement password_field = defect_driver.findElement(By.name("pass"));
        password_field.sendKeys("natchamps");
    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        String text = defect_driver.switchTo().alert().getText();
        assertEquals("Username not found", text);
        defect_driver.switchTo().alert().accept();
    }
}

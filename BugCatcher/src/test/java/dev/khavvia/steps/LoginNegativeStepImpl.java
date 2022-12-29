//package dev.khavvia.steps;
//
//import dev.khavvia.runners.LoginNegativeRunner;
//import dev.khavvia.runners.LoginPositiveRunner;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//
//public class LoginNegativeStepImpl {
//    public static WebDriver driver = LoginNegativeRunner.driver;
//
//    @When("The employee types in g8tor into the username input")
//    public void the_employee_types_in_g8tor_into_the_username_input() {
//        WebElement username_field = driver.findElement(By.name("username"));
//        username_field.sendKeys("g8tor");
//    }
//    @When("The employee types in chomp!! into the password input")
//    public void the_employee_types_in_chomp_into_the_password_input() {
//        WebElement password_field = driver.findElement(By.name("pass"));
//        password_field.sendKeys("chomp!!");
//    }
//
//    @Then("The employee should see an alert saying they have the wrong password")
//    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("The employee is on the login page")
//    public void the_employee_is_on_the_login_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee types in sicEmDawgs into the username input")
//    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee types in natchamps into the password input")
//    public void the_employee_types_in_natchamps_into_the_password_input() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee clicks on the login button")
//    public void the_employee_clicks_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("The employee should see an alert saying no user with that username found")
//    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//}

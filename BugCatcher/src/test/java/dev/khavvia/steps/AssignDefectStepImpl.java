package dev.khavvia.steps;

import dev.khavvia.runners.DefectRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

/****** NOT FINISHED *********/

public class AssignDefectStepImpl {
    public static WebDriver driver = DefectRunner.defect_driver;
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
        // log in
        WebElement username_field = driver.findElement(By.name("username"));
        username_field.sendKeys("g8tor");
        WebElement password_field = driver.findElement(By.name("pass"));
        password_field.sendKeys("chomp!");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(1000);
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        assertEquals("Manager Home", driver.findElement(By.xpath("//h1")).getText());
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

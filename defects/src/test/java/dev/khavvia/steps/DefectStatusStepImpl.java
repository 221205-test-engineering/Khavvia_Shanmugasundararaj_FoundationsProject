package dev.khavvia.steps;

import dev.khavvia.runners.DefectRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class DefectStatusStepImpl {
    public static WebDriver defect_driver = DefectRunner.defect_driver;
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() throws InterruptedException {
        defect_driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
        // log in
        WebElement username_field = defect_driver.findElement(By.name("username"));
        username_field.sendKeys("ryeGuy");
        WebElement password_field = defect_driver.findElement(By.name("pass"));
        password_field.sendKeys("coolbeans");
        WebElement button = defect_driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(1000);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        assertEquals("My Test Cases", defect_driver.findElement(By.xpath("/html/body/div[1]/h3[2]")).getText());
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        // finish this
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        // finish this
    }

}

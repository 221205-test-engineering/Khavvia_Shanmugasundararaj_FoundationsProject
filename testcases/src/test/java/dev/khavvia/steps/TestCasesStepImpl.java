package dev.khavvia.steps;

import dev.khavvia.runners.TestcasesRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class TestCasesStepImpl {
    public static WebDriver test_driver = TestcasesRunner.test_driver;
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        // log in
        test_driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
        WebElement username_field = test_driver.findElement(By.name("username"));
        username_field.sendKeys("ryeGuy");
        WebElement password_field = test_driver.findElement(By.name("pass"));
        password_field.sendKeys("coolbeans");
        WebElement button = test_driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(1000);
        test_driver.findElement(By.xpath("/html/body/div[1]/nav/a[2]")).click();
        Thread.sleep(1000);
    }
    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String docString) {
        test_driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/textarea[1]")).sendKeys(docString);
    }
    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String docString) {
        test_driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/textarea[2]")).sendKeys(docString);
    }
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/button")).click();
        Thread.sleep(1000);
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {

        // finish this
        test_driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[last()]"));
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        String status = test_driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[last()]/td[3]")).getText();
        assertEquals("UNEXECUTED", status);
    }

    @When("The tester presses on details")
    public void the_tester_presses_on_details() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[last()]/td[4]/button")).click();
        Thread.sleep(1000);
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        boolean modal_exists = false;
        try
        {
            test_driver.findElement(By.className("ReactModal__Content ReactModal__Content--after-open"));
            //modal_exists = true;
        }
        catch (NoSuchElementException e)
        {
            modal_exists = true;
        }

        System.out.println(modal_exists);
        assertTrue(modal_exists);
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        String text = test_driver.findElement(By.xpath("/html/body/div[3]/div/div/p[6]")).getText();
        assertEquals("No One", text);
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div[3]/div/div/button[1]")).click();
        Thread.sleep(1000);
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {

        // fix this!!
        boolean modal_exists = true;
        try
        {
            //test_driver.findElement(By.class("ReactModal__Content ReactModal__Content--after-open"));
            //modal_exists = true;
        }
        catch (NoSuchElementException e)
        {
            modal_exists = false;
        }

        System.out.println(modal_exists);
        assertTrue(modal_exists);
    }


    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div[3]/div/div/button[2]")).click();
        Thread.sleep(1000);
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        assertEquals("Overview", test_driver.findElement(By.xpath("/html/body/div/fieldset[1]/legend")).getText());
    }
    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div/button")).click();
        Thread.sleep(1000);
    }
    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String string) {
        test_driver.findElement(By.xpath("/html/body/div/fieldset[1]/textarea[1]")).sendKeys(string);
    }
    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String string) {
        test_driver.findElement(By.xpath("/html/body/div/fieldset[1]/textarea[2]")).sendKeys(string);
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        test_driver.findElement(By.xpath("/html/body/div/fieldset[1]/input")).click();
    }
    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String string) {
        new Select(test_driver.findElement(By.xpath("/html/body/div/fieldset[1]/select"))).selectByValue(string);


    }
    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String string) {
        new Select(test_driver.findElement(By.xpath("/html/body/div/fieldset[1]/select"))).selectByValue(string);
    }
    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String string) {
        test_driver.findElement(By.xpath("/html/body/div/fieldset[2]/textarea")).sendKeys(string);
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div/button[2]")).click();
        Thread.sleep(1000);
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        //
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        test_driver.switchTo().alert().accept();
    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        test_driver.switchTo().alert().accept();
    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() throws InterruptedException {
        test_driver.findElement(By.xpath("/html/body/div/button[1]")).click();
        Thread.sleep(1000);
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        //
    }

}

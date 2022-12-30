package dev.khavvia.steps;

import dev.khavvia.runners.DefectRunner;
import dev.khavvia.runners.ReportDefectPositiveRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReportDefectPositiveStepImpl {
    public WebDriver driver = DefectRunner.driver;
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page()  throws InterruptedException {
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
        // log in
        WebElement username_field = driver.findElement(By.name("username"));
        username_field.sendKeys("g8tor");
        WebElement password_field = driver.findElement(By.name("pass"));
        password_field.sendKeys("chomp!");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(1000);
        WebElement link = driver.findElement(By.xpath("/html/body/div[1]/nav/a[3]"));
        Thread.sleep(1000);

    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date()  throws InterruptedException {
        WebElement date_input = driver.findElement(By.name("dateReported"));
        LocalDate date = LocalDate.now();
        String dateString = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        date_input.sendKeys(dateString);
        Thread.sleep(1000);

    }
    @When("The employee types in Description with")
    public void the_employee_types_in_description_with(String docString) {
        WebElement description = driver.findElement(By.name("desc"));
        description.sendKeys(docString);
    }
    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String docString) {
        WebElement steps = driver.findElement(By.name("stepsToReproduce"));
        steps.sendKeys(docString);
    }
    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String string) {
        WebElement priority = driver.findElement(By.name("priority"));
        priority.sendKeys(Keys.ARROW_RIGHT);
    }
    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String string) throws InterruptedException {
        WebElement severity = driver.findElement(By.name("severity"));
        severity.sendKeys(Keys.ARROW_RIGHT);
        Thread.sleep(2000);
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//button"));
        Thread.sleep(2000);
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {

        boolean alert_exists = false;
        try
        {
            driver.switchTo().alert();
            alert_exists = true;
        }
        catch (NoAlertPresentException e)
        {
            alert_exists = false;
        }

        assertEquals(true, alert_exists);
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        WebElement modal = driver.findElement(By.xpath("//h4"));
        assertTrue(modal.getText().length() > 0);
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        WebElement body = driver.findElement(By.xpath("//body"));
        String body_class = body.getAttribute("class");
        assertEquals("vsc-initialized", body_class);
    }
}

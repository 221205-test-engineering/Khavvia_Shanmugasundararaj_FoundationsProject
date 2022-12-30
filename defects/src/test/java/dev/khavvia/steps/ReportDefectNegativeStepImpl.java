package dev.khavvia.steps;

import dev.khavvia.runners.DefectRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;

public class ReportDefectNegativeStepImpl {
    public static WebDriver defect_driver = DefectRunner.defect_driver;
    @When("The employee types in description with")
    public void the_employee_types_in_description_with(String docString) {
        WebElement description = defect_driver.findElement(By.name("desc"));
        description.sendKeys(docString);
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() throws InterruptedException {
        WebElement priority = defect_driver.findElement(By.name("priority"));
        priority.sendKeys(Keys.ARROW_RIGHT);
        Thread.sleep(500);
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() throws InterruptedException {
        WebElement severity = defect_driver.findElement(By.name("severity"));
        severity.sendKeys(Keys.ARROW_LEFT);
        severity.sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(500);
    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        defect_driver.switchTo().alert();

        boolean alert_exists = false;
        try
        {
            defect_driver.switchTo().alert().accept();
            alert_exists = true;
        }
        catch (NoAlertPresentException e)
        {
            alert_exists = false;
        }

        assertEquals(false, alert_exists);

    }

    @When("The employee types in steps with")
    public void the_employee_types_in_steps_with(String docString) {
        WebElement steps = defect_driver.findElement(By.name("stepsToReproduce"));
        System.out.println(steps.getAttribute("name"));
        steps.sendKeys(docString);
    }


}

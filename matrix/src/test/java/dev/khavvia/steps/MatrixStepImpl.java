package dev.khavvia.steps;

import dev.khavvia.runners.MatrixRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MatrixStepImpl {
    public static WebDriver mat_driver = MatrixRunner.mat_driver;
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        mat_driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
        // log in
        WebElement username_field = mat_driver.findElement(By.name("username"));
        username_field.sendKeys("g8tor");
        WebElement password_field = mat_driver.findElement(By.name("pass"));
        password_field.sendKeys("chomp!");
        WebElement button = mat_driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(1000);
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        mat_driver.findElement(By.xpath("/html/body/div/nav/a[6]")).click();
        assertEquals("Manager Home", mat_driver.findElement(By.xpath("//h1")).getText());

    }
    @When("The manager chooses to create a new matrix")
    public void the_manager_chooses_to_create_a_new_matrix() throws InterruptedException {
        mat_driver.findElement(By.xpath("//button")).click();
        Thread.sleep(5000);
    }
    @When("The manager creates a title for the matrix")
    public void the_manager_creates_a_title_for_the_matrix() {
        mat_driver.findElement(By.xpath("/html/body/div/input")).sendKeys("this is a title");
    }
    @When("The manager adds requirements to the matrix")
    public void the_manager_adds_requirements_to_the_matrix() {
        mat_driver.findElement(By.xpath("/html/body/div/fieldset/table/tbody/tr/td[1]/input")).sendKeys("here's a user story");
    }
    @When("The manager saves the matrix")
    public void the_manager_saves_the_matrix() throws InterruptedException {
        mat_driver.findElement(By.xpath("/html/body/div/button")).click();
        Thread.sleep(1000);
    }
    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear() {
        mat_driver.switchTo().alert();

        boolean alert_exists = false;
        try
        {
            mat_driver.switchTo().alert();
            alert_exists = true;
        }
        catch (NoAlertPresentException e)
        {
            alert_exists = false;
        }

        mat_driver.switchTo().alert().accept();

        assertEquals(true, alert_exists);
    }



    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage() throws InterruptedException {
        mat_driver.findElement(By.xpath("/html/body/div/nav/a[1]")).click();
        Thread.sleep(1000);
    }
    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix() throws InterruptedException {
        mat_driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/span/button")).click();
        Thread.sleep(1000);
    }
    @When("The manager adds a defect")
    public void the_manager_adds_a_defect() throws InterruptedException {
        mat_driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")).click();
        Thread.sleep(1000);
        // need to finish this
    }
    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes()  throws InterruptedException {
        mat_driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/button")).click();
        Thread.sleep(1000);
    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        mat_driver.switchTo().alert().accept();
    }

    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases() {
        mat_driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[1]/li[2]/input")).click();
    }

}

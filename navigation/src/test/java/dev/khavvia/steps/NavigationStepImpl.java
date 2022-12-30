package dev.khavvia.steps;

import dev.khavvia.runners.NavigationRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationStepImpl {
    public static WebDriver nav_driver = NavigationRunner.nav_driver;
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        nav_driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=21");
        // log in
        WebElement username_field = nav_driver.findElement(By.name("username"));
        username_field.sendKeys("g8tor");
        WebElement password_field = nav_driver.findElement(By.name("pass"));
        password_field.sendKeys("chomp!");
        WebElement button = nav_driver.findElement(By.xpath("//button"));
        button.click();
        Thread.sleep(1000);

    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        assertEquals("Manager Home", nav_driver.findElement(By.xpath("//h1")).getText());
    }
    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {

        boolean matrices = nav_driver.findElement(By.xpath("/html/body/div/nav/a[1]")).getText().equals("Matrices");
        boolean test_cases = nav_driver.findElement(By.xpath("/html/body/div/nav/a[2]")).getText().equals("Test Cases");
        boolean report_defect = nav_driver.findElement(By.xpath("/html/body/div/nav/a[3]")).getText().equals("Report a Defect");
        boolean defect_overview = nav_driver.findElement(By.xpath("/html/body/div/nav/a[4]")).getText().equals("Defect Overview");
        boolean all_visible = matrices & test_cases & report_defect & defect_overview;
        assertTrue(all_visible);
    }

    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() throws InterruptedException {
        WebElement link = nav_driver.findElement(By.xpath("/html/body/div/nav/a[1]"));
        link.click();
        Thread.sleep(1000);
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        assertEquals("Matrices", nav_driver.findElement(By.xpath("//h1")).getText());
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() throws InterruptedException {
        nav_driver.navigate().back();
        Thread.sleep(1000);
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        assertEquals("Manager Home", nav_driver.findElement(By.xpath("//h1")).getText());
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() throws InterruptedException {
        nav_driver.findElement(By.xpath("/html/body/div/nav/a[2]")).click();
        Thread.sleep(1000);
    }

    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String string)  throws InterruptedException {
        String xpath = "//a[contains(text(), '" + string + "')]";
        nav_driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(1000);
    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String string) {
        assertEquals(string, nav_driver.findElement(By.xpath("//h1")).getText());
    }

}

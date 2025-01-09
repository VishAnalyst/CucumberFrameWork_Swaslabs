package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSD {

    WebDriver driver;

    @Given("I am on the login page.")
    public void loginPage() {
        // Initialize the WebDriver and open the login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println("I am on the login page.");
    }

    @When("I enter correct username and password.")
    public void I_enter_valid_username_password() {
        // Enter valid username and password
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        System.out.println("I have entered correct username and password.");
    }

    @When("I enter incorrect username and password.")
    public void i_enter_incorrect_username_and_password() {
        // Enter invalid username and password
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("vishnu");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("123test");
        System.out.println("Incorrect username and password are entered.");
    }

    @When ("I keep username and password blank.")
    public void I_keep_username_and_password_blank(){
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("");
        System.out.println("BLANK username and password");
    }

    @And("I click the login button.")
    public void I_click_login_button() {
        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        System.out.println("I have clicked the login button.");
    }

    @Then("I should be redirected to the listing page.")
    public void I_should_be_redirected_to_the_listing_page() {
        // Validate redirection to the listing page
        String expected = "Swag Labs";
        String actual = driver.getTitle();
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        if (expected.equals(actual)) {
            System.out.println("I have been redirected to the listing page.");
        } else {
            System.out.println("I have not been redirected to the listing page.");
        }
    }

    @Then("I should not be redirected to the listing page.")
    public void I_should_not_be_redirected_to_the_listing_page() {
        // Validate the error message for invalid login
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualError = errorMessage.getText();
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        System.out.println("Actual error displayed: " + actualError);
        System.out.println("Expected error displayed: " + expectedError);
        if (actualError.equals(expectedError)) {
            System.out.println("Validation works properly. TEST PASSED.");
        } else {
            System.out.println("Validation does not work properly. TEST FAILED.");
        }
    }

    @Then("Field Validation Should be shown blocks user entry.")
    public void Field_Validation_Should_be_shown_blocks_user_entry (){
        WebElement errorMessage = driver.findElement(By.xpath("//h3[normalize-space()='Epic sadface: Username is required']"));
        String actualError = errorMessage.getText();
        String expectedError = "Epic sadface: Username is required";
        System.out.println("The ACTUAL ERROR DISPLAYED AS"+actualError );
        System.out.println("The ACTUAL ERROR DISPLAYED AS"+expectedError );
        if(actualError.equals(expectedError)){
            System.out.println("THE TEST IS PASSED, User blocked via field validation");
        }else{
            System.out.println("The TEST IS FAILED");
        }
    }
    @Then("I need to quit the browser.")
    public void I_need_to_quit_the_browser() {
        // Quit the browser
        if (driver != null) {
            driver.quit();
            System.out.println("The browser is closed.");
        } else {
            System.out.println("Driver is null, no browser to close.");
        }
    }
}
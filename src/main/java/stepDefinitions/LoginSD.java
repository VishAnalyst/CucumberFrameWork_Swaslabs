package stepDefinitions;

import io.cucumber.java.be.I;
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
    public void loginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println("I am on the login page");
    }

    @When("I enter correct username and password.")
    public void I_entre_valid_username_password (){
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        System.out.println("I have entered correct username and password");
    }

    @And("I click the login button")
    public void I_click_login_button(){
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        System.out.println("I have clicked the login button");
    }

    @Then("I should be redirected to the listing page.")
    public void I_should_be_redirected_to_the_listing_page() {
        String expected = "Swag Labs";
        String actual = driver.getTitle();
        System.out.println("Expected:" +expected);
        System.out.println("Actual:" +actual);
        if (expected.equals(actual)){
            System.out.println("I have redirected to the listing page");
        }else {

            System.out.println("I have not redirected to the listing page");
        }
    }

    @Then("I need to quit the browser.")
    public void I_need_to_quit_the_browser(){
        String expected = "Swag Labs";
        String actual = driver.getTitle();
        System.out.println("Expected:" +expected);
        System.out.println("Actual:" +actual);
        if (expected.equals(actual)){
            System.out.println("I have redirected to the listing page");
            System.out.println("The bowser is closed");
            driver.quit();
        }else {
            System.out.println("ISSUE IS THERE");
            System.out.println("I have not redirected to the listing page");
        }

    }


}

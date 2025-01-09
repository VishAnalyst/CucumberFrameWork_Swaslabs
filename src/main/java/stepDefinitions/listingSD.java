package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class listingSD {
    WebDriver driver;
    @Given("I am on the login page")
    public  void I_am_on_the_login_page(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("The LOGIN PAGE IS LOADED");
    }

    @When("I enter a valid username and password")
    public void I_enter_a_valid_username_and_password(){
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        System.out.println("The username is passed with the value: "+username);
        System.out.println("The password is passed with the value: "+password);
    }

    @And("I click the login button")
    public void I_click_the_login_button(){
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        System.out.println("The Login button is clicked");
    }

    @And("I navigate to the listing page")
    public void I_navigate_to_the_listing_page() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();

        // Assert to verify the title matches
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("The listing page is successfully loaded with title: " + actualTitle);
        } else {
            System.out.println("Expected title: " + expectedTitle + ", but got: " + actualTitle);
            throw new AssertionError("The listing page is not loaded as expected.");
        }
    }

    @And("I click the Add to Cart button for one item")
    public void I_click_the_Add_to_Cart_button_for_one_item(){
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
        System.out.println("The one ADD TO CART BUTTON IS CLICKED");
    }

    @And("Remove should be displayed on the clicked button")
    public void Remove_should_be_displayed_on_the_clicked_button(){
        WebElement removeTag = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        String actualOutput = removeTag.getText();
        String expectedOutput = "Remove";
        if(actualOutput.equals(expectedOutput)){
            System.out.println("REMOVE IS DISPLAYED");
        }else{
            System.out.println("REMOVE IS NOT DISPLAYED");
        }

    }

    @Then("The cart count should reflect as one")
    public void the_cart_count_should_reflect_as_one() {
        WebElement addToCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        String actualOutput = addToCartBadge.getText();
        String expectedOutput = "1";
        // Compare the actual output with the expected output
        if (actualOutput.equals(expectedOutput)) {
            System.out.println("The cart count is updated as 1: TEST PASSED");
        } else {
            System.out.println("Expected cart count: " + expectedOutput + ", but got: " + actualOutput);
            throw new AssertionError("The cart count did not update correctly: TEST FAILED");
        }
    }

    @And("I quit the browser")
    public void I_quit_the_browser(){
        // Quit the browser
        if (driver != null) {
            driver.quit();
            System.out.println("The browser is closed.");
        } else {
            System.out.println("Driver is null, no browser to close.");
        }
    }
}





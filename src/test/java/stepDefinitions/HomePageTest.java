package stepDefinitions;

import pages.HomePage;
import utils.WebDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePageTest {

     private WebDriver driver ;
     private HomePage homepage;
     
     @Before("@SearchTest")
     public void setup() {
    	 driver= WebDriverSetup.SelectDriver("chrome"); 
    	 homepage= new HomePage(driver);
     }
    @Given("User is on the Bookswagon home page")
    public void user_is_on_the_bookswagon_home_page() {
        driver.get("https://www.bookswagon.com");
       driver.manage().window().maximize();
    }

    @Then("Search bar should be displayed")
    public void search_bar_should_be_displayed() {
        homepage.searchbutton();
    }

    @When("User searches for Product {string}")
    public void user_searches_for(String searchText) {
        homepage.searchingforproduct(searchText);
       homepage.booktitile();
       
    }
    
    @After("@SearchTest")
    public void teardown()
    {
    	 driver.quit();
    }
}
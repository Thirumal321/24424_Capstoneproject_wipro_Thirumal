package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchResultsPage;
import pages.productdetailspage;
import utils.WebDriverSetup;

public class SearchResultTest {

    private WebDriver driver ;
    private SearchResultsPage searchresults ;
@Before("@SearchResultsTest")
public void setup() {
	driver= WebDriverSetup.SelectDriver("chrome");
	searchresults= new SearchResultsPage(driver);
}
    @Given("User is on home page")
    public void userpage1() {
        driver.get("https://www.bookswagon.com");
        driver.manage().window().maximize();
    }

    @When("User searches for {string}")
    public void searchingproduct(String product) throws InterruptedException {
        searchresults.searcharea(product);
        searchresults.searchButton();
        Thread.sleep(3000);
    }

    @When("User applies filters")
    public void filters()  throws InterruptedException {
        //searchresults.filterbutton();
    Thread.sleep(3000);
        searchresults.pricebutton();
        Thread.sleep(3000);
        searchresults.discountbutton();
        Thread.sleep(3000);
       searchresults.languagebutton();
       Thread.sleep(3000);
    }

    @Then("Search results should be displayed")
    public void search_results() {
    	Assert.assertTrue(searchresults.issearchresultsdisplayed(), "Search results are not displayed.");        
    }
    @After("@SearchResultsTest")
    public void teardown() {
    	driver.quit();
    }
}
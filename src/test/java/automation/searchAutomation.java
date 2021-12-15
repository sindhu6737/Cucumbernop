package automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.qa.pageObjects.cartPageObjects;
import com.qa.utils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchAutomation extends TestBase {
	cartPageObjects pom;
	
	public searchAutomation (){
		super();
	}
	@Given("Browser is open4")
	public void browser_is_open4() throws IOException {
		driver = initializeDriver();
		pom= new cartPageObjects();
	}

	@And("user is on website home page4")
	public void user_is_on_website_home_page4() {
		System.out.println("Website......");
	}

	@When("user enters the product to be searched")
	public void user_enters_the_product_to_be_searched() {
		pom.searchOption.sendKeys("Pen");


	}

	@And("clicks on search")
	public void clicks_on_search() {
		pom.searchButton.click();
	}

	@Then("Message is displayed as no product found")
	public void message_is_displayed_as_no_product_found() {
		String act=pom.noProductWarning.getText();
		String exp="No products were found that matched your criteria.";
		Assert.assertEquals(act, exp);
		tearDown();

	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}


}

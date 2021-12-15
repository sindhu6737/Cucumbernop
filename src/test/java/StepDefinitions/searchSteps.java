package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class searchSteps {
	private WebDriver driver;
	@Given("Browser is open4")
	public void browser_is_open4() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@And("user is on website home page4")
	public void user_is_on_website_home_page4() {
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
	}

	@When("user enters the product to be searched")
	public void user_enters_the_product_to_be_searched() {
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Pen");


	}

	@And("clicks on search")
	public void clicks_on_search() {
		driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click();
	}

	@Then("Message is displayed as no product found")
	public void message_is_displayed_as_no_product_found() {
		String act=driver.findElement(By.xpath("//div[@class='no-result']")).getText();
		String exp="No products were found that matched your criteria.";
		Assert.assertEquals(act, exp);

	}


}

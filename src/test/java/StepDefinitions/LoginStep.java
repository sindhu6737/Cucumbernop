package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	private WebDriver driver;
	@Given("Browser is open2")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Given("user is on website home page2")
	public void user_is_on_website_home_page() {
		driver.get("https://demo.nopcommerce.com");
	}

	@And("user clicks on Log in option")
	public void user_clicks_on_log_in_option() {
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		String actualUrl="https://demo.nopcommerce.com/login?returnUrl=%2F";
		Assert.assertEquals(actualUrl , driver.getCurrentUrl());
	}

	@When("user enters the username and password")
	public void user_enters_the_username_and_password() {
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("a@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234567");
	}

	@And("clicks on Log in button")
	public void clicks_on_log_in_button() {
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
	}

	@Then("User should be on home page")
	public void user_should_be_on_home_page() {
		String expected=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
		String msg="Welcome to our store";
		System.out.println(expected);
		Assert.assertEquals(expected , msg);
		driver.close();

	}

	@When("user enters the invalid username and password")
	public void user_enters_the_invalid_username_and_password() {
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("sindhunaik");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1234567");
		//driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
	}

	@Then("User should get an error message for invalid username")
	public void user_should_get_an_error_message_for_invalid_username() {
		String msg="Wrong email";
		String actual=driver.findElement(By.xpath("//span[@id='Email-error']")).getText();
		Assert.assertEquals(actual, msg);
		driver.close();
	}

	@When("user enters the valid username and invalid password")
	public void user_enters_the_valid_username_and_invalid_password() {
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("a@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("sindhu6737");
		//driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
	}

	@Then("User should get an error message for invalid password")
	public void user_should_get_an_error_message_for_invalid_password() {
		String invalidPassErr = driver.findElement(By.cssSelector("div[class='message-error validation-summary-errors'] ul li")).getText();
		String actinvalidPassErr = "The credentials provided are incorrect";
		Assert.assertEquals(invalidPassErr,actinvalidPassErr);
		driver.close();
	}

	@When("user directly clicks on Login")
	public void user_directly_clicks_on_login() {
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

	}

	@Then("user should get an error message for empty fields")
	public void user_should_get_an_error_message_for_empty_fields() {
		String msg="Please enter your email";
		String actual=driver.findElement(By.xpath("//span[@id='Email-error']")).getText();
		Assert.assertEquals(actual,msg );
		driver.close();
	}

	@When("user enters unregistered user details")
	public void user_enters_unregistered_user_details() {
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		//driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
	}

	@Then("User should get an error message for unregistered user")
	public void user_should_get_an_error_message_for_unregistered_user() {
		String invalidPass= driver.findElement(By.xpath("//li[normalize-space()='No customer account found']")).getText();
		String actinvalidPass = "No customer account found";
		Assert.assertEquals(invalidPass,actinvalidPass );
		driver.close();
	}

}

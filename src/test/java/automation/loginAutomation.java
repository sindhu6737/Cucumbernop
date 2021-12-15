package automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pageObjects.cartPageObjects;
import com.qa.utils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginAutomation extends TestBase{
	cartPageObjects pom;


	public loginAutomation() throws IOException {
		super();
	}
	@Given("Browser is open2")
	public void browser_is_open() throws IOException {
		driver = initializeDriver();
		pom = new cartPageObjects();
	}

	@Given("user is on website home page2")
	public void user_is_on_website_home_page() {
		System.out.println("Website......");

	}

	@And("user clicks on Log in option")
	public void user_clicks_on_log_in_option() {
		pom.loginOption.click();
		String pageTitle = driver.getCurrentUrl();
		String expectedUrl="https://demo.nopcommerce.com/login?returnUrl=%2F";
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@When("user enters the username and password")
	public void user_enters_the_username_and_password() {
		pom.emailLoginOption.sendKeys("sindhu@gmail.com");
		pom.passwordLoginOption.sendKeys("1234567");
	}

	@And("clicks on Log in button")
	public void clicks_on_log_in_button() {
		pom.submitLoginOption.click();
	}

	@Then("User should be on home page")
	public void user_should_be_on_home_page() {
		String actualMsg=pom.successfulLogin.getText();
		String expectedMsg="Welcome to our store";
		System.out.println(expectedMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		tearDown();

	}

	@When("user enters the invalid username and password")
	public void user_enters_the_invalid_username_and_password() {
		pom.emailLoginOption.sendKeys("sindhu");
		pom.passwordLoginOption.sendKeys("1234567");
		pom.submitLoginOption.click();
	}

	@Then("User should get an error message for invalid username")
	public void user_should_get_an_error_message_for_invalid_username() {
		String msg="Wrong email";
		String actual=pom.wrongEmailWarning.getText();
		Assert.assertEquals(actual, msg);
		tearDown();
	}

	@When("user enters the valid username and invalid password")
	public void user_enters_the_valid_username_and_invalid_password() {
		pom.emailLoginOption.sendKeys("sindhu@gmail.com");
		pom.passwordLoginOption.sendKeys("1234");
		pom.submitLoginOption.click();
	}

	@Then("User should get an error message for invalid password")
	public void user_should_get_an_error_message_for_invalid_password() {
		String invalidPassErr =pom.invalidPasswordWarning.getText();
		String actinvalidPassErr = "The credentials provided are incorrect";
		Assert.assertEquals(invalidPassErr,actinvalidPassErr);
		tearDown();
	}

	@When("user directly clicks on Login")
	public void user_directly_clicks_on_login() {
		pom.submitLoginOption.click();

	}

	@Then("user should get an error message for empty fields")
	public void user_should_get_an_error_message_for_empty_fields() {
		String msg="Please enter your email";
		String actual=pom.emptyEmailLogin.getText();
		Assert.assertEquals(actual,msg );
		tearDown();
	}

	@When("user enters unregistered user details")
	public void user_enters_unregistered_user_details() {
		pom.emailLoginOption.sendKeys("sindhunaik00@gmail.com");
		pom.passwordLoginOption.sendKeys("1234");
		pom.submitLoginOption.click();
	}

	@Then("User should get an error message for unregistered user")
	public void user_should_get_an_error_message_for_unregistered_user() {
		String invalidPass= pom.noCustomerWarning.getText();
		String actinvalidPass = "No customer account found";
		Assert.assertEquals(invalidPass,actinvalidPass );
		tearDown();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}



}

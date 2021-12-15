package StepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	private WebDriver driver;
	private WebElement password;
	private WebElement confirmPassword;

	@Given("Browser is open1")
	public void browser_is_open1() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();


	}

	@And("user is on website home page1")
	public void user_is_on_website_home_page1() {
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();

	}

	@And("user clicks on Register option")
	public void user_clicks_on_register_option() {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		

	}
	

	@Then("registration form is displayed")
	public void registration_form_is_displayed() {
		String actualUrl="https://demo.nopcommerce.com/register?returnUrl=%2F";
		Assert.assertEquals(actualUrl , driver.getCurrentUrl());

	    String ex=driver.findElement(By.xpath("//strong[text()='Your Personal Details']")).getText();
	    String act="Your Personal Details";
	    Assert.assertEquals(ex,act);
	    driver.close();
	}


	@When("user enters the following details")
	public void user_enters_the_following_details(DataTable dataTable) {
		WebElement gender = driver.findElement(By.id("gender-female"));
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		driver.findElement(By.id("FirstName")).sendKeys((userList.get(0).get("firstname")));
		driver.findElement(By.id("LastName")).sendKeys((userList.get(0).get("lastname")));
		driver.findElement(By.name("DateOfBirthDay")).sendKeys(userList.get(0).get("Date"));
		driver.findElement(By.name("DateOfBirthMonth")).sendKeys(userList.get(0).get("month"));
		driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		driver.findElement(By.id("Email")).sendKeys(userList.get(0).get("email"));
		driver.findElement(By.id("Company")).sendKeys(userList.get(0).get("company name"));;
		driver.findElement(By.id("Password")).sendKeys(userList.get(0).get("password"));
		driver.findElement(By.id("ConfirmPassword")).sendKeys(userList.get(0).get("confirm password"));

	}

	@Then("user clicks on register button")
	public void user_clicks_on_register_button() {
		driver.findElement(By.id("register-button")).click();
		String msg="Your registration completed";
		String actual=driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertEquals(actual, msg);
			driver.close();

	}
	@When("user directly clicks on register button")
	public void user_directly_clicks_on_register_button() {
		driver.findElement(By.id("register-button")).click();
	}
	@Then("user should get error message for empty fields")
	public void user_should_get_error_message_for_empty_fields() {
		String act1=driver.findElement(By.id("FirstName-error")).getText();
		String exp1="First name is required.";
		Assert.assertEquals( act1,exp1 );
		String actualmsg=driver.findElement(By.id("LastName-error")).getText();
		String expectedmsg="Last name is required.";
		String actualmsgemail=driver.findElement(By.id("Email-error")).getText();
		String expectedmsgemail="Email is required.";
		Assert.assertEquals( actualmsg , expectedmsg);
		String actmsg=driver.findElement(By.id("Password-error")).getText();
		String expmsg="Password is required.";
		Assert.assertEquals(actmsg ,  expmsg);
		String acmsg=driver.findElement(By.id("ConfirmPassword-error")).getText() ;
		String exmsg= "Password is required.";
		Assert.assertEquals(acmsg,exmsg);
		driver.close();
	}
	@When("user enters the following details with invalid email")
	public void user_enters_the_following_details_with_invalid_email(DataTable dataTable) {
		WebElement gender = driver.findElement(By.id("gender-female"));
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		driver.findElement(By.id("FirstName")).sendKeys((userList.get(0).get("Firstname")));
		driver.findElement(By.id("LastName")).sendKeys((userList.get(0).get("Lastname")));
		driver.findElement(By.name("DateOfBirthDay")).sendKeys(userList.get(0).get("date"));
		driver.findElement(By.name("DateOfBirthMonth")).sendKeys(userList.get(0).get("Month"));
		driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("Year"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		driver.findElement(By.id("Email")).sendKeys(userList.get(0).get("Email"));
		driver.findElement(By.id("Company")).sendKeys(userList.get(0).get("Company name"));;
		driver.findElement(By.id("Password")).sendKeys(userList.get(0).get("Password"));
		driver.findElement(By.id("ConfirmPassword")).sendKeys(userList.get(0).get("Confirm password"));

	}

	@When("clicks on the register option")
	public void clicks_on_the_register_option() {
		driver.findElement(By.id("register-button")).click();
	}

	@Then("user should get error message for invalid email")
	public void user_should_get_error_message_for_invalid_email() {
		String msg="Wrong email";
		String exp=driver.findElement(By.id("Email-error")).getText();
		Assert.assertEquals(exp ,msg);
		driver.close();
	}
	@When("user enters the following details with different passwords")
	public void user_enters_the_following_details_with_different_passwords(io.cucumber.datatable.DataTable dataTable) {
		WebElement gender = driver.findElement(By.id("gender-female"));
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		driver.findElement(By.id("FirstName")).sendKeys((userList.get(0).get("fname")));
		driver.findElement(By.id("LastName")).sendKeys((userList.get(0).get("lname")));
		driver.findElement(By.name("DateOfBirthDay")).sendKeys(userList.get(0).get("dates"));
		driver.findElement(By.name("DateOfBirthMonth")).sendKeys(userList.get(0).get("Months"));
		driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("Years"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		driver.findElement(By.id("Email")).sendKeys(userList.get(0).get("Emailid"));
		//driver.findElement(By.id("Company")).sendKeys(userList.get(0).get(" Company"));
		password=	driver.findElement(By.id("Password"));
		password.sendKeys((userList.get(0).get("Pass")));
		confirmPassword=driver.findElement(By.id("ConfirmPassword"));
		confirmPassword.sendKeys((userList.get(0).get("Confirm pass")));
	}

	@Then("user gets error message for different passwords")
	public void user_gets_error_message_for_different_passwords() {
		Assert.assertNotEquals(password.getAttribute("value"),confirmPassword .getAttribute("value"));
		driver.close();
	}
	
	@When("user enters the following details with invalid password")
	public void user_enters_the_following_details_with_invalid_password(io.cucumber.datatable.DataTable dataTable) {
		WebElement gender = driver.findElement(By.id("gender-female"));
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		driver.findElement(By.id("FirstName")).sendKeys((userList.get(0).get("fname")));
		driver.findElement(By.id("LastName")).sendKeys((userList.get(0).get("lname")));
		driver.findElement(By.name("DateOfBirthDay")).sendKeys(userList.get(0).get("dates"));
		driver.findElement(By.name("DateOfBirthMonth")).sendKeys(userList.get(0).get("Months"));
		driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("Years"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		driver.findElement(By.id("Email")).sendKeys(userList.get(0).get("Emailid"));
		//driver.findElement(By.id("Company")).sendKeys(userList.get(0).get(" Company"));
		password=	driver.findElement(By.id("Password"));
		password.sendKeys((userList.get(0).get("Pass")));
		confirmPassword=driver.findElement(By.id("ConfirmPassword"));
		confirmPassword.sendKeys((userList.get(0).get("Confirm pass")));
	}

	@Then("user gets error message for invalid password")
	public void user_gets_error_message_for_invalid_password() {
		String data = driver.findElement(By.cssSelector("span[id='Password-error'] p") ).getText();
		System.out.println(data);
		String data1 = driver.findElement(By.cssSelector("span[id='Password-error'] ul li") ).getText();
		System.out.println(data1);
		String actual="Password must meet the following rules:";
		String act="must have at least 6 characters";
		Assert.assertEquals(data, actual);
		Assert.assertEquals(data1,act );
		driver.close();
	}
	@When("user enters details that already exist")
	public void user_enters_details_that_already_exist() {
		driver.findElement(By.id("FirstName")).sendKeys("sindhu");
		driver.findElement(By.id("LastName")).clear();
		driver.findElement(By.id("LastName")).sendKeys("Naik");
		
		driver.findElement(By.name("DateOfBirthDay")).sendKeys("23");
		driver.findElement(By.name("DateOfBirthMonth")).click();
		driver.findElement(By.xpath("//option[text()='June']")).click();
		driver.findElement(By.name("DateOfBirthYear")).click();
		driver.findElement(By.xpath("//option[text()='2000']")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("kkgk@gmail.com");
		driver.findElement(By.id("Company")).clear();
		driver.findElement(By.id("Company")).sendKeys("IVL");
		WebElement password1= driver.findElement(By.id("Password"));
		password1.sendKeys("123456");
		WebElement confirmPassword1 = driver.findElement(By.id("ConfirmPassword"));
		confirmPassword1 .sendKeys("123456");
		
	}

	@Then("user gets error")
	public void user_gets_error() {
		String ac="The specified email already exists";
		String ex=driver.findElement(By.xpath("//li[normalize-space()='The specified email already exists']")).getText();
		System.out.println(ex);
		Assert.assertEquals(ex,ac );
		driver.close();
	}




}

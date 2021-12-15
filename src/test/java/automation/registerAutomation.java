package automation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import com.qa.pageObjects.cartPageObjects;
import com.qa.utils.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registerAutomation extends TestBase{
	cartPageObjects path;
	
	public registerAutomation() {
		super();
	}
	private WebElement password;
	private WebElement confirmPassword;

	@Given("Browser is open1")
	public void browser_is_open1() throws IOException {
		driver = initializeDriver();
		path= new cartPageObjects();


	}

	@And("user is on website home page1")
	public void user_is_on_website_home_page1() {
		System.out.println("Website...");

	}

	@And("user clicks on Register option")
	public void user_clicks_on_register_option() {
		path.registerOption.click();
		

	}
	

	@Then("registration form is displayed")
	public void registration_form_is_displayed() {
		String expected="https://demo.nopcommerce.com/register?returnUrl=%2F";
		String actual= driver.getCurrentUrl();
		Assert.assertEquals(actual ,expected);
		String ex=path.registerForm.getText();
	    String act="Your Personal Details";
	    Assert.assertEquals(ex,act);
	    tearDown();
	}


	@When("user enters the following details")
	public void user_enters_the_following_details(DataTable dataTable) {
		WebElement gender = path.genderButton;
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		path.firstname.sendKeys((userList.get(0).get("firstname")));
		path.lastname.sendKeys((userList.get(0).get("lastname")));
		path.day.sendKeys((userList.get(0).get("Date")));
		path.month.sendKeys(userList.get(0).get("month"));
		path.year.sendKeys(userList.get(0).get("year"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		path.emailfield.sendKeys(userList.get(0).get("email"));
		path.companyname.sendKeys(userList.get(0).get("company name"));;
		path.passwordfield.sendKeys(userList.get(0).get("password"));
		path.confirmPasswordfield.sendKeys(userList.get(0).get("confirm password"));
		

	}

	@Then("user clicks on register button")
	public void user_clicks_on_register_button() {
		driver.findElement(By.id("register-button")).click();
		String msg="Your registration completed";
		String actual=path.registerSuccessMsg.getText();
		Assert.assertEquals(actual, msg);
		tearDown();

	}
	@When("user directly clicks on register button")
	public void user_directly_clicks_on_register_button() {
		path.registerButton.click();
	}
	@Then("user should get error message for empty fields")
	public void user_should_get_error_message_for_empty_fields() {
		String act1=path.emptyFirstnameMsg.getText();
		String exp1="First name is required.";
		Assert.assertEquals( act1,exp1 );
		String actualmsg=path.emptyLastnameMsg.getText();
		String expectedmsg="Last name is required.";
		String actualmsgemail=path.emptyEmailMsg.getText();
		String expectedmsgemail="Email is required.";
		Assert.assertEquals( actualmsg , expectedmsg);
		String actmsg=path.emptyPasswordMsg.getText();
		String expmsg="Password is required.";
		Assert.assertEquals(actmsg ,  expmsg);
		String acmsg=path.emptyConfPasswordMsg.getText() ;
		String exmsg= "Password is required.";
		Assert.assertEquals(acmsg,exmsg);
		tearDown();
	}
	@When("user enters the following details with invalid email")
	public void user_enters_the_following_details_with_invalid_email(DataTable dataTable) {
		WebElement gender = path.genderButton;
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		path.firstname.sendKeys((userList.get(0).get("Firstname")));
		path.lastname.sendKeys((userList.get(0).get("Lastname")));
		path.day.sendKeys(userList.get(0).get("date"));
		path.month.sendKeys(userList.get(0).get("Month"));
		path.year.sendKeys(userList.get(0).get("Year"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		path.emailfield.sendKeys(userList.get(0).get("Email"));
		path.companyname.sendKeys(userList.get(0).get("Company name"));;
		path.passwordfield.sendKeys(userList.get(0).get("Password"));
		path.confirmPasswordfield.sendKeys(userList.get(0).get("Confirm password"));

	}

	@When("clicks on the register option")
	public void clicks_on_the_register_option() {
		path.registerButton.click();
	}

	@Then("user should get error message for invalid email")
	public void user_should_get_error_message_for_invalid_email() {
		String msg="Wrong email";
		String exp=path.wrongEmailMsg.getText();
		Assert.assertEquals(exp ,msg);
		tearDown();
	}
	@When("user enters the following details with different passwords")
	public void user_enters_the_following_details_with_different_passwords(io.cucumber.datatable.DataTable dataTable) {
		WebElement gender = path.genderButton;
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		path.firstname.sendKeys((userList.get(0).get("fname")));
		path.lastname.sendKeys((userList.get(0).get("lname")));
		path.day.sendKeys(userList.get(0).get("dates"));
		path.month.sendKeys(userList.get(0).get("Months"));
		path.year.sendKeys(userList.get(0).get("Years"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		path.emailfield.sendKeys(userList.get(0).get("Emailid"));
		//driver.findElement(By.id("Company")).sendKeys(userList.get(0).get(" Company"));
		password=path.passwordfield;
		password.sendKeys((userList.get(0).get("Pass")));
		confirmPassword=path.confirmPasswordfield;
		confirmPassword.sendKeys((userList.get(0).get("Confirm pass")));
	}

	@Then("user gets error message for different passwords")
	public void user_gets_error_message_for_different_passwords() {
		Assert.assertNotEquals(password.getAttribute("value"),confirmPassword .getAttribute("value"));
		tearDown();
	}
	
	@When("user enters the following details with invalid password")
	public void user_enters_the_following_details_with_invalid_password(io.cucumber.datatable.DataTable dataTable) {
		WebElement gender = path.genderButton;
		gender.click();
		Assert.assertEquals(gender.isSelected(), true);
		List<Map<String,String>> userList=dataTable.asMaps(String.class,String.class);
		// System.out.println(userList);
		path.firstname.sendKeys((userList.get(0).get("fname")));
		path.lastname.sendKeys((userList.get(0).get("lname")));
		path.day.sendKeys(userList.get(0).get("dates"));
		path.month.sendKeys(userList.get(0).get("Months"));
		path.year.sendKeys(userList.get(0).get("Years"));
		//  driver.findElement(By.xpath("//option[text()='June']")).click();
		//driver.findElement(By.name("DateOfBirthYear")).sendKeys(userList.get(0).get("year"));
		//driver.findElement(By.xpath("//option[text()='2000']")).click();

		path.emailfield.sendKeys(userList.get(0).get("Emailid"));
		//driver.findElement(By.id("Company")).sendKeys(userList.get(0).get(" Company"));
		password=	path.passwordfield;
		password.sendKeys((userList.get(0).get("Pass")));
		confirmPassword=path.confirmPasswordfield;
		confirmPassword.sendKeys((userList.get(0).get("Confirm pass")));
	}

	@Then("user gets error message for invalid password")
	public void user_gets_error_message_for_invalid_password() {
		String data = path.wrongPassMsg0.getText();
		System.out.println(data);
		String data1 = path.wrongPassMsg1.getText();
		System.out.println(data1);
		String actual="Password must meet the following rules:";
		String act="must have at least 6 characters";
		Assert.assertEquals(data, actual);
		Assert.assertEquals(data1,act );
		tearDown();
	}
	@When("user enters details that already exist")
	public void user_enters_details_that_already_exist() {
		path.firstname.sendKeys("sindhu");
		path.lastname.clear();
		path.lastname.sendKeys("Naik");
		
		path.day.sendKeys("23");
		path.month.click();
		path.specmonth.click();
		path.year.click();
		path.specyear.click();
		path.emailfield.clear();
		path.emailfield.sendKeys("sindhu@gmail.com");
		path.companyname.clear();
		path.companyname.sendKeys("IVL");
		WebElement password1= path.passwordfield;
		password1.sendKeys("1234567");
		WebElement confirmPassword1 = path.confirmPasswordfield;
		confirmPassword1 .sendKeys("1234567");
		
	}

	@Then("user gets error")
	public void user_gets_error() {
		String ex="The specified email already exists";
		String ac=path.duplicateWarning.getText();
		System.out.println(ex);
		Assert.assertEquals(ac,ex );
		tearDown();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

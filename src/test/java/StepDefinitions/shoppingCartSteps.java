package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class shoppingCartSteps {
	private WebDriver driver;
	@Given("Browser is open3")
	public void browser_is_open3() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@And("user is on website home page3")
	public void user_is_on_website_home_page3() {
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
	}
	@Then("cart should be displayed")
	public void cart_should_be_displayed() {
		driver.findElement(By.xpath(" //span[@class='cart-label']")).click();
		String actualUrl="https://demo.nopcommerce.com/cart";
		Assert.assertEquals(actualUrl , driver.getCurrentUrl());	
		driver.close();
	}


	@When("user clicks on shopping cart")
	public void user_clicks_on_shopping_cart() {
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
	}

	@Then("message should be displayed for empty cart")
	public void message_should_be_displayed_for_empty_cart() {
		String msg="Your Shopping Cart is empty!";
		String act=driver.findElement(By.cssSelector(".no-data")).getText();
		Assert.assertEquals(act, msg);
		driver.close();
	}

	@When("user adds product to the cart")
	public void user_adds_product_to_the_cart() throws InterruptedException {
		Actions act=new Actions(driver);
		WebElement comlink=driver.findElement(By.linkText("Apparel"));
		act.moveToElement(comlink).perform();
		Thread.sleep(6000);
		driver.findElement(By.linkText("Clothing")).click();
	
		
		driver.findElement(By.xpath("//img[@title='Show details for Nike Tailwind Loose Short-Sleeve Running Shirt']")).click();
				//driver.findElement(By.xpath("//select[@id='product_attribute_11']>option:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("select[name='product_attribute_11'] >option:nth-of-type(2)") ).click();
		driver.findElement(By.id("product_enteredQuantity_27")).clear();
		driver.findElement(By.id("product_enteredQuantity_27")).sendKeys("2");
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-27']")).click();
		Thread.sleep(5000);
	}

	@And("clicks on shopping cart")
	public void clicks_on_shopping_cart() {
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();

	}

	@Then("Products should be displayed with price")
	public void products_should_be_displayed_with_price() {
		String expectedProduct=driver.findElement(By.xpath("//span[@class='sku-number']")).getText();
		String expectedPrice=driver.findElement(By.xpath(" //span[@class='product-subtotal']")).getText();
		String actualProduct="NK_TLS_RS";
		String actualPrice="$30.00";
		Assert.assertEquals(expectedProduct, actualProduct);
		Assert.assertEquals(expectedPrice, actualPrice);
		driver.close();
	}

	@When("user clicks on remove option")
	public void user_clicks_on_remove_option() throws InterruptedException {
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		WebElement comlink=driver.findElement(By.linkText("Apparel"));
		act.moveToElement(comlink).perform();
		Thread.sleep(6000);
		driver.findElement(By.linkText("Clothing")).click();
	
		
		driver.findElement(By.xpath("//img[@title='Show details for Nike Tailwind Loose Short-Sleeve Running Shirt']")).click();
				//driver.findElement(By.xpath("//select[@id='product_attribute_11']>option:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("select[name='product_attribute_11'] >option:nth-of-type(2)") ).click();
		driver.findElement(By.id("product_enteredQuantity_27")).clear();
		driver.findElement(By.id("product_enteredQuantity_27")).sendKeys("2");
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-27']")).click();
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		
		driver.findElement(By.xpath("//button[@class='remove-btn']")).click();
	}

	@Then("products should be removed")
	public void products_should_be_removed() {
		String act=driver.findElement(By.xpath("//div[@class='no-data']")).getText();
		String exp="Your Shopping Cart is empty!";
		Assert.assertEquals(act, exp);
		driver.close();
	}



}

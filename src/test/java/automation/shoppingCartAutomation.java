package automation;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.qa.pageObjects.cartPageObjects;
import com.qa.utils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class shoppingCartAutomation extends TestBase{
	cartPageObjects pom;
	@Given("Browser is open3")
	public void browser_is_open3() throws IOException {
		driver = initializeDriver();
		pom=new cartPageObjects();
	}

	@And("user is on website home page3")
	public void user_is_on_website_home_page3() {
		System.out.println("Website......");
	}
	@Then("cart should be displayed")
	public void cart_should_be_displayed() {
		pom.cart.click();
		String expectedPage="https://demo.nopcommerce.com/cart";
		String actualPage=driver.getCurrentUrl();
		Assert.assertEquals(actualPage , expectedPage);	
		tearDown();
	}


	@When("user clicks on shopping cart")
	public void user_clicks_on_shopping_cart() {
		pom.cart.click();
	}

	@Then("message should be displayed for empty cart")
	public void message_should_be_displayed_for_empty_cart() {
		String msg="Your Shopping Cart is empty!";
		String act=pom.emptyCartMsg.getText();
		Assert.assertEquals(act, msg);
		tearDown();
	}

	@When("user adds product to the cart")
	public void user_adds_product_to_the_cart() throws InterruptedException {
		Actions act=new Actions(driver);
		WebElement comlink=pom.addApparel;
		act.moveToElement(comlink).perform();
		Thread.sleep(6000);
		pom.addClothing.click();
	
		
		pom.product.click();
				//driver.findElement(By.xpath("//select[@id='product_attribute_11']>option:nth-of-type(2)")).click();
		pom.sizeOfProduct.click();
		pom.quantity.clear();
		pom.quantity.sendKeys("2");
		pom.addToCart.click();
		Thread.sleep(5000);
	}

	@And("clicks on shopping cart")
	public void clicks_on_shopping_cart() {
		pom.cart.click();

	}

	@Then("Products should be displayed with price")
	public void products_should_be_displayed_with_price() {
		String expectedProduct=pom.productNo.getText();
		String expectedPrice=pom.productPrice.getText();
		String actualProduct="NK_TLS_RS";
		String actualPrice="$30.00";
		Assert.assertEquals(expectedProduct, actualProduct);
		Assert.assertEquals(expectedPrice, actualPrice);
		tearDown();
	}

	@When("user clicks on remove option")
	public void user_clicks_on_remove_option() throws InterruptedException {
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		WebElement comlink=pom.addApparel;
		act.moveToElement(comlink).perform();
		Thread.sleep(6000);
		pom.addClothing.click();
	
		
		pom.product.click();
				//driver.findElement(By.xpath("//select[@id='product_attribute_11']>option:nth-of-type(2)")).click();
		pom.sizeOfProduct.click();
		pom.quantity.clear();
		pom.quantity.sendKeys("2");
		pom.addToCart.click();
		pom.cart.click();
		
		pom.removeButton.click();
	}

	@Then("products should be removed")
	public void products_should_be_removed() {
		String act=pom.cartEmptymsg.getText();
		String exp="Your Shopping Cart is empty!";
		Assert.assertEquals(act, exp);
		tearDown();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}

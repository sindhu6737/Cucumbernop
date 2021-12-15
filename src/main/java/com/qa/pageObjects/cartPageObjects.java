package com.qa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBase;

public class cartPageObjects extends TestBase{
	//Register Locators
	@FindBy(xpath="//a[text()='Register']")
	public WebElement registerOption;

	@FindBy(id="FirstName")
	public WebElement firstname;

	@FindBy(id="LastName")
	public WebElement lastname;

	@FindBy(name="DateOfBirthDay")
	public WebElement day;

	@FindBy(name="DateOfBirthMonth")
	public WebElement month;

	@FindBy(name="DateOfBirthYear")
	public WebElement year;

	@FindBy(id="Email")
	public WebElement emailfield;

	@FindBy(id="Company")
	public WebElement companyname;

	@FindBy(id="Password")
	public WebElement passwordfield;

	@FindBy(id="ConfirmPassword")
	public WebElement confirmPasswordfield;

	@FindBy(id="register-button")
	public WebElement registerButton;

	@FindBy(xpath="//div[@class='result']")
	public WebElement registerSuccessMsg;

	@FindBy(id="FirstName-error")
	public WebElement emptyFirstnameMsg;

	@FindBy(id="LastName-error")
	public WebElement emptyLastnameMsg;

	@FindBy(id="Email-error")
	public WebElement emptyEmailMsg;

	@FindBy(id="Password-error")
	public WebElement emptyPasswordMsg;

	@FindBy(id="ConfirmPassword-error")
	public WebElement emptyConfPasswordMsg;

	@FindBy(id="gender-female")
	public WebElement genderButton;

	@FindBy(id="Email-error")
	public WebElement wrongEmailMsg;

	@FindBy(css="span[id='Password-error'] p")
	public WebElement wrongPassMsg0;

	@FindBy(css="span[id='Password-error'] ul li")
	public WebElement wrongPassMsg1;

	@FindBy(css="div[class='message-error validation-summary-errors'] ul li")
	public WebElement duplicateWarning;

	@FindBy(xpath="//strong[text()='Your Personal Details']")
	public WebElement registerForm;

	@FindBy(xpath="//option[text()='June']")
	public WebElement specmonth;

	@FindBy(xpath="//option[text()='2000']")
	public WebElement specyear;


	//Login locators
	@FindBy(xpath="//a[text()='Log in']")
	public WebElement loginOption;

	@FindBy(xpath="//input[@id='Email']")
	public WebElement emailLoginOption;

	@FindBy(xpath = "//input[@id='Password']")
	public WebElement passwordLoginOption;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	public WebElement submitLoginOption;

	@FindBy(xpath = "//span[@id='Email-error']")
	public WebElement emptyEmailLogin;

	@FindBy(xpath= "//span[@id='Email-error']")
	public WebElement wrongEmailWarning;

	@FindBy (xpath="//a[text()='Forgot password?']")
	public WebElement forgetPasswordLink;

	@FindBy(xpath="//li[normalize-space()='No customer account found']")
	public WebElement noCustomerWarning;

	@FindBy(css="div[class='message-error validation-summary-errors'] ul li")
	public WebElement invalidPasswordWarning;

	@FindBy(xpath="//h2[text()='Welcome to our store']")
	public WebElement successfulLogin;

	//Search Locators
	@FindBy(xpath="//input[@id='small-searchterms']")
	public WebElement searchOption;

	@FindBy(xpath="//button[@class='button-1 search-box-button']")
	public WebElement searchButton;

	@FindBy(xpath="//div[@class='no-result']")
	public WebElement noProductWarning;

	//shopping cart locators
	@FindBy(xpath="//span[@class='cart-label']")
	public WebElement cart;
	
	@FindBy(css=".no-data")
	public WebElement emptyCartMsg;
	
	@FindBy(linkText="Apparel")
	public WebElement addApparel;
	
	@FindBy(linkText="Clothing")
	public WebElement addClothing;
	
	@FindBy(xpath="//img[@title='Show details for Nike Tailwind Loose Short-Sleeve Running Shirt']")
	public WebElement product;
	
	@FindBy(css="select[name='product_attribute_11'] >option:nth-of-type(2)")
	public WebElement sizeOfProduct;
	
	@FindBy(id="product_enteredQuantity_27")
	public WebElement quantity;
	
	@FindBy(xpath="//button[@id='add-to-cart-button-27']")
	public WebElement addToCart;
	
	@FindBy(xpath="//span[@class='sku-number']")
	public WebElement productNo;
	
	@FindBy(xpath="//span[@class='product-subtotal']")
	public WebElement productPrice;
	
	@FindBy(xpath="//button[@class='remove-btn']")
	public WebElement removeButton;
	
	@FindBy(xpath="//div[@class='no-data']")
	public WebElement cartEmptymsg;
	
	

	// To initialize the Page objects WebElements in defined in this Cart Page class, create the constructor of Cart Page

	public cartPageObjects() {           
		// this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


}

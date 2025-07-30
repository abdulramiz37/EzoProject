package EzionpageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import EzionAbstractionComponents.Abstraction;



public class UserIdPage extends Abstraction {
public WebDriver driver;
	// === Locators using @FindBy ===mn
	@FindBy(xpath = "//input[@placeholder='Mobile No']")
	private WebElement mobileNoField;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@status=\"primary\"]")
	private WebElement continueButton;
	
	@FindBy(xpath = "//li[@class='alert-message']")
	private WebElement alertmessage;
	
	@FindBy(xpath = "//ul[@class='alert-message-list']")
	WebElement incorrectCredentialAlert;

	@FindBy(css = ".ngx-select__toggle")
	WebElement dynamicDropdown;
	// === Constructor ===
	public UserIdPage(WebDriver driver) {
		super(driver);  // Initialize Abstraction first
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// === Getters ===
	public WebElement getMobileNoField() {
	    return waitForVisibility(mobileNoField);
	}

	public WebElement getPasswordField() {
	    return waitForVisibility(passwordField);
	}
	public WebElement getInvisible() {
	    return waitForInvisibility(continueButton);
	}

	// === Actions ===
	public void enterMobileNumber(String mobileNumber) {
		getMobileNoField().sendKeys(mobileNumber);
	}

	public void enterPassword(String password) {
		getPasswordField().sendKeys(password);
	}

	public By getDropdownOptionByName(String optionName) {
	    return By.xpath("//span[normalize-space()='" + optionName + "']");
	}
	public void selectOptionByName(String optionName) {
	    // Click to open the dropdown
	    waitForClickability(dynamicDropdown).click();

	    // Get the dynamic option
	    WebElement option = waitForClickability(driver.findElement(getDropdownOptionByName(optionName)));

	    // Click the option
	    option.click();
	}


	public void clickContinue() throws InterruptedException {
		
		continueButton.click();
		
	}
	
	public String getAlertMsg() throws InterruptedException {
		
		String str=alertmessage.getText();
		getInvisible();
		return str;
		
		
	}
	public String isIncorrectCredentialAlertDisplayed() {
	  
	    	System.out.println(incorrectCredentialAlert.getText().trim());
	        return incorrectCredentialAlert.getText().trim();
	    
	}
	}


package EzionpageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EzionAbstractionComponents.Abstraction;

public class NewRegistration extends Abstraction{

private	WebDriver driver;
	public NewRegistration(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	   @FindBy(xpath = "//span[text()='New Registration']")
	    private WebElement newRegistrationButton;

	    @FindBy(xpath = "(//span[text()='Select'])[1]")
	    private WebElement titleSelect;

	    @FindBy(xpath = "//span[text()='Mr.']")
	    private WebElement titleMr;

	    @FindBy(xpath = "//input[@formcontrolname='firstname']")
	    private WebElement firstNameInput;

	    @FindBy(xpath = "//input[@formcontrolname='middlename']")
	    private WebElement middleNameInput;

	    @FindBy(xpath = "//input[@formcontrolname='lastname']")
	    private WebElement lastNameInput;

	    @FindBy(xpath = "//input[@placeholder='DD/MM/YYYY']")
	    private WebElement dobField;

	    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
	    private WebElement monthYearChooser;

	    @FindBy(xpath = "//button[@aria-label='Previous 21 years']")
	    private WebElement prevYearsButton;

	    @FindBy(xpath = "//td[@aria-label='1999']")
	    private WebElement year1999;

	    @FindBy(xpath = "//td[@aria-label='May 1999']")
	    private WebElement monthMay;

	    @FindBy(xpath = "//td[@aria-label='May 12, 1999']")
	    private WebElement date12May;

	    @FindBy(xpath = "//input[@formcontrolname='mobile']")
	    private WebElement mobileInput;

	    @FindBy(xpath = "//input[@value='Save']")
	    private WebElement saveButton;

	    // Private data variables
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String mobileNumbers;

	

	    // Getters and Setters
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getMiddleName() {
	        return middleName;
	    }

	    public void setMiddleName(String middleName) {
	        this.middleName = middleName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }


	 // Click New Registration
	    public void clickNewRegistration() {
	        waitForClickability(newRegistrationButton).click();
	    }

	    // Select Title
	    public void selectTitle() {
//	        waitForClickability(titleSelect).click();
	        waitForVisibility(titleMr).click(); // You can make this dynamic later
	    }

	    // Enter Name Details
	    public void enterFullName(String firstName, String middleName, String lastName) {
	        waitForClickability(firstNameInput).sendKeys(firstName);
	        waitForClickability(middleNameInput).sendKeys(middleName);
	        waitForClickability(lastNameInput).sendKeys(lastName);
	    }


	    // Select Date of Birth
	    public void selectDOB() {
	        waitForClickability(dobField).click();
	        waitForClickability(monthYearChooser).click();
	        waitForClickability(prevYearsButton).click();
	        waitForClickability(year1999).click();
	        waitForClickability(monthMay).click();
	        waitForClickability(date12May).click();
	    }

	    // Enter Mobile Number
	    public void enterMobileNumber(String mobileNumber) {
	        waitForClickability(mobileInput).sendKeys(mobileNumber);
	    }

	    // Click Save
	    public OPBillingService clickSave() {
	        waitForClickability(saveButton).click();
	        OPBillingService opservice = new OPBillingService(driver);
			return opservice;
	    }

	    // Combined Method (if needed)


}

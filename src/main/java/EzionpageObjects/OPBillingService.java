package EzionpageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EzionAbstractionComponents.Abstraction;

public class OPBillingService extends Abstraction {

	public OPBillingService(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//div[@class='three-dots relative'])[1]")
    private WebElement firstThreeDots;

    @FindBy(xpath = "(//div[@class='pls-img-cont'])[4]")
    private WebElement fourthPatientImage;

    @FindBy(xpath = "//span[text()='Cardiology']")
    private WebElement cardiologyOption;

    @FindBy(xpath = "//span[text()='Dr. Malik']")
    private WebElement drMalikOption;

    @FindBy(xpath = "//span[text()='APPEARANCE']")
    private WebElement appearanceOption;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    private WebElement fourthTextInput;

    @FindBy(xpath = "//input[@value='Add']")
    private WebElement addButton;

    @FindBy(xpath = "(//input[@value='Save'])[1]")
    private WebElement firstSaveButton;

    // ====== Actions ======

    public void openFirstPatientOptions() {
        waitForClickability(firstThreeDots).click();
    }

    public void selectFourthPatientImage() {
        waitForClickability(fourthPatientImage).click();
    }

    public void selectCardiology() {
        waitForClickability(cardiologyOption).click();
    }

    public void selectDoctorMalik() {
        waitForClickability(drMalikOption).click();
    }

    public void clickAppearanceOption() {
        waitForClickability(appearanceOption).click();
    }

    public void enterAppearanceValue(String value) {
        waitForClickability(fourthTextInput).sendKeys(value);
    }

    public void clickAddButton() {
        waitForClickability(addButton).click();
    }

    public void clickFirstSaveButton() {
        waitForClickability(firstSaveButton).click();
    }
    public void fillAppearanceForm(String appearanceValue) {
        waitForClickability(firstThreeDots).click();
        waitForClickability(fourthPatientImage).click();
        waitForClickability(cardiologyOption).click();
        waitForClickability(drMalikOption).click();
        waitForClickability(appearanceOption).click();
        waitForClickability(fourthTextInput).sendKeys(appearanceValue);
        waitForClickability(addButton).click();
        waitForClickability(firstSaveButton).click();
    }
    
}



package EzionpageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import EzionAbstractionComponents.Abstraction;
import ezion.Resources.EnvUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends Abstraction {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"form-control-group\"]//input")
	private WebElement userId;

	@FindBy(xpath = "//button[@size=\"large\"]")
	private WebElement submit;

	@FindBy(xpath = "//ul[contains(@class, 'alert-message-list')]/li[contains(@class, 'alert-message')]")
	WebElement alertMessage2;

	public WebElement getUserId() {
		return userId;
	}

	public void setUserId(WebElement userId) {
		this.userId = userId;
	}

	public UserIdPage login(String userIdName) {
		userId.sendKeys(userIdName);
		submit.click();
		return new UserIdPage(driver);
	}

	public String getAlertMessage() {
		System.out.println(alertMessage2.getText().trim());
		return alertMessage2.getText().trim();
	}
	
	public void getLoginEzion(String browser) {
//		String baseUrl = EnvUtil.get("BASE_URL");

		driver.get(browser);
	}
}

package EzionAbstractionComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EzionpageObjects.NewRegistration;


public class Abstraction {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    public Abstraction(WebDriver driver) {
       
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;

    }
    @FindBy(xpath = "//a[@title='Registration']")
    private WebElement registrationElement;
    
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminTab;

    @FindBy(xpath = "//span[text()='Roles Management']")
    private WebElement rolesManagement;
   
    @FindBy(xpath = "//a[@title='Masters']")
    private WebElement mastersTab;

    @FindBy(xpath = "//a[@title='Master Set-up']")
    private WebElement masterSetupTab;
    
    @FindBy(xpath = "//div[@class='back-icon']")
    private WebElement backIcon;

    @FindBy(xpath = "//h4[text()=' Pharmacy']")
    private WebElement pharmacyHeading;
    
    @FindBy(xpath = "//span[text()='Pharmacy']")
    private WebElement pharmacyTab;

    @FindBy(xpath = "(//span[text()='Purchase'])[1]")
    private WebElement purchaseMenu;
  
    @FindBy(xpath = "(//span[text()='Indent'])[1]")
    private WebElement indent;
//    (//span[text()='Indent Approval'])[1]
    @FindBy(xpath = "(//span[text()='Indent Approval'])[1]")
    private WebElement indentApproval;
    
    @FindBy(xpath = "(//span[text()='Internal Indent'])[1]")
    private WebElement indentRequest;
    
    @FindBy(xpath = "(//span[text()='Purchase Order'])[1]")
    private WebElement orderMenu;
//    (//span[text()='Internal Indent'])[1]
    @FindBy(xpath = "(//span[text()='Purchase Return'])[1]")
    private WebElement purchaseReturnMenu;
    
    
    @FindBy(xpath = "(//span[text()='Sales'])[1]")
    private WebElement sales;
    

    @FindBy(xpath = "(//span[text()='Sales'])[2]")
    private WebElement sales2;
  //a[@title='Pharmacy']
    // Wait for visibility and return the WebElement
    public WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void masterSetupOpenOnly() {
    	waitForClickability(masterSetupTab).click();
    }
    public List<WebElement> waitForVisibility(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    // Wait for clickability and return the WebElement
    public WebElement waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForClickability(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public NewRegistration clickOnRegistration() throws InterruptedException {
    	
    	WebElement registrationElements =	waitForVisibility(registrationElement);
        registrationElements.click();
        NewRegistration newregister = new NewRegistration(driver);
        return newregister;
    }
    
    public void navigateToPurchaseWithRetry() {
        for (int i = 0; i < 3; i++) {
            try {
                WebElement pharmacy = waitForClickability(pharmacyTab);
                pharmacy.click();

                WebElement purchase = waitForClickability(purchaseMenu);
                purchase.click();
                System.out.println("✅ Navigation to Purchase successful on attempt " + (i + 1));
                break;
            } catch (Exception e) {
                System.out.println("❌ Attempt " + (i + 1) + " failed: " + e.getMessage());
                if (i == 4) throw e;
            }
        }
    }
    
    public void navigateToIndentWithRetry() {
        for (int i = 0; i < 5; i++) {
            try {
                WebElement pharmacy = waitForClickability(pharmacyTab);
                pharmacy.click();

                WebElement purchase = waitForClickability(indent);
                purchase.click();
                System.out.println("✅ Navigation to Purchase successful on attempt " + (i + 1));
                break;
            } catch (Exception e) {
                System.out.println("❌ Attempt " + (i + 1) + " failed: " + e.getMessage());
                if (i == 4) throw e;
            }
        }
    }
    
    public void navigateSalesWithRetry() {
        for (int i = 0; i < 5; i++) {
            try {
                WebElement pharmacy = waitForClickability(pharmacyTab);
                pharmacy.click();

                WebElement sales1 = waitForClickability(sales);
                sales1.click();
                System.out.println("✅ Navigation to Purchase successful on attempt " + (i + 1));
                break;
            } catch (Exception e) {
                System.out.println("❌ Attempt " + (i + 1) + " failed: " + e.getMessage());
                if (i == 4) throw e;
            }
        }
    }
    public WebElement waitForInvisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }
    public WebElement waitForClickability(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisibility(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public List<WebElement> waitForVisibility(List<WebElement> element, int seconds) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    
    public void timeoutElement() throws InterruptedException {
    	
    }
    public void clickWithJavaScript(WebElement element) {
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("JS click failed: " + e.getMessage());
        }
    }
    

    

    

    

//    public IndentApprovalTablePage indentStock() {
//    	navigateToIndentWithRetry();
//    	 waitForClickability(indentApproval).click();
//    	 IndentApprovalTablePage indentApproval= new IndentApprovalTablePage(driver);
//    	 return indentApproval;
//    	
//    }

    


    public void waitForPharmacyPageWithBackClick() {
        for (int i = 0; i <= 10; i++) {
            try {
            	waitForClickability(backIcon, 1).click();      // waits 3 seconds max
            	waitForVisibility(pharmacyHeading, 3);         // waits 3 seconds max

                System.out.println("Pharmacy page is visible.");
                break;
            } catch (Exception e) {
                System.out.println("Attempt " + (i + 1) + ": Pharmacy not visible yet.");
                if (i ==  4) {
                    throw new RuntimeException("Failed to navigate back to Pharmacy page", e);
                }
            }
        }
    }
    public void waitForPharmacyPageWithBackClickOnce() {
        for (int i = 0; i <= 10; i++) {
            try {
            	waitForClickability(backIcon, 1).click();      // waits 3 seconds max
            	     
            	waitForVisibility(pharmacyHeading, 3);  
                System.out.println("harmacy page is visible.");
                break;
            } catch (Exception e) {
                System.out.println("Attempt " + (i + 1) + ": Pharmacy not visible yet.");
                if (i ==  4) {
                    throw new RuntimeException("Failed to navigate back to Pharmacy page", e);
                }
            }
        }
    }
    public List<WebElement> waitForPresenceOfAll(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    public void waitForUrl(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
 
    public void waitForPharmacyPageWithBackClickOnce2() {
        By backIconLocator = By.xpath("//i[@class='fa fa-chevron-left']");
        By pharmacyHeadingLocator = By.xpath("//h4[text()=' Pharmacy']");

        for (int i = 0; i < 5; i++) {
            try {
                WebElement backIconElement = driver.findElement(backIconLocator);
                js.executeScript("arguments[0].click();", backIconElement);

                WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
                shortWait.until(ExpectedConditions.visibilityOfElementLocated(pharmacyHeadingLocator));

                System.out.println("Pharmacy page is visible.");
                break;
            } catch (Exception e) {
                System.out.println("Attempt " + (i + 1) + ": Pharmacy page not visible yet.");
                if (i == 4) {
                    throw new RuntimeException("Failed to load Pharmacy page after 5 attempts", e);
                }
            }
        }
    }

    
    

}

package abdulTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.Date;


import EzionpageObjects.LoginPage;
//import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
	public WebDriver driver;
	public LoginPage login;
	public Properties prop;

	public WebDriver initializeWeb() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//ezion//Resources//Global.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
//			WebDriverManager.chromedriver().setup();
			if(browserName.contains("incognito")){
			options.addArguments("--incognito");
			}		
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen

		}
		else if(browserName.equals("firefox")) {
				driver = new FirefoxDriver();
				
			}
		
		else 	
			if(browserName.equals("edge")) {
				driver = new EdgeDriver();
				
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    // Add timestamp to the test case name
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String screenshotPath = System.getProperty("user.dir") + "//reports//" + testCaseName + "_" + timestamp + ".png";

	    File destination = new File(screenshotPath);
	    FileUtils.copyFile(source, destination);

	    return screenshotPath;
	}
	@SuppressWarnings("deprecation")
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	@BeforeClass(alwaysRun = true)
	public void loginPage() throws IOException {
	    driver = initializeWeb();
	    login = new LoginPage(driver);
	    String baseUrl = System.getProperty("BASE_URL", prop.getProperty("BASE_URL"));
	    login.getLoginEzion(baseUrl);
	}
//	@AfterClass(alwaysRun = true)
//	public void closeBrowser() {
//	    driver.quit();
//	}

}
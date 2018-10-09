package driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	public enum Browser 
	{
        Chrome,
        Firefox
    }
    
	public static WebDriver setupDriver(Browser browser) 
	{
		WebDriver driver = null;
		String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");
		if(browser == Browser.Chrome) 
		{
			if (osName.equals("windows")) 
			{
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			} 
			else 
			{
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
			}
			// For preventing Chrome from displaying information bar, 
			// that our automation script running on the chrome.
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			
			driver = new ChromeDriver(options);
		}
		
		else if (browser == Browser.Firefox) 
		{
			if (osName.equals("windows")) 
			{
				System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
			} 
			else 
			{
				System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
			}
		
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}	
	
}

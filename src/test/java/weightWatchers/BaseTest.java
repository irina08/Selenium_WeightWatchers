package weightWatchers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import driver.DriverSetup;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeClass
	  public void beforeMethod() {
		driver = DriverSetup.setupDriver(DriverSetup.Browser.Chrome);
		//driver = DriverSetup.setupDriver(DriverSetup.Browser.Firefox);
	} 
	
	@AfterClass
    public void teardown () {
        driver.quit();
    }
}

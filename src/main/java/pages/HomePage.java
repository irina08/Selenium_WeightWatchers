package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver;
	String baseURL = "https://www.weightwatchers.com/us/";
	
	public HomePage (WebDriver driver) {
        this.driver = driver;
    }
	
	public void verifyPageTitle(String expectedTitle) {
		driver.get(baseURL);
		
		String actualTitle = driver.getTitle();
		System.out.println("Home page title is : "+ actualTitle);
		System.out.println("Expected Home page title is : "+ expectedTitle);	
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Verification are passed");
		System.out.println();
	}  
	
}

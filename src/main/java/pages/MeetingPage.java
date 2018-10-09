package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MeetingPage {

	public WebDriver driver;
	JavascriptExecutor js;
	String baseURL = "https://www.weightwatchers.com/us/";
	String class_findMeeting = "find-a-meeting";
	String id_meetingSearch = "meetingSearch";
	String class_meetingClick = "input-group-btn";
	String xpathTitle = "/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ui-view[1]/ui-view[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/result-location[1]/div[1]/div[1]/a[1]/location-address[1]/div[1]/div[1]/div[1]/div[1]/span[1]";
	String xpathLocation = "//div[@class='location__distance'][contains(text(),'0.49 mi.')]";
	String classLocation = "location";
	String xpath_firstSearchTitle = "//div[@class='location__top']";
	String currentHours = "//div[@class='hours-list-item-wrapper hours-list--currentday']";
	
	public MeetingPage (WebDriver driver) {
        this.driver = driver;
    }
	
	public void goToMeetingPage() {
		driver.get(baseURL);
		driver.findElement(By.className(class_findMeeting)).click();
	}
	
	public void verifyTitlePage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("Actual Meeting page title is : "+ actualTitle);
		System.out.println("Expecting Meeting page title is : "+ expectedTitle);
		if (expectedTitle.equals(actualTitle))
			System.out.println("Verification of MeetingPageTitle is: passed");
		else
			System.out.println("Verification of MeetingPageTitle is: failed");
		System.out.println();
	}
	
	/*find meetings by given ZipCode, print the first search
	 result name and distance. 
	 This method will return String - name of first Studio in
	 search result, because we need to use it in next method.
	*/
	public String searchMeeting(String zipCode) {
		String firstTitle = "";
		driver.findElement(By.id(id_meetingSearch)).sendKeys(zipCode);	
		driver.findElement(By.className(class_meetingClick)).click();
		
		List<WebElement> titleFirstSearchResult = driver.findElements(By.xpath(xpathTitle));
		List<WebElement> distanceFirstSearch = driver.findElements(By.xpath(xpathLocation));
		
		for(WebElement firstT : titleFirstSearchResult) {
			firstTitle = firstT.getText();
			System.out.println("Title of first search result: "+ firstTitle);
		}
		for(WebElement firstDistance : distanceFirstSearch) {
			System.out.println("Distance of first search result: " + firstDistance.getText());
		}
		System.out.println();
		return firstTitle;
	}
	
	//verify displayed location name matches with the name of the 
	// first searched result that was clicked.
		public void verifyDisplayedLocationName(String firstTitle) {
		driver.findElement(By.className(classLocation)).click();	
			
		WebElement afterClick = driver.findElement(By.xpath(xpath_firstSearchTitle));
		String titleAfterClick = afterClick.getText();
		System.out.println("Title after Click is: " + 
					titleAfterClick);
		
		if(firstTitle.equals(titleAfterClick)) 
			System.out.println("Verification of displayed location " 
					+ "name is: successful");
		else
			System.out.println("Verification of displayed location " 
					+ "name is: failed");	
		System.out.println();
	}
	
	public void printOperatingHours() {
		js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,1000)");
		List<WebElement> todayHours = driver.findElements(By.xpath(currentHours));
		for(WebElement hours: todayHours) {
			System.out.println("Today's day of week and hours : "+ hours.getText());
		}
	}		
}
package weightWatchers;
/* We can use different approaches for verification a title of 
* Page: 1) use Assert.assertEquals() method which will abort
*  test execution and give us AssertionError Exception;
* 2) if-else conditions statements, in our case:
* if (expectedTitle.equals(actualTitle))
* 	System.out.println("Verification is successful");
* else
* 	System.out.println("Verification is failed");
* Second approach gives us in any case all tests passed but we 
* can find that by outputs that "Verification is failed" but
* it will continue test execution.
*/

import org.testng.annotations.*;
import pages.HomePage;

public class TestHomePage extends BaseTest {
	
	String expectedTitle1 = "WW (Weight Watchers): Weight Loss & Wellness Help";
	String expectedTitle2 = "Weight Loss Program, Recipes & Help | Weight Watchers";
	
	@Test
	public void verifyPageTitle1() {
		System.out.println("Test 'verifyTitle1'");
		HomePage homePage = new HomePage(driver);
		homePage.verifyPageTitle(expectedTitle1);
	}

	@Test
	public void verifyPageTitle2() {
		HomePage homePage = new HomePage(driver);
		System.out.println("Test 'verifyTitle2'");
		homePage.verifyPageTitle(expectedTitle2);
	}
	
}


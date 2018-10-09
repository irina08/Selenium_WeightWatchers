package weightWatchers;

import org.testng.annotations.*;

import pages.MeetingPage;


public class TestMeetingPage extends BaseTest {
	
	@Test
	public void testMeetingPage() {

		MeetingPage meetingPage = new MeetingPage(driver);
		String expectedTitle = "Get Schedules & Times Near You";
		
		meetingPage.goToMeetingPage();		
		meetingPage.verifyTitlePage(expectedTitle);
		String firstTitle = meetingPage.searchMeeting("10011");
		meetingPage.verifyDisplayedLocationName(firstTitle);
		meetingPage.printOperatingHours();
		
}
	
}
 
# Selenium_WeightWatchers
In the src/main/java/driver DriverSetup java_class which let us to chose drivers Firefox or Google Chrome for Mac or Windows.
In the src/main/java/pages HomePage.java and MeetingPage.java which contain methods for testing HomePage and MeetingPage
In the src/test/java/weightWatchers BaseTest class which contains methods suitable for every TestCase:
- beforeMethod() method which  let us setup driver before execute every class
- teardown() method which let us quit driver after execute every class. 
In the src/test/resources/driver are executable Chrome Drivers and Gecko(Firefox) Drivers for Mac and Windows.

Task:
1. Navigate to https://www.weightwatchers.com/us/
2. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
3. On the right corner of the page, click on “Find a Meeting”
4. Verify loaded page title contains “Get Schedules & Times Near You”
5. In the search field, search for meetings for zip code: 10011
6. Print the title of the first result and the distance (located on the right of location title/name)
7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)

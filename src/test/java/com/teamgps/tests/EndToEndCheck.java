//package com.teamgps.tests;
//
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//import pages.LoginPage.LoginPage;
//import pages.homePage.HomePage;
//import pages.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.OngoingMeetingPage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;
//import pages.LoginPage.LoginPage;
//
//public class EndToEndCheck  {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get("https://itbd-stage-frontend.team-gps.net/login");
//		driver.manage().window().maximize();
//
//		// -- Interact with the login page
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.enterUsername("lucas.sarzo@yopmail.com").clickNextButton().enterPassword("John@123").clickLoginButton();
//
//		// -- Interact with the Main page which comes after the login
//		HomePage homePage = new HomePage(driver);
//		homePage.clickOnMeetings();
//		homePage.clickOnOneOnOneMeetings();
//
//		// -- Interact with the One-on-One meeting page which opens after clicking the 1:1 meeting from the left menu
//		OneOnOneMeetingsPage oneOnOneMeetingsPage = new OneOnOneMeetingsPage(driver);
//		//oneOnOneMeetingsPage.clickStartMeeting(1);
//		oneOnOneMeetingsPage.clickEditMeeting(1); // why is it not working with the meeting in the second row or third row
//		//oneOnOneMeetingsPage.clickCreateMeeting();
//
//		OngoingMeetingPage ongoingMeetingPage = new OngoingMeetingPage(driver);
//		ongoingMeetingPage.clickOnCompleteMeetingbutton();
//
//
//		// -- Interact with the Create Event page of the new One-on-One meeting being created
//		CreateEventPage createEventPage = new CreateEventPage(driver);
//		createEventPage.addRecipient("Sergio");
//		createEventPage.setEventTitle("meeting with ralph and phil 08 nov");
//		//createEventPage.clickOnRecurringMeeting();
//		createEventPage.clickOnCreateButton();
//
//		//-- Interact with the select Template page which comes in second step while creating the meeting
//		SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
//		selectTemplatePage.clickDefaultTemplate();
//		selectTemplatePage.clickSaveAndNextButton();
//
//		//-- Interact with the Edit Meeting page which comes in third step while creating the meeting
//		EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
//		editMeetingPage.clickSaveAndSendUpdateButton();
//		// editMeetingPage.clickAddToCalendarButton();
//		editMeetingPage.clickSkipCalendarButton();
//
//
////				AgendaTabPage agendaPage = new AgendaTabPage(driver);
////				agendaPage.clickOnEditAgendaItem(2);
//
//		System.out.println("anurag");
//
//		Thread.sleep(4000);
//
//		driver.quit();
//	}
//
//}
package com.teamgps.tests;

import org.testng.annotations.Test;
import pages.homePage.HomePage;
import pages.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.EditMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.OngoingMeetingPage;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;

public class EndToEndCheck extends BaseTest {

	@Test
	public void testEndToEndFlow() throws InterruptedException {
		// You no longer need to initialize WebDriver or LoginPage, as they are handled in BaseTest

		// -- Interact with the Main page which comes after the login
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMeetings();
		homePage.clickOnOneOnOneMeetings();

		// -- Interact with the One-on-One meeting page which opens after clicking the 1:1 meeting from the left menu
		OneOnOneMeetingsPage oneOnOneMeetingsPage = new OneOnOneMeetingsPage(driver);
		oneOnOneMeetingsPage.clickStartMeeting(1);
		oneOnOneMeetingsPage.clickEditMeeting(1); // why is it not working with the meeting in the second row or third row

		// -- Interact with the Ongoing Meeting page
		OngoingMeetingPage ongoingMeetingPage = new OngoingMeetingPage(driver);
		ongoingMeetingPage.clickOnCompleteMeetingButton();

		// -- Interact with the Create Event page of the new One-on-One meeting being created
		CreateEventPage createEventPage = new CreateEventPage(driver);
		createEventPage.addRecipient("Sergio");
		createEventPage.setEventTitle("Meeting with Ralph and Phil 08 Nov");
		createEventPage.clickOnCreateButton();

		// -- Interact with the Select Template page while creating the meeting
		SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
		selectTemplatePage.clickDefaultTemplate();
		selectTemplatePage.clickSaveAndNextButton();

		// -- Interact with the Edit Meeting page
		EditMeetingPage editMeetingPage = new EditMeetingPage(driver);
		editMeetingPage.clickSaveAndSendUpdateButton();
		editMeetingPage.clickSkipCalendarButton();

		System.out.println("End-to-end flow completed successfully.");

		// Optional: Sleep for a few seconds to visually confirm
		Thread.sleep(4000);
	}
}

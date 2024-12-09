//package com.teamgps.tests.meetings;
//
//import com.teamgps.tests.BaseTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.testng.annotations.AfterMethod;
//import pages.homePage.HomePage;
//import pages.homePage.meetings.oneOnOneMeetings.OneOnOneMeetingsPage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.CreateEventPage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.SelectTemplatePage;
//import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.AgendaTabPage;
////import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.TasksPage;
////import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.MeetingSurveyPage;
//
//public class OneOnOneMeetingTests extends BaseTest {
//
//    private HomePage homePage;
//    private OneOnOneMeetingsPage oneOnOneMeetingsPage;
//    private CreateEventPage createEventPage;
//    private SelectTemplatePage selectTemplatePage;
//    private AgendaTabPage agendaPage;
////    private TasksPage tasksPage;
////    private MeetingSurveyPage meetingSurveyPage;
//
//    @BeforeMethod
//    public void setUp() {
//        homePage = new HomePage(driver); // Initializing the HomePage object
//        oneOnOneMeetingsPage = new OneOnOneMeetingsPage(driver);
//        createEventPage = new CreateEventPage(driver);
//        selectTemplatePage = new SelectTemplatePage(driver);
//        agendaPage = new AgendaTabPage(driver);
////        tasksPage = new TasksPage(driver);
////        meetingSurveyPage = new MeetingSurveyPage(driver);
//    }
//
//    @Test
//    public void testOneOnOneMeetingFlow() throws InterruptedException {
//        // Step 1: Go to HomePage and navigate to 1:1 meetings
//        homePage.clickOnMeetings();
//        homePage.clickOnOneOnOneMeetings();
//
//        // Step 2: Start a new meeting or edit an existing one
//        oneOnOneMeetingsPage.clickStartMeeting(1); // Use the first meeting for testing
//        oneOnOneMeetingsPage.clickEditMeeting(1);  // Edit the meeting
//
//        // Step 3: Create Event
//        createEventPage.addRecipient("Sergio");
//        createEventPage.setEventTitle("1:1 Meeting with Sergio");
//        createEventPage.clickOnCreateButton();
//
//        // Step 4: Select Template for the Meeting
//        selectTemplatePage.clickDefaultTemplate();
//        selectTemplatePage.clickSaveAndNextButton();
//
//        // Step 5: Add Agenda to the meeting
//        agendaPage.addAgendaItem("Discuss project updates");
//        agendaPage.clickSaveAndNextButton();
//
//        // Step 6: Add Tasks for the meeting
////        tasksPage.addTask("Prepare presentation");
////        tasksPage.clickSaveAndNextButton();
//
//        // Step 7: Add Meeting Survey if applicable
////        meetingSurveyPage.addSurvey("Feedback on the meeting");
////        meetingSurveyPage.clickSaveAndNextButton();
//
//        // Optional: Sleep for a few seconds to visually confirm
//        Thread.sleep(3000);
//
//        // Step 8: Complete and create the meeting
////        meetingSurveyPage.clickCreateMeetingButton();
//        System.out.println("1:1 Meeting created successfully.");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit(); // Close the browser after the test
//    }
//}

package com.teamgps.tests.meetings;

import com.teamgps.tests.BaseTest;
import org.testng.annotations.Test;
import pages.homePage.meetings.oneOnOneMeetings.createNewMeeting.*;

public class OneOnOneMeetingTests extends BaseTest { // Extends your existing BaseTest

    @Test
    public void testCreateOneOnOneMeeting() throws InterruptedException {
        // Initialize page objects
        CreateEventPage createEventPage = new CreateEventPage(driver);
        RecurringMeetingPage recurringMeetingPage = new RecurringMeetingPage(driver);
        SelectTemplatePage selectTemplatePage = new SelectTemplatePage(driver);
        AgendaTabPage agendaTabPage = new AgendaTabPage(driver);

        // Step 1: Create Event
        createEventPage.setEventTitle("Automation Test Meeting");
        createEventPage.addRecipient("John Doe");
        createEventPage.clickOnRecurringMeeting();

        // Step 2: Set Recurring Meeting Details
        recurringMeetingPage.setStartDate("2024-12-10");
        recurringMeetingPage.setEndDate("2024-12-15");
        recurringMeetingPage.setStartTime("10:00 AM");
        recurringMeetingPage.setEndTime("11:00 AM");
        recurringMeetingPage.selectRecurrencePattern("Weekly");

        // Step 3: Select Template
        selectTemplatePage.clickDefaultTemplate();
        selectTemplatePage.clickSaveAndNextButton();

        // Step 4: Edit Agenda
        agendaTabPage.addNewAgendaItem();
        agendaTabPage.clickOnEditAgendaItem(1); // Edit the first agenda item
        agendaTabPage.addNotesToAgendaItem(1, "Discuss project updates");
        agendaTabPage.showPrivateNotes();
        agendaTabPage.hidePrivateNotes();
    }
}

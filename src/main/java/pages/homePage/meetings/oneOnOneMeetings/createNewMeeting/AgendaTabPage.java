package pages.homePage.meetings.oneOnOneMeetings.createNewMeeting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgendaTabPage {

WebDriver driver;
WebDriverWait wait;

	public AgendaTabPage(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//locators
	private int agendaNumber;
	By editAgendaItem = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-add-agenda[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div["+agendaNumber+"]/div[1]/div[4]/span[1]");
	By addNotesToAgendaItem = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-add-agenda[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div["+agendaNumber+"]/div[1]/div[5]/span[1]/img[1]");
	By deleteAgendaItem = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-add-agenda[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div["+agendaNumber+"]/div[1]/div[5]/span[2]/img[1]");


	By addNewAgendaItem = By.className("form-row addItem mb-4 ng-star-inserted");
	By showPrivateNotes = By.xpath("//div[@class='d-flex justify-content-end']//span[1]");
	By hidePrivateNotes = By.className("ml-2 btn-primary addNote ng-star-inserted");

	public void clickOnEditAgendaItem(int num) {
		agendaNumber = num;
		wait.until(ExpectedConditions.visibilityOfElementLocated(editAgendaItem));
		driver.findElement(editAgendaItem).click();
		driver.findElement(editAgendaItem).clear();
		driver.findElement(editAgendaItem).sendKeys("this is the agenda item created by automation");

	}

	public void addNewAgendaItem() {
	}

	public void addNotesToAgendaItem(int i, String discussProjectUpdates) {
	}

	public void showPrivateNotes() {
	}

	public void hidePrivateNotes() {
	}
}

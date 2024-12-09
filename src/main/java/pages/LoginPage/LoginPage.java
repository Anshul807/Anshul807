package pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriverWait wait;

    // Locators for the elements on the login page
    private final By emailInputField = By.xpath("//input[@id='email']");
    private final By nextButton = By.xpath("//button[normalize-space()='Next']");
    private final By passwordInputField = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Log In']");

    // Constructor to initialize the WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to enter the email/username
    public LoginPage enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField)).sendKeys(username);
        return this;
    }

    // Method to click the "Next" button
    public LoginPage clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        return this;
    }

    // Method to enter the password
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputField)).sendKeys(password);
        return this;
    }

    // Method to click the "Log In" button
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}

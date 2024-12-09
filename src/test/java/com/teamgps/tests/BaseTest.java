package com.teamgps.tests;

import pages.LoginPage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Set ChromeDriver path (if not using WebDriverManager)
        System.setProperty("web driver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        // Create ChromeOptions for additional settings (optional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  // Optional: Starts Chrome maximized

        // Initialize WebDriver with options
        driver = new ChromeDriver(options);

        // Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the login page
        driver.get("https://itbd-stage-frontend.team-gps.net/login");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize the LoginPage
        loginPage = new LoginPage(driver);

        // Perform login (assuming username and password are already defined)
        String username = "lucas.sarzo@yopmail.com";  // Replace with actual username
        String password = "John@123";  // Replace with actual password
        loginPage.enterUsername(username)
                .clickNextButton()
                .enterPassword(password)
                .clickLoginButton();
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver after all tests in this class
        if (driver != null) {
            driver.quit();
        }
    }
}

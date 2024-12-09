PROJECT STRUCTURE

teamgps-tests
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.teamgps.pages         # Contains page classes (Page Object Model).
│   │           └── LoginPage.java        # Page class to define web element locators and actions for the Login page.
│   │
│   ├── test
│   │   └── java
│   │       └── com.teamgps.tests         # Contains test classes.
│   │           ├── BaseTest.java         # Base test class for common setup/teardown logic.
│   │           └── LoginTest.java        # Test class for Login functionality.
│   │       └── com.teamgps.utilities     # Contains utility classes for reusable methods.
│   │           ├── WaitUtility.java      # Utility for explicit waits.
│   │           ├── ScreenshotUtility.java # Utility for capturing screenshots.
│   │           ├── ConfigUtility.java    # Utility to read configuration from `config.properties`.
│   │           └── ReportUtility.java    # Utility for generating test reports (e.g., ExtentReports).
│   │
│   └── resources
│       └── config.properties             # Configuration file for storing application URL, username, and password.
│
├── reports                                # Directory for test report output.
│   └── ExtentReport.html                 # Test report generated after execution.
│
├── screenshots                            # Directory for storing screenshots of failed test cases.
│   └── LoginTestFailure.png              # Example screenshot for a failed LoginTest.
│
├── .gitignore                             # Specifies files/folders to exclude from version control.
├── pom.xml                                # Maven configuration file for managing dependencies.
├── testng.xml                             # TestNG configuration file for running test suites.
└── README.md                              # Project documentation file.

Directory/Files Overview
1. src/main/java
   This directory contains reusable code for the Page Object Model (POM):
com.teamgps.pages: Contains one class per application page (e.g., LoginPage.java) to encapsulate locators and methods for interacting with page elements.

2. src/test/java
   This directory contains the test code:

->com.teamgps.tests:
BaseTest.java: Contains setup (e.g., browser initialization) and teardown logic for all tests.
LoginTest.java: Test class focusing on login functionality.

->com.teamgps.utilities:
WaitUtility.java: Provides explicit wait methods.

->ScreenshotUtility.java: Captures screenshots for failed test cases.

->ConfigUtility.java: Reads and fetches properties from config.properties.

->ReportUtility.java: Generates test reports using ExtentReports.

3. src/resources
   ->config.properties: Stores environment variables such as:
   baseURL: Application URL.
   username: Login credentials.
   password: Login password.

4. Root-Level Files/Directories
   ->reports/: Contains ExtentReport files for executed test runs.
   ->screenshots/: Stores screenshots of test failures (helps in debugging).
   ->.gitignore: Lists files/folders to exclude from version control (e.g., target/ or logs).
   ->pom.xml: Specifies project dependencies such as Selenium, TestNG, ExtentReports, etc.
   ->testng.xml: Configures test execution, including test classes, groups, and parallel runs.
   ->README.md: Documentation for project setup and execution instructions.

5.Advantages of This Structure
   ->Modularity: Clear separation of test logic, utilities, and resources.
   ->Maintainability: Easily extendable for new pages, tests, and utilities.
   ->Reusability: Shared utilities minimize code duplication.
   ->Scalability: Suitable for growing projects with additional functionality.
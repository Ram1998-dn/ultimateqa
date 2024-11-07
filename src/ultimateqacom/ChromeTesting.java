package ultimateqacom;
/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Set up Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Click on the "Sign In" link
 * 7. Print the current URL
 * 8. Enter the email in the email field.
 * 9. Enter the password in the password field.
 * 10. Click on the Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to the Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTesting {
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    // Method to set up the Chrome browser and perform actions
    public static void setupBrowser() {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        // Open URL
        driver.get(baseUrl);

        // Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Print the page source
        System.out.println("Page Source: " + driver.getPageSource());

        // Click on the "Sign In" link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Print the current URL after clicking on 'Sign In'
        System.out.println("Current URL after clicking Sign In: " + driver.getCurrentUrl());

        // Enter email in the email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("test@example.com");

        // Enter password in the password field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("password123");

        // Click on the Login Button
        WebElement loginButton = driver.findElement(By.linkText("Sign in"));
        loginButton.click();

        // Navigate back to the base URL
        driver.navigate().to(baseUrl);

        // Navigate forward to the Homepage
        driver.navigate().forward();

        // Navigate back to baseUrl again
        driver.navigate().back();

        // Refresh the page
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }

    // Main method to execute setup
    public static void main(String[] args) {
        setupBrowser();
    }

}

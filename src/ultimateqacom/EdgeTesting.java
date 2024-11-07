package ultimateqacom;
/**
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Set up Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Click on the ‘Sign In’ link
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTesting {
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    // Method to set up the browser and perform actions
    public static void setupBrowser(String browser) {
        // Initialize browser based on input
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
            driver = new EdgeDriver();
        } else {
            System.out.println("Unsupported browser! Please use 'chrome', 'firefox', or 'edge'.");
            return;
        }

        // Open URL
        driver.get(baseUrl);

        // Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Print the page source
        System.out.println("Page Source: " + driver.getPageSource());

        // Click on the ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Print the current URL after clicking Sign In
        System.out.println("Current URL after clicking Sign In: " + driver.getCurrentUrl());

        // Enter email in the email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("test@example.com");

        // Enter password in the password field
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("password123");

        // Click on the Login Button
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();

        // Navigate back to the base URL
        driver.navigate().to(baseUrl);

        // Navigate forward to the Homepage
        driver.navigate().forward();

        // Navigate back to the base URL
        driver.navigate().back();

        // Refresh the page
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }

    // Main method to execute setup for different browsers
    public static void main(String[] args) {
        // Set browser to "chrome", "firefox", or "edge"
        String browser = "chrome"; // Change this to test with different browsers

        // Run setupBrowser method for the selected browser
        setupBrowser(browser);
    }
}

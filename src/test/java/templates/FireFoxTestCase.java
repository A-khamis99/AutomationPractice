package templates;

import engine.ActionBot;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class FireFoxTestCase {
    // This class serves as a template for creating new test cases.
    // You can add common setup, teardown, and utility methods here that can be reused across multiple test cases.


    // declaration for webDriver and WebDriverWait
    public WebDriver driver;
    public ActionBot actionBot;


    public static FirefoxOptions getOptimizedOptions() {
        FirefoxOptions options = new FirefoxOptions();

        // Essential execution mode
//        options.addArguments("--headless");

        // CI/CD-specific stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Performance & consistency
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");

        return options;
    }

    @BeforeMethod
    public void setUp() {
        // Common setup code for all test cases can be added here.
        driver = new FirefoxDriver(getOptimizedOptions());
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(AssertionError.class)
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);

        actionBot = new ActionBot(wait);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}

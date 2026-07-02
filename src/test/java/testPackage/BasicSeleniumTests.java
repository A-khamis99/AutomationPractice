package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicSeleniumTests {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
       driver  = new ChromeDriver(getOptimizedOptions());
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://www.example.com");
        System.out.println("Page title is: " + driver.getTitle());
    }
    public static ChromeOptions getOptimizedOptions() {
        ChromeOptions options = new ChromeOptions();

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

}

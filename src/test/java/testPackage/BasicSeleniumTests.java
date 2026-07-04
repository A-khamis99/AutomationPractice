package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicSeleniumTests {

    WebDriver driver;

    @Test


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

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(getOptimizedOptions());
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

    @Test
    public void checkPageTitle() {

        driver.navigate().to("//duckduckgo.com");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google");
    }

    @Test
    public void checkVisibilityOfPageLogo() {

        driver.navigate().to("https://duckduckgo.com/");
        // ( //a[@title='Learn about DuckDuckGo']//img)[1]
        By logoLocator = By.xpath("(//a[@title='Learn about DuckDuckGo']//img)[1]");
        var s = driver.findElement(logoLocator).isDisplayed();
        System.out.println("Is the DuckDuckGo logo displayed? " + s);
        Assert.assertTrue(driver.findElement(logoLocator).isDisplayed());
    }

    @Test
    public void validateSearchResultsForSelenuim() {

        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.id("searchbox_input")).sendKeys("Selenium WebDriver" + Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#r1-0 a[data-testid=result-title-a]")));
        String URL = driver.findElement(By.cssSelector("#r1-0 a[data-testid=result-title-a]")).getDomAttribute("href");
        System.out.println("URL of the 1st search result is: " + URL);
//        driver.findElement(By.cssSelector("#r1-0 a[data-testid=result-title-a]")).click();
//        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.selenium.dev/documentation/webdriver/");
    }

    @Test
    public void validateSearchResultsForTestNG() {

        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.id("searchbox_input")).sendKeys("TestNG" + Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#r1-0 a[data-testid=result-title-a]")));
        String title = driver.findElement(By.cssSelector("#r1-3 a[data-testid=result-title-a]")).getText();
        System.out.println("Title of the 4th search result is: " + title);
        Assert.assertTrue(title.contains("TestNG Tutorial"));

    }

    @Test
    public void validateSearchResultsForCucumberIO() {

        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.id("searchbox_input")).sendKeys("Cucumber IO" + Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#r1-0 a[data-testid=result-title-a]")));
        driver.findElement(By.cssSelector("#r1-1 a[data-testid=result-title-a]")).click();
        String URL = driver.getCurrentUrl();
        System.out.println("URL of the 2nd search result is: " + URL);
        Assert.assertTrue((URL.contains("https://www.linkedin.com")));
    }

    @Test
    public void validateCheckBoxes() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.findElement(By.cssSelector("#checkboxes >input:nth-of-type(1)")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#checkboxes >input:nth-of-type(1)")).isSelected());

    }

    @Test
    public void validateTableData() {

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        String companyName = driver.findElement(By.cssSelector("#customers > tbody > tr:nth-child(4)> td:nth-child(1)")).getText();
        String companyCountry = driver.findElement(By.cssSelector("#customers > tbody > tr:nth-child(4)> td:nth-child(3)")).getText();
        Assert.assertTrue(companyName.equals("Ernst Handel") && companyCountry.equals("Austria"));
    }

    @Test
    public void validateUploadAction() {

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\EXPRESS\\OneDrive\\Documents\\GitHub\\AutomationPractice\\src\\test\\resources\\letter-j.png");
        driver.findElement(By.id("file-submit")).click();
        String uploadedFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(uploadedFileName, "letter-j.png");
    }
}

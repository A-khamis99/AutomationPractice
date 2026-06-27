package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicSeleniumTests {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
       driver  = new EdgeDriver();
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

}

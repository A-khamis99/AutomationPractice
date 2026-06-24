package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void test() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.example.com");
    }
}

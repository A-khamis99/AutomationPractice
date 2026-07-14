package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class ActionBot {

    Wait<WebDriver> wait;

    public ActionBot(Wait<WebDriver> wait) {
        this.wait = wait;
    }

    public void navigateTo(String url) {
        wait.until(driver -> {
            System.out.println("Start navigation to: " + url);
            driver.get(url);
            System.out.println("Navigated to: " + url);
            return true;
        });
    }

    public void assertPageTitle(String expectedTitle) {

        wait.until(driver -> {

            System.out.println("Asserting page title...");
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, " Page title does not match. Expected");
            System.out.println("Page title assertion passed: " + actualTitle);
            return true;
        });
    }

    public void assertElementVisibility(By locator) {
        wait.until(driver -> {
            System.out.println("Asserting visibility of element: " + locator);
            boolean isVisible = driver.findElement(locator).isDisplayed();
            Assert.assertTrue(isVisible, "Element is not visible: " + locator);
            System.out.println("Element visibility assertion passed: " + locator);
            return true;
        });
    }

    public void performSearch(By locator, String query) {
        wait.until(driver -> {
            System.out.println("Performing search for: " + query);
            driver.findElement(locator).sendKeys(query + Keys.ENTER);
            System.out.println("Search performed for: " + query);
            return true;
        });
    }

    public void validateFirstSearchResultURL(By locator, String expectedURL) {
        wait.until(driver -> {
            System.out.println("Validating first search result URL...");
            String actualURL = driver.findElement(locator).getDomAttribute("href");
            Assert.assertEquals(actualURL, expectedURL, "First search result URL does not match. Expected: " + expectedURL + ", but got: " + actualURL);
            System.out.println("First search result URL validation passed: " + actualURL);
            return true;
        });
    }

}

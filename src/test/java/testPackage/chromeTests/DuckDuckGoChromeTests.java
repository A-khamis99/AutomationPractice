package testPackage.chromeTests;

import org.testng.annotations.Test;
import pages.DuckDuckGoHome;
import templates.ChromeTestCase;

public class DuckDuckGoChromeTests extends ChromeTestCase {

    // This class serves as a page object model for the DuckDuckGo search engine.
    // You can add methods to interact with the DuckDuckGo page, such as performing searches
    // and retrieving search results. This helps in keeping the test code clean and maintainable.

    @Test
    public void validatePageTitle() {
        // Implement the logic to validate the page title of DuckDuckGo.
        new DuckDuckGoHome(actionBot).navigateToDuckDuckGo()
                .validatePageTitle("DuckDuckGo - Protection. Privacy. Peace of mind.");
    }

    @Test
    public void validateLogoVisibility() {
        // Implement the logic to validate the visibility of the DuckDuckGo logo.
        new DuckDuckGoHome(actionBot).navigateToDuckDuckGo()
                .ValidateLogoVisibility();
    }

    @Test
    public void validateSearchResultsForSelenium() {
        // Implement the logic to validate the search results for "Selenium WebDriver".
        new DuckDuckGoHome(actionBot).navigateToDuckDuckGo()
                .performSearch("Selenium WebDriver")
                .validateFirstSearchResultURL("https://www.selenium.dev/documentation/webdriver/");
    }

    @Test
    public void validateSearchResultsForTestNG() {
        // Implement the logic to validate the search results for "TestNG".
        new DuckDuckGoHome(actionBot).navigateToDuckDuckGo()
                .performSearch("Cucumber IO")
                .validateSecondSearchResultURL("https://www.linkedin.com");
    }


}

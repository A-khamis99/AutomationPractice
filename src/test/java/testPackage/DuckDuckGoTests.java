package testPackage;

import engine.DuckDuckGo;
import org.testng.annotations.Test;
import templates.TestCase;

public class DuckDuckGoTests extends TestCase {

    // This class serves as a page object model for the DuckDuckGo search engine.
    // You can add methods to interact with the DuckDuckGo page, such as performing searches
    // and retrieving search results. This helps in keeping the test code clean and maintainable.

    @Test
    public void validatePageTitle() {
        // Implement the logic to validate the page title of DuckDuckGo.
        new DuckDuckGo(actionBot).navigateToDuckDuckGo()
                .validatePageTitle("DuckDuckGo - Protection. Privacy. Peace of mind.");
    }

    @Test
    public void validateLogoVisibility() {
        // Implement the logic to validate the visibility of the DuckDuckGo logo.
        new DuckDuckGo(actionBot).navigateToDuckDuckGo()
                .ValidateLogoVisibility();
    }


}

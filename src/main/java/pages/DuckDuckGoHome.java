package pages;

import engine.ActionBot;
import org.openqa.selenium.By;

public class DuckDuckGoHome {

    ActionBot duckDuckGoBot;
    By logoLocator = By.xpath("(//a[@title='Learn about DuckDuckGo']//img)[2]");
    By searchLocator = By.xpath("//input[@id='searchbox_input']");

    public DuckDuckGoHome(ActionBot duckDuckGoBot) {
        this.duckDuckGoBot = duckDuckGoBot;
    }

    public DuckDuckGoHome navigateToDuckDuckGo() {
        duckDuckGoBot.navigateTo("https://duckduckgo.com");
        return this;
    }

    public DuckDuckGoHome validatePageTitle(String expectedTitle) {
        duckDuckGoBot.assertPageTitle(expectedTitle);
        return this;
    }

    public DuckDuckGoHome ValidateLogoVisibility() {
        duckDuckGoBot.assertElementVisibility(logoLocator);
        return this;
    }

    public DuckDuckGoSearchPage performSearch(String query) {
        duckDuckGoBot.performSearch(searchLocator, query);
        return new DuckDuckGoSearchPage(duckDuckGoBot);
    }


}

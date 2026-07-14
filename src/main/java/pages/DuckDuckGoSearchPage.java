package pages;

import engine.ActionBot;
import org.openqa.selenium.By;

public class DuckDuckGoSearchPage {

    ActionBot duckDuckGoSearchBot;
    By firstSearchResultsLocator = By.xpath("//article[@id='r1-0']//h2//a");
    By secondSearchResult = By.xpath("//article[@id='r1-1']//h2//a");

    public DuckDuckGoSearchPage(ActionBot Bot) {
        this.duckDuckGoSearchBot = Bot;
    }

    public void validateFirstSearchResultURL(String expectedURL) {
        duckDuckGoSearchBot.validateFirstSearchResultURL(firstSearchResultsLocator, expectedURL);
    }

    public void validateSecondSearchResultURL(String expectedURL) {
        duckDuckGoSearchBot.validateFirstSearchResultURL(secondSearchResult, expectedURL);
    }

}

package pages;

import engine.ActionBot;
import org.openqa.selenium.By;

public class DuckDuckGoSearchPage {

    ActionBot duckDuckGoSearchBot;
    By firstSearchResultsUrlLocator = By.xpath("//article[@id='r1-0']//h2//a");
    By secondSearchResultUrlLocator = By.xpath("//article[@id='r1-1']//h2//a");
    By fourthSearchResultTextLocator = By.xpath("//article[@id='r1-3']//h2//a//span");

    public DuckDuckGoSearchPage(ActionBot Bot) {
        this.duckDuckGoSearchBot = Bot;
    }

    public void validateFirstSearchResultURL(String expectedURL) {
        duckDuckGoSearchBot.validateSearchResultURL(firstSearchResultsUrlLocator, expectedURL);
    }

    public void validateSecondSearchResultURL(String expectedURL) {
        duckDuckGoSearchBot.validateSearchResultURL(secondSearchResultUrlLocator, expectedURL);
    }

    public void validateFourthSearchResultText(String expectedText) {
        duckDuckGoSearchBot.validateSearchResultText(fourthSearchResultTextLocator, expectedText);
    }

}

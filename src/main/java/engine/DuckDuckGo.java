package engine;

import org.openqa.selenium.By;

public class DuckDuckGo {

    ActionBot duckDuckGoBot;
    By logoLocator = By.xpath("(//a[@title='Learn about DuckDuckGo']//img)[2]");

    public DuckDuckGo(ActionBot duckDuckGoBot) {
        this.duckDuckGoBot = duckDuckGoBot;
    }

    public DuckDuckGo navigateToDuckDuckGo() {
        duckDuckGoBot.navigateTo("https://duckduckgo.com");
        return this;
    }

    public DuckDuckGo validatePageTitle(String expectedTitle) {
        duckDuckGoBot.assertPageTitle(expectedTitle);
        return this;
    }

    public DuckDuckGo ValidateLogoVisibility() {
        duckDuckGoBot.assertElementVisibility(logoLocator);
        return this;
    }


}

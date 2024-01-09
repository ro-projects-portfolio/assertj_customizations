package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * This class represent page object of Google Search Page.
 * Extend {@link BasePage} and provides common functionality and initialization for this page.
 */
public class SearchPage extends BasePage {

    @FindBy(id = "APjFqb")
    private WebElement searchWidget;
    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']/center/input[@role='button']")
    private WebElement searchBtn;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Opens the Google Search Page.
     */
    public void open() {
        this.driver.get("https://www.google.com/");
    }

    /**
     * Enters the search query in the search input field.
     *
     * @param searchObject The search query to be entered.
     */
    public void search(String searchObject) {
        this.searchWidget.sendKeys(searchObject);
    }

    public WebElement getSearchWidget() {
        return this.searchWidget;
    }

    public WebElement getSearchBtn() {
        return this.searchBtn;
    }

    /**
     * Checks if the Google Search Page is loaded.
     *
     * @return True if the page title contains "Google," indicating a successful load.
     */
    @Override
    public boolean isLoaded() {
        return this.driver.getTitle().contains("Google");
    }
}

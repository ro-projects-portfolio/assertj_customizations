package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * An abstract base (template) class for page objects.
 * Provides common functionality and initialization for page objects.
 */
public abstract class BasePage {
    // Use protected fields to get access only in subclasses
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }


    // Based on this method will be created our custom Page Assertion (Should be public)
    public abstract boolean isLoaded(); // Any logic can be applied to check if the page is loaded (compare Url, Title etc)

}

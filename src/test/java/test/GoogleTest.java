package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;

public class GoogleTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeMethod
    public void initializePages () {
        this.searchPage = new SearchPage(driver); // Initialize Page before test execution, using driver instance from Base Test
    }

    @Test
    public void launchSite () {
        this.searchPage.open();
        assertThat(this.searchPage) // Method inside Base Test allow use without creating object of PageAssert class
                .isOpen(); // isOpen()(related to our FA) check condition based on isLoaded()
    }

    @Test (dependsOnMethods = "launchSite") // Dependent test (not good practice)
    public void elementValidation () {
        assertThat(this.searchPage.getSearchWidget()) // Validation of search field
                .isDisplayed()
                .isEnabled();
                //.isInputTextField();

        assertThat(this.searchPage.getSearchBtn()) // Validation of search button
                .isEnabled()
                .isDisplayed()
                .isButton();
    }
}

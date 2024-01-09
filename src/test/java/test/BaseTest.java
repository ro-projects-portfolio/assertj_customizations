package test;

import custom.PageAssert;
import custom.WebElementAssert;
import custom.WebElementSoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

import java.util.function.Consumer;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Use WebDriverManager to keep browser up to date
        this.driver = new ChromeDriver();
    }

    /**
     * Provides a fluent interface for making assertions
     * The method create {@link WebElementAssert} instance to perform assertions on a specific {@link WebElement}
     *
     * @param element on which assertions will be performed
     * @return instance for fluent assertion chaining
     */
    protected WebElementAssert assertThat(WebElement element) {
        return WebElementAssert.assertThat(element);
    } // Keep this method in your base test or utility class. (This is execute-around method design pattern)

    /**
     * Soft Assert method that allows to apply custom assertion for {@link WebElement}
     *
     * @param assertConsumer method takes a {@link Consumer} as a parameter,
     *                       where the {@link Consumer} represents a block of assertions to be performed on a {@link WebElementSoftAssert} instance
     * @see WebElementAssert
     */
    protected void assertSoftly(Consumer<WebElementSoftAssert> assertConsumer) {
        WebElementSoftAssert softAssert = new WebElementSoftAssert();
        assertConsumer.accept(softAssert);
        softAssert.assertAll();// This method provided by SoftAssertions. This method checks all the collected assertions, and if any of them failed, it throws an exception.
    } // Keep this method in your base test or utility class. (This is execute-around method design pattern)

    /**
     * Provides a fluent interface for making assertions
     * The method create {@link PageAssert} instance to perform assertions on a specific Page
     *
     * @param basePage on which assertions will be performed
     * @return instance for fluent assertion chaining
     */
    protected PageAssert assertThat(BasePage basePage){
        return PageAssert.assertThat(basePage);
    } // Keep this method in your base test or utility class. (This is execute-around method design pattern)

    @AfterTest
    public void quit() {
        this.driver.quit();
    }
}

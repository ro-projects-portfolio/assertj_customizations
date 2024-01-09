package test;

import custom.WebElementAssert;
import custom.WebElementSoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class WebElementTest {
    private WebElement searchWidget;
    private WebElement searchBtn;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        searchWidget = driver.findElement(By.id("APjFqb"));
        searchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@role='button']"));
    }

    @Test
    public void searchWidget() {
        assertThat(this.searchWidget)
                .isEnabled()
                .isDisplayed()
                .hasAttributeValue("id", "APjFqb");
    }

    @Test
    public void searchWidgetSoft() {
        // Same test as above but using AssertJ Soft
        assertSoftly(softAssertions -> softAssertions.
                assertThat(this.searchWidget)
                .isEnabled()
                .isDisplayed()
                .hasAttributeValue("id", "APjFqb")
        );
    }

    @Test
    public void searchBtn() {
        assertThat(this.searchBtn)
                .isDisplayed()
                .isEnabled()
                .isButton();
    }

    /**
     * Provides a fluent interface for making assertions
     * The method create {@link WebElementAssert} instance to perform assertions on a specific {@link WebElement}
     *
     * @param element on which assertions will be performed
     * @return instance for fluent assertion chaining
     */
    private WebElementAssert assertThat(WebElement element) {
        return WebElementAssert.assertThat(element);
    } // Put this method in your base test or utility class. (This is execute-around method design pattern)

    /**
     * Soft Assert method that allows to apply custom assertion for {@link WebElement}
     *
     * @param assertConsumer method takes a {@link Consumer} as a parameter,
     *                       where the {@link Consumer} represents a block of assertions to be performed on a {@link WebElementSoftAssert} instance
     * @see WebElementAssert
     */
    private void assertSoftly(Consumer<WebElementSoftAssert> assertConsumer) {
        WebElementSoftAssert softAssert = new WebElementSoftAssert();
        assertConsumer.accept(softAssert);
        softAssert.assertAll();// This method provided by SoftAssertions. This method checks all the collected assertions, and if any of them failed, it throws an exception.
    } // Put this method in your base test or utility class. (This is execute-around method design pattern)

    @AfterMethod
    public void after() {
        driver.quit();
    }
}

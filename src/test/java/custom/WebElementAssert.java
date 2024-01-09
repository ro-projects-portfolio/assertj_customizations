package custom;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

/**
 * Custom assertion class for {@link WebElement} objects, providing fluent assertions for common conditions.
 * Extends {@link AbstractAssert} for use with AssertJ.
 */
public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    /**
     * Static factory method for creating a new {@link WebElementAssert} instance.
     *
     * @param webElement The {@link WebElement} to perform assertions on.
     * @return A new instance of {@link WebElementAssert}.
     */
    public static WebElementAssert assertThat(WebElement webElement) {
        return new WebElementAssert(webElement);
    } // This method if you want to call it without calling class (using static import)

    /**
     * Asserts that the {@link WebElement} is displayed.
     *
     * @return This {@link WebElementAssert} for further assertions.
     */
    public WebElementAssert isDisplayed() {
        isNotNull();

        // Check condition
        if (!actual.isDisplayed())
            failWithMessage("Expected element is not displayed!");

        return this;
    }

    /**
     * Asserts that the {@link WebElement} is enabled.
     *
     * @return This {@link WebElementAssert} for further assertions.
     */
    public WebElementAssert isEnabled() {
        isNotNull();

        // Check condition
        if (!actual.isEnabled())
            failWithMessage("Expected element is not enable!");

        return this;
    }

    /**
     * Asserts that the {@link WebElement} is a button.
     *
     * @return This {@link WebElementAssert} for further assertions.
     */
    public WebElementAssert isButton() {
        isNotNull();

        // Add and check condition
        if (!(actual.getTagName().equalsIgnoreCase("input")
                && actual.getAttribute("role").equalsIgnoreCase("button")))
            failWithMessage("Expected element is not a button!");
        // This one It is specific condition for Google Search Page
        // Commonly for buttons use tag <button> or attribute type="button"
        //  (actual.getTagName().equalsIgnoreCase("button") || actual.getAttribute("type").equalsIgnoreCase("button"))

        return this;
    }

    /**
     * Asserts that the {@link WebElement} is a link.
     *
     * @return This {@link WebElementAssert} for further assertions.
     */
    public WebElementAssert isLink() {
        isNotNull();

        // Add and check condition
        if (!actual.getTagName().equalsIgnoreCase("a"))
            failWithMessage("Expected element is not a link!");

        return this;
    }

    /**
     * Asserts that the {@link WebElement} has the specified attribute with the given value.
     *
     * @param attribute The attribute to check.
     * @param value     The expected value of the attribute.
     * @return This {@link WebElementAssert} for further assertions.
     */
    public WebElementAssert hasAttributeValue(String attribute, String value) {
        isNotNull();

        // Check condition
        if (!actual.getAttribute(attribute).equals(value))
            failWithMessage("Expected element have not attribute <%s>  with value as <%s>!", attribute, value);

        return this;
    }
    /**
     * Asserts that the {@link WebElement} is a input text field.
     *
     * @return This {@link WebElementAssert} for further assertions.
     */
    public WebElementAssert isInputTextField() {
        isNotNull();

        // Add and check condition
        if (!(actual.getTagName().equalsIgnoreCase("textarea")
                && actual.getAttribute("type").equalsIgnoreCase("search")))
            failWithMessage("Expected element is not a input search field!"); // In real time need to be found a common parameters

        return this;
    }

}

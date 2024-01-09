package custom;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

/**
 * Custom class {@link WebElementSoftAssert} extends {@link SoftAssertions},
 * which is a class from the AssertJ library that provides soft assertion functionality.
 * Soft assertions allow you to collect multiple assertion failures before throwing an exception.
 * Extends {@link SoftAssertions}
 */
public class WebElementSoftAssert extends SoftAssertions {

    /**
     * The method returns an instance of the class {@link WebElementAssert}.
     * This suggests that it's used for creating and returning an assertion object for a {@link WebElement}.
     *
     * @param actual The {@link WebElement} object on which assertions will be performed.
     * @return The method returns the dynamically created proxy instance,
     * which allows you to perform assertions specific to {@link WebElement} through the {@link WebElementAssert}
     */
    public WebElementAssert assertThat(WebElement actual){
        return proxy(WebElementAssert.class, WebElement.class, actual);
    }

}

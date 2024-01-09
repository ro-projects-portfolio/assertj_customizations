package custom;

import org.assertj.core.api.AbstractAssert;
import pages.BasePage;

/**
 * Custom assertion class for Page objects, providing fluent assertions for common conditions.
 * Extends {@link AbstractAssert} for use with AssertJ.
 */
public class PageAssert extends AbstractAssert<PageAssert, BasePage> {

    public PageAssert(BasePage basePage) {
        super(basePage, PageAssert.class);
    }

    /**
     * Static factory method for creating a new {@link PageAssert} instance.
     *
     * @param page The instance of {@link BasePage} to perform assertions on.
     * @return A new instance of {@link PageAssert}.
     */
    public static PageAssert assertThat(BasePage page) {
        return new PageAssert(page);
    }

    /**
     * Asserts that the page is open.
     *
     * @return This {@link PageAssert} for further assertions.
     */
    public PageAssert isOpen() {
        isNotNull();
        if (!actual.isLoaded()) {
            failWithMessage("Page is not displayed");
        }
        return this;
    }

}

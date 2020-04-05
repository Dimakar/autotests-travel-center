package org.example.stepdefs;

import cucumber.api.java.ru.И;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.context.PageContext;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;

public class CommonStepDefs {

    @И("^(?:пользователь |он )? проверяет что css-аттрибут \"([^\"]*)\" элемента \"([^\"]*)\" равен \"([^\"]*)\"$")
    public void checkEmpty(String cssAttribute, String elementTitle, String attributeValue) throws PageException {
        WebElement webElement = getElement(elementTitle);
        String attributeValueFromPage = webElement.getCssValue(cssAttribute);
        Assert.assertEquals(attributeValue, attributeValueFromPage);
    }

    private <E> E getElement(String elementTitle) throws PageException {
        Page currentPage = PageContext.getCurrentPage();
        if (currentPage == null) {
            throw new PageException("Current page is undefined. Please execute \"open page\" step first");
        } else {
            return Environment.getFindUtils().getElementByTitle(PageContext.getCurrentPage(), elementTitle);
        }
    }
}

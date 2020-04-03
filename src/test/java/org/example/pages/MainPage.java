package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.api.junit.ApiSteps;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.actions.PageActions;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.web.environment.WebEnvironment;

@PageEntry(title = "Главная страница center.travel")
public class MainPage extends WebPage {

    @ElementTitle("Войти")
    @FindBy(xpath = "//a[@href='https://online.center.travel/']")
    public WebElement login;

}

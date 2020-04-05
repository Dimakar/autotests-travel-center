package org.example.pages;

import org.example.pages.blocks.DesktopHeaderBlock;
import org.example.pages.blocks.InputUserDataModalBlock;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.api.junit.ApiSteps;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.actions.PageActions;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.environment.Environment;
import ru.sbtqa.tag.pagefactory.web.environment.WebEnvironment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@PageEntry(title = "Главная страница center.travel", url = "https://center.travel/")
public class MainPage extends HTMLPage {

    @ElementTitle("Header")
    public DesktopHeaderBlock desktopHeaderBlock;

    @ElementTitle("Модальное окно ввода данных")
    public InputUserDataModalBlock inputUserDataModalBlock;

    @ElementTitle("Получить доступ : Сервис оформления командировок")
    @FindBy(xpath = "//div[h1[.='Сервис оформления командировок']]/button[span[.='Получить доступ']]")
    public WebElement getAccess;

    @ElementTitle("Получить доступ : Руководителю")
    @FindBy(xpath = "//div[span[.='Руководителю']]/button[span[.='Получить доступ']]")
    public WebElement getAccessManager;

}

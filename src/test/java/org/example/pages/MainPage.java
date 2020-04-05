package org.example.pages;

import org.example.pages.blocks.DesktopHeaderBlock;
import org.example.pages.blocks.InputUserDataModalBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

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

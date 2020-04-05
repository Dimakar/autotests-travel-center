package org.example.pages;

import org.example.pages.blocks.DesktopHeaderBlock;
import org.example.pages.blocks.InputUserDataModalBlock;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.WebPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Дополнительные услуги")
public class ServicePage extends HTMLPage {

    @ElementTitle("Header")
    public DesktopHeaderBlock desktopHeaderBlock;

    @ElementTitle("Модальное окно ввода данных")
    public InputUserDataModalBlock inputUserDataModalBlock;

    @ElementTitle("Воспользоваться услугами")
    @FindBy(xpath = "//button[span[.='Воспользоваться услугами']]")
    public WebElement useService;
}

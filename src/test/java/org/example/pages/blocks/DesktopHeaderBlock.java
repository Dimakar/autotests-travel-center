package org.example.pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//header[contains(@class,'DesktopHeader')]")
public class DesktopHeaderBlock extends HtmlElement {
    @ElementTitle("Войти в систему")
    @FindBy(xpath = ".//li[a[@href='https://online.center.travel/']]")
    public WebElement login;

    @ElementTitle("Организация командировок")
    @FindBy(xpath = ".//li[a[.='Организация командировок']]")
    public WebElement travelArrangements;

    @ElementTitle("Дополнительные услуги")
    @FindBy(xpath = ".//li[a[.='Дополнительные услуги']]")
    public WebElement services;

    @ElementTitle("Контакты")
    @FindBy(xpath = ".//li[.='Контакты']")
    public WebElement contacts;


}

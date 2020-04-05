package org.example.pages.blocks;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//div[@id='modal']")
public class InputUserDataModalBlock extends HtmlElement {

    @ElementTitle("Отправить")
    @FindBy(xpath = ".//button[span[.='Отправить']]")
    public WebElement send;

    @ElementTitle("Имя")
    @FindBy(xpath = ".//input[@placeholder='Имя']")
    public WebElement name;

    @ElementTitle("Телефон")
    @FindBy(xpath = ".//input[@placeholder='Телефон']")
    public WebElement mobile;

    @ElementTitle("Почта")
    @FindBy(xpath = ".//input[@placeholder='Почта']")
    public WebElement email;

    @ElementTitle("Название компании")
    @FindBy(xpath = ".//input[@placeholder='Название компании']")
    public WebElement company;

    @ElementTitle("Закрыть модальное окно")
    @FindBy(xpath = ".//div[contains(@class, 'Popupstyles__Close-sc-1ksdb1j-3 bfoHnB')]")
    public WebElement closeModal;

    @ElementTitle("Подпись 'Телефон'")
    @FindBy(xpath = ".//div[input[@placeholder='Телефон']]/following::div[.='Телефон']")
    public WebElement noteMobile;

    @ActionTitle(value = "проверяет что номер телефона отображается корректно")
    public void check(String mobile) {
        String mobileFromSite = this.mobile.getAttribute("value");
        StringBuilder formatted = new StringBuilder();

        //преобразуем телефон в формат как должно быть на сайте
        int length = Math.min(mobile.length(), 11);
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                formatted.append("+");
            }
            formatted.append(mobile.charAt(i));
            if (i == 0) {
                formatted.append("(");
            } else if (i == 3) {
                formatted.append(")");
            } else if ((i == 6) || (i == 8)) {
                formatted.append("-");
            }
        }
        Assert.assertEquals(formatted.toString(), mobileFromSite);
    }
}

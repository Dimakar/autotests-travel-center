package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.HTMLPage;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

@PageEntry(title = "Страница авторизации")
public class LoginPage extends HTMLPage {
    @ElementTitle("Электронная почта")
    @FindBy(xpath = "//input[@placeholder='Электронная почта']")
    public WebElement email;

    @ElementTitle("Пароль")
    @FindBy(xpath = "//input[@placeholder='Пароль']")
    public WebElement password;

    @ElementTitle("Войти")
    @FindBy(xpath = "//button[.='Войти']")
    public WebElement enter;

//    @ElementTitle("Всплывающая подсказка")
//    @FindBy(xpath = "//div[@class='tippy-popper']//span")
//    public WebElement tippyPopper;

//    @ActionTitle(value = "проверяет наличие подсказки Неверный пароль или адрес электронной почты")
//    public void check() {
//        // TODO: 25.04.2020 добавить обработчик ошибок
//        Assert.assertEquals(tippyPopper.getText(), "Неверный пароль или адрес электронной почты");
//    }
}

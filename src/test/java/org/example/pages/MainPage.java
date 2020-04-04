package org.example.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.api.junit.ApiSteps;
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
public class MainPage extends WebPage {

    @ElementTitle("Войти")
    @FindBy(xpath = "//a[@href='https://online.center.travel/']")
    public WebElement login;

//    кнопки получить доступ
    @ElementTitle("Получить доступ : Сервис оформления командировок")
    @FindBy(xpath = "//div[h1[.='Сервис оформления командировок']]/button[span[.='Получить доступ']]")
    public WebElement getAccess;

    @ElementTitle("Получить доступ : Руководителю")
    @FindBy(xpath = "//div[span[.='Руководителю']]/button[span[.='Получить доступ']]")
    public WebElement getAccessManager;

    @ElementTitle("Получить доступ : Тревел-координатору")
    @FindBy(xpath = "//div[span[.='Тревел-координатору']]/button[span[.='Получить доступ']]")
    public WebElement getAccessCoordinator;

    @ElementTitle("Получить доступ : Бухгалтеру>")
    @FindBy(xpath = "//div[span[.='Бухгалтеру']]/button[span[.='Получить доступ']]")
    public WebElement getAccessBooker;

    @ElementTitle("Получить доступ : Сотруднику")
    @FindBy(xpath = "//div[span[.='Сотруднику']]/button[span[.='Получить доступ']]")
    public WebElement getAccessEmployee;

    @ElementTitle("Получить доступ : Начните пользоваться")
    @FindBy(xpath = "//div[h3[.='Начните пользоваться']]/button[span[.='Получить доступ']]")
    public WebElement getAccessStartToUse;

    @ElementTitle("Подробнее")
    @FindBy(xpath = "//button[span[a[.='Подробнее']]]")
    public WebElement moreDetails;

//    модальное окно получить доступ
    @ElementTitle("Имя")
    @FindBy(xpath = "//div[@id='modal']//input[@placeholder='Имя']")
    public WebElement name;

    @ElementTitle("Телефон")
    @FindBy(xpath = "//div[@id='modal']//input[@placeholder='Телефон']")
    public WebElement mobile;

    @ElementTitle("Почта")
    @FindBy(xpath = "//div[@id='modal']//input[@placeholder='Почта']")
    public WebElement email;

    @ElementTitle("Название компании")
    @FindBy(xpath = "//div[@id='modal']//input[@placeholder='Название компании']")
    public WebElement company;

    @ElementTitle("Закрыть модальное окно")
    @FindBy(xpath = "//div[@id='modal']//div[contains(@class, 'Popupstyles__Close-sc-1ksdb1j-3 bfoHnB')]")
    public WebElement closeModal;

    @ActionTitle(value = "проверяет что номер телефона корректный")
    public void check(String mobile) {
        String mobileFromSite = this.mobile.getAttribute("value");
        Pattern pattern = Pattern.compile("\\+\\d{1}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}");
        Assert.assertEquals(pattern.matcher(mobileFromSite).matches(), true);
        Assert.assertEquals(mobileFromSite
                .replaceAll("[^0-9]", ""), mobile);
    }
}

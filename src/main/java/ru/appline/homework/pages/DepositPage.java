package ru.appline.homework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static ru.appline.homework.utils.Parser.parseToInt;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//span[text()='Рубли']")
    WebElement RUB;

    @FindBy(xpath = "//span[text()='Доллары США']")
    WebElement USD;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement amount;

    @FindBy(xpath = "//input[@name='replenish']")
    WebElement monthlyReplenish;

    @FindBy(xpath = "//select")
    WebElement selectElement;

    @FindBy(xpath = "//span[text()='Ежемесячная капитализация']")
    WebElement monthlyCapitalization;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement accrual;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement result;

    /**
     * Метод позволяющий выбрать валюту депозита
     *
     * @param text - название валюты (рубли/доллары)
     * @return остаемся на данной странице
     */
    @Step("Выбрать ${text}, как валюту вклада ")
    public DepositPage chooseCurrency(String text) {
        switch (text.toLowerCase()) {
            case ("рубли"):
                actions.moveToElement(RUB).click().build().perform();
                break;

            case ("доллары"):
                actions.moveToElement(USD).click().build().perform();
                break;

            default:
                Assertions.fail("Валюта " + text + " отсутствует на сайте");
        }
        return app.getDepositPage();
    }

    /**
     * Метод заполняющий поля
     *
     * @param text  - название поля (сумма вклада/ежемесячное пополнение/срок)
     * @param value - значение поля
     * @return Остаемся на данной странице
     */
    @Step("Заполнить поле ${text} значением ${value}")
    public DepositPage fillField(String text, String value) {
        switch (text.toLowerCase()) {
            case ("сумма вклада"):
                fillFieldBase(amount, value);
                break;
            case ("ежемесячное пополнение"):
                fillFieldBase(monthlyReplenish, value);
                break;
            case ("срок"):
                chooseDropDown(value);
                break;
            default:
                Assertions.fail("Поле с именем " + text + " отсутствует на странцие");
        }
        return app.getDepositPage();
    }

    /**
     * Метод позволяющий выбрать опцию
     *
     * @param text - название опции (ежемесячная капитализация)
     * @param flag - значение чекбокса (true - включить опцию, false - отключить опцию)
     * @return Остаемся на данной странице
     */
    @Step("Выбрать опцию ${text}")
    public DepositPage chooseOption(String text, boolean flag) {
        switch (text.toLowerCase()) {
            case ("ежемесячная капитализация"):
                chooseOptionBase(monthlyCapitalization, flag);
        }
        return app.getDepositPage();
    }

    /**
     * Метод для проверки полей страницы Вклады
     *
     * @param text  - название поля (начислено/пополнение/к снятию)
     * @param value - значение поля
     * @return Остаемся на данной странице
     */
    @Step("Проверить, что значение поля ${text} равно ${value}")
    public DepositPage checkDepositResult(String text, String value) {
        switch (text.toLowerCase()) {
            case ("начислено"):
                checkField(accrual, value, text);
                break;
            case ("пополнение"):
                checkField(replenish, value, text);
                break;
            case ("к снятию"):
                checkField(result, value, text);
                break;
            default:
                Assertions.fail("Поля " + text + " не существует на странице");
        }
        return app.getDepositPage();
    }

    /**
     * Метод выбирающий значение в поле "срок"
     *
     * @param value - число месяцев
     */
    private void chooseDropDown(String value) {
        Select select = new Select(selectElement);
        switch (parseToInt(value)) {
            case 3:
                select.selectByValue("3");
                break;
            case 6:
                select.selectByValue("6");
                break;
            case 9:
                select.selectByValue("9");
                break;
            case 12:
                select.selectByValue("12");
                break;
            case 13:
                select.selectByValue("13");
                break;
            case 18:
                select.selectByValue("18");
                break;
            default:
                Assertions.fail("Депозит на данный срок отсутствует");
        }
    }


}

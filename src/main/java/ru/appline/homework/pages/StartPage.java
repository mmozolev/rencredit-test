package ru.appline.homework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//div[text()='Вклады']")
    WebElement deposit;

    /**
     * Метод перехода на страницу Вклады
     *
     * @return Страницу вкладов
     */
    @Step("Перейти на страницу вклады")
    public DepositPage chooseDeposit() {
        actions.moveToElement(deposit).click().build().perform();
        return app.getDepositPage();
    }

}

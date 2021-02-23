package ru.appline.homework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.appline.homework.baseTest.BaseTest;


public class FirstTest extends BaseTest {

    @DisplayName("Проверка страницы Вклады")
    @ParameterizedTest
    @CsvFileSource(resources = "/firstTestData.csv")
    public void test(String a, String b, String c, String d, boolean e, String f, String g, String h){
        app.getStartPage()
                .chooseDeposit()
                .chooseCurrency(a)
                .fillField("сумма вклада", b)
                .fillField("срок", c)
                .fillField("ежемесячное пополнение", d)
                .chooseOption("Ежемесячная капитализация", e)
                .checkDepositResult("начислено", f)
                .checkDepositResult("к снятию", h)
                .checkDepositResult("пополнение", g);
    }
}

package ru.appline.homework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.appline.homework.baseTest.BaseTest;


public class FirstTest extends BaseTest {

    @DisplayName("Проверка страницы Вклады")
    @ParameterizedTest
    @CsvFileSource(resources = "/firstTestData.csv")
    public void test(String a, String b, String c){
        app.getStartPage()
                .chooseDeposit()
                .chooseCurrency(a)
                .fillField("сумма вклада", b)
                .fillField("срок", c)
                .fillField("ежемесячное пополнение", "50000")
                .chooseOption("Ежемесячная капитализация", true)
                .checkDepositResult("начислено", "9 062,40")
                .checkDepositResult("пополнение", "250 000")
                .checkDepositResult("к снятию", "559 062,40");
    }
}

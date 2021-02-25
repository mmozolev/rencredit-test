package ru.appline.homework.utils;

public class Parser {

    public static int parseToInt(String text) {
        return Integer.parseInt(text.replaceAll("[^\\d]", ""));
    }

}

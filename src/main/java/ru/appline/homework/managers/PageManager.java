package ru.appline.homework.managers;

import ru.appline.homework.pages.DepositPage;
import ru.appline.homework.pages.StartPage;


public class PageManager {

    private static PageManager pageManager;

    private static StartPage startPage;

    private static DepositPage depositPage;


    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public DepositPage getDepositPage() {
        if (depositPage == null) {
            depositPage = new DepositPage();
        }
        return depositPage;
    }

}

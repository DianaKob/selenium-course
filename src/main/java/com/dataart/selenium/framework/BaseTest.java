package com.dataart.selenium.framework;

import org.testng.annotations.*;

public class BaseTest {
    private static Settings settings = new Settings();

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() {
        BasePage.driver = settings.getDriver();
        BasePage.settings = settings;
        BasePage.driver.get(settings.getBaseUrl());
        BasePage.driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        BasePage.driver.close();
    }
}

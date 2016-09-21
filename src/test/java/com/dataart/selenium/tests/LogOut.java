package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.BasicPage;
import com.dataart.selenium.pages.HeaderPage;
import com.dataart.selenium.pages.HomePage;
import com.dataart.selenium.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;

/**
 * Created by dianka on 9/11/16.
 */
public class LogOut extends BaseTest {

    private LoginPage loginPage;
    private BasicPage basicPage;
    private HeaderPage headerPage;
    private User user;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        headerPage = initPage(HeaderPage.class);
        homePage = initPage(HomePage.class);
        user = admin();
    }

    @Test
    public void logoutTabSwitchingTest() {
        loginPage.loginAs(user);
        headerPage.assertHeader(user);
        homePage.switchToNewTab();
        homePage.performLogout();
        homePage.switchToPreviousTab();
        homePage.performLinkClick();
        loginPage.assertLoginPage();
    }
}

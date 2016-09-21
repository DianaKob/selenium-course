package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.models.UserBuilder;
import com.dataart.selenium.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.initPage;

/**
 * Created by dianka on 9/11/16.
 */
public class RegistrationTest extends BaseTest {
    private LoginPage loginPage;
    private BasicPage basicPage;
    private RegistrationPage registrationPage;
    private HeaderPage headerPage;
    private User user;
    private User developer;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        registrationPage = initPage(RegistrationPage.class);
        headerPage = initPage(HeaderPage.class);
        homePage = initPage(HomePage.class);
        user = UserBuilder.admin();
        developer = UserBuilder.developer();
    }

    @Test
    public void registerNewUserTest() {
        loginPage.navigateToRegistrationPage();
        registrationPage.registerNewUser(user);
        headerPage.assertHeader(user);
    }

    @Test
    public void registerNewUseVerifyPossibilityOfSecondLoginTest(){
        loginPage.navigateToRegistrationPage();
        registrationPage.registerNewUser(user);
        homePage.performLogout();
        loginPage.loginAs(user);
        headerPage.assertHeader(user);
    }


    @Test
    public void registerAsDeveloperAndOpenUploadPage(){
        loginPage.navigateToRegistrationPage();
        registrationPage.registerNewDeveloper(developer);
        homePage.performApplicationLinkClick();
        homePage.addApplicationclick ();
    }

    @Test
    public void userSeeApplicationButCannotUpload(){
        loginPage.navigateToRegistrationPage();
        user.setUsername(String.valueOf(Math.random() * 10000000).split( "\\.")[0]);
        registrationPage.registerNewUser(user);
        homePage.assertUserCanSeeApplications();
        headerPage.assertMyapplicationLinkNotVisibleToUser();
    }

    ///DDT 5users how to do
}

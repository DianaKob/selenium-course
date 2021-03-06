package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;

/**
 * Created by dianka on 9/15/16.
 */
public class JsTests extends BaseTest {

    private LoginPage loginPage;
    private BasicPage basicPage;
    private RegistrationPage registrationPage;
    private HomePage homepage;
    private HeaderPage headerPage;
    private User user;

    @BeforeMethod
    public void openLoginPage() {
        basicPage = initPage(BasicPage.class);
        loginPage = basicPage.forceLogout();
        headerPage = initPage(HeaderPage.class);
        homepage = initPage(HomePage.class );
        user = admin();
    }

    @Test
    public void jsCoordinates(){
        loginPage.loginAs(user);
        homepage.navigationToJsPage();
        homepage.findJsDiv();

    }
}

package com.dataart.selenium.tests;

import com.dataart.selenium.framework.BaseTest;
import com.dataart.selenium.models.User;
import com.dataart.selenium.pages.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.dataart.selenium.framework.BasePage.initPage;
import static com.dataart.selenium.models.UserBuilder.admin;

/**
 * Created by dianka on 9/12/16.
 */
public class ApplicationTests extends BaseTest{
    private LoginPage loginPage;
    private BasicPage basicPage;
    private RegistrationPage registrationPage;
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
    public void jsonApplicationTest(){
        loginPage.loginAs(user);
        homePage.detailslinkclick();
        HashMap<String, String> savedValues = homePage.getAppValues();
        JsonObject json = (JsonObject) homePage.downloadApplicationclick();
        Assert.assertEquals(json.get("title").getAsString(), savedValues.get("title"));
        Assert.assertEquals(json.getAsJsonObject("author").get("name").getAsString(), savedValues.get("author"));
        Assert.assertEquals(json.getAsJsonObject("category").get("title").getAsString(), savedValues.get("category"));
        Assert.assertTrue(json.get("description").getAsString().contains(savedValues.get("description")));
    }

    @Test
    public void createAppWithoutImages(){
        loginPage.loginAs(user);
        homePage.performApplicationLinkClick();
        homePage.addApplicationclick();
        homePage.createNewApplicationWithoutImage();
        homePage.assertNewApplicationIsDisplayed();
        homePage.newApplicationCanBeDownloaded();
    }

    @Test
    public void editApplicationWithoutImages(){
        loginPage.loginAs(user);
        homePage.performApplicationLinkClick();
        homePage.addApplicationclick();
        homePage.createNewApplicationToEdit();
        homePage.editApplication ();
        homePage.assertEdit();
    }

//clarify order of buttons and uploading method, but works  :) add pictures to recourses
    @Test
   public void createAppWithImage(){
        loginPage.loginAs(user);
        homePage.performApplicationLinkClick();
        homePage.addApplicationclick();
        homePage.createApplication();
    }

    @Test
    public void checkPopularApplication(){
        loginPage.loginAs(user);
        homePage.performApplicationLinkClick();
        homePage.addApplicationclick();
        homePage.createApplication();
        homePage.downloadXTimes();
        homePage.assertLocationInPopular();
    }


    @Test
    public void deleteApp(){
        loginPage.loginAs(user);
        homePage.performApplicationLinkClick();
        homePage.addApplicationclick();
        homePage.createNewApplicationToDelete();
        homePage.deleteApplication();
    }
}

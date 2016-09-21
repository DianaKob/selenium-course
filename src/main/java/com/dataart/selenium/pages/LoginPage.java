package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage  {

    public static final String USER_NAME_TEXT_FIELD_ID = "j_username";
    public static final String USER_PASSWORD_TEXT_FIELD_ID = "j_password";
    public static final String LOGIN_BUTTON_XPATH = "//input[@value='Login']";
    public static final String REGISTRATION_LINK_CSS = "div.form>a";

    @FindBy(id = USER_NAME_TEXT_FIELD_ID)
    WebElement userNameTextField;
    @FindBy(id = USER_PASSWORD_TEXT_FIELD_ID)
    WebElement passwordTextField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    WebElement loginButton;
    @FindBy(css = REGISTRATION_LINK_CSS)
    WebElement registrationLink;

    public HomePage loginAs(User user) {
        userNameTextField.clear();
        passwordTextField.clear();

        userNameTextField.sendKeys(user.getUsername());
        passwordTextField.sendKeys(user.getPassword());

        loginButton.click();
        return initPage(HomePage.class);
    }

    public RegistrationPage navigateToRegistrationPage() {
        registrationLink.click();
        return initPage(RegistrationPage.class);
    }

    public void assertLoginPage(){
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/auth/login"));
        Assert.assertEquals(driver.findElement(By.cssSelector(".form > h1")).getText(), "Login");
    }

}

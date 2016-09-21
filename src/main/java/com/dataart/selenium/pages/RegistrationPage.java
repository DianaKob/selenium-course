package com.dataart.selenium.pages;

import com.dataart.selenium.framework.BasePage;
import com.dataart.selenium.models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by dianka on 9/10/16.
 */
public class RegistrationPage extends BasePage {
    public static final String NAME_FIELD_XPATH = "//input[@name='name']";
    public static final String FIRST_NAME_FIELD_XPATH = "//input[@name='fname']";
    public static final String LAST_NAME_FIELD_XPATH = "//input[@name='lname']";
    public static final String PASSWORD_FIELD_XPATH = "//input[@name='password']";
    public static final String CONFIRM_PASWORD_FIELD_XPATH = "//input[@name='passwordConfirm']";
    public static final String ROLE_COMBOBOX_XPATH = "//select[@name='role']";
    public static final String REGISTER_BUTTON_XPATH = "//input[@value='Register']";

    @FindBy(xpath = NAME_FIELD_XPATH)
    WebElement nameField;
    @FindBy(xpath = FIRST_NAME_FIELD_XPATH)
    WebElement firstNameField;
    @FindBy(xpath = LAST_NAME_FIELD_XPATH)
    WebElement lastNameField;
    @FindBy(xpath = PASSWORD_FIELD_XPATH)
    WebElement passwordField;
    @FindBy(xpath = CONFIRM_PASWORD_FIELD_XPATH)
    WebElement confirmPasswordField;
    @FindBy(xpath = ROLE_COMBOBOX_XPATH)
    WebElement roleCombobox;
    @FindBy(xpath = REGISTER_BUTTON_XPATH)
    WebElement registerButton;


    public HomePage registerNewUser(User user) {
        nameField.clear();
        firstNameField.clear();
        lastNameField.clear();
        passwordField.clear();
        confirmPasswordField.clear();

        nameField.sendKeys(user.getUsername());
        firstNameField.sendKeys(user.getFname());
        lastNameField.sendKeys(user.getLname());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());

        Select select = new Select(roleCombobox);
        select.selectByValue(user.getRole().name());


        registerButton.click();

        return initPage(HomePage.class);
    }

    public HomePage registerNewDeveloper (User developer ) {
        nameField.clear();
        firstNameField.clear();
        lastNameField.clear();
        passwordField.clear();
        confirmPasswordField.clear();

        nameField.sendKeys(developer.getUsername());
        firstNameField.sendKeys(developer.getFname());
        lastNameField.sendKeys(developer.getLname());
        passwordField.sendKeys(developer.getPassword());
        confirmPasswordField.sendKeys(developer.getPassword());

        Select select = new Select(roleCombobox);
        select.selectByValue(developer.getRole().name());

        registerButton.click();

        return initPage(HomePage.class);
    }


}

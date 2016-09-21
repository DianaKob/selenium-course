package com.dataart.selenium.pages;

import com.dataart.selenium.models.Application;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomePage extends BasicPage {
    public HeaderPage getHeader() {
        return initPage(HeaderPage.class);
    }

    public static final String LOG_OUT_BUTTON_XPATH = "//a[contains(text(), 'Logout')]";
    public static final String INFORMATION_XPATH= "html/body/div[2]/div[2]/ul/li[2]/a";
    public static final String BODY_CSS = "Body";
    public static final String MY_APPLICATION_XPATH = "//div[@class='navigation']/a[@href='/my']";
    public static final String DETAILS_XPATH = "//div[@class='app']//a";
    public static final String DOWNLOAD_APPLICATION_CSS = ".download-button>a";
    public static final String TITLE_OF_NEW_APPLICATION_XPATH = "//input[@name='title']";
    public static final String DESCRIPTION_OF_NEW_APPLICATION_XPATH = "//textarea[@name='description']";
    public static final String ADD_APPLICATION_XPATH = "html/body/div[2]/div[1]/a[1]";
    public static final String CATEGORY_OF_APPLICATION_COMBOBOX_XPATH = "//select[@name='category']";
    public static final String CREATE_NEW_APPLICATION_BUTTON = "//input[@value='Create']";
    public static final String BROWSE_IMAGE_BUTTON_XPATH = "//input[@name='image']";
    public static final String BROWSE_ICON_BUTTON_XPATH = "//input[@name='icon']";
    public static final String AJAX_TEST_PAGE_XPATH = "//a[contains(text(), 'Ajax test page')]";
    public static final String INPUT_X_AJAX_XPATH = ".//*[@id='x']";
    public static final String INPUT_Y_AJAX_XPATH = ".//*[@id='y']";
    public static final String SUM_AJAX_XPATH = ".//*[@id='calc']";
    public static final String RESULT_AJAX_XPATH= ".//*[@id='result']";
//delete     public static final String AJAX_TEST_PAGE_XPATH = "//a[contains(text(), 'JS test page')]";
    public static final String JS_TEST_PAGE_XPATH = "//div[@class='navigation']/a[@href='/js/']";
    public static final String JS_TOP_TEXT_FIELD = ".//*[@id='top']";
    public static final String JS_LEFT_TEXT_FIELD = ".//*[@id='left']";
    public static final String JS_PROCESS_TEXT_FIELD = ".//*[@id='process']";
    public static final String EDIT_BUTTON_XPATH = "//div[@class='edit-app-button']/a[contains(text(), 'Edit')]";
    public static final String DELETE_APPLICATION_BUTTON_XPATH = "//a[@onclick='return confirmDelete();']";
    public static final String UPDATE_BUTTON_XPATH ="//input[@type=\'submit\']";



    @FindBy(xpath = LOG_OUT_BUTTON_XPATH)
    WebElement logOutButton;
    @FindBy(xpath = INFORMATION_XPATH)
    WebElement informationButton;
    @FindBy(css = BODY_CSS)
    WebElement body;
    @FindBy(xpath = MY_APPLICATION_XPATH)
    WebElement myApplicationButton;
    @FindBy(xpath = DETAILS_XPATH)
    WebElement detailsButton;
    @FindBy(css = DOWNLOAD_APPLICATION_CSS)
    WebElement downloadApplicationButton;
    @FindBy(xpath = ADD_APPLICATION_XPATH)
    WebElement addAplication;
    @FindBy(xpath = TITLE_OF_NEW_APPLICATION_XPATH)
    WebElement titleNewApplication;
    @FindBy(xpath = DESCRIPTION_OF_NEW_APPLICATION_XPATH)
    WebElement descriptionNewApplication;
    @FindBy(xpath = CATEGORY_OF_APPLICATION_COMBOBOX_XPATH)
    WebElement categoryOfApplication;
    @FindBy(xpath = CREATE_NEW_APPLICATION_BUTTON)
    WebElement createNewApplicationButton;
    @FindBy(xpath = BROWSE_IMAGE_BUTTON_XPATH)
    WebElement browseImage;
    @FindBy(xpath = BROWSE_ICON_BUTTON_XPATH)
    WebElement browseIcon;
    @FindBy(xpath = AJAX_TEST_PAGE_XPATH)
    WebElement ajaxTestPage;
    @FindBy(xpath = INPUT_X_AJAX_XPATH)
    WebElement inputX;
    @FindBy(xpath = INPUT_Y_AJAX_XPATH)
    WebElement inputY;
    @FindBy(xpath = SUM_AJAX_XPATH)
    WebElement sumAJax;
    @FindBy(xpath = RESULT_AJAX_XPATH)
    WebElement resultAjax;
    @FindBy(xpath = JS_TEST_PAGE_XPATH)
    WebElement jsTestPage;
    @FindBy(xpath = JS_TOP_TEXT_FIELD)
    WebElement jsTop;
    @FindBy(xpath = JS_LEFT_TEXT_FIELD)
    WebElement jsLeft;
    @FindBy(xpath = JS_PROCESS_TEXT_FIELD)
    WebElement jsProcess;
    @FindBy(xpath = EDIT_BUTTON_XPATH)
    WebElement editButton;
    @FindBy(xpath = UPDATE_BUTTON_XPATH)
    WebElement updateButton;
    @FindBy(xpath = DELETE_APPLICATION_BUTTON_XPATH)
    WebElement deleteButton;



    public void findJsDiv(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Map<String,Object> val = (Map<String, Object>)js.executeScript("return document.getElementsByClassName('flash')[0].getBoundingClientRect();");
        long top = Math.round((Double) val.get("top"));
        long left = Math.round((Double) val.get("left"));
        jsTop.sendKeys(String.valueOf(top));
        jsLeft.sendKeys(String.valueOf(left));
        jsProcess.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Whoo Hoooo! Correct!");
        alert.accept();

    }

    public HomePage navigationToJsPage(){
        jsTestPage.click();
        return initPage(HomePage.class);
    }

    public void assertSumWithString(){
        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='r']//div[@id='result']")));
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='r']//div[@id='result']")).getText(),
                "Result is: Incorrect data");
    }

    public void assertAjaxResult(){

        WebDriverWait wait = new WebDriverWait(driver,8);
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='r']//div[@id='result']")));

        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='r']//div[@id='result']")).getText(),
                "Result is: 270728.0");
    }

    public void calculateInvalidSumAjax(){
        inputX.sendKeys("170014");
        inputY.sendKeys("bhb");
        sumAJax.click();
    }

    public void calculateSumAjax(){
        inputX.sendKeys("170014");
        inputY.sendKeys("100714");
        sumAJax.click();
    }

    public HomePage navigationToajaxPage(){
        ajaxTestPage.click();
        return initPage(HomePage.class);
    }


    public void downloadXTimes(){
        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.xpath("//div[@class='apps']/div[last()]/a")).click();
        driver.findElement(By.cssSelector(".application")).click();
        for (int i =0; i <20; i++){
            downloadApplicationButton.click();
            driver.navigate().back();
        }
    }

    public void assertLocationInPopular(){
        driver.findElement(By.cssSelector("body")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='application']/div[@class='name']")).getText(),
                driver.findElement(By.xpath("//div[@class='popular-app']/a/div")).getText());
    }

    public void newApplicationCanBeDownloaded(){
        driver.findElement(By.xpath("//div[contains (text(), '123automationTestTitle')]")).click();
        detailsButton.click();
    }

    public void assertNewApplicationIsDisplayed(){
        Assert.assertEquals("123aautomationTestTitle",driver.findElement(By.xpath("//div[contains (text(), '123aautomationTestTitle')]")).getText ());
        Assert.assertEquals("123aautomationTestDescription",driver.findElement(By.xpath("//div[contains (text(), '123aautomationTestDescription')]")).getText ());
    }

    public void createNewApplicationWithoutImage(){
        titleNewApplication.sendKeys("123aautomationTestTitle");
        descriptionNewApplication.sendKeys("123aautomationTestDescription");
        new Select (driver.findElement(By.xpath("//select[@name='category']"))).selectByVisibleText ("News");
        createNewApplicationButton.click();
    }

    public void createNewApplicationToEdit(){
        titleNewApplication.sendKeys("inOrderToCheckEdit");
        descriptionNewApplication.sendKeys("inOrderToCheckEdit");
        new Select (driver.findElement(By.xpath("//select[@name='category']"))).selectByVisibleText ("Maps");
        createNewApplicationButton.click();
    }

    public void createNewApplicationToDelete(){
        titleNewApplication.sendKeys("inOrderToDelete");
        descriptionNewApplication.sendKeys("inOrderToDelete");
        new Select (driver.findElement(By.xpath("//select[@name='category']"))).selectByVisibleText ("Maps");
        createNewApplicationButton.click();
    }

    public void editApplication(){
        driver.findElement(By.xpath ("//div[@class='app']/a[@href='/app?title=inOrderToCheckEdit']")).click ();
        editButton.click();
        descriptionNewApplication.clear();
        descriptionNewApplication.sendKeys("thisIsEditCheck");
        new Select (driver.findElement(By.xpath("//select[@name='category']"))).selectByVisibleText ("Games");
        updateButton.click();
    }

    public void deleteApplication(){
        driver.findElement(By.xpath ("//div[@class='app']/a[@href='/app?title=inOrderToDelete']")).click ();
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        myApplicationButton.click();
        org.junit.Assert.assertTrue(driver.findElements(By.xpath
                ("//div[@class='app']/a[@href='/app?title=inOrderToDelete']")).size() == 0);
    }

    public void assertEdit(){
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().refresh();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'thisIsEditCheck')]")).getText(),
                "Description: thisIsEditCheck");
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Games')]")).getText(),
                "Category: Games");
    }


    public void createApplication(){
        Application application = new Application("DautomationTestTitleImage",
                "automationTestDescriptionImage",
                "Development",
                "/Users/dianka/Desktop/forTests/images.jpeg",
                "/Users/dianka/Desktop/forTests/index.jpeg");

        titleNewApplication.sendKeys(application.getTittle());
        descriptionNewApplication.sendKeys(application.getDescription());
        new Select (driver.findElement(By.xpath("//select[@name='category']"))).selectByVisibleText(application.getCategory());
        driver.findElement(By.xpath("//input[@name='icon']")).sendKeys(application.getIconUrl());
        driver.findElement(By.xpath("//input[@name='image']")).sendKeys(application.getImageUrl());
        createNewApplicationButton.click();
    }

    public void addApplicationclick(){
        addAplication.click();
    }

    public JsonElement downloadApplicationclick(){
        downloadApplicationButton.click();
        return new JsonParser().parse(driver.findElement(By.xpath( "//pre" )).getText());
    }

    public void detailslinkclick(){
         detailsButton.click();
    }

    public void performApplicationLinkClick(){
        myApplicationButton.click();
    }
    public void switchToNewTab() {
        body.sendKeys(Keys.COMMAND + "t");
        driver.get("http://localhost:8080/");
    }

    public void performLogout() {
        logOutButton.click();
    }

    public void switchToPreviousTab() {
        body.sendKeys(Keys.COMMAND, Keys.SHIFT, "{");
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(0));
    }

    public LoginPage performLinkClick() {
        informationButton.click ();
        return initPage(LoginPage.class);
    }

    public void assertUserCanSeeApplications(){
        Assert.assertTrue(driver.findElement(By.className("apps-container")).isDisplayed ());
    }

    public HashMap<String, String> getAppValues() {
        HashMap<String, String> values = new HashMap<String, String>();
        values.put("title", driver.findElement(By.cssSelector("div.name")).getText());
        values.put("description", driver.findElement(By.xpath("//div[@class='description'][1]")).getText().split(":")[1].trim());
        values.put("category", driver.findElement(By.xpath("//div[@class='description'][2]")).getText().split(":")[1].trim());
        values.put("author", driver.findElement(By.xpath("//div[@class='description'][3]")).getText().split(":")[1].trim());
        values.put("downloads", driver.findElement(By.xpath("//div[@class='downloads']")).getText().split(":")[1].trim());
        return values;
    }

}

package Tests;

import Actions.CRM_Edit_UserProfile_Actions;
import Actions.CRM_Login_Actions;
import Commons.LoadConfigFile;
import Commons.Result2Excels;
import Objects.CRM_Users;
import Pages.CRM_Edit_UserProfile_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Tests.CRM_LoginTC.waitMoment;

public class CRM_Edit_UserProfile_TC {
    Properties properties;
    String propertyFilePath = ".\\src\\test\\Resources\\Configs\\Config.properties";

    WebDriver driver;

    CRM_Users user1 = new CRM_Users();
    int TimeOut = 2;

    @BeforeMethod
    public void init() throws InterruptedException, IOException {

        properties = LoadConfigFile.loadPropertiesFile(propertyFilePath);

        user1.setUsername(properties.getProperty("ID"));
        user1.setPassword(properties.getProperty("pass"));

        user1.setName(properties.getProperty("Name"));
        user1.setCompany(properties.getProperty("Company"));
        user1.setPhone(properties.getProperty("Phone"));

        System.setProperty(properties.getProperty("ChromeWebDriver"), properties.getProperty("WebDriver_Resource"));
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Navigate to CRM site
        driver.get(properties.getProperty("SiteURL"));
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        CRM_Login_Actions.enterUsernameAndPassword(driver,user1.getUsername(),user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);
        CRM_Edit_UserProfile_Actions.clickProfilelink(driver);
    }

    //Verify that 'Edit success!' message displays when user updates information successfully
    @Test(description = "Verify that 'Edit success!' message displays when user updates information successfully")
    public void editUserProfileTC001() throws IOException {
        CRM_Edit_UserProfile_Actions.clearName_Company_Phone(driver);
        CRM_Edit_UserProfile_Actions.enterName_Company_Phone(driver, user1.getName(), user1.getComapny(), user1.getPhone());
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);

        if ((driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtEditSuccessMessage)).getText()
                .equalsIgnoreCase("Edit success!"))) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_03_01", "Verify that 'Edit success!' message displays when user updates information successfully");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_03_01", "Verify that 'Edit success!' message displays when user updates information successfully");
        }

       Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtEditSuccessMessage)).getText(),"Edit success!");
        waitMoment();
        driver.quit();

    }

    //Verify that "Please enter your name" red message displays above Name field when leaving Name field blank
    @Test(description = "Verify that 'Please enter your name' red message displays above Name field when leaving Name field blank")
    public void editUserProfileTC002() throws IOException {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtName)).clear();
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);

        if ((driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtNameMessage)).getText()
                .equalsIgnoreCase("Please enter your name"))) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_01", "Verify that 'Please enter your name' red message displays above Name field when leaving Name field blank");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_01", "Verify that 'Please enter your name' red message displays above Name field when leaving Name field blank");
        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtNameMessage)).getText(),"Please enter your name");
        waitMoment();
        driver.quit();
    }

    //Verify that "Please enter your company" red message displays above Company field when leaving Company field blank
    @Test(description = "Verify that 'Please enter your company' red message displays above Company field when leaving Company field blank")
    public void editUserProfileTC003() throws IOException {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtCompany)).clear();
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);

        if ((driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtComapnyMessage)).getText()
                .equalsIgnoreCase("Please enter your company"))) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_02", "Verify that 'Please enter your company' red message displays above Company field when leaving Company field blank");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_02", "Verify that 'Please enter your name' red message displays above Name field when leaving Name field blank");
        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtComapnyMessage)).getText(),"Please enter your company");
        waitMoment();
        driver.quit();
    }

    //Verify that "Please enter your phone" red message displays above Phone field when leaving Phone field blank
    @Test(description = "Verify that 'Please enter your phone' red message displays above Phone field when leaving Phone field blank")
    public void editUserProfileTC004() throws IOException {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhone)).clear();
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);

        if ((driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhoneMessage)).getText()
                .equalsIgnoreCase("Please enter your phone"))) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_03", "Verify that 'Please enter your phone' red message displays above Phone field when leaving Phone field blank");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_03", "Verify that 'Please enter your phone' red message displays above Phone field when leaving Phone field blank");
        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhoneMessage)).getText(),"Please enter your phone");
        waitMoment();
        driver.quit();
    }

    //Verify that "Only numbers 0-9" red message displays above Phone filed when user enters any letter into Phone field
    @Test(description = "Verify that 'Only numbers 0-9' red message displays above Phone filed when user enters any letter into Phone field")
    public void editUserProfileTC005() throws IOException {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhone)).clear();
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhone)).sendKeys("abcdef");
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);

        if ((driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhoneMessage)).getText()
                .equalsIgnoreCase("Only numbers 0-9"))) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_04", "Verify that 'Only numbers 0-9' red message displays above Phone filed when user enters any letter into Phone field");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_04_04", "Verify that 'Only numbers 0-9' red message displays above Phone filed when user enters any letter into Phone field");
        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhoneMessage)).getText(),"Only numbers 0-9");
        waitMoment();
        driver.quit();
    }

    @AfterTest
    public void end()
    {
        driver.quit();

    }

    public static void waitMoment()
    {

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


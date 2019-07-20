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
    public void LoginTC1() throws IOException {
        CRM_Edit_UserProfile_Actions.clearName_Company_Phone(driver, user1.getName(), user1.getComapny(), user1.getPhone());
        CRM_Edit_UserProfile_Actions.enterName_Company_Phone(driver, user1.getName(), user1.getComapny(), user1.getPhone());
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);

        if ((driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.editSuccessMessage)).getText()
                .equalsIgnoreCase("Edit success!"))) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_03_01", "Verify that 'Edit success!' message displays when user updates information successfully");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_UPM_Update_03_01", "Verify that 'Edit success!' message displays when user updates information successfully");
        }
        waitMoment();
        driver.quit();

    }

    //Verify that "Please enter your name" red message displays above Name field when leaving Name field blank
    @Test(description = "Verify that 'Please enter your name' red message displays above Name field when leaving Name field blank")
    public void LoginTC2() throws IOException {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtName)).clear();
        CRM_Edit_UserProfile_Actions.clickSaveinformationButton(driver);


    }
}


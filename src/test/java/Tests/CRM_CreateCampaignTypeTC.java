package Tests;


import Actions.CRM_CM_AddCampaignType_Actions;
import Actions.CRM_Login_Actions;
import Commons.LoadConfigFile;

import Commons.Result2Excels;
import Objects.CRM_CampaignType;
import Objects.Users;

import Pages.CRM_CM_Page;
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

public class CRM_CreateCampaignTypeTC {
    Properties properties;
    String propertyFilePath= ".\\src\\test\\Resources\\Configs\\Config.properties";

    WebDriver driver;

    Users user1 = new Users();
    CRM_CampaignType crmCampaignType = new CRM_CampaignType();

    int TimeOut = 2;

    @BeforeMethod
    public void init() throws InterruptedException, IOException {

        properties = LoadConfigFile.loadPropertiesFile(propertyFilePath);

        user1.setUsername(properties.getProperty("ID"));
        user1.setPassword(properties.getProperty("pass"));
        crmCampaignType.setCampaingTypeName(properties.getProperty("CampaignTypeName"));

        System.setProperty(properties.getProperty("ChromeWebDriver"), properties.getProperty("WebDriver_Resource"));
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Navigate to site
        driver.get(properties.getProperty("SiteURL"));
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        CRM_Login_Actions.enterUsernameAndPassword(driver,user1.getUsername(),user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);



    }


    @Test(description = "Verify that user can add a new campaign type")
    public  void createCampaignTypeTC1() throws IOException {

        CRM_CM_AddCampaignType_Actions.clickCreateCampaingTyoe(driver);
        Assert.assertEquals(driver.getCurrentUrl(),CRM_CM_Page.urlCreateCampaingType);
        CRM_CM_AddCampaignType_Actions.enterCampaignTypeName(driver,crmCampaignType.getCampaingTypeName());
        CRM_CM_AddCampaignType_Actions.clickBtnSave(driver);


        try {
            Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlShowAllCampaignTypes);
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_AddType_01_01","Verify that user can add a new campaign type");


        }catch (Exception e)
        {
            e.printStackTrace();
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_AddType_01_01","Verify that user can add a new campaign type");

            waitMoment();
            driver.quit();
            assert false;

        }



        waitMoment();
        driver.quit();
    }

    //Verify that the red message "Please enter campaign type name" displays above Campagin Name Type field when leaving this field blank
    @Test(description = "Verify that user cannot create a new campaign type when leaving Campaign Name Type field blank")
    public  void createCampaignTypeTC2() throws IOException {

        CRM_CM_AddCampaignType_Actions.clickCreateCampaingTyoe(driver);
        Assert.assertEquals(driver.getCurrentUrl(),CRM_CM_Page.urlCreateCampaingType);
        CRM_CM_AddCampaignType_Actions.clearCampaignTypeName(driver);
        CRM_CM_AddCampaignType_Actions.clickBtnSave(driver);


        try {
            Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtCampaignTypeNameRedMessage)).getText(),"Please enter campaign type name");
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_AddType_01_02","Verify that user cannot create a new campaign type when leaving Campaign Name Type field blank");


        }catch (Exception e)
        {
            e.printStackTrace();
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_AddType_01_02","Verify that user cannot create a new campaign type when leaving Campaign Name Type field blank");

            waitMoment();
            driver.quit();
            assert false;

        }

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
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package Tests;


import Actions.CRM_Login_Actions;
import Commons.LoadConfigFile;
import Commons.Result2Excels;
import Objects.CRM_Campaign;
import Objects.CRM_Users;
import Pages.CRM_Edit_CM_Pages;
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

public class CRM_EditCampaignTC {
    Properties properties;
    String propertyFilePath= ".\\src\\test\\Resources\\Configs\\Config.properties";

    WebDriver driver;

    CRM_Users user1 = new CRM_Users();
    CRM_Campaign crmCampaign = new CRM_Campaign();

    int TimeOut = 2;

    @BeforeMethod
    public void init() throws InterruptedException, IOException {

        properties = LoadConfigFile.loadPropertiesFile(propertyFilePath);

        user1.setUsername(properties.getProperty("ID"));
        user1.setPassword(properties.getProperty("pass"));
        crmCampaign.setCampaignName(properties.getProperty("CampaignName"));
        crmCampaign.setChooseCampaignTypeName(properties.getProperty("ChooseCampaignTypeName"));
        crmCampaign.setCampaignStatus(properties.getProperty("CampaignStatus"));
        crmCampaign.setCampaignStartDate(properties.getProperty("CampaignStartDate"));
        crmCampaign.setCampaignExpectedRevenue(properties.getProperty("CampaignExpectedRevenue"));
        crmCampaign.setCampaignEndDate(properties.getProperty("CampaignEndDate"));
        crmCampaign.setCampaignBudgetedCost(properties.getProperty("CampaignBudgetedCost"));
        crmCampaign.setCampaignActualCost(properties.getProperty("CampaignActualCost"));
        crmCampaign.setCampaignDescription(properties.getProperty("CampaignDescription"));

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
        driver.findElement(By.xpath(CRM_Edit_CM_Pages.lnkCampaigns)).click();
        driver.findElement(By.xpath(CRM_Edit_CM_Pages.lnkShowAllCampaigns)).click();
    }

    //Verify that the red message "Please enter start date" displays above Start Date field when leaving Start Date field blank
    @Test(description = "Verify that the red message 'Please enter start date' displays above Start Date field when leaving Start Date field blank")
    public  void editCampaignTC001() throws IOException {

        driver.findElement(By.xpath(CRM_Edit_CM_Pages.btnEdit)).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://14.176.232.213:8080/CRMweb/faces/editCampaign.xhtml?id=3");

        driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtStartDate)).clear();
        driver.findElement(By.xpath(CRM_Edit_CM_Pages.btnSave)).click();


        if (driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtStartDateRedMessage)).getText()
                .equalsIgnoreCase("Please enter start date")) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_CM_Edit_02_02", "Verify that the red message 'Please enter start date' displays above Start Date field when leaving Start Date field blank");
        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_CM_Edit_02_02", "Verify that the red message 'Please enter start date' displays above Start Date field when leaving Start Date field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtStartDateRedMessage)).getText(), "Please enter start date");

        driver.quit();
    }
    //Verify that the red message "Please enter expected revenue" displays above Expected Revenue field when leaving Expected Revenue field blank
    @Test(description = "Verify that the red message 'Please enter expected revenue' displays above Expected Revenue field when leaving Expected Revenue field blank")
    public  void editCampaignTC002() throws IOException {

        driver.findElement(By.xpath(CRM_Edit_CM_Pages.btnEdit)).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://14.176.232.213:8080/CRMweb/faces/editCampaign.xhtml?id=3");

        driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtExpectedRevenue)).clear();
        driver.findElement(By.xpath(CRM_Edit_CM_Pages.btnSave)).click();

        if (driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtExpectedRevenueRedMessage)).getText()
                .equalsIgnoreCase("Please enter expected revenue")) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_CM_Edit_02_03", "Verify that the red message 'Please enter expected revenue' displays above Expected Revenue field when leaving Expected Revenue field blank");

        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_CM_Edit_02_03", "Verify that the red message 'Please enter expected revenue' displays above Expected Revenue field when leaving Expected Revenue field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtExpectedRevenueRedMessage)).getText(), "Please enter expected revenue");

        driver.quit();
    }
    //Verify that the red message "Please enter end date" displays above End Date field when leaving End Date field blank
    @Test(description = "Verify that the red message 'Please enter end date' displays above End Date field when leaving End Date field blank")
    public  void editCampaignTC003() throws IOException {

        driver.findElement(By.xpath(CRM_Edit_CM_Pages.btnEdit)).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://14.176.232.213:8080/CRMweb/faces/editCampaign.xhtml?id=3");

        driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtEndDate)).clear();
        driver.findElement(By.xpath(CRM_Edit_CM_Pages.btnSave)).click();

        if (driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtEndDateRedMessage)).getText()
                .equalsIgnoreCase("Please enter end date")) {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo", "Result",
                    "TC_REQ_CM_Edit_02_04", "Verify that the red message 'Please enter end date' displays above End Date field when leaving End Date field blank");
        } else {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo", "Result",
                    "TC_REQ_CM_Edit_02_04", "Verify that the red message 'Please enter end date' displays above End Date field when leaving End Date field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Edit_CM_Pages.txtEndDateRedMessage)).getText(), "Please enter end date");

        driver.quit();
    }
    @AfterTest
    public void end()
    {
        driver.quit();
    }
}



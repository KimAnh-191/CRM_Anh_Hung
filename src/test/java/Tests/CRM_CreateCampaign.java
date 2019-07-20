package Tests;


import Actions.CRM_CM_AddCampaign_Actions;
import Actions.CRM_Login_Actions;
import Commons.LoadConfigFile;
import Commons.Result2Excels;
import Objects.CRM_Campaign;
import Objects.CRM_Users;
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

public class CRM_CreateCampaign {

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

    }

    //Verify that Create Campaign page displays information of campaign follow those fields
    @Test(description = "Verify that Create Campaign page displays when clicking Create Campaign Link")
    public  void createCampaignTC001() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);

        if (driver.getCurrentUrl().equalsIgnoreCase(CRM_CM_Page.urlCreateCampaing))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_01_01","Verify that Create Campaign page displays when clicking Create Campaign Link");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_01_01","Verify that Create Campaign page displays when clicking Create Campaign Link");

        }

        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        waitMoment();
        driver.quit();

    }

    //Verify that the form must show which fields is required information
    @Test(description = "Verify that the form must show which fields is required information")
    public  void createCampaignTC002() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);




        waitMoment();
        driver.quit();
    }


//    //Verify that user can add a new campaign
//    @Test(description = "Verify that user can add a new campaign successful")
//    public  void createCampaignTC003() throws IOException {
//
//        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
//        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);
//
//        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
//                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
//                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
//                crmCampaign.getCampaignDescription());
//        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);
//
//        if (driver.getCurrentUrl().equalsIgnoreCase(CRM_CM_Page.urlShowAllCampaigns))
//        {
//            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
//                    "TC_REQ_CM_Add_02_01","Verify that user can add a new campaign successful");
//
//        }
//        else
//        {
//            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
//                    "TC_REQ_CM_Add_02_01","Verify that user can add a new campaign successful");
//
//        }
//
//        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlShowAllCampaigns);
//
//        waitMoment();
//        driver.quit();
//
//    }

    //Verify that the red message "Please enter campaign name" displays above Campaign Name field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving Campaign Name field blank")
    public  void createCampaignTC004() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,"",crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtCampaignNameRedMessage)).getText()
                .equalsIgnoreCase("Please enter campaign name"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_01","Verify that user cannot create a new Campaign when leaving Campaign Name field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_01","Verify that user cannot create a new Campaign when leaving Campaign Name field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtCampaignNameRedMessage)).getText(),"Please enter campaign name");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Please enter start date" display above Start Date field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving Start Date field blank")
    public  void createCampaignTC005() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),"",crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtStartDateRedMessage)).getText()
                .equalsIgnoreCase("Please enter start date"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_02","Verify that user cannot create a new Campaign when leaving Start Date field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_02","Verify that user cannot create a new Campaign when leaving Start Date field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtStartDateRedMessage)).getText(), "Please enter start date");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Please enter expected revenue" display above Expected Revenue field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving Expected Revenue field blank")
    public  void createCampaignTC006() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),"",
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtExpectedRevenueRedMessage)).getText()
                .equalsIgnoreCase("Please enter expected revenue"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_03","Verify that user cannot create a new Campaign when leaving Expected Revenue field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_03","Verify that user cannot create a new Campaign when leaving Expected Revenue field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtExpectedRevenueRedMessage)).getText(), "Please enter expected revenue");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Please enter end date" display above End Date field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving End Date field blank")
    public  void createCampaignTC007() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                "",crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtEndDateRedMessage)).getText()
                .equalsIgnoreCase("Please enter end date"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_04","Verify that user cannot create a new Campaign when leaving End Date field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_04","Verify that user cannot create a new Campaign when leaving End Date field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtEndDateRedMessage)).getText(), "Please enter end date");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Please enter budgeted cost" display above Budgeted Cost field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving Budgeted Cost field blank")
    public  void createCampaignTC008() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),"",crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtBudgetedCostRedMessage)).getText()
                .equalsIgnoreCase("Please enter budgeted cost"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_05","Verify that user cannot create a new Campaign when leaving Budgeted Cost field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_05","Verify that user cannot create a new Campaign when leaving Budgeted Cost field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtBudgetedCostRedMessage)).getText(), "Please enter budgeted cost");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Please enter actual cost" display above Actual Cost field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving Actual Cost field blank")
    public  void createCampaignTC009() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),"",
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtActualCostRedMessage)).getText()
                .equalsIgnoreCase("Please enter actual cost"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_06","Verify that user cannot create a new Campaign when leaving Actual Cost field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_06","Verify that user cannot create a new Campaign when leaving Actual Cost field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtActualCostRedMessage)).getText(), "Please enter actual cost");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Please enter description" display above Description field when leaving this field blank
    @Test(description = "Verify that user cannot create a new Campaign when leaving Description field blank")
    public  void createCampaignTC010() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(), crmCampaign.getCampaignActualCost(),
                "");
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtDescriptionRedMessage)).getText()
                .equalsIgnoreCase("Please enter description"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_07","Verify that user cannot create a new Campaign when leaving Description field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_07","Verify that user cannot create a new Campaign when leaving Description field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtDescriptionRedMessage)).getText(), "Please enter description");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Enter YYYY-MM-DD please" display above Start Date field when entering invalid value into this field
    @Test(description = "Verify that user cannot create a new Campaign when entering invalid value into Start Date field")
    public  void createCampaignTC011() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),"1234"+crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtStartDateRedMessage)).getText()
                .equalsIgnoreCase("Enter YYYY-MM-DD please"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_08","Verify that user cannot create a new Campaign when entering invalid value into Start Date field");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_08","Verify that user cannot create a new Campaign when entering invalid value into Start Date field");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtStartDateRedMessage)).getText(), "Enter YYYY-MM-DD please");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Expected revenue is not a number pattern. Example: #,##0.0#" display above Expected Revenue field when entering invalid value into this field
    @Test(description = "Verify that user cannot create a new Campaign when entering invalid value into Expected Revenue field")
    public  void createCampaignTC012() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        String invalidExpectedRevenue = "qwe"+crmCampaign.getCampaignExpectedRevenue();

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),invalidExpectedRevenue,
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtExpectedRevenueRedMessage)).getText()
                .equalsIgnoreCase("Expected revenue is not a number pattern. Example: #,##0.0#"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_09","Verify that user cannot create a new Campaign when entering invalid value into Expected Revenue field");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_09","Verify that user cannot create a new Campaign when entering invalid value into Expected Revenue field");


        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtExpectedRevenueRedMessage)).getText(), "Expected revenue is not a number pattern. Example: #,##0.0#");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Enter YYYY-MM-DD please" display above End Date field when entering invalid value into this field
    @Test(description = "Verify that user cannot create a new Campaign when entering invalid value into End Date field")
    public  void createCampaignTC013() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        String invalidEndDate = "1234"+crmCampaign.getCampaignEndDate();

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                invalidEndDate,crmCampaign.getCampaignBudgetedCost(),crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtEndDateRedMessage)).getText()
                .equalsIgnoreCase("Enter YYYY-MM-DD please"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_10","Verify that user cannot create a new Campaign when entering invalid value into End Date field");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_10","Verify that user cannot create a new Campaign when entering invalid value into End Date field");

        }


        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtEndDateRedMessage)).getText(), "Enter YYYY-MM-DD please");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Budgeted cost is not a number pattern. Example: #,##0.0#" display above Budgeted Cost field when entering invalid value into this field
    @Test(description = "Verify that user cannot create a new Campaign when entering invalid value into Budgeted Cost field")
    public  void createCampaignTC014() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        String invalidBudgetedCost = "qwe"+crmCampaign.getCampaignBudgetedCost();

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),invalidBudgetedCost,crmCampaign.getCampaignActualCost(),
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtBudgetedCostRedMessage)).getText()
                .equalsIgnoreCase("Budgeted cost is not a number pattern. Example: #,##0.0#"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_11","Verify that user cannot create a new Campaign when entering invalid value into Budgeted Cost field");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_11","Verify that user cannot create a new Campaign when entering invalid value into Budgeted Cost field");


        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtBudgetedCostRedMessage)).getText(),
                "Budgeted cost is not a number pattern. Example: #,##0.0#");

        waitMoment();
        driver.quit();

    }

    //Verify that the red message "Actual cost is not a number pattern. Example: #,##0.0#" display above Actual Cost field when entering invalid value into this field
    @Test(description = "Verify that user cannot create a new Campaign when entering invalid value into Actual Cost field")
    public  void createCampaignTC015() throws IOException {

        CRM_CM_AddCampaign_Actions.clickCreateCampaign(driver);
        Assert.assertEquals(driver.getCurrentUrl(), CRM_CM_Page.urlCreateCampaing);

        String invalidActualCost = "qwe"+crmCampaign.getCampaignActualCost();

        CRM_CM_AddCampaign_Actions.createCampaing(driver,crmCampaign.getCampaignName(),crmCampaign.getChooseCampaignTypeName(),
                crmCampaign.getCampaignStatus(),crmCampaign.getCampaignStartDate(),crmCampaign.getCampaignExpectedRevenue(),
                crmCampaign.getCampaignEndDate(),crmCampaign.getCampaignBudgetedCost(),invalidActualCost,
                crmCampaign.getCampaignDescription());
        CRM_CM_AddCampaign_Actions.clickCreateButton(driver);

        if (driver.findElement(By.xpath(CRM_CM_Page.txtActualCostRedMessage)).getText()
                .equalsIgnoreCase("Actual cost is not a number pattern. Example: #,##0.0#"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_12","Verify that user cannot create a new Campaign when entering invalid value into Actual Cost field");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_CM_Add_03_12","Verify that user cannot create a new Campaign when entering invalid value into Actual Cost field");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_CM_Page.txtActualCostRedMessage)).getText(),
                "Actual cost is not a number pattern. Example: #,##0.0#");

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

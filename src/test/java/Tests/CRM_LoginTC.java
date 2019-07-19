package Tests;

import Actions.CRM_Login_Actions;

import Commons.LoadConfigFile;
import Commons.Result2Excels;
import Objects.Users;
import Pages.CRM_Login_Page;

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

public class CRM_LoginTC {
    Properties properties;
    String propertyFilePath= ".\\src\\test\\Resources\\Configs\\Config.properties";

    WebDriver driver;

    Users user1 = new Users();
    int TimeOut = 2;

    @BeforeMethod
    public void init() throws InterruptedException, IOException {

        properties = LoadConfigFile.loadPropertiesFile(propertyFilePath);

        user1.setUsername(properties.getProperty("ID"));
        user1.setPassword(properties.getProperty("pass"));

        System.setProperty(properties.getProperty("ChromeWebDriver"), properties.getProperty("WebDriver_Resource"));
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Navigate to CRM site
        driver.get(properties.getProperty("SiteURL"));
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
    }

    //Verify that user can login with correct username and password
    @Test(description = "Verify that user can login with correct username and password")
    public  void LoginTC1() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,user1.getUsername(),user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.txtLogOut)).isDisplayed())
        {
           Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                   "TC_REQ_REQ_UPM_Login_02_03","Verify that user can login with correct username and password");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_02_03","Verify that user can login with correct username and password");

        }

        //Check default page display after login successful
        Assert.assertEquals(true,driver.findElement(By.xpath(CRM_Login_Page.txtProfile)).isDisplayed());
        //End
        waitMoment();
        driver.quit();

    }

    //Verify that "Please enter your email" red message displays above Email field and "Please enter your password" red message
    // displays above password field when leaving all fields blank
    @Test(description = "Verify that user cannot login when leaving Email and Password fields are blank")
    public  void LoginTC2() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,"","");
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.txtEmailRedMessage)).getAttribute("innerHTML").equalsIgnoreCase("Please enter your email")&&
                driver.findElement(By.xpath(CRM_Login_Page.txtPasswordRedMessage)).getAttribute("innerHTML").equalsIgnoreCase("Please enter your password"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_01","Verify that user cannot login when leaving Email and Password fields are blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_01","Verify that user cannot login when leaving Email and Password fields are blank");

        }

        Assert.assertTrue(driver.findElement(By.xpath(CRM_Login_Page.txtEmailRedMessage)).getAttribute("innerHTML").equalsIgnoreCase("Please enter your email")&&
                driver.findElement(By.xpath(CRM_Login_Page.txtPasswordRedMessage)).getAttribute("innerHTML").equalsIgnoreCase("Please enter your password"));

        waitMoment();
        driver.quit();

    }

    //Verify that "Please enter your password" red message displays above password field with Password field is blank
    @Test(description = "Verify that user cannot login when leaving password field are blank")
    public  void LoginTC3() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,user1.getUsername(),"");
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.txtPasswordRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("Please enter your password"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_02","Verify that user cannot login when leaving Password field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_02","Verify that user cannot login when leaving Password field blank");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Login_Page.txtPasswordRedMessage))
                .getAttribute("innerHTML"),"Please enter your password");

        waitMoment();
        driver.quit();

    }

    //Verify that "Please enter your email" red message displays above Email field with Email field is blank
    @Test(description = "Verify that user cannot login when leaving Email field blank")
    public  void LoginTC4() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,"",user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.txtEmailRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("Please enter your email"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_03","Verify that user cannot login when leaving Email field blank");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_03","Verify that user cannot login when leaving Email field blank");

        }

        Assert.assertTrue(driver.findElement(By.xpath(CRM_Login_Page.txtEmailRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("Please enter your email"));

        waitMoment();
        driver.quit();

    }


    //Verify that "The email or password is incorrect" red message displays above Login button when user login with a correct email address and incorrect password
    @Test(description = "Verify that user cannot login with correct email and incorrect password")
    public  void LoginTC5() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,user1.getUsername(),user1.getPassword()+"123");
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("The email or password is incorrect!"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_04","Verify that user cannot login with a correct email and incorrect password");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_04","Verify that user cannot login with a correct email and incorrect password");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage)).getAttribute("innerHTML"),"The email or password is incorrect!");

        waitMoment();
        driver.quit();

    }

    //Verify that "The email or password is incorrect" red message displays above Login button when user login with an incorrect email address
    @Test(description = "Verify that user cannot login with an incorrect email")
    public  void LoginTC6() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,"ABC"+user1.getUsername(),user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("The email or password is incorrect!"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_05","Verify that user cannot login with an incorrect email");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_05","Verify that user cannot login with an incorrect email");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage)).getAttribute("innerHTML"),"The email or password is incorrect!");

        waitMoment();
        driver.quit();

    }

    //Verify that "The email is not valid (ex: abc@abc)" red message displays above Email field when user login with an invalid email address
    @Test(description = "Verify that user cannot login with an invalid email")
    public  void LoginTC7() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,user1.getUsername()+"@Yahoo.com",user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.txtEmailRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("The email is not valid (ex: abc@abc)"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_06","Verify that user cannot login with an invalid email");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_06","Verify that user cannot login with an invalid email");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Login_Page.txtEmailRedMessage)).getText(),"The email is not valid (ex: abc@abc)");

        waitMoment();
        driver.quit();

    }


    //Verify that "Blocked Account" red message displays above Login button when user login with email address of user was blocked
    @Test(description = "Verify that user cannot login with an incorrect email")
    public  void LoginTC8() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,"1"+user1.getUsername(),user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("Blocked User!"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_07","Verify that user cannot login with an email of user was blocked");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_07","Verify that user cannot login with an email of user was blocked");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage)).getAttribute("innerHTML"),"Blocked User!");

        waitMoment();
        driver.quit();

    }

    //Verify that "The email or password is incorrect" red message displays above Login button when user login with email address of user was deleted
    @Test(description = "Verify that user cannot login with a email of user was deleted")
    public  void LoginTC9() throws IOException {

        CRM_Login_Actions.enterUsernameAndPassword(driver,"1"+user1.getUsername(),user1.getPassword());
        CRM_Login_Actions.clickLoginButton(driver);

        if (driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage))
                .getAttribute("innerHTML").equalsIgnoreCase("The email or password is incorrect!"))
        {
            Result2Excels.saveResult2ExcelFilePassed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_08","Verify that user cannot login with a email of user was deleted");

        }
        else
        {
            Result2Excels.saveResult2ExcelFileFailed("ResultDemo","Result",
                    "TC_REQ_REQ_UPM_Login_03_08","Verify that user cannot login with a email of user was deleted");

        }

        Assert.assertEquals(driver.findElement(By.xpath(CRM_Login_Page.btnLoginRedMessage)).getAttribute("innerHTML"),"The email or password is incorrect!");

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

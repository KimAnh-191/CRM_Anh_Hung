package Actions;

import Pages.CRM_Edit_UserProfile_Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Edit_UserProfile_Actions {
    public static void clickProfilelink(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.profileLink)).click();
    }
    public static void clearName_Company_Phone(WebDriver driver, String name, String company, String phone)
    {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtName)).clear();
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtCompany)).clear();
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhone)).clear();
    }

    public static void enterName_Company_Phone(WebDriver driver, String name, String company, String phone)
    {

        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtName)).sendKeys(name);
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtCompany)).sendKeys(company);
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.txtPhone)).sendKeys(phone);
    }

    public static void clickSaveinformationButton(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_Edit_UserProfile_Pages.btnSaveinfomation)).click();

    }

}


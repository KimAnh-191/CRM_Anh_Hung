package Actions;

import Pages.CRM_CM_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_CM_AddCampaignType_Actions {


    public static void clickCampaingsLink(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_CM_Page.lnkCampaigns)).click();


    }

    public static void clickCreateCampaingTyoe(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement campaignsLink;
        WebElement createCampaignType;

        campaignsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CRM_CM_Page.lnkCampaigns)));
        campaignsLink.click();
        createCampaignType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CRM_CM_Page.lnkCreateCampaignType)));
        createCampaignType.click();



    }

    public static void enterCampaignTypeName(WebDriver driver,String campaignTypeName)
    {
        driver.findElement(By.xpath(CRM_CM_Page.txtCampaignTypeName)).sendKeys(campaignTypeName);

    }

    public static void clearCampaignTypeName(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_CM_Page.txtCampaignTypeName)).clear();

    }


    public static void clickBtnSave(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_CM_Page.btnSave)).click();

    }

    public static void clickBtnCancel(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_CM_Page.btnCancel)).click();

    }



}

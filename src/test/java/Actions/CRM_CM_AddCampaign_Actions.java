package Actions;

import Pages.CRM_CM_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_CM_AddCampaign_Actions {




    public static void clickCreateCampaign(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement campaignsLink;
        WebElement createCampaign;

        campaignsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CRM_CM_Page.lnkCampaigns)));
        campaignsLink.click();
        createCampaign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CRM_CM_Page.lnkCreateCampaign)));
        createCampaign.click();

    }

    public static void createCampaing(WebDriver driver, String CName, String CType, String CStatus, String CStartDate,
                                      String CExpectedRevenue, String CEndDate, String CBudgetedCost, String CActualCost, String CDescription)
    {

        driver.findElement(By.xpath(CRM_CM_Page.txtCampaignName)).sendKeys(CName);
        new Select(driver.findElement(By.xpath(CRM_CM_Page.txtCampaignType))).selectByVisibleText(CType);
        new Select(driver.findElement(By.xpath(CRM_CM_Page.txtCampaignStatus))).selectByVisibleText(CStatus);
        driver.findElement(By.xpath(CRM_CM_Page.txtStartDate)).sendKeys(CStartDate);
        driver.findElement(By.xpath(CRM_CM_Page.txtExpectedRevenue)).sendKeys(CExpectedRevenue);
        driver.findElement(By.xpath(CRM_CM_Page.txtEndDate)).sendKeys(CEndDate);
        driver.findElement(By.xpath(CRM_CM_Page.txtBudgetedCost)).sendKeys(CBudgetedCost);
        driver.findElement(By.xpath(CRM_CM_Page.txtActualCost)).sendKeys(CActualCost);
        driver.findElement(By.xpath(CRM_CM_Page.txtDescription)).sendKeys(CDescription);


    }

    public static void clickCreateButton(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_CM_Page.btnCreate)).click();

    }




}

package Actions;

import Pages.CRM_Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM_Login_Actions {

    public static void enterUsernameAndPassword(WebDriver driver,String username,String password)
    {

        driver.findElement(By.xpath(CRM_Login_Page.txtEmail)).sendKeys(username);
        driver.findElement(By.xpath(CRM_Login_Page.txtPassword)).sendKeys(password);

    }

    public static void clickLoginButton(WebDriver driver)
    {
        driver.findElement(By.xpath(CRM_Login_Page.btnLogin)).click();

    }


}

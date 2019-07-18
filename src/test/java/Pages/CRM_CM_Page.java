package Pages;

public class CRM_CM_Page {

    public static String urlCreateCampaing = "http://14.176.232.213:8080/CRMweb/faces/createCampaign.xhtml";
    public static String urlShowAllCampaigns = "http://14.176.232.213:8080/CRMweb/faces/listCampaign.xhtml";
    public static String urlCreateCampaingType = "http://14.176.232.213:8080/CRMweb/faces/createCampaignType.xhtml";
    public static String urlShowAllCampaignTypes ="http://14.176.232.213:8080/CRMweb/faces/listCampaignType.xhtml";

    public static String lnkCampaigns = "//ul[@id='side-menu']//span[contains(.,'Campaigns')]";
    public static String lnkCreateCampaign = "//ul[@id='side-menu']//a[@href='createCampaign.xhtml']";
    public static String lnkShowAllCampaigns = "//ul[@id='side-menu']//a[@href='listCampaign.xhtml']";
    public static String lnkShowCampaignTypes = "//ul[@id='side-menu']//a[@href='listCampaignType.xhtml']";
    public static String lnkCreateCampaignType = "//ul[@id='side-menu']//a[@href='createCampaignType.xhtml']";

    public static String txtCampaignName = "//input[@id='j_idt70:cn']";
    public static String txtCampaignNameRedMessage = "//form[@id='j_idt70']/div[1]/div/span";
    public static String txtCampaignType = "//select[@name='j_idt70:j_idt74']";
    public static String txtCampaignStatus = "//select[@name='j_idt70:j_idt77']";
    public static String txtStartDate = "//input[@id='j_idt70:sd']";
    public static String txtStartDateRedMessage = "//form[@id='j_idt70']/div[5]/div[1]/div[1]/div/span";
    public static String txtExpectedRevenue = "//input[@id='j_idt70:er']";
    public static String txtExpectedRevenueRedMessage = "//form[@id='j_idt70']/div[5]/div[1]/div[2]/div/span";
    public static String txtEndDate = "//input[@id='j_idt70:ed']";
    public static String txtEndDateRedMessage = "//form[@id='j_idt70']/div[5]/div[2]/div[1]/div/span";
    public static String txtBudgetedCost = "//input[@id='j_idt70:bc']";
    public static String txtBudgetedCostRedMessage = "//form[@id='j_idt70']/div[5]/div[2]/div[2]/div/span";
    public static String txtActualCost = "//input[@id='j_idt70:ac']";
    public static String txtActualCostRedMessage = "//form[@id='j_idt70']/div[5]/div[2]/div[3]/div/span";
    public static String txtDescription = "//textarea[@id='j_idt70:de']";
    public static String txtDescriptionRedMessage = "//form[@id='j_idt70']/div[7]/div/span";
    public static String btnCreate ="//input[@name='j_idt70:j_idt93']";
    public static String btnCancelCampaign ="//a[@href='/CRMweb/faces/listCampaign.xhtml']";


    public static String txtCampaignTypeName = "//input[@id='campaigntypeform:ctn']";
    public static String btnSave = "//input[@name='campaigntypeform:j_idt73']";
    public static String btnCancel = "//a[@href='/CRMweb/faces/listCampaignType.xhtml']";
    public static String txtCampaignTypeNameRedMessage = "//form[@id='campaigntypeform']//span";


}

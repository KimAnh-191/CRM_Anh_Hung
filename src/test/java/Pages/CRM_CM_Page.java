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

    public static String txtCampaignName = "//form[@id='j_idt70']//input[@id='j_idt70:cn']";
    public static String txtCampaignNameRedMessage = "//form[@id='j_idt70']//span[following-sibling::input[@id='j_idt70:cn']]";
    public static String txtCampaignType = "//form[@id='j_idt70']//select[@name='j_idt70:j_idt74']";
    public static String txtCampaignStatus = "//form[@id='j_idt70']//select[@name='j_idt70:j_idt77']";
    public static String txtStartDate = "//input[@id='j_idt70:sd']";
    public static String txtStartDateRedMessage = "//form[@id='j_idt70']//span[following-sibling::input[@id='j_idt70:sd']]";
    public static String txtExpectedRevenue = "//form[@id='j_idt70']//input[@id='j_idt70:er']";
    public static String txtExpectedRevenueRedMessage = "//form[@id='j_idt70']//span[following-sibling::input[@id='j_idt70:er']]";
    public static String txtEndDate = "//form[@id='j_idt70']//input[@id='j_idt70:ed']";
    public static String txtEndDateRedMessage = "//form[@id='j_idt70']//span[following-sibling::input[@id='j_idt70:ed']]";
    public static String txtBudgetedCost = "//form[@id='j_idt70']//input[@id='j_idt70:bc']";
    public static String txtBudgetedCostRedMessage = "//form[@id='j_idt70']//span[following-sibling::input[@id='j_idt70:bc']]";
    public static String txtActualCost = "//form[@id='j_idt70']//input[@id='j_idt70:ac']";
    public static String txtActualCostRedMessage = "//form[@id='j_idt70']//span[following-sibling::input[@id='j_idt70:ac']]";
    public static String txtDescription = "//form[@id='j_idt70']//textarea[@id='j_idt70:de']";
    public static String txtDescriptionRedMessage = "//form[@id='j_idt70']//span[following-sibling::textarea[@id='j_idt70:de']]";
    public static String btnCreate ="//form[@id='j_idt70']//input[@name='j_idt70:j_idt93']";
    public static String btnCancelCampaign ="//form[@id='j_idt70']//a[@href='/CRMweb/faces/listCampaign.xhtml']";


    public static String txtCampaignTypeName = "//form[@id='campaigntypeform']//input[@id='campaigntypeform:ctn']";
    public static String btnSave = "//input[@name='campaigntypeform:j_idt73']";
    public static String btnCancel = "//a[@href='/CRMweb/faces/listCampaignType.xhtml']";
    public static String txtCampaignTypeNameRedMessage = "//form[@id='campaigntypeform']//span[following-sibling::input[@id='campaigntypeform:ctn']]";


}

package Pages;

public class CRM_CM_Page {

    public static String urlCreateCampaingType = "http://14.176.232.213:8080/CRMweb/faces/createCampaignType.xhtml";
    public static String urlShowAllCampaigns = "http://14.176.232.213:8080/CRMweb/faces/listCampaignType.xhtml";

    public static String lnkCampaigns = "//ul[@id='side-menu']//span[contains(.,'Campaigns')]";
    public static String lnkCreateCampaignType = "//ul[@id='side-menu']//a[@href='createCampaignType.xhtml']";

    public static String txtCampaignTypeName = "//input[@id='campaigntypeform:ctn']";
    public static String btnSave = "//input[@name='campaigntypeform:j_idt73']";
    public static String btnCancel = "//a[@href='/CRMweb/faces/listCampaignType.xhtml']";


    public static String txtCTNameRedMessage = "//form[@id='campaigntypeform']//span";





}

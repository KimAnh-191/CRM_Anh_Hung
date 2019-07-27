package Pages;

public class CRM_Edit_CM_Pages {
    public static String lnkCampaigns = "//ul[@id='side-menu']//span[contains(.,'Campaigns')]";
    public static String lnkShowAllCampaigns = "//a[@href='listCampaign.xhtml']";

    public static String txtStartDate = "//input[@id='j_idt72:sd']";
    public static String txtStartDateRedMessage = "//form[@id='j_idt72']//span[following-sibling::input[@id='j_idt72:sd']]";
    public static String txtExpectedRevenue = "//form[@id='j_idt72']//input[@id='j_idt72:er']";
    public static String txtExpectedRevenueRedMessage = "//form[@id='j_idt72']//span[following-sibling::input[@id='j_idt72:er']]";
    public static String txtEndDate = "//form[@id='j_idt72']//input[@id='j_idt72:ed']";
    public static String txtEndDateRedMessage = "//form[@id='j_idt72']//span[following-sibling::input[@id='j_idt72:ed']]";
    public static String btnSave ="//form[@id='j_idt72']//input[@name='j_idt72:j_idt97']";

    public static String btnEdit = "//a[@href='/CRMweb/faces/editCampaign.xhtml?id=3']";

}

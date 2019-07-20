package Pages;

public class CRM_Login_Page {

    public static String txtEmail = "//input[@id='campaigntypeform:email']";
    public static String txtEmailRedMessage = "//form[@id='campaigntypeform']//span[following-sibling::input[@id='campaigntypeform:email']]";
    public static String txtPassword = "//input[@id='campaigntypeform:pass']";
    public static String txtPasswordRedMessage = "//form[@id='campaigntypeform']//span[following-sibling::input[@id='campaigntypeform:pass']]";
    public static String btnLogin = "//input[@name='campaigntypeform:j_idt14']";
    public static String btnLoginRedMessage = "//form[@id='campaigntypeform']//p[following-sibling::input[@name='campaigntypeform:j_idt14']]";

    public static String txtProfile = "//ul[@id='side-menu']//a[contains(text(),'Profile')]";
    public static String txtLogOut = "//form[@id='j_idt63']//a[contains(.,'Logout')]";




}

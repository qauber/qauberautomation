package testResources;
import Pages.*;
import org.openqa.selenium.WebDriver;

public class PageResources {
    WebDriver driver;



    public SignUpGooglePage SignUpGooglePage;
    public LoginPage loginPage;
    public AddUsersPage addUsersPage;
    public AddReport addReport;
    public AddEntity addEntity;
    public LogOut logOut;
    public AddSubDep addSubDep;
    public ViewReport viewReport;
    public ExportPDF exportPDF;
    public SAUSignUp sauSignUp;
    public ReportSearchPages reportSearchPages;
    public SubscriptionUsingPaypal subscriptionUsingPaypal;


    public ForgetPassPage forgetPassPage;

    public PageResources(WebDriver driver)
    {
        this.driver = driver;
        loginPage =    new LoginPage(driver);
        addUsersPage = new AddUsersPage(driver);
        addReport =    new AddReport(driver);
        addEntity =    new AddEntity(driver);
        addSubDep=     new AddSubDep(driver);
        logOut =       new LogOut(driver);
        exportPDF= new ExportPDF(driver);
        viewReport = new ViewReport(driver);
        sauSignUp= new SAUSignUp(driver);
        reportSearchPages = new ReportSearchPages(driver);
        subscriptionUsingPaypal= new SubscriptionUsingPaypal(driver);
        SignUpGooglePage = new SignUpGooglePage(driver);
        forgetPassPage = new ForgetPassPage(driver);


    }
    public SignUpGooglePage getSignUpGooglePage() {     return SignUpGooglePage;    }
    public ReportSearchPages getReportSearchPages() {        return reportSearchPages;    }
    public SAUSignUp getSauSignUp() { return sauSignUp;    }
    public LogOut getLogOut() {   return logOut;    }
    public AddSubDep getAddSubDep() {
        return addSubDep;
    }
    public AddEntity getAddEntity() {
        return addEntity;
    }
    public AddReport getAddReport() {
        return addReport;
    }
    public AddUsersPage getAddUsersPage() {
        return addUsersPage;
    }
    public LoginPage getLoginPage() {
        return loginPage;
    }
    public ExportPDF getExportPDF() {      return exportPDF;    }
    public ViewReport getViewReport() {        return viewReport; }
    public SubscriptionUsingPaypal getSubscriptionUsingPaypal() {
        return subscriptionUsingPaypal;
    }
    public ForgetPassPage getForgetPassPage() {        return forgetPassPage;    }

}

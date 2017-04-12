package testresources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;


public class PageResources {

    private LoginPage loginPage;
    private AddSubDepartment addSubDepartment;
    private AddReport addReport;
    private AddUser addUser;
    private AssignUser assignUser;
    private LogoutPage logoutPage;
    private AddDepartment addDepartment;
    private AddEntity addEntity;
    private EditCompany editCompany;
    private InviteUsertoNewEntity inviteUsertoNewEntity;
    private SubscribeUsingPaypal subscribeUsingPaypal;
    private ViewReport viewReport;
    private CleanUpAssignedUserData cleanUpAssignedUserData;
    private AddReport_Subject addReportSubject;
    private AddReport_Identifiers addReportIdentifiers;
    private AddReport_IDinformation addReportIDinformation;
    private AddReport_GangMembership addReportGangMembership;
    private AddReport_AddPhoto addReportAddPhoto;
    private AddReport_Vehicle addReportVehicle;
    private AddReport_Preview_PublishReport addReportPreviewPublishReport;
    private EDIT_DEPT edit_dept;
    private EditORG editORG;
    private FacebookLogin facebookLogin;
    private RegisterCompany registerCompany;
    private RegisterUser registerUser;

    public PageResources(WebDriver driver) {
        facebookLogin = new FacebookLogin();
        facebookLogin.FacebookLogin(driver);
        registerCompany= new RegisterCompany();
        registerCompany.RegisterCompany(driver);
        registerUser = new RegisterUser();
        registerUser.RegisterUser(driver);
        loginPage = new LoginPage();
        loginPage.LoginPage(driver);
        addSubDepartment = new AddSubDepartment(driver);
        addUser = new AddUser();
        addUser.AddUser(driver);
        addReport = new AddReport();
        addReport.AddReport(driver);
        assignUser = new AssignUser();
        assignUser.AssignUser(driver);
        logoutPage = new LogoutPage(driver);
        addDepartment = new AddDepartment();
        addDepartment.AddDepartment(driver);
        addEntity = new AddEntity();
        addEntity.AddEntity(driver);
        editCompany = new EditCompany();
        editCompany.EditCompany(driver);
        inviteUsertoNewEntity = new InviteUsertoNewEntity();
        inviteUsertoNewEntity.InviteUsertoNewEntity(driver);
        subscribeUsingPaypal = new SubscribeUsingPaypal();
        subscribeUsingPaypal.SubscribeUsingPaypal(driver);
        viewReport = new ViewReport();
        viewReport.ViewReport(driver);
        cleanUpAssignedUserData = new CleanUpAssignedUserData();
        cleanUpAssignedUserData.CleanUpAssignedUserData(driver);
        editORG = new EditORG();
        editORG.EditORG(driver);
        edit_dept = new EDIT_DEPT();
        edit_dept.EDIT_DEPT(driver);
        addReportSubject= new AddReport_Subject(driver);
        addReportIdentifiers= new AddReport_Identifiers(driver);
        addReportIDinformation= new AddReport_IDinformation(driver);
        addReportGangMembership= new AddReport_GangMembership(driver);
        addReportAddPhoto= new AddReport_AddPhoto(driver);
        addReportVehicle= new AddReport_Vehicle(driver);
        addReportPreviewPublishReport= new AddReport_Preview_PublishReport(driver);
    }


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AddSubDepartment getAddSubDepartment() {
        return addSubDepartment;
    }

    public AddUser getAddUser() {
        return addUser;
    }

    public AddReport getAddReport() {
        return addReport;
    }

    public AssignUser getAssignUser() {
        return assignUser;
    }

    public LogoutPage getLogoutPage() {
        return logoutPage;
    }

    public AddDepartment getAddDepartment() {
        return addDepartment;
    }

    public AddEntity getAddEntity() {
        return addEntity;
    }

    public ViewReport getViewReport() {
        return viewReport;
    }

    public EditCompany getEditCompany() {
        return editCompany;
    }

    public InviteUsertoNewEntity getInviteUsertoNewEntity() {
        return inviteUsertoNewEntity;
    }

    public SubscribeUsingPaypal getSubscribeUsingPaypal() {
        return subscribeUsingPaypal;
    }

    public CleanUpAssignedUserData getCleanUpAssignedUserData() {
        return cleanUpAssignedUserData;
    }

    public EditORG getEditORG() {
        return editORG;
    }

    public EDIT_DEPT getEdit_dept() {
        return edit_dept;
    }

    public AddReport_Subject getAddReportSubject() {
        return addReportSubject;
    }

    public AddReport_IDinformation getAddReportIDinformation() {
        return addReportIDinformation;
    }

    public AddReport_GangMembership getAddReportGangMembership() {
        return addReportGangMembership;
    }

    public AddReport_AddPhoto getAddReportAddPhoto() {
        return addReportAddPhoto;
    }

    public AddReport_Vehicle getAddReportVehicle() {
        return addReportVehicle;
    }

    public AddReport_Preview_PublishReport getAddReportPreviewPublishReport() {
        return addReportPreviewPublishReport;
    }

    public AddReport_Identifiers getAddReportIdentifiers() {
        return addReportIdentifiers;
    }


    public RegisterCompany getRegisterCompany() {
        return registerCompany;
    }

    public RegisterUser getRegisterUser() {
        return registerUser;
    }


    public FacebookLogin getFacebookLogin() {
        return facebookLogin;
    }
}
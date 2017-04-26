package ObjectRepository;
import Pages.*;
import org.openqa.selenium.WebDriver;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Jennifer Grelik on 3/16/2017.
 */
public class PageResources {
    private LoginPage loginPage;
    private AddReport addReport;
    private AddReportEntityTab addReportEntityTab;
    private AddReportSubjectInformationTab addReportSubjectInformationTab;
    private AddReportGangMembershipTab addReportGangMembershipTab;
    private AddReportPreviewTab addReportPreviewTab;
    private ReportsPage reportsPage;
    private ViewReport viewReport;
    private UsersPage usersPage;
    private InviteUserPage inviteUserPage;
    private UserPermissionsPage userPermissionsPage;
    private EntityPage entityPage;
    private ViewEntityPage viewEntityPage;
    private ViewDepartmentPage viewDepartmentPage;
    private AddDepartmentPage addDepartmentPage;
    private AddSubDepartmentPage addSubDepartmentPage;
    private UserMenuPanel userMenuPanel;
    private AddEntityPage addEntityPage;
    private AddEntityInviteUserPage addEntityInviteUserPage;
    private AddEntityInviteAdminPage addEntityInviteAdminPage;
    private AddEntitySubscriptionPage addEntitySubscriptionPage;
    private PaypalPage paypalPage;
    private PaypalLogin paypalLogin;
    private PaypalConfirmPaymentPage paypalConfirmPaymentPage;
    private UserSettingsPanel userSettingsPanel;
    private ChangeEntitySubPage changeEntitySubPage;
    private EntityAssignPermissionsPage entityAssignPermissionsPage;
    private MailsacPage mailsacPage;
    private MailsacInbox mailsacInbox;
    private MailsacViewMail mailsacViewMail;
    private MailsacUnblockLinksnImages mailsacUnblockLinksnImages;
    private RegistrationPage registrationPage;
    private ActivationPage activationPage;

    public PageResources(WebDriver driver) {

        loginPage = new LoginPage(driver);

        addReport = new AddReport(driver);

        addReportEntityTab = new AddReportEntityTab(driver);

        addReportSubjectInformationTab = new AddReportSubjectInformationTab(driver);

        addReportGangMembershipTab = new AddReportGangMembershipTab(driver);

        addReportPreviewTab = new AddReportPreviewTab(driver);

        reportsPage = new ReportsPage(driver);

        viewReport = new ViewReport(driver);

        usersPage = new UsersPage(driver);

        inviteUserPage = new InviteUserPage(driver);

        userPermissionsPage = new UserPermissionsPage(driver);

        entityPage = new EntityPage(driver);

        viewEntityPage = new ViewEntityPage(driver);

        viewDepartmentPage = new ViewDepartmentPage(driver);

        addDepartmentPage = new AddDepartmentPage(driver);

        addSubDepartmentPage = new AddSubDepartmentPage(driver);

        userMenuPanel = new UserMenuPanel(driver);

        addEntityPage = new AddEntityPage(driver);

        addEntityInviteUserPage = new AddEntityInviteUserPage(driver);

        addEntityInviteAdminPage = new AddEntityInviteAdminPage(driver);

        addEntitySubscriptionPage = new AddEntitySubscriptionPage(driver);

        paypalPage = new PaypalPage(driver);

        paypalLogin = new PaypalLogin(driver);

        paypalConfirmPaymentPage = new PaypalConfirmPaymentPage(driver);

        userSettingsPanel = new UserSettingsPanel(driver);

        changeEntitySubPage = new ChangeEntitySubPage(driver);

        entityAssignPermissionsPage = new EntityAssignPermissionsPage(driver);

        mailsacPage = new MailsacPage(driver);

        mailsacInbox = new MailsacInbox(driver);

        mailsacViewMail = new MailsacViewMail(driver);

        mailsacUnblockLinksnImages = new MailsacUnblockLinksnImages(driver);

        registrationPage = new RegistrationPage(driver);

        activationPage = new ActivationPage(driver);

    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public AddReport getAddReport(){
        return addReport;
    }

    public AddReportEntityTab getAddReportEntityTab(){

        return addReportEntityTab;
    }

    public AddReportSubjectInformationTab getAddReportSubjectInformationTab(){

        return addReportSubjectInformationTab;
    }

    public AddReportGangMembershipTab getAddReportGangMembershipTab(){

        return addReportGangMembershipTab;
    }

    public AddReportPreviewTab getAddReportPreviewTab(){

        return addReportPreviewTab;
    }

    public ReportsPage getReportsPage(){

        return reportsPage;
    }

    public ViewReport getViewReport(){

        return viewReport;
    }

    public UsersPage getUsersPage(){

        return usersPage;
    }

    public InviteUserPage getInviteUserPage(){

        return inviteUserPage;
    }

    public UserPermissionsPage getUserPermissionsPage(){

        return userPermissionsPage;
    }

    public EntityPage getEntityPage(){

        return entityPage;
    }

    public ViewEntityPage getViewEntityPage(){

        return viewEntityPage;
    }

    public ViewDepartmentPage getViewDepartmentPage(){

        return viewDepartmentPage;
    }

    public AddDepartmentPage getAddDepartmentPage(){

        return addDepartmentPage;
    }

    public AddSubDepartmentPage getAddSubDepartmentPage(){

        return addSubDepartmentPage;
    }

    public UserMenuPanel getUserMenuPanel(){

        return userMenuPanel;
    }

    public AddEntityPage getAddEntityPage(){

        return addEntityPage;
    }

    public AddEntityInviteUserPage getAddEntityInviteUserPage(){

        return addEntityInviteUserPage;
    }

    public AddEntityInviteAdminPage getAddEntityInviteAdminPage(){

        return addEntityInviteAdminPage;
    }

    public AddEntitySubscriptionPage getAddEntitySubscriptionPage(){

        return addEntitySubscriptionPage;
    }

    public PaypalPage getPaypalPage(){

        return paypalPage;
    }

    public PaypalLogin getPaypalLogin(){

        return paypalLogin;
    }

    public PaypalConfirmPaymentPage getPaypalConfirmPaymentPage(){

        return paypalConfirmPaymentPage;
    }

    public UserSettingsPanel getUserSettingsPanel(){

        return userSettingsPanel;
    }

    public ChangeEntitySubPage getChangeEntitySubPage(){

        return changeEntitySubPage;
    }

    public EntityAssignPermissionsPage getEntityAssignPermissionsPage(){

        return entityAssignPermissionsPage;
    }

    public MailsacPage getMailsacPage(){

        return mailsacPage;
    }

    public MailsacInbox getMailsacInbox(){

        return mailsacInbox;
    }

    public MailsacUnblockLinksnImages getMailsacUnblockLinksnImages(){

        return mailsacUnblockLinksnImages;
    }

    public RegistrationPage getRegistrationPage(){

        return registrationPage;
    }

    public ActivationPage getActivationPage(){

        return activationPage;
    }

    public MailsacViewMail getMailsacViewMail(){

        return mailsacViewMail;
    }
}

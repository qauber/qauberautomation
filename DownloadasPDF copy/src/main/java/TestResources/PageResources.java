package TestResources;

import Pages.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by jaishree on 3/26/17.
 */
public class PageResources {
    Login login;
    ViewReports viewReports;
    DataProvidersClass dataProvidersClass;
    ViewSpecificReport viewSpecificReport;

    public MainNavigation getMainNavigation() {
        return mainNavigation;
    }

    MainNavigation mainNavigation;

    public AddReports getAddReports() {
        return addReports;
    }

    AddReports addReports;

    public Distribution getDistribution() {
        return distribution;
    }

    Distribution distribution;

    public Identifiers getIdentifiers() {
        return identifiers;
    }

    Identifiers identifiers;

    public IDInformation getIdInformation() {
        return idInformation;
    }

    IDInformation idInformation;

    public Photos getPhotos() {
        return photos;
    }

    Photos photos;

    public Preview getPreview() {
        return preview;
    }

    Preview preview;

    public Reports getReports() {
        return reports;
    }

    Reports reports;

    public SubjectInformation getSubjectInformation() {
        return subjectInformation;
    }

    SubjectInformation subjectInformation;

    public Vehicle getVehicle() {
        return vehicle;
    }

    Vehicle vehicle;


    Entities entities;

    public Paypal getPaypal() {
        return paypal;
    }

    Paypal paypal;


    CreateEntities createEntities;

    public InviteRegularUser getInviteRegularUser() {
        return inviteRegularUser;
    }

    InviteRegularUser inviteRegularUser;

    public InviteAdminUser getInviteAdminUser() {
        return inviteAdminUser;
    }

    InviteAdminUser inviteAdminUser;


    public ViewReports getViewReports() {
        return viewReports;
    }

    public ViewSpecificReport getViewSpecificReport() {
        return viewSpecificReport;
    }

    public Login getLogin() {
        return login;
    }

    public Entities getEntities() {
        return entities;
    }

    public CreateEntities getCreateEntities() {
        return createEntities;
    }

    public PageResources(WebDriver driver) {
        login = new Login(driver);
        viewReports = new ViewReports(driver);
        viewSpecificReport = new ViewSpecificReport(driver);
        addReports = new AddReports(driver);
        distribution = new Distribution(driver);
        identifiers = new Identifiers(driver);
        idInformation = new IDInformation(driver);
        photos = new Photos(driver);
        preview = new Preview(driver);
        reports = new Reports(driver);
        subjectInformation = new SubjectInformation(driver);
        vehicle = new Vehicle(driver);
        mainNavigation = new MainNavigation(driver);
        entities = new Entities(driver);
        createEntities = new CreateEntities(driver);
        inviteAdminUser = new InviteAdminUser(driver);
        inviteRegularUser = new InviteRegularUser(driver);
        paypal = new Paypal(driver);

    }

}



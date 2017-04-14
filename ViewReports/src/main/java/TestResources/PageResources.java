package TestResources;

import Pages.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by jaishree on 3/24/17.
 */
public class PageResources {

    Login login;

    Reports reports;

    ViewReports viewReports;

    DataProvidersClass dataProvidersClass;

    Identifiers identifiers;

    AddReports addReports;

    SubjectInformation subjectInformation;

    ViewSpecificReport viewSpecificReport;

    IDInformation idInformation;

    Distribution distribution;

    Vehicle vehicle;

    Preview preview;

    Photos photos;

    Entities entities;

    InviteRegularUser inviteRegularUser;

    public InviteRegularUser getInviteRegularUser() {
        return inviteRegularUser;
    }

    public InviteAdminUser getInviteAdminUser() {
        return inviteAdminUser;
    }

    InviteAdminUser inviteAdminUser;

    public CreateEntities getCreateEntities() {
        return createEntities;
    }

    CreateEntities createEntities;

    Paypal paypal;

    public Paypal getPaypal() {
        return paypal;
    }



    public Reports getReports() {
        return reports;
    }

    public ViewReports getViewReports() {
        return viewReports;
    }

    public ViewSpecificReport getViewSpecificReport() {
        return viewSpecificReport;
    }

    public Login getLogin() {
        return login;
    }

    public AddReports getAddReports() {
        return addReports;
    }

    public Entities getEntities() {
        return entities;
    }

    public SubjectInformation getSubjectInformation() {
        return subjectInformation;
    }

    public Identifiers getIdentifiers() {
        return identifiers;
    }

    public IDInformation getIdInformation() {
        return idInformation;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Preview getPreview() {
        return preview;
    }

    public Photos getPhotos() {
        return photos;
    }



    public PageResources(WebDriver driver) {
        login = new Login(driver);
        reports = new Reports(driver);
        viewReports = new ViewReports(driver);
        viewSpecificReport = new ViewSpecificReport(driver);
        addReports = new AddReports(driver);
        subjectInformation = new SubjectInformation(driver);
        identifiers = new Identifiers(driver);
        idInformation = new IDInformation(driver);
        distribution = new Distribution(driver);
        photos = new Photos(driver);
        vehicle = new Vehicle(driver);
        preview = new Preview(driver);
        entities = new Entities(driver);
        createEntities = new CreateEntities(driver);
        paypal = new Paypal(driver);
        inviteAdminUser = new InviteAdminUser(driver);
        inviteRegularUser = new InviteRegularUser(driver);
    }

}

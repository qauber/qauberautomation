package TestResources;

import Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by jaishree on 4/6/17.
 */
public class PageResources {
    Login login;
    ViewReports viewReports;

    public DataProvidersClass getDataProvidersClass() {
        return dataProvidersClass;
    }

    DataProvidersClass dataProvidersClass;


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


    CreateEntities createEntities;

    public InviteAdminUser getInviteAdminUser() {
        return inviteAdminUser;
    }

    InviteAdminUser inviteAdminUser;

    public InviteRegularUser getInviteRegularUser() {
        return inviteRegularUser;
    }

    InviteRegularUser inviteRegularUser;

    public Paypal getPaypal() {
        return paypal;
    }

    Paypal paypal;

    public Entities getEntities() {
        return entities;
    }

    Entities entities;


    public ViewReports getViewReports() {
        return viewReports;
    }


    public Login getLogin() {
        return login;
    }


    public CreateEntities getCreateEntities() {
        return createEntities;
    }

    public PageResources(WebDriver driver) {
        login = new Login(driver);
        viewReports = new ViewReports(driver);
        addReports = new AddReports(driver);
        distribution = new Distribution(driver);
        identifiers = new Identifiers(driver);
        idInformation = new IDInformation(driver);
        photos = new Photos(driver);
        preview = new Preview(driver);
        reports = new Reports(driver);
        subjectInformation = new SubjectInformation(driver);
        vehicle = new Vehicle(driver);
        createEntities = new CreateEntities(driver);
        inviteRegularUser = new InviteRegularUser(driver);
        inviteAdminUser = new InviteAdminUser(driver);
        paypal = new Paypal(driver);
        entities = new Entities(driver);
    }


}

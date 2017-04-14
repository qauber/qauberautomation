package TestResources;

import Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by jaishree on 3/24/17.
 */
public class PageResources {


    Login login;
    AddReports addReports;
    Distribution distribution;
    Identifiers identifiers;
    IDInformation idInformation;
    Photos photos;
    Preview preview;
    SubjectInformation subjectInformation;
    Vehicle vehicle;
    ReportInformation reportInformation;

    public Entities getEntities() {
        return entities;
    }

    Entities entities;

    public Paypal getPaypal() {
        return paypal;
    }

    Paypal paypal;

    public InviteAdminUser getInviteAdminUser() {
        return inviteAdminUser;
    }

    InviteAdminUser inviteAdminUser;

    public InviteRegularUser getInviteRegularUser() {
        return inviteRegularUser;
    }

    InviteRegularUser inviteRegularUser;

    public CreateEntities getCreateEntities() {
        return createEntities;
    }

    CreateEntities createEntities;


    public ReportInformation getReportInformation() {
        return reportInformation;
    }



    public Login getLogin() {               //create a public class login, right click and generate a getter
        return login;
    }


    public AddReports getAddReports() {
        return addReports;
    }


    public Distribution getDistribution() {
        return distribution;
    }

    public Identifiers getIdentifiers() {
        return identifiers;
    }


    public IDInformation getIdInformation() {
        return idInformation;
    }


    public Preview getPreview() {
        return preview;
    }


    public SubjectInformation getSubjectInformation() {
        return subjectInformation;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public Photos getPhotos() {
        return photos;
    }



    public PageResources(WebDriver driver){     //create a public PageResources function and pass Webdriver to initialize object
        login= new Login(driver);               //create or initialize new object login to act on behalf of Login by driver
        addReports =new AddReports(driver);
        distribution = new Distribution(driver);
        identifiers = new Identifiers(driver);
        idInformation = new IDInformation(driver);
        photos = new Photos(driver);
        preview = new Preview(driver);
        subjectInformation = new SubjectInformation(driver);
        vehicle = new Vehicle(driver);
        reportInformation = new ReportInformation(driver);
        inviteAdminUser = new InviteAdminUser(driver);
        inviteRegularUser = new InviteRegularUser(driver);
        createEntities = new CreateEntities(driver);
        paypal = new Paypal(driver);
        entities = new Entities(driver);
    }


}

package TestResources;
import Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by jaishree on 4/6/17.
 */
public class PageResources {

    Login login;

    CreateEntities createEntities;

    DataProviderClass dataProviderClass;

    Entities entities;

    MainNavigation mainNavigation;

    InviteRegularUser inviteRegularUser;

    InviteAdminUser inviteAdminUser;

    Paypal paypal;

    public InviteAdminUser getInviteAdminUser() {
        return inviteAdminUser;
    }

    public Paypal getPaypal() {
        return paypal;
    }

    public Login getLogin() {
        return login;
    }

    public CreateEntities getCreateEntities() {
        return createEntities;
    }

    public MainNavigation getMainNavigation() {
        return mainNavigation;
    }

    public InviteRegularUser getInviteRegularUser() {
        return inviteRegularUser;
    }

    public Entities getEntities() {
        return entities;
    }

    public DataProviderClass getDataProviderClass() {
        return dataProviderClass;
    }

    public PageResources(WebDriver driver){
        login= new Login(driver);
        createEntities = new CreateEntities(driver);
        mainNavigation = new MainNavigation(driver);
        inviteRegularUser = new InviteRegularUser(driver);
        inviteAdminUser = new InviteAdminUser(driver);
        paypal = new Paypal(driver);
        entities = new Entities(driver);

    }




}

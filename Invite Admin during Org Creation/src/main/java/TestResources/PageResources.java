package TestResources;

import Pages.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by jaishree on 3/23/17.
 */
public class PageResources {

                         //PageResources is the mediator between Pages and Testcase




    Login login;
    CreateEntity createEntity;
    DataProviderClass dataProviderClass;
    MainNavigation mainNavigation;
    InviteRegularUsers inviteRegularUsers;
    InviteAdminUsers inviteAdminUsers;

    public Entities getEntities() {
        return entities;
    }

    Entities entities;



    Users users;


    Paypal paypal;

    public Login getLogin() {
        return login;
    }

    public CreateEntity getCreateEntity() {
        return createEntity;
    }

    public DataProviderClass getDataProviderClass() {
        return dataProviderClass;
    }

    public MainNavigation getMainNavigation() {
        return mainNavigation;
    }

    public InviteRegularUsers getInviteRegularUsers() {
        return inviteRegularUsers;
    }

    public InviteAdminUsers getInviteAdminUsers() {
        return inviteAdminUsers;
    }

    public Paypal getPaypal() {
        return paypal;
    }

    public Users getUsers() {
        return users;
    }

    public PageResources(WebDriver driver){
        login= new Login(driver);
        createEntity = new CreateEntity(driver);
        mainNavigation = new MainNavigation(driver);
        inviteRegularUsers = new InviteRegularUsers(driver);
        inviteAdminUsers = new InviteAdminUsers(driver);
        paypal = new Paypal(driver);
        users= new Users(driver);
        entities = new Entities(driver);

    }


}


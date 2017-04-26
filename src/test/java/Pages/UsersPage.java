package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Jenny on 3/19/2017.
 */
public class UsersPage {
    ///// UsersPage Objects /////

    WebDriver driver;

    By usersLink = By.xpath("//*[@title=\"Users\"]");
    By inviteUser = By.xpath("//*[@class=\"pull-right btn btn-info btn-sm\"]");
    By addedUser = By.xpath("*//tr[6]/td[1]/div/div[1]/div/div[2]/div[2]/span/a"); //Delete
    By assignPermissions = By.xpath("*//tr[2]/td[2]/button[1]");
    By reassignPermissions = By.xpath("*//tr[1]/td[2]/button[1]");
    By confirmDeletion = By.xpath("//button[contains(text(), 'Delete')]");

    public UsersPage(WebDriver driver){

        this.driver = driver;
    }

    // "Users" link

    public WebElement usersLink(){

        return driver.findElement(usersLink);
    }

    // "Invite User" button

    public WebElement inviteUser(){

        return driver.findElement(inviteUser);
    }

    // Name of added user

    public WebElement addedUser(){

        return driver.findElement(addedUser);
    }

    // "Assign Permissions" button for added user.

    public WebElement assignPermissions(){

        return driver.findElement(assignPermissions);
    }

    // "Assign Permissions" button for the first user in list.

    public WebElement reassignPermissions(){

        return driver.findElement(reassignPermissions);
    }

    public WebElement confirmDeletion(){

        return driver.findElement(confirmDeletion);
    }
}

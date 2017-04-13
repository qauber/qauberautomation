package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Created By Anbu */

public class InviteUser {
    WebDriver driver;

    By Users = By.xpath("//a[@class='ng-scope']//span[text()='Users']");
    By InviteUser_button= By.xpath("//h3[@class='h3-alt ng-scope']//button[text()='Invite User']");
    //By InviteUser_frame = By.name("inviteForm");
    By UserEmail =By.xpath("//form//input[@name='email']");
    By SendInvite_button= By.xpath("//button[@type='button']");


    public InviteUser(WebDriver driver) {

        this.driver = driver;
    }

    public void invite_user() throws InterruptedException {

        driver.findElement(Users).click();
        driver.findElement(InviteUser_button).click();
        driver.findElement(UserEmail).sendKeys("a@gmail.com");
        driver.findElement(SendInvite_button).click();
        Thread.sleep(3000);
    }
}

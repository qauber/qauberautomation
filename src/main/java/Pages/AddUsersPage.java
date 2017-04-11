package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUsersPage {
	///// Invite User Object //////

	WebDriver driver;

	public AddUsersPage(WebDriver driver)
	{
		this.driver = driver;
	}
    By UserSetting  = By.xpath("html/body/div[2]/section/div/div/div/div/table/tbody/tr[1]/td[2]/button[1]");
	By Users = By.xpath("//span[text()='Users']");//span[text()='Users']
	By inviteUser = By.xpath("html/body/div[2]/section/div/h3/button");
	By SendEmailInviteUser= By.xpath("//input[@ng-model='inviteEmail']");
    By sendInvitationbutton= By.xpath("//button[@ng-click='validateForm() && confirm(inviteEmail)']");
    By AssignUser= By.xpath("(//tr/td[2]/button[@title='Assign permissions'])[last()]");
    By dropdown=  By.xpath(".//*[@id='ngdialog3']/div[2]/div[1]/div/table/tbody/tr/td[2]/select");
	 By closePopup = By.xpath("//div[@class='ngdialog-content']/div[2]");
	 By saveBtn= By.xpath(".//*[@id='ngdialog3']/div[2]/div[1]/div/table/tbody/tr[2]/td[3]/button[1]");

	public WebElement users() {
		
		return driver.findElement(Users);
	}
	public WebElement SendInvitatonButton(){
		return driver.findElement(sendInvitationbutton);
	}
	public WebElement InviteUser() {
		return driver.findElement(inviteUser);
	}
	public  WebElement UserSetting(){return driver.findElement(UserSetting);	}
	public WebElement SendEmailInviteUser(){return driver.findElement(SendEmailInviteUser);	}
	public WebElement AssignUser(){ return driver.findElement(AssignUser);}
	public WebElement dropdown(){return driver.findElement(dropdown);}
	public WebElement closePopup(){return driver.findElement(closePopup);}
	public WebElement SaveBtn(){return  driver.findElement(saveBtn);}

}
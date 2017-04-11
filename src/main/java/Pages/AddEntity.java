package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEntity
{

	WebDriver driver;

	public AddEntity(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By EntityBtn = By.xpath("//nav/ul/li[2]");
	By addEntityButton= By.xpath("//div/h3/button[@class='pull-right btn btn-info btn-sm mt-sm ng-binding']");
	By EntityName= By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[1]/div[1]/div/input");
	By country = By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[2]/select");
	By Address = By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[3]/input");
	By city = By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[5]/input");
	By state = By.xpath("//select[@name='state']");
	By PostalCode = By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[2]/div[1]/div[7]/input");
	By phone = By.xpath("html/body/div[2]/section/div/div/div[1]/div[1]/form/div[1]/div[2]/div/input");
	By Email= By.xpath("//input[@name='email']");
	By NextStep= By.xpath("html/body/div[2]/section/div/div/div[2]/button[2]");
	//Invite Regular user
	By InviteRegularUser = By.xpath("html/body/div[2]/section/div/div/div[1]/div[2]/form/div/div/input");
	By Nextpage1 = By.xpath("html/body/div[2]/section/div/div/div[2]/button[2]");
	By OK= By.xpath(".//*[@id='ngdialog1']/div[2]/div/button");
	//Invite Admin User
	By AdminUser = By.xpath("html/body/div[2]/section/div/div/div[1]/div[3]/form/div/div/input");
	By Nextpage2= By.xpath("html/body/div[2]/section/div/div/div[2]/button[2]");
	By OK1 = By.xpath(".//*[@id='ngdialog2']/div[2]/div/button");
	By Finish= By.xpath("html/body/div[2]/section/div/div/div[2]/button[2]");
	//pAYpAL
	 By methodPaypal= By.xpath("//input[@id='loadLogin']");
	 By emailPaypal = By.xpath(".//*[@id='login_email']");
	 By passPaypal= By.xpath(".//*[@id='login_password']");
	 By loginPaypal= By.xpath(".//*[@id='submitLogin']");
	 By contiuePayPall=By.xpath("//input[@id='continue']");

	public WebElement methodPaypal()
	{
		return driver.findElement(methodPaypal);
	}

	public WebElement emailPaypal(){
		return driver.findElement(emailPaypal);
	}
	public WebElement passPaypal()
	{
		return driver.findElement(passPaypal);
	}

	public WebElement loginPaypal()
	{
		return  driver.findElement(loginPaypal);
	}
	public WebElement continuePaypal()
	{
		return driver.findElement(contiuePayPall);
	}

	public WebElement AdminUser()
	{
		return driver.findElement(AdminUser);
	}
	public WebElement Finish()
	{
		return driver.findElement(Finish);
	}
	public WebElement NextPage2()
	{
		return driver.findElement(Nextpage2);
	}
	public WebElement ok1(){
		return driver.findElement(OK1);
	}
	public WebElement OK()
	{
		return driver.findElement(OK);
	}
	public WebElement NextPage1() {
		return driver.findElement(Nextpage1);
	}
	public WebElement InviteUser() {
		return driver.findElement(InviteRegularUser);
	}
	public WebElement Country(){
		return driver.findElement(country);
	}
	public WebElement EntityBtn(){		return driver.findElement(EntityBtn);
	}
	public WebElement addEntityButton(){
		return driver.findElement(addEntityButton);
			}
	public WebElement EntityName(){
		return driver.findElement(EntityName);
	}
	public WebElement Address(){
		return driver.findElement(Address);
	}
	public WebElement City(){
		return driver.findElement(city);
			}
	public WebElement PostalCode(){
		return driver.findElement(PostalCode);
	}
	public WebElement Phone(){
		return driver.findElement(phone);
			}
	public WebElement state(){
		return driver.findElement(By.xpath("//select[@name='state']"));
	}
	public WebElement Email(){
		return driver.findElement(Email);
			}
	public WebElement NextStep(){
		return driver.findElement(NextStep);
	}

}
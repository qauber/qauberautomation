package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


	WebDriver driver;
	By EmailID = By.xpath(".//*[@id='exampleInputEmail1']");
	By password= By.xpath(".//*[@id='exampleInputPassword1']");
	By signIn = By.xpath("//button[@type='submit']");
	By UserNameProfile = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By EmailCheck= By.xpath("//h5[@class='ng-binding']");


	public WebElement EmailCheck()	{ return  driver.findElement(EmailCheck);}

	public WebElement UserNameProfile()
	{ return  driver.findElement(UserNameProfile);}
	public WebElement EmailId()	{return driver.findElement(EmailID);	}
	public WebElement password()
	{
		return driver.findElement(password);
	}

	public WebElement SignIn(){
		return driver.findElement(signIn);
	}

	public LoginPage (WebDriver driver){
		this.driver=driver;
	}
}

package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;


public class InviteUsertoNewEntity {
    WebDriver driver;

    private By  inviteRUemail = By.cssSelector(".bootstrap-tagsinput>input");
    private By  nextStepButtonRU = By.cssSelector("button.btn-info:nth-child(2)");
    private By  doneButtonRU= By.cssSelector("div.text-right:nth-child(3) > button:nth-child(1)");
    private By  inviteAUemail= By.cssSelector("form.ng-pristine:nth-child(5) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
    private By  nextStepButtonAU= By.cssSelector("button.btn-info:nth-child(2)");
    private By  doneButtonAU = By.cssSelector("div.text-right:nth-child(3) > button:nth-child(1)");
    private By subscribeFinishButton=By.cssSelector("button.btn-info:nth-child(2)");

    public void InviteUsertoNewEntity(WebDriver driver){ this.driver= driver; }
    public void setInviteRUemail(String strRUemail){driver.findElement(inviteRUemail).sendKeys(strRUemail);}
    public void clickNextStepButtonRU(){driver.findElement(nextStepButtonRU ).click();}
    public void clickdoneButtonRU(){driver.findElement(doneButtonRU).click();}
    public void setinviteAUemail(String strAUemail){driver.findElement(inviteAUemail).sendKeys(strAUemail);}
    public void clickNextStepButtonAU(){driver.findElement(nextStepButtonAU).click();}
    public void clickdoneButtonAU(){driver.findElement(doneButtonAU).click();}
    public void clicksubscribeFinishButton(){driver.findElement(subscribeFinishButton).click();}

    public void InviteUserEntity(String strRUemail,String strAUemail) throws InterruptedException{
        this.setInviteRUemail(strRUemail);Thread.sleep(8000);
        this.clickNextStepButtonRU();Thread.sleep(8000);
        this.clickdoneButtonRU();Thread.sleep(8000);
        this.setinviteAUemail(strAUemail);Thread.sleep(8000);
        this.clickNextStepButtonAU();Thread.sleep(8000);
        this.clickdoneButtonAU();Thread.sleep(8000);
        this.clicksubscribeFinishButton();Thread.sleep(8000);
    }

}

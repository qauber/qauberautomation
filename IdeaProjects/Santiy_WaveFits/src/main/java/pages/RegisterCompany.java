package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCompany {
    WebDriver driver;
    private By companyName= By.xpath("//input[@name='name']");
    private By contactPhone = By.xpath("//input[@name='phone']");
    private By contactEmail= By.xpath("//input[@name='email']");
    private By country = By.xpath("//select[@name='country']");
    private By address = By.xpath("//input[@name='address1']");
    private By city= By.xpath("//input[@name='city']");
    private By state= By.cssSelector("input.form-control:nth-child(3)");
    private By postalCode = By.xpath("//input[@name='zip']");
    private By finishButton= By.xpath("//button[@id='registerConfirm']");


    public void RegisterCompany(WebDriver driver){
        this.driver= driver;
    }
    public void setCompanyName(String strName){
        driver.findElement(companyName).sendKeys(strName);
    }
    public void setContactPhone(String strPhone){
        driver.findElement(contactPhone).sendKeys(strPhone);
    }
    public void setContactEmail(String strEmail){
        driver.findElement(contactEmail).sendKeys(strEmail);

    }
    public void setCountry(String strCountry){
        driver.findElement(country).sendKeys(strCountry);
    }
    public void setAddress(String strAddress){
        driver.findElement(address).sendKeys(strAddress);
    }
    public void setCity (String strCity){
        driver.findElement(city).sendKeys(strCity);
    }
    public void setState(String strState){
        driver.findElement(state).sendKeys(strState);
    }
    public void setPostalCode(String strZip){
        driver.findElement(postalCode).sendKeys(strZip);
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }

}

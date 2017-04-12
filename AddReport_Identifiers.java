package pages;


//*Created By Em


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.*;
public class AddReport_Identifiers {
    WebDriver driver;

    //  Identifiers page


    private By identifiersPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[3]");
    private By tattooCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.tattoos']");
    private By tattooTextField = By.xpath("//input[@name='Tattoos']");
    private By scarCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.scars']");
    private By scarTextField = By.xpath("//input[@name='Scars']");
    private By needleMarksCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.needleMarks']");
    private By needleTextField = By.xpath("//input[@name='needleMarks']");
    private By tracksCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.tracks']");
    private By tracksTextField = By.xpath("//input[@name='Tracks']");
    private By glassesCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.glasses']");
    private By glassesTextField = By.xpath("//input[@name='Glasses']");
    private By mustacheCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.mustache']");
    private By mustacheTextField = By.xpath("//input[@name='Mustache']");
    private By beardCheckbox = By.xpath("//div[@class='input-group']//input[@ng-model='wizard.report.beard']");
    private By beardTextField = By.xpath("//input[@name='Beard']");


    //###########################################################################################################
    public AddReport_Identifiers(WebDriver driver){
        this.driver=driver;
    }
    public void clickOnIdentifiersPage (){


        WebElement element = driver.findElement(identifiersPage);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);}

    public void setTattooCheckbox (){ driver.findElement(tattooCheckbox).click();    }
    public void setTattooTextField(String strTattoo){ driver.findElement(tattooTextField).sendKeys(strTattoo);    }
    public void setScarCheckbox (){ driver.findElement(scarCheckbox).click();    }
    public void setScarTextField(String strScar){ driver.findElement(scarTextField).sendKeys(strScar);    }
    public void setNeedleMarksCheckbox(){  driver.findElement(needleMarksCheckbox).click();    }
    public void setNeedleTextField (String strNeedleMarks){ driver.findElement(needleTextField).sendKeys(strNeedleMarks);    }
    public void setTracksCheckbox (){  driver.findElement(tracksCheckbox).click();    }
    public void setTracksTextField(String strTrack){  driver.findElement(tracksTextField).sendKeys(strTrack);    }
    public void setGlassesCheckbox(){ driver.findElement(glassesCheckbox).click();    }
    public void setGlassesTextField(String strGlasses){   driver.findElement(glassesTextField).sendKeys(strGlasses);    }
    public void setMustacheCheckbox(){   driver.findElement(mustacheCheckbox).click();    }
    public void setMustacheTextField(String strMustache){  driver.findElement(mustacheTextField).sendKeys(strMustache);    }
    public void setBeardCheckbox(){    driver.findElement(beardCheckbox).click();    }
    public void setBeardTextField(String strBeard){  driver.findElement( beardTextField).sendKeys(strBeard);   }
















}

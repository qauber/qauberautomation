package pages;


//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class AddReport_AddPhoto {
    WebDriver driver;
    //Photo page

    private By photosPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[7]");
    private By addPhotoButton = By.xpath("//button[@class='upload btn btn-primary btn-labeled']");

    //###########################################################################################################
    public AddReport_AddPhoto(WebDriver driver){
        this.driver=driver;
    }
    public void  clickPhotosPage(){driver.findElement(photosPage).click();}

    public void  clickAddPhotoButton() {
    driver.findElement(addPhotoButton).click();



    }

}

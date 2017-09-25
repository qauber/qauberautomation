package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sc on 2/13/2017.
 */
public class NavBar {

    WebDriver dr;
    WebElement element;
    public NavBar(WebDriver dr){

        System.out.println("Getting the links from Main Navigation");
        this.dr=dr;
    }

    public WebElement entitiesButton(){
       return dr.findElement(By.xpath("//a[@title='Entities']"));

    }

    public WebElement usersButton() {
        element = dr.findElement(By.xpath("//a[@title='Users']"));
        return element;
    }

    public WebElement addReportButton() {
        element = dr.findElement(By.xpath("//span[contains(text(),'Add Report')]"));
        return element;
    }

    public WebElement reportsButton() {
        element = dr.findElement(By.xpath("//a[@title='Reports']"));
        return element;
    }
    public WebElement mainNavigationText() {
        element = dr.findElement(By.xpath("//nav[@class=\"sidebar\"]/ul/li[1]"));
        return element;
    }

    public List<WebElement> navbarlist(){

        return dr.findElements(By.xpath("//ul[@class='nav ng-scope']"));
    }



}

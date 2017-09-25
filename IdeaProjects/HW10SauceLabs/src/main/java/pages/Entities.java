package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sc on 2/13/2017.
 */
public class Entities {

    WebDriver dr;
    Faker faker = new Faker();
    WebElement element;
    public Entities(WebDriver dr) {

        System.out.println("This is Entities Page");
        this.dr = dr;
    }

    public WebElement entitiesButton(){
        return dr.findElement(By.xpath("//a[@class='ng-scope']/span[text()='Entities']"));
    }

    public WebElement addOrganisationButton(){

         return dr.findElement(By.xpath("//button[text()='Add Entity']"));
    }

    public List<WebElement> organizationList(){
           return dr.findElements(By.xpath("//td//a[@class='ng-binding']"));
    }

    public WebElement organizationInfo(int rowindex){
        return organizationList().get(rowindex - 1);
    }

    public List<WebElement> entitySubscriptionUserList(){
        return dr.findElements(By.xpath("//*[contains(text(),'Users used')]"));
    }


    public WebElement organizationSubscriptionUsers(int rowindex){
        return entitySubscriptionUserList().get(rowindex - 1);
    }

    // web element list for assign permissions button
    public List<WebElement> assignPermissionsButtonList(){
        return dr.findElements(By.xpath("//*[@title='Assign permissions']"));

    }

    public WebElement assignPermissionButton(int rowIndex) {
        return assignPermissionsButtonList().get(rowIndex -1);

    }

    public WebElement organizationLogo(int rowindex){
        return  dr.findElement(By.xpath("//div[@class='text-center inline'][rowindex]"));
    }



    // Web element list for deletion
    public List<WebElement> deleteOrganizationButtonList(){
        return dr.findElements(By.xpath("//*[@title='Delete']"));
    }

    // Web element for "Action" delete an organization
    public WebElement deleteOrganizationButton(int rowindex){
        return deleteOrganizationButtonList().get(rowindex - 1);
    }

    // Web element for "Action" edit organization
    public List<WebElement> editOrganizationButtonList(){

        return dr.findElements(By.xpath("//button[@title='Edit']"));
    }

    // Web element for "Action" edit organization
    public WebElement editOrganizationButton(int rowindex){

        return editOrganizationButtonList().get(rowindex-1);
    }
    //finish button
    public List<WebElement> finishCreateOrganizationButtonList(){
        return dr.findElements(By.xpath("//button[@title='Finish creating the entity']"));
    }

    public WebElement finishCreateOrganizationButton(int rowindex){
        return finishCreateOrganizationButtonList().get(rowindex);
    }

    // find the matching web element from web elements list
    public int findEditOrganizationIndex(String orgname){
        List<WebElement> els = organizationList();
        int rowindex = 1;
        for (int i = 0; i < els.size(); i++){
            if (els.get(i).getText().equals(orgname)){
                break;
            } else {
                rowindex++;
            }
        }
        if (rowindex == els.size()+1){
            System.out.println("The organization is not on the list");
        }
        return rowindex;
    }
// Add department after adding the entity
    public WebElement AddDepartmentButton() {
        element = dr.findElement(By.xpath("//button[@title='Add Department']"));
        return element;
    }

    public WebElement AddDepartmentField() {
        element = dr.findElement(By.xpath("//input[@placeholder='Department name']"));
        return element;
    }

    public WebElement CreatDepartmentButton() {
        element = dr.findElement(By.xpath("//div[@class='clearfix']"));
        return element;
    }
//From here it is not done by soni Chalasani-- May be needed to edit again

    //On department
    //get web element list for department name
    public List<WebElement> departmentNameList(){
        return dr.findElements(By.xpath("//td[@class='pl-lg']/a[@class='ng-binding']"));
    }

    public WebElement departmentName(int index){
        return departmentNameList().get(index - 1);
    }

    //get web element list for department assign permissions buttons
    public List<WebElement> departmentAssignPermissionsButtonList(){
        return dr.findElements(By.xpath("//*[@title='Assign permissions']"));
    }

    public WebElement departmentAssignPermissionsButton(int index){
        return departmentAssignPermissionsButtonList().get(index - 1);
    }

    //get web element list for department edit buttons
    public List<WebElement> departmentEditButtonList(){
        return dr.findElements(By.xpath("//*[@title='Edit']"));
    }

    public WebElement departmentEditButton(int index){
        return departmentEditButtonList().get(index - 1);
    }

    //get web element list for department delete buttons
    public List<WebElement> departmentDeleteButtonList(){
        return dr.findElements(By.xpath("//*[@title='Delete']"));
    }

    public WebElement departmentDeleteButton(int index){
        return departmentDeleteButtonList().get(index - 1);
    }


    //On subdepartment

    //add subdepartment
    public WebElement addSubdepartmentButton(){
        return dr.findElement(By.xpath("//*[text()='Add Department']"));
    }

    public WebElement addSubdepartmentField() {
        return dr.findElement(By.xpath("//input[contains(@required,'required')]"));
    }

    public WebElement creatSubepartmentButton() {
        return dr.findElement(By.xpath("//button[contains(@ng-disabled,'error.required')]"));
    }
    //get web element list for subdepartment name
    public List<WebElement> subdepartmentNameList(){
        return dr.findElements(By.xpath("//td[@class='pl-lg']/a[@class='ng-binding']"));
    }

    public WebElement subdepartmentName(int index){
        return subdepartmentNameList().get(index - 1);
    }

    //get web element list for subdepartment assign permissions buttons
    public List<WebElement> subdepartmentAssignPermissionsButtonList(){
        return dr.findElements(By.xpath("//*[@title='Assign permissions']"));
    }

    public WebElement subdepartmentAssignPermissionsButton(int index){
        return subdepartmentAssignPermissionsButtonList().get(index - 1);
    }

    //get web element list for subdepartment edit buttons
    public List<WebElement> subdepartmentEditButtonList(){
        return dr.findElements(By.xpath("//*[@title='Edit']"));
    }

    public WebElement subdepartmentEditButton(int index){
        return subdepartmentEditButtonList().get(index - 1);
    }

    //get web element list for subdepartment delete buttons
    public List<WebElement> subdepartmentDeleteButtonList(){
        return dr.findElements(By.xpath("//*[@title='Delete']"));
    }

    public WebElement subdepartmentDeleteButton(int index){
        return subdepartmentDeleteButtonList().get(index - 1);
    }

    public List<WebElement> entityRows() {
        return dr.findElements(By.xpath("//tbody/tr[@class='ng-scope']"));
    }

    public boolean nextPageButtonEnabled() {return dr.findElements(By.xpath("//li[@class=\"ng-scope\" and @class !=\"disabled\"]/a[@ng-click=\"setCurrent(pagination.current + 1)\"]")).size() > 0;}

    public WebElement nextPageButton() {return dr.findElement(By.xpath("//li[contains(@class, 'pagination-next ng-scope')]/a[contains(@class, 'ng-binding')]")); } //next page, if Users paginated. SHOWS WHETHER ENABLED OR DISABLED

    public boolean nextPageButtonDisabled() //if nextPageButton is either disabled or does not exist, returns true
    {
        if (dr.findElements(By.xpath("/html/body/div[2]/section/div/div/pages-manager/div[2]/ul/li[4]/a")).size() > 0) { //if disabled next button exists...
            return true;
        }
        else if (nextPageButton().isDisplayed()) { //if disabled next page button does not exist, is there a next page button at all?
            return false; //nope
        }
        else { //there is no next page button
            return true;
        }
    }

    public WebElement entityUpdatedMessage() {return dr.findElement(By.xpath("//div[text()='The organization has been updated.']"));}


}
package pagestest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
*Created By Em
 */

public class Data_Provider {

    @DataProvider(name="AUCredential")

    public static Object[][] getUserData() {
        Object[][] data = new Object[1][3];

        // data arrays contain type of user, username and password

        // Admin User
        data[0][0] = "AU";
        data[0][1] = "qaubertester@mailinator.com";
        data[0][2] = "qaubertester";
        return data;
    }

    @DataProvider(name="RUCredential")

    public static Object[][] getRUdata() {
        Object[][] data = new Object[1][3];
        data[0][0] = "RU";
        data[0][1] = "ruqauber@mailinator.com";
        data[0][2] = "ruqauber";

        return data;
    }
    @DataProvider(name="SAUCredential")

    public static Object[][] getSAUdata() {
        Object[][] data = new Object[1][3];
        data[0][0] = "SAU";
        data[0][1] = "t8sterfoster@gmail.com";
        data[0][2] = "superangry";

        return data;
    }
    @DataProvider(name="NewUserEmail")

    public static Object[][] setNewUserEmail() {
        Object[][] data = new Object[1][1];

       //Invite user email = random string generator (in Test2)+data[0][0]
          data[0][0] = "@mailinator.com";

        return data;
    }

    // Assigning user
    @DataProvider(name="RegularPermission")
    public static Object[][] setRUPermission() {
        Object[][] data = new Object[1][1];

        data[0][0] = "Regular user";

        return data;
    }

    @DataProvider(name="AdminPermission")
    public static Object[][] setAUPermission() {
        Object[][] data = new Object[1][1];


        data[0][0] = "Admin";

        return data;
    }

    @DataProvider(name="SubDepartmentName")
    public static Object[][] setSubDepartmentName() {
        Object[][] data = new Object[1][1];

        //start name of subdepartment, will add with random string generator
        data[0][0] = "SubComp";
        return data;
    }

    @DataProvider(name="DepartmentName")
    public static Object[][] setDepartmentName() {
        Object[][] data = new Object[1][1];

        //start name of Department, will add with random string generator
        data[0][0] = "Department ";

        return data;
    }

    @DataProvider(name="ReportRequiredDetail")
    //This data provider only store data that are required field in 'Add Report' method.
    //which contain:Type of entity,First name, Last name and Location of stop

    public static Object[][] setReportRequiredDetail() {
        Object[][] data = new Object[1][3];
       // data[0][0] = "IT";
        data[0][0] = "Last";
        data[0][1] = "First";
        data[0][2] = "Locate at";
        return data;
    }
    @DataProvider(name="AddEntitiesInfo")
    //This data provider only store data that are required fields in 'Add Entities method.
    //which contain:Type of entity name,country, address, city, state, postcode.

    public static Object[][] setAddEntitiesInfo() {
        Object[][] data = new Object[1][6];
        data[0][0] = "Comp";
        data[0][1] = "United States";
        data[0][2] = "00 Empty St.,";
        data[0][3] = "Ghosttown";
        data[0][4] = "Texas";
        data[0][5] = "+0000000+";
        return data;
    }


    @DataProvider(name="EditORG")
    //path in the user dir to get report download file

    public static Object[][] setEditORG() {
        Object[][] data = new Object[1][1];
        data[0][0] = "Comp";

        return data;
}

    @DataProvider(name="AddSubjectInformation")
    public static Object[][] setAddSubject() {
        Object[][] data = new Object[1][28];
        data[0][0] = "CaseID";
        data[0][1] ="Suspect";
        data[0][2] = "Hollister";
        data[0][3] = "James";
        data[0][4] = "Thompson";
        data[0][5] = "J";
        data[0][6] = "03021982";
        data[0][7] = "37";
        data[0][8] = "Male";
        data[0][9] = "Caucasian";
        data[0][10] = "823";
        data[0][11]= "1982";
        data[0][12]="Athletic";
        data[0][13]="Brown";
        data[0][14]="Short";
        data[0][15]="Bald";
        data[0][16]="Gray";
        data[0][17]="Light";
        data[0][18]="Missing";
        data[0][19]="Unknown";
        data[0][20]="English";
        data[0][21]="101 Angelo Ave";
        data[0][22]="United States";
        data[0][23]="Oakland";
        data[0][24]="California";
        data[0][25]="94961";
        data[0][26]="510-598-7789";
        data[0][27]="subject@Susject.com";

        return data;
    }

    @DataProvider(name="AddReportIDInformation")
    public static Object[][] setAddReportID() {
        Object[][] data = new Object[1][26];
        data[0][0] = "889-57-4567";
        data[0][1] = "B1234567";
        data[0][2] = "A222578952";
        data[0][3] = "UNKNOWN";
        data[0][4] = "Yemen";
        data[0][5] ="UNKNOWN";
        data[0][6]= "R45CN8897YN";
        // School Information section
        data[0][7] = "Berkeley City College";
        data[0][8] = "2050 Center Street ";
        data[0][9] = "Berkeley";
        data[0][10] = "California";
        data[0][11]= "94704";
        data[0][12]="(510) 981-2800";
        //Parent Information section
        data[0][13]="Garry Brown";
        data[0][14]="123 Ashby Ave";
        data[0][15]="Berkeley";
        data[0][16]="California";
        data[0][17]="94568";
        data[0][18]="(510)-223-5689";
        //Employer Information section
        data[0][19]="Teacher";
        data[0][20]="City of Berkeley ";
        data[0][21]="1947 Center Street, 3rd Floor";
        data[0][22]="Berkeley";
        data[0][23]="California";
        data[0][24]="94961";
        data[0][25]="510-598-7100";

        return data;

    }

    @DataProvider(name="AddIdentifiers")
    public static Object[][] setAddReportIdentifiers() {
        Object[][] data = new Object[1][7];
        data[0][0] = "On left shoulder";
        data[0][1] = "Deep scar right cheek";
        data[0][2] = "2 lines on chest";
        data[0][3] = "No Track";
        data[0][4] = "No Glasses";
        data[0][5] = "No Mustache";
        data[0][6] = "Thick bread";

        return data;
    }

    @DataProvider(name="AddVehicleInfo")
    public static Object[][] setAddVehicleInfo() {
        Object[][] data = new Object[1][8];
        data[0][0] = "7FNG456";
        data[0][1] = "Toyota";
        data[0][2] =" RAV 4";
        data[0][3] = "Truck";
        data[0][4] = "2016";
        data[0][5] = "Dark Gray";
        data[0][6] = "CA";
        data[0][7] = "UNKNOWN";

        return data;
    }
    @DataProvider(name="AddGangMembershipInfo")
    public static Object[][] setAddGangMembershipInfo() {
        Object[][] data = new Object[1][13];
        data[0][0] = "Homicide";
        data[0][1] = "UNKNOWN";
        data[0][2] = "I-880 N";
        data[0][3] = "VIOLATION ISSUED FOR FAILURE TO OBEY RIGHT LANE EXIT ONLY";
        data[0][4] = "Tom&Jerry";
        data[0][5] = "5 years";
        data[0][6] = "Parole Officer Robert Jr.";
        data[0][7] = "(510)7894561";
        data[0][8] = "Probation Officer Stuart Pattrick";
        data[0][9] = "(415)7896547";
        data[0][10]= "UNKNOWN";
        data[0][11]="CH4567";
        data[0][12]="UNKNOWN";

        return data;
    }

    @DataProvider(name="RegisterCompany")
    //This data provider only store data that are required fields in 'Add Entities method.
    //which contain:Type of entity name,country, address, city, state, postcode.

    public static Object[][] setRegisterCompanyInfo() {
        Object[][] data = new Object[1][8];
        data[0][0] = "Comp";
        data[0][1]= "51044788956";
        data[0][2] = "@mailinator.com";
        data[0][3] = "United States";
        data[0][4] = "00 Empty St.,";
        data[0][5] = "Ghosttown";
        data[0][6] = "Texas";
        data[0][7] = "+0000000+";
        return data;
    }


}

package Extra;


import Extra.Files.PayLoad;
import Extra.Files.Resources;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by kamkam on 3/30/2017.
 */
public class Basic3 {
    Properties prop = new Properties();

    @BeforeTest
    public void getData() throws IOException {

        FileInputStream fi = new FileInputStream("D:\\Users\\kamkam\\IdeaProjects\\WaveFit\\src\\test\\java\\Extra\\Files\\env.properties");
        prop.load(fi);


    }

    @Test
    public void AddAndDelete() {

        ///////////////////////////////Task1.Grab the Response
        RestAssured.baseURI = prop.getProperty("HOST");
        Response res = given().
                queryParam("key", prop.get("KEY")).

                body(PayLoad.getPostData()).
                when().
                post(Resources.PostData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK")).
                extract().response();
        /////////////////change the RAW data to the Json Format
        String responseString = res.asString();
        System.out.print(responseString);

        /////////////Task2. Grab the place ID(Change the String to Jason Path)

        JsonPath js = new JsonPath(responseString);
        String PlaceId = js.get("place_id");
        System.out.println("PlaceId is :" + PlaceId);


        //////////////Place this PlaceId in the delete request
        given().
                queryParam("key", "AIzaSyBlTxUVLQTO6x4Tph3HNPinDzEfGHx0bRg").

                body("{" +
                        "  \"place_id\":\"" + PlaceId + "\"" +
                        "} ").
                when().
                post("/maps/api/place/delete/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("status", equalTo("OK"));

    }

}

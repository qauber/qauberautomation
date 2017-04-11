package Extra;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by kamkam on 3/30/2017.
 */
public class RestApi {

    @Test
    public void PostData() throws IOException

    {
        RestAssured.baseURI="https://maps.googleapis.com";
        given().
                queryParam("key","AIzaSyBlTxUVLQTO6x4Tph3HNPinDzEfGHx0bRg").

           // body(GenericDataToXml("D:\\Users\\kamkam\\Desktop\\PostData.xml")).
                when().

                post("/maps/api/place/add/xml").
                then().assertThat().statusCode(200).and().contentType(ContentType.XML).and().
                body("status",equalTo("OK"));



    }
//    public  static String GenericDataToXml( String path) throws IOException {
//        //return new String(Files.readAllBytes(Paths.get(path)));
//    }
}

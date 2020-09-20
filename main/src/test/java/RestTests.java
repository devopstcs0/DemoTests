import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.util.HashMap;
import java.util.Map;


/*
* For the Rest API im using RestAssured framework and dependency has been added to the POM.XML
*
* */

public class RestTests {

    String url = "https://reqres.in/api/users";

    // Testing the Rest API for GET request and validating the status code
    // and a data element at  0th index is equalTo
    @Test
    public void  getUserListDetails() {
        given()
                .get(url)
                .then()
                .statusCode(EndpointConstants.REST_STATUS_CODE_200)
                .body("data.id[0]", equalTo(1))
                .body("data.first_name[0]", equalTo("George"));
    }

    // Asserting get request has email data
    @Test
    public void getUserEmailValidation() {
        given()
                .get(url)
                .then()
                .assertThat()
                .body("data.email", hasItems("george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in"));
    }


    // Rest API for GET request and validating JSON Schema for the file under resources - > user.json
    @Test
    public void  getUserListDetailsJSONSchemaValidation() {
        given()
                .get(url)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user.json"));
    }

    // Testing the Rest API for POST request and passing the values name : “darth vader”, job : “villain”
    // Validating the status response with assert to 201 code.
    //  { name : “darth vader”, job : “villain” }
    @Test
    public void  postUserDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "\"darth vader\"");
        map.put("job", "\" villain\" ");

       given().header("Content-Type", "application/json")
                .contentType(JSON).accept(JSON).body(map).
        when()
                .post(url)
                .then()
                .assertThat()
                .statusCode(EndpointConstants.REST_POST_STATUS_CODE_201);
    }

    // Testing the Rest API for POST request and using JSON Object
    //  { "name" : “darth vader”, "job" : “villain” }
    @Test
    public void  postUserJsonObject() {
        JSONObject request = new JSONObject();
        request.put("name", "darth vader");
        request.put("job", "villain");
        given().header("Content-Type", "application/json")
                .contentType(JSON).accept(JSON).body(request.toJSONString())
                .when()
                .post(url)
                .then()
                .assertThat()
                .statusCode(EndpointConstants.REST_POST_STATUS_CODE_201);
    }

    // Testing the Rest API for POST request and assert the value is expected.
    @Test
    public void makingPostRequestAssert() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("name", "darth vader");
        request.put("job", "villain");

        String name = given().header("Content-Type", "application/json")
                .contentType(JSON).accept(JSON).body(request)
                .when()
                .post(url)
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .path("name");
        Assert.assertEquals(name, "darth vader");
    }
}

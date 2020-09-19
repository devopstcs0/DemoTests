import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.common.mapper.TypeRef;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestTests {

    @Test
    public void  getUserListDetails() {
        given()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(EndpointConstants.REST_STATUS_CODE_200)
                .body("data.id[0]", equalTo(1));
    }

    @Test
    public void  getUserListDetailsNew() {
        // Extract
        List<Map<String, Object>> products = given().get("https://reqres.in/api/users").as(new TypeRef<List<Map<String, Object>>>() {
        });

        // Now you can do validations on the extracted objects:
        assertThat(products, hasSize(2));
    }



    @Test
    public void  getUserListDetailsJSONSchemaValidation() {
        given()
                .get("https://reqres.in/api/users/")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("/JsonSchemas/user.json"));
    }

    @Test
    public void  postUserDetails() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test", "sdaf");
        map.put("test2", "sdaadf");

        given()
                .contentType(JSON)
                .body(map)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(EndpointConstants.REST_POST_STATUS_CODE_201);
    }
}
package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TestHome {
    @BeforeClass
    public static void beforeClass() {
        useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://testerhome.com";
        RestAssured.filters((rep,res,ctx)->{
            rep.cookie("testerhome","seveniruby");
            return ctx.next(rep,res);
        });
//        RestAssured.proxy("127.0.0.1", 8080);
    }

    @Test
    public void topice() {
        given()
                .when().log().all()
                .get("https://testerhome.com/api/v3/topics.json").prettyPeek()
                .then().log().all()
//                .body("topics[0].id", equalTo(15323))
//                .body("topics.id", hasItem(14736))
//                .body("topics[-1].user.login", equalTo("harris"))
//                .body("topics.find{it.id == 14736}.user.login", equalTo("suyuchen123"))
                .body("topics.find{it.excellent == 0}.size()", greaterThan(4))
                .time(lessThan(2000L))
        ;
    }

    @Test
    public void baidu() {
        Map<String, String> data = new HashMap<>();
        data.put("wd", "mp3");
        Response response = given().proxy("127.0.0.1", 8080)
                .contentType(ContentType.JSON).body(data)
                .when().post("http://www.baidu.com/s")
                .then().log().all()
                .statusCode(200)
                .extract().response();
        String title = response.htmlPath().getString("html.head.title");
        assertThat(title,equalTo("mp3_百度搜索"));
    }

    @Test
    public void testAuth(){
        given().auth().basic("hogwarts","123456")
                .get("http://shell.testing-studio.com:9002/")
        .then().log().all().statusCode(200);
    }
    @Test
    public void testBase64(){
        given()
                .filter((rep,res,ctx)->{
                    Response responseOri = ctx.next(rep,res);
                    ResponseBuilder responseBuilder = new ResponseBuilder().clone(responseOri);
                    responseBuilder.setBody(Base64.getDecoder().decode(responseOri.getBody()
                            .asString().trim().replace("\n","")));
                    responseBuilder.setContentType(ContentType.JSON);
                    return responseBuilder.build();
                })
                .auth().basic("hogwarts","123456")
                .get("http://shell.testing-studio.com:9002/sec.json")
                .then().log().all().statusCode(200);
    }
}

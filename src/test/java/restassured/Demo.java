package restassured;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
//@RunWith(Parameterized.class)
public class Demo {
    @Parameterized.Parameters(name = "{index}:baidu search wd={0} expect{1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0,0},{1,1},{2,1},{3,2},{4,3},{5,5},{6,8}
        });
    }
    @Parameterized.Parameter
    public int fInput;

    @Parameterized.Parameter(1)
    public int fExpected;

    @Test
    public void testHome(){
        useRelaxedHTTPSValidation();
        given()
                    .log().all()
                .when()
                    .get("https://testerhome.com")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("html.head.title",equalTo("TesterHome"));
    }

    @Test
    public void baidu(){
        given()
                    .log().all()
                    .queryParam("wd",fInput)
                .when()
                    .get("http://www.baidu.com/s")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("html.head.title",equalTo(fExpected+"_百度搜索"));
}

    @Test
    public void Login(){
        given().log().all()
                    .formParam("grant_type","password")
                    .formParam("client_id","JtXbaMn7eP")
                    .formParam("client_secret","txsDfr9FphRSPov5oQou74")
                    .header("User-Agent","Xueqiu Android 11.1.1")
                .when().log().all()
                    .post("https://api.xueqiu.com/provider/oauth/token")
                .then().log().all();
//                .body("scope",equalTo("all"));
    }
    @Test
    public void test(){
        given().log().all()
                .formParam("on","false")
                .formParam("x","0.7632")
                .header("User-Agent","Xueqiu Android 11.1.1")
                .header("Cookie","xq_a_token=c02c61367490b367c76defa1522d774f79a9fd58;u=7729708590")
                .when().log().all()
                .post("https://api.xueqiu.com/etc/mobile/state.json")
                .then().log().all()
                .body("success",equalTo(true));
    }
}

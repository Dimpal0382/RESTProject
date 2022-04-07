import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest1 {

    @Test
    void Test1(){
        Response response = RestAssured.get("https://statsapi.web.nhl.com/api/v1/standings?season=20202021");

        System.out.println("StatusCode" +response.getStatusCode());
    }
}

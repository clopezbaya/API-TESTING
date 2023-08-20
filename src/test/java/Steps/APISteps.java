package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class APISteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse validator;
    
    @Given("I send the request")
    public void sendRequest(){
        request = given().baseUri("https://api.github.com/").contentType(ContentType.JSON);
    }

    @Then("I get {int} of status code")
    public void verifyList(int statusCode){
        response = request.when().get("/users/clopezbaya/repos");

        validator = response.then().statusCode(statusCode);
    }
}

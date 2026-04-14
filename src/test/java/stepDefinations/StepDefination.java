package stepDefinations;
import POJO.Serialization.AddPlace;
import Utils.SpecBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static payloads.AddPlacePayload.getAddPlace;

public class StepDefination {

    RequestSpecification requestSpecification;
    Response response;
    @Given("Add Place payload")
    public void add_place_payload() {
        // Write code here that turns the phrase above into concrete actions
        AddPlace addPlace = getAddPlace();
        requestSpecification= given().spec(SpecBuild.requestSpecBuilder())
                .body(addPlace);
    }
    @When("user calls {string} API with post https request")
    public void user_calls_api_with_post_https_request(String string) {
        // Write code here that turns the phrase above into concrete actions
         response= requestSpecification.when().post("/maps/api/place/add/json");
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(200, response.getStatusCode());
    }
    @Then("{string} in the response body is {string}")
    public void in_the_response_body_is(String keyVlaue, String expectedValue) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedValue ,response.jsonPath().getString(keyVlaue));
    }
}

package OrderPackage;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.net.HttpURLConnection;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderResponse {
    @Step("Check order is created with different color options")
    public int orderIsCreated(ValidatableResponse orderResponseCreated) {
        int id = orderResponseCreated
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("track")
                ;
        return id;
    }

    @Step("Check order has track")
    public void orderHasTrackSuccess(ValidatableResponse orderResponseCreatedTrack) {
                orderResponseCreatedTrack.assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .body("track", notNullValue());
    }

    public void cancelOrderSuccesfully(ValidatableResponse response) {

    }
}

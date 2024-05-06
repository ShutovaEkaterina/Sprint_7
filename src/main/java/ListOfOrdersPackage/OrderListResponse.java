package ListOfOrdersPackage;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.net.HttpURLConnection;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;

public class OrderListResponse {
    @Step("Check orderList is not empty")
    public void orderListNotEmpty(ValidatableResponse orderListResponseNotEmpty) {
        orderListResponseNotEmpty.assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("orders", notNullValue())
                .body("orders", hasSize(greaterThan(0)));
    }

}

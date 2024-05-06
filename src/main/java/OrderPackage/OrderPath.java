package OrderPackage;

import BasicPackage.BasicStaff;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Map;


public class OrderPath extends BasicStaff {
    private static final String ORDER_PATH = "/orders";

    @Step("Order created with color")
    public ValidatableResponse orderCreate(Order order) {
        return spec()
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then().log().all();
    }

    @Step("Order has track")
    public ValidatableResponse orderWithTrack(Order order) {
        return spec()
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then().log().all();
    }

    @Step("Order is cancelled")
    public ValidatableResponse cancelOrderSuccess(int track) {
        return spec()
                .body(Map.of("track", track))
                .when()
                .put(ORDER_PATH + "/cancel")
                .then().log().all();
    }
}

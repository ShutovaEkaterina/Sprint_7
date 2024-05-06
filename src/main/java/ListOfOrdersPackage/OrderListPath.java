package ListOfOrdersPackage;

import BasicPackage.BasicStaff;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class OrderListPath extends BasicStaff {
    private static final String ORDER_LIST_PATH = "/orders";

    @Step("Getting order list")
    public ValidatableResponse orderGetList(OrderList orderList) {
        return spec()
                .body(orderList)
                .when()
                .get(ORDER_LIST_PATH)
                .then().log().all();
    }
}

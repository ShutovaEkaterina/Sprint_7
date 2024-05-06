import OrderPackage.Order;
import OrderPackage.OrderPath;
import OrderPackage.OrderResponse;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class OrderTrackTest {

    private final OrderPath orderPath = new OrderPath();
    private final OrderResponse orderResponse = new OrderResponse();
    int trackId;

    @After
    public void cancelOrder() {
        if (trackId != 0) {
            ValidatableResponse response = orderPath.cancelOrderSuccess(trackId);
            orderResponse.cancelOrderSuccesfully(response);
        }
    }

    @DisplayName("Order contains track in body")
    @Test
    public void orderHasTrack() {
        Order randomOrder = Order.random();
        ValidatableResponse orderResponseCreated = orderPath.orderWithTrack(randomOrder);
        Response response = orderResponseCreated.extract().response();
        trackId = response.path("track");
        orderResponse.orderHasTrackSuccess(orderResponseCreated);
    }
}
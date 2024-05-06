import OrderPackage.Order;
import OrderPackage.OrderPath;
import OrderPackage.OrderResponse;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertNotEquals;



@RunWith(Parameterized.class)
public class OrderParamColorTest {
    private final OrderPath orderPath = new OrderPath();
    private final OrderResponse orderResponse = new OrderResponse();

    int trackId;
    private final String[] color;

    public OrderParamColorTest(String[] color) {
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getColor() {
        return new Object[][]{
                {null},
                {new String[]{"BLACK"}},
                {new String[]{"GRAY"}},
                {new String[]{"BLACK", "GRAY"}},
        };
    }

    @After
    public void cancelOrder() {
        if (trackId != 0) {
            ValidatableResponse response = orderPath.cancelOrderSuccess(trackId);
            orderResponse.cancelOrderSuccesfully(response);
        }
    }

    @DisplayName("Order is created with different color options")
    @Test
    public void orderCreatedSuccess() {
        Order randomOrder = Order.random();
        randomOrder.setColor(color);
        ValidatableResponse orderResponseCreated = orderPath.orderCreate(randomOrder);
        trackId = orderResponse.orderIsCreated(orderResponseCreated);

        assertNotEquals(0, trackId);
    }


}

import ListOfOrdersPackage.OrderListResponse;
import ListOfOrdersPackage.OrderList;
import ListOfOrdersPackage.OrderListPath;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class OrderListTest {

    private final OrderListPath orderListPath = new OrderListPath();
    private final OrderListResponse orderListResponse = new OrderListResponse();

    @DisplayName("OrderList is not empty")
    @Test
    public void orderListHasOrders() {
        ValidatableResponse orderListResponseNotEmpty = orderListPath.orderGetList(new OrderList());
        orderListResponse.orderListNotEmpty(orderListResponseNotEmpty);
    }
}

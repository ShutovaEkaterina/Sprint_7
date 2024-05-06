import CourierPackage.Courier;
import CourierPackage.CourierIsLogged;
import CourierPackage.CourierPath;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;


public class CourierTest {
    private final CourierPath courierPath = new CourierPath();
    private final CourierIsLogged courierIsLogged = new CourierIsLogged();

    static Courier courier;
    static Courier courierWithoutLogin;

    static Courier courierWithoutPassword;
    private static int courierId;

    @After
    public void deleteCourier() {
        if (courierId != 0) {
            ValidatableResponse response = courierPath.deleteCourier(courierId);
            courierIsLogged.deletedSuccesfully(response);
        }
    }

    @DisplayName("Courier is creating")
    @Test
    public void courier() {
        courier = Courier.random();
        ValidatableResponse createResponse = courierPath.createCourier(courier);
        courierIsLogged.createdSuccessfully(createResponse);
    }

    @DisplayName("Courier with the same login is creating")
    // тест упадет, так как текст ошибки приходит иной - баг
    @Test
    public void testCreateTwoCouriersWithSameLogin() {
        var courier = Courier.random();
        ValidatableResponse createResponse = courierPath.createCourier(courier);
        courierIsLogged.createdSuccessfully(createResponse);

        String login = courier.getLogin();

        Courier courier2 = new Courier(login, "anotherPassword", "AnotherName");

        ValidatableResponse createCourierWithTheSameLogin = courierPath.createCourierWithTheSameLogin(courier2);
        courierIsLogged.createdUnSuccessfully(createCourierWithTheSameLogin);
    }

    @DisplayName("Courier is creating without login")
    @Test
    public void testCreateCouriersWithoutLogin() {
        courierWithoutLogin = new Courier(null, "secret123", "Smith");
        ValidatableResponse createResponseWithoutLogin = courierPath.createResponseWithoutLogin(courierWithoutLogin);
        courierIsLogged.createdWithoutLogin(createResponseWithoutLogin);
    }

    @DisplayName("Courier is creating without password")
    @Test
    public void testCreateCouriersWithoutPassword() {
        var courier = Courier.random();
        courierWithoutPassword = new Courier(courier.getLogin(), null, courier.getFirstName());
        ValidatableResponse createResponseWithoutPassword = courierPath.createResponseWithoutPassword(courierWithoutPassword);
        courierIsLogged.createdWithoutPassword(createResponseWithoutPassword);
    }


}

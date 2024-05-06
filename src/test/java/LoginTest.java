import CourierPackage.Courier;
import CourierPackage.CourierCredentials;
import CourierPackage.CourierIsLogged;
import CourierPackage.CourierPath;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class LoginTest {
    private final CourierPath courierPath = new CourierPath();
    private final CourierIsLogged courierIsLogged = new CourierIsLogged();
    int courierId;

    @After
    public void deleteCourier() {
        if (courierId != 0) {
            ValidatableResponse response = courierPath.deleteCourier(courierId);
            courierIsLogged.deletedSuccesfully(response);
        }
    }

    @DisplayName("Courier can login")
    @Test
    public void courierLoginSuccess() {

        CourierTest courierTest = new CourierTest();
        courierTest.courier();

        CourierCredentials creds = CourierCredentials.from(CourierTest.courier);
        ValidatableResponse loginResponse = courierPath.loginCourier(creds);
        courierId = courierIsLogged.loggedInSuccessfully(loginResponse);

        assertNotEquals(0, courierId);
    }

    @DisplayName("Courier login without login")
    @Test
    public void courierLoginWithoutLogin() {

        CourierTest courierTest = new CourierTest();
        courierTest.testCreateCouriersWithoutLogin();

        CourierCredentials creds = CourierCredentials.from(CourierTest.courierWithoutLogin);
        ValidatableResponse loginResponseBadRequestLogin = courierPath.loginResponseWithoutLogin(creds);
        courierIsLogged.loginWithoutLogin(loginResponseBadRequestLogin);
    }

    @DisplayName("Courier login without password")
    // тест упадет с ошибкой 504 - баг
    @Test
    public void courierLoginWithoutPassword() {
        CourierTest courierTest = new CourierTest();
        courierTest.testCreateCouriersWithoutPassword();

        CourierCredentials creds = CourierCredentials.from(CourierTest.courierWithoutPassword);
        ValidatableResponse loginResponseBadRequestPassword = courierPath.loginResponseWithoutPassword(creds);
        courierIsLogged.loginWithoutPassword(loginResponseBadRequestPassword);
    }

    @DisplayName("Courier login with incorrect login")
    @Test
    public void courierLoginWithIncorrectLogin() {

        CourierCredentials creds = CourierCredentials.from(CourierTest.courier);
        creds.setLogin("incorrect_login");
        ValidatableResponse loginResponseNotFoundLogin = courierPath.loginResponseIncorrectLogin(creds);
        courierIsLogged.loginIncorrectLogin(loginResponseNotFoundLogin);
    }

    @DisplayName("Non-existent courier login")
    @Test
    public void courierNonExistentLogin() {

        Courier nonExistentCourier = new Courier("nonexistent_login", "33123", "John");
        CourierCredentials creds = CourierCredentials.from(nonExistentCourier);
        ValidatableResponse loginResponseNotFoundNonExistent = courierPath.loginNonExistentLogin(creds);
        courierIsLogged.loginNonExistentLogin(loginResponseNotFoundNonExistent
        );
    }
}

package CourierPackage;

import BasicPackage.BasicStaff;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.util.Map;

public class CourierPath extends BasicStaff {
    private static final String COURIER_PATH = "/courier";

    @Step("Login courier")
    public ValidatableResponse loginCourier(CourierCredentials creds) {
        return spec()
                .body(creds)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }

    @Step("Create courier")
    public ValidatableResponse createCourier(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then().log().all();
    }

    @Step("Create 2 couriers with the same login")
    public ValidatableResponse createCourierWithTheSameLogin(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then().log().all();
    }

    @Step("Create courier without login")
    public ValidatableResponse createResponseWithoutLogin(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then().log().all();
    }

    @Step("Create courier without password")
    public ValidatableResponse createResponseWithoutPassword(Courier courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then().log().all();
    }

    @Step("Courier login without login")
    public ValidatableResponse loginResponseWithoutLogin(CourierCredentials courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }

    @Step("Courier login without password")
    public ValidatableResponse loginResponseWithoutPassword(CourierCredentials courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }
    @Step("Courier login without incorrect login")
    public ValidatableResponse loginResponseIncorrectLogin(CourierCredentials courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }

    @Step("Courier non-existent login")
    public ValidatableResponse loginNonExistentLogin(CourierCredentials courier) {
        return spec()
                .body(courier)
                .when()
                .post(COURIER_PATH + "/login")
                .then().log().all();
    }
    @Step("Courier is deleted")
    public ValidatableResponse deleteCourier(int id) {
        return spec()
                .body(Map.of("id", id))
                .when()
                .delete(COURIER_PATH + "/" + id)
                .then().log().all();
    }
}

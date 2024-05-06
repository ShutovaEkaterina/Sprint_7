package CourierPackage;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import java.net.HttpURLConnection;
import static org.junit.Assert.*;

public class CourierIsLogged {
    @Step("Check courier can login")
    public int loggedInSuccessfully(ValidatableResponse loginResponse) {
        int id = loginResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id")
                ;
        return id;
    }

    @Step("Check courier created successfully")
    public void createdSuccessfully(ValidatableResponse createResponse) {
        boolean created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok")
                ;
        assertTrue(created);
    }

    @Step("Check courier created unsuccessfully with the same login")
    public void createdUnSuccessfully(ValidatableResponse createResponseConflict) {
        String errorMessage = createResponseConflict
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CONFLICT)
                .extract()
                .path("message")
                ;
        assertEquals("Этот логин уже используется", errorMessage);
    }

    @Step("Check courier created without login")
    public void createdWithoutLogin(ValidatableResponse createResponseBadRequestLogin) {
        String errorMessage = createResponseBadRequestLogin
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message")
                ;
        assertEquals("Недостаточно данных для создания учетной записи", errorMessage);
    }

    @Step("Check courier created without password")
    public void createdWithoutPassword(ValidatableResponse createResponseBadRequestPassword) {
        String errorMessage = createResponseBadRequestPassword
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message")
                ;
        assertEquals("Недостаточно данных для создания учетной записи", errorMessage);
    }


    @Step("Check courier cannot login without login")
    public void loginWithoutLogin(ValidatableResponse loginResponseBadRequestLogin) {
        String errorMessage = loginResponseBadRequestLogin
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message")
                ;
        assertEquals("Недостаточно данных для входа", errorMessage);
    }

    @Step("Check courier cannot login without password")
    public void loginWithoutPassword(ValidatableResponse loginResponseBadRequestPassword) {
        String errorMessage = loginResponseBadRequestPassword
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message")
                ;
        assertEquals("Недостаточно данных для входа", errorMessage);
    }

    @Step("Check courier cannot login with incorrect login")
    public void loginIncorrectLogin(ValidatableResponse loginResponseNotFoundLogin) {
        String errorMessage = loginResponseNotFoundLogin
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND)
                .extract()
                .path("message")
                ;
        assertEquals("Учетная запись не найдена", errorMessage);
    }

    @Step("Check non-existent courier login")
    public void loginNonExistentLogin(ValidatableResponse loginResponseNotFoundNonExistent) {
        String errorMessage = loginResponseNotFoundNonExistent
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND)
                .extract()
                .path("message")
                ;
        assertEquals("Учетная запись не найдена", errorMessage);
    }

    public void deletedSuccesfully(ValidatableResponse response) {

    }
}

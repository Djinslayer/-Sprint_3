import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class OrderClient extends RestAssuredClient {

    private static final String ORDER_PATH = "api/v1/orders/";
    private static final String ORDER_BY_ID_PATH = "api/v1/orders/track";

    @Step("Создание заказа")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .spec(getBaseSpec())
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse getOrderList() {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(ORDER_PATH)
                .then();
    }

    @Step("Получение заказа по id")
    public ValidatableResponse getOrderById(int trackId) {
        return given()
                .spec(getBaseSpec())
                .when()
                .queryParam("t", trackId)
                .get(ORDER_BY_ID_PATH)
                .then();
    }
}
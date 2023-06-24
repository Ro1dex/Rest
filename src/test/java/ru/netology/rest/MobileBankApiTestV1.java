package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)

                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))

                .body("[0].currency.enum[0]", equalTo("RUB"))
                .body("[1].currency.enum[0]", equalTo("USD"))
                .body("[2].currency.enum[0]", equalTo("RUB"));


    }
}

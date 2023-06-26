package ru.netology.rest;

import io.restassured.path.json.config.JsonPathConfig;
import org.codehaus.groovy.ast.Parameter;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.codehaus.groovy.ast.tools.GeneralUtils.params;
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

                .body("[0].currency", equalTo("RUB"))
                .body("[1].currency", equalTo("USD"))
                .body("[2].currency", equalTo("RUB"));


    }

}

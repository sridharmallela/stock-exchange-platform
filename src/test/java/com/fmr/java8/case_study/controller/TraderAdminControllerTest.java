package com.fmr.java8.case_study.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class TraderAdminControllerTest {

    @Test
    void findAllTraders() {
        given()
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .when()
            .get("/admin/traders")
            .then()
            .statusCode(HttpStatus.OK.value());
//            .and()
//            .body("currencies", hasItems("USD", "GBP", "EUR", "JPY"));
    }

    @Test
    void findTraderByTraderId() {
    }

    @Test
    void findTraderByLastName() {
    }

    @Test
    void createOrUpdateTrader() {
    }

    @Test
    void deleteTrader() {
    }
}

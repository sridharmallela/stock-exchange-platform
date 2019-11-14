package com.fmr.java8.case_study.controller;

import com.fmr.java8.case_study.model.AppResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class TraderAdminControllerTest {

    @Test
    void findAllTraders() {
//        AppResponse response = given()
//                                         .accept(MediaType.APPLICATION_JSON_VALUE)
//                                         .when()
//                                         .get("/admin/traders")
//                                         .then()
//                                         .statusCode(HttpStatus.OK.value())
//                                         .and()
//                                         .body("message", is("Operation Successful"))
//                                         .extract();
    }

    @Test
    void findTraderByTraderId() {
//        given()
//        .accept(MediaType.APPLICATION_JSON_VALUE)
//        .when()
//        .get("/admin/traders/id/9")
//        .then()
//        .statusCode(HttpStatus.OK.value());
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

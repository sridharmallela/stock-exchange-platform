package com.fmr.java8.case_study.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fmr.java8.case_study.domain.Trader;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyString;

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
//            .body("firstName", emptyString());
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
    	Response response =        
	    	given()
	        .accept(MediaType.APPLICATION_JSON_VALUE)
	        .when()
	        .get("/admin/traders/name/Garrett")
	        .then()
	        .statusCode(HttpStatus.OK.value())
	        .extract()
	        .response();  
        
        List<Trader> traders = response.as(List.class);
        //assertEquals(2, traders.length);
        
        assertEquals(2, traders.size());     
        
        
        
    }

    @Test
    void createOrUpdateTrader() {
    }

    @Test
    void deleteTrader() {
    }
}

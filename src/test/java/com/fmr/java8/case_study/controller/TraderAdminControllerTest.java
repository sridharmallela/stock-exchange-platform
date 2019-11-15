package com.fmr.java8.case_study.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import com.fmr.java8.case_study.model.AppResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fmr.java8.case_study.domain.Trader;

import io.restassured.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

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
            .log().body()
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

    	AppResponse<List<Trader>> response =        
	    	given()
	        .accept(MediaType.APPLICATION_JSON_VALUE)
	        .when()
	        .get("/admin/traders/name/Garrett")
	        //.get("/admin/traders/name/Kloosterboer")	        
	        .then()
	        .log().body()
	        .and().statusCode(HttpStatus.OK.value())
	        .and().extract().as(new TypeRef<AppResponse<List<Trader>>>() {});
        
    	
    	/*
    	List<Trader> traders = new ObjectMapper().readValue(
    			response.asString(), new TypeReference<List<Trader>>() { }
    		);
    	*/
    	

        List<Trader> traders = response.getResponse();
        
    	//Trader[] traders = response.as(Trader[].class);
        //assertEquals(2, traders.length);
        
        assertEquals(1, traders.size());   
    	//assertEquals(2, traders.length);
        
        
        
    }

    @Test
    void createOrUpdateTrader() {
    }

    @Test
    void deleteTrader() {
    }
}

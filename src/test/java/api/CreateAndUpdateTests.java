package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import request.RequestData;


public class CreateAndUpdateTests {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    void createUser() {
        String name = "morpheus";
        String job = "leader";

        String data = RequestData.builder()
                .withName(name)
                .withJob(job)
                .build();

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response();

        SoftAssertions.assertSoftly(softy -> {
                    softy.assertThat(response.path("name").toString()).as("Username").isEqualTo(name);
                    softy.assertThat(response.path("job").toString()).as("User job").isEqualTo(job);
                }
        );
    }

    @Test
    void updateUser() {
        String name = "morpheus";
        String job = "driver" +
                "";
        String data = RequestData.builder()
                .withJob("driver")
                .withName("morpheus")
                .build();

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();


        SoftAssertions.assertSoftly(softy -> {
                    softy.assertThat(response.path("name").toString()).as("Username").isEqualTo(name);
                    softy.assertThat(response.path("job").toString()).as("User job").isEqualTo(job);
                }
        );
    }
}

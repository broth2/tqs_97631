package tqs.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AppTest 
{
    @Test
    public void testTodos()
    {
        String uri = "https://jsonplaceholder.typicode.com/todos";
        given()
        .when()
            .get(uri)
        .then()
            .statusCode(200);
    }

    @Test
    public void testTitleTodo()
    {
        String uri = "https://jsonplaceholder.typicode.com/todos/4";
        given()
        .when()
            .get(uri)
        .then()
            .statusCode(200)
            .and().body("title", equalTo("et porro tempora"));
    }

    @Test
    public void itemsArePresent() 
    {
        String uri = "https://jsonplaceholder.typicode.com/todos";
        given()
        .when()
            .get(uri)
        .then()
            .statusCode(200)
            .and().body("id", hasItems(198, 199));
    }
}

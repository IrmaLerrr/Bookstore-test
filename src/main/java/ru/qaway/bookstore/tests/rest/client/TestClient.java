package ru.qaway.bookstore.tests.rest.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import ru.qaway.bookstore.tests.props.TestConfig;
import ru.qaway.bookstore.tests.rest.model.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class TestClient {

    private String baseUri;
    private String basePath;

    public TestClient() {
        this(TestConfig.Uri.value, TestConfig.Path.value);
    }

    private RequestSpecification getRequestSpec() {
        return given().
                baseUri(baseUri).
                basePath(basePath).
                contentType(ContentType.JSON).
                log().all();
    }

    private RequestSpecification getRequestSpec(Object body) {
        return getRequestSpec().
                body(body);
    }

    public BookValidatableResponse create(Book book) {
        Response response = getRequestSpec(book).when().
                post("/books");

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse read(Integer id) {
        Response response = getRequestSpec().when().
                get("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse update(Integer id, Book book) {
        Response response = getRequestSpec(book).when().
                put("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse delete(Integer id) {
        Response response = getRequestSpec().when().
                delete("/books/{id}", id);

        response.then().log().all();

        return new BookValidatableResponse(response);
    }

    public BookValidatableResponse deleteAll() {
        Response response = getRequestSpec().when().
                delete("/books");

        response.then().log().all();

        return new BookValidatableResponse(response);
    }


}

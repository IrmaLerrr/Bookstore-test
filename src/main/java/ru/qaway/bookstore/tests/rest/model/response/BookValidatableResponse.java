package ru.qaway.bookstore.tests.rest.model.response;

import org.hamcrest.Matchers;
import org.testng.Assert;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import ru.qaway.bookstore.tests.rest.model.Book;

public class BookValidatableResponse {

    private BookResponse model;
    private final Response response;

    @SneakyThrows
    public BookValidatableResponse(Response response) {
        this.response = response;
        if (!response.asString().isEmpty()) {
            model = response.as(BookResponse.class);
        }
    }

    public BookValidatableResponse checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);

        return this;
    }

    public BookValidatableResponse checkIdNotNull() {
        response.then().body("id", Matchers.notNullValue());

        return this;
    }

    public BookValidatableResponse checkLastUpdated() {
        response.then().body("lastUpdated", Matchers.notNullValue());

        return this;
    }

    public BookValidatableResponse checkBook(Book expected) {
        Assert.assertEquals(new Book(model), expected);

        return this;
    }

    public BookValidatableResponse checkId(Integer id) {
        response.then().body("id", Matchers.equalTo(id));

        return this;
    }

//    public BookValidatableResponse checkCount(Integer count) {
//        response.then().body("count", Matchers.equalTo(count));
//
//        return this;
//    }

//    public BookValidatableResponse checkErrorResponse(BookResponse expected) {
//        response.then().body("timestamp", Matchers.notNullValue());
//        Assert.assertEquals(model, expected);
//
//        return this;
//    }

    public Integer getId() {
        return response.jsonPath().getInt("id");
    }

//    public String getTitle() {
//        return response.jsonPath().getString("title");
//    }
}

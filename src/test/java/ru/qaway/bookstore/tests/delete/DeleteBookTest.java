package ru.qaway.bookstore.tests.delete;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.Book;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;

public class DeleteBookTest  extends BookStoreTestBase {

    @Test
    public void testDeleteBook() {
        BookValidatableResponse response = testClient.create(Book.defaultOf()).
                checkStatusCode(201);

        testClient.delete(response.getId()).
                checkStatusCode(200);

        testClient.read(response.getId()).
                checkStatusCode(404);
    }

    @Test
    public void testDeleteAllBooks() {
        BookValidatableResponse response1 = testClient.create(Book.defaultOf()).
                checkStatusCode(201);
        BookValidatableResponse response2 = testClient.create(Book.defaultOf()).
                checkStatusCode(201);
        BookValidatableResponse response3 = testClient.create(Book.defaultOf()).
                checkStatusCode(201);

        testClient.deleteAll().
                checkStatusCode(200);

        testClient.read(response1.getId()).
                checkStatusCode(404);
        testClient.read(response2.getId()).
                checkStatusCode(404);
        testClient.read(response3.getId()).
                checkStatusCode(404);
    }
}

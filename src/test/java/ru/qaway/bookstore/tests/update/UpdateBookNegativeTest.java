package ru.qaway.bookstore.tests.update;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookData;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.Book;

public class UpdateBookNegativeTest extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient.create(Book.defaultOf()).
                checkStatusCode(201).getId();
    }

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testUpdateBookNegative(Book book) {
        testClient.update(id, book).
                checkStatusCode(400);

        testClient.read(id).
                checkStatusCode(200).
                checkId(id).
                checkLastUpdated().
                checkBook(Book.defaultOf());
    }
}
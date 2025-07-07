package ru.qaway.bookstore.tests.create;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookData;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.Book;

public class CreateBookNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "negative", dataProviderClass = BookData.class)
    public void testCreateBookNegative(Book book) {
        testClient.create(book).
                checkStatusCode(400);
    }
}
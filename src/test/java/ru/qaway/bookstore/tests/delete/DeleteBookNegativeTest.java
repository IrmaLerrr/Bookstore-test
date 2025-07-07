package ru.qaway.bookstore.tests.delete;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;

public class DeleteBookNegativeTest  extends BookStoreTestBase {

    @Test
    public void testDeleteBook() {
        testClient.delete(9999).
                checkStatusCode(404);
    }
}

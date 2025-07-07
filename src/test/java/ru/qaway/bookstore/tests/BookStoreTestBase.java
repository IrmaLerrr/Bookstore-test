package ru.qaway.bookstore.tests;

import ru.qaway.bookstore.tests.rest.client.TestClient;

public class BookStoreTestBase {

    public static TestClient testClient;

    static {
        testClient = new TestClient();
    }
}

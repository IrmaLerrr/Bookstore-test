package ru.qaway.bookstore.tests.props;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static Properties getConfiguration() {
        return getConfiguration("config.properties");
    }

    @SneakyThrows
    public static Properties getConfiguration(String filename) {
        Properties prop;
        try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream(filename)) {

            if (input == null) {
                throw new IllegalArgumentException("Unable to find " + filename);
            }

            prop = new Properties();
            prop.load(input);
        }

        return prop;
    }
}


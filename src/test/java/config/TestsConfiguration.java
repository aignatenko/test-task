package config;

import ui.core.selenium.enums.SupportedBrowsers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class TestsConfiguration {

    public static String baseUrl() {
        return PropertiesReader.read("baseUrl");
    }

    public static String platform() {
        return PropertiesReader.read("platform");
    }

    public static SupportedBrowsers browser() {
        return Enum.valueOf(SupportedBrowsers.class, PropertiesReader.read("browser"));
    }

    private static class PropertiesReader {

        public static String read(String propertyName) {
            return loadProperties().getProperty(propertyName);
        }

        private static Properties loadProperties() {
            String testsConfigPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("tests.properties")).getPath();
            Properties props = new Properties();
            try {
                props.load(new FileInputStream(testsConfigPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return props;
        }
    }
}

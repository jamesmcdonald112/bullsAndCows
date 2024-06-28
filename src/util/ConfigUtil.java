package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The ConfigUtil class is responsible for loading and providing configuration properties
 * for the Bulls and Cows game. It reads the configuration from a properties file.
 */
public class ConfigUtil {
    private static final Properties properties = new Properties();

    // Default Values
    private static final int DEFAULT_MIN_PASSWORD_LENGTH = 1;
    private static final int DEFAULT_MAX_PASSWORD_LENGTH = 36;

    // Static block to load properties from the config file
    static {
        String configFilePath = "src/config.properties";
        try (InputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
        } catch (IOException ex) {
            System.err.println("Warning: Error loading config.properties. Using default values.");
        }
    }

    /**
     * Gets the minimum password length from the configuration properties.
     * If the property is not found, returns the default value.
     *
     * @return the minimum password length
     */
    public static int getMinPasswordLength() {
        return Integer.parseInt(properties.getProperty("min.password.length", String.valueOf(DEFAULT_MIN_PASSWORD_LENGTH)));
    }

    /**
     * Gets the maximum password length from the configuration properties.
     * If the property is not found, returns the default value.
     *
     * @return the maximum password length
     */
    public static int getMaxPasswordLength() {
        return Integer.parseInt(properties.getProperty("max.password.length", String.valueOf(DEFAULT_MAX_PASSWORD_LENGTH)));
    }
}

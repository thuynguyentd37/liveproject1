package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    private static Properties properties;

    // ✅ Load properties at startup
    static {
        loadProperties();
    }

    public static void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "main"
                        + File.separator + "java"
                        + File.separator + "resources"
                        + File.separator + "config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load config.properties", e);
        }
    }

    /**
     * ✅ Get property value with the priority:
     * 1️⃣ Environment Variable
     * 2️⃣ System Property (-D flag)
     * 3️⃣ config.properties file
     */
    public static String getProperty(String key) {
        // 1️⃣ Check environment variable first
        String value = System.getenv(key);
        if (value != null && !value.isEmpty()) {
            return value;
        }

        // 2️⃣ Check system property (-D flag)
        value = System.getProperty(key);
        if (value != null && !value.isEmpty()) {
            return value;
        }

        // 3️⃣ Check config.properties file
        return properties.getProperty(key);
    }
}

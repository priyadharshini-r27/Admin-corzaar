package utils;


import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
private static Properties prop;

public static Properties initProp() {
prop = new Properties();
// Uses ClassLoader to find config.properties inside src/test/resources/config/
try (InputStream ip = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
if (ip == null) {
throw new RuntimeException("config.properties not found in classpath under config/ folder!");
}
prop.load(ip);
} catch (Exception e) {
System.err.println("Failed to load config properties: " + e.getMessage());
e.printStackTrace();
}
return prop;
}

public static String getProperty(String key) {
if (prop == null) {
initProp();
}
String value = prop.getProperty(key);
if (value == null) {
throw new RuntimeException("Key '" + key + "' not found in config.properties!");
}
return value.trim();
}
}
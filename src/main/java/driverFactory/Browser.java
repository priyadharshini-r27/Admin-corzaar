package driverFactory;


public class Browser {

private static final ThreadLocal<String> browser = new ThreadLocal<>();

public static void setBrowser(String browserName) {
browser.set(browserName);
}

public static String getBrowser() {
return browser.get();
}

public static void removeBrowser() {
browser.remove();
}
}

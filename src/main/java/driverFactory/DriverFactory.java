package driverFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

public static synchronized WebDriver initDriver(String browser) {
if (browser == null || browser.trim().isEmpty()) {
browser = "chrome";
}

switch (browser.toLowerCase().trim()) {
case "chrome":
WebDriverManager.chromedriver().setup();
tlDriver.set(new ChromeDriver(getChromeOptions()));
break;

case "firefox":
WebDriverManager.firefoxdriver().setup();
FirefoxOptions ffOptions = new FirefoxOptions();
ffOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
tlDriver.set(new FirefoxDriver(ffOptions));
break;

case "edge":
WebDriverManager.edgedriver().setup();
EdgeOptions edgeOptions = new EdgeOptions();
edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
tlDriver.set(new EdgeDriver(edgeOptions));
break;

case "safari":
tlDriver.set(new SafariDriver());
break;

default:
throw new IllegalArgumentException("Unsupported browser: " + browser);
}

configureBrowser();
return getDriver();
}

public static WebDriver getDriver() {
return tlDriver.get();
}

private static void configureBrowser() {
WebDriver driver = getDriver();
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
}

private static ChromeOptions getChromeOptions() {
ChromeOptions options = new ChromeOptions();
Map<String, Object> prefs = new HashMap<>();

prefs.put("credentials_enable_service", false);
prefs.put("profile.password_manager_enabled", false);
prefs.put("profile.password_manager_leak_detection", false);
prefs.put("profile.default_content_setting_values.notifications", 2);
prefs.put("profile.default_content_setting_values.geolocation", 2);
prefs.put("download.prompt_for_download", false);
prefs.put("profile.default_content_settings.popups", 0);

options.setExperimentalOption("prefs", prefs);
options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
options.addArguments("--disable-notifications", "--disable-popup-blocking", "--disable-infobars", "--disable-extensions");
return options;
}

public static void quitDriver() {
if (tlDriver.get() != null) {
tlDriver.get().quit();
tlDriver.remove();
}
}
}
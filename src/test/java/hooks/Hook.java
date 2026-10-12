package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

@Before(order = 0)
public void setupConfig() {
ConfigReader.initProp();
}

@Before(order = 1)
public void launchBrowser() {
String browser = ConfigReader.getProperty("browser");
DriverFactory.initDriver(browser);
DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
}

@After
public void tearDown(Scenario scenario) {
WebDriver driver = DriverFactory.getDriver();
if (driver != null) {
if (scenario.isFailed()) {
byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
scenario.attach(screenshot, "image/png", scenario.getName() + " - Failure Screenshot");
}
DriverFactory.quitDriver();
}
}
}
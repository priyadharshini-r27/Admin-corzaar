package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {

private final WebDriver driver;
private final WebDriverWait wait;

public Element(WebDriver driver) {
this.driver = driver;
this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.EXPLICIT_WAIT_TIME));
}

public WebElement waitForElementToBeClickable(WebElement element) {
return wait.until(ExpectedConditions.elementToBeClickable(element));
}

public WebElement waitForVisibilityOfElement(WebElement element) {
return wait.until(ExpectedConditions.visibilityOf(element));
}

public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> elements) {
return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
}

public Alert waitForAlertIsPresent() {
return wait.until(ExpectedConditions.alertIsPresent());
}

public void clickElement(WebElement element) {
waitForElementToBeClickable(element).click();
}

public void sendKeys(WebElement element, String text) {
WebElement el = waitForVisibilityOfElement(element);
el.clear();
el.sendKeys(text);
}

public String getText(WebElement element) {
return waitForVisibilityOfElement(element).getText().trim();
}

public String getTextByXpath(String xpath) {
return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText().trim();
}

public boolean isDisplayed(WebElement element) {
try {
return waitForVisibilityOfElement(element).isDisplayed();
} catch (Exception e) {
return false;
}
}

public boolean isDisplayed(String xpath) {
List<WebElement> elements = driver.findElements(By.xpath(xpath));
return !elements.isEmpty() && elements.get(0).isDisplayed();
}

public String getTitle() {
return driver.getTitle();
}

public String getCurrentUrl() {
return driver.getCurrentUrl();
}

public void dropDownByVisibleText(WebElement element, String text) {
Select select = new Select(waitForVisibilityOfElement(element));
select.selectByVisibleText(text);
}

public void dropDownByValue(WebElement element, String value) {
Select select = new Select(waitForVisibilityOfElement(element));
select.selectByValue(value);
}

public void dropDownByIndex(WebElement element, int index) {
Select select = new Select(waitForVisibilityOfElement(element));
select.selectByIndex(index);
}

public void moveToElement(WebElement element) {
new Actions(driver).moveToElement(waitForVisibilityOfElement(element)).perform();
}

public void clearField(WebElement element) {
WebElement el = waitForVisibilityOfElement(element);
el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
el.sendKeys(Keys.BACK_SPACE);
}

public List<String> getTexts(List<WebElement> elements) {
List<WebElement> visibleElements = waitForVisibilityOfAllElements(elements);
List<String> texts = new ArrayList<>();
for (WebElement element : visibleElements) {
texts.add(element.getText().trim());
}
return texts;
}

public void uploadUsingRobot(WebElement upload, String filePath) throws AWTException {
clickElement(upload);
StringSelection selection = new StringSelection(filePath);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

Robot robot = new Robot();
robot.delay(1000);
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_CONTROL);
robot.delay(500);
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
}

public void selectCheckBox(WebElement cb) {
WebElement el = waitForElementToBeClickable(cb);
if (!el.isSelected()) {
el.click();
}
}

public void unselectCheckBox(WebElement cb) {
WebElement el = waitForElementToBeClickable(cb);
if (el.isSelected()) {
el.click();
}
}

public void jsClick(WebElement element) {
WebElement el = waitForVisibilityOfElement(element);
((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
}

public void scrollToElement(WebElement element) {
WebElement el = waitForVisibilityOfElement(element);
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
}

public void scrollAndClick(WebElement element) {
    WebElement el = waitForVisibilityOfElement(element);
    ((JavascriptExecutor) driver)
            .executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    el);
    try {
        wait.until(
                ExpectedConditions.elementToBeClickable(el));
        el.click();
    } catch (Exception e) {
        System.out.println(
                "Normal click failed. Using JS click.");
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",el);
    }}

public void acceptAlert() {
waitForAlertIsPresent().accept();
}

public void dismissAlert() {
waitForAlertIsPresent().dismiss();
}

public void switchToChildWindow(String parentHandle) {
for (String handle : driver.getWindowHandles()) {
if (!handle.equals(parentHandle)) {
driver.switchTo().window(handle);
break;
}
}
}

public static String takeScreenshot(WebDriver driver, String screenshotName) {
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
String filepath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
File destination = new File(filepath);
try {
FileUtils.copyFile(source, destination);
} catch (IOException e) {
throw new RuntimeException("Failed to save screenshot", e);
}
return filepath;
}
}
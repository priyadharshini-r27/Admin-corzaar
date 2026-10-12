package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Element;

public class LoginPage {

 private final WebDriver driver;
 private final Element Element;

 public LoginPage(WebDriver driver) {
 this.driver = driver;
 PageFactory.initElements(driver, this);
 this.Element = new Element(driver);
 }

 @FindBy(xpath = "//*[text()='Admin']")
 private WebElement adminButton;

 @FindBy(id = "super-admin-email")
 private WebElement emailField;

 @FindBy(xpath = "//*[@type='password']")
 private WebElement passwordField;

 @FindBy(xpath = "//button[normalize-space()='Authenticate Super-Admin']")
 private WebElement authenticateButton;

 @FindBy(id = "enter-admin-2fa-code")
 private WebElement otpField;

 @FindBy(xpath = "//button[normalize-space()='Authorize Administrative Session']")
 private WebElement submitOtpButton;

 @FindBy(xpath = "//*[normalize-space()='Invalid admin credentials']")
 private WebElement invalidCredentialsMessage;

 @FindBy(xpath = "//span[contains(text(),'Invalid admin OTP')]")
 private WebElement invalidOtpMessage;

 @FindBy(xpath = "//*[@class='text-xs font-bold text-indigo-950 dark:text-indigo-200']")
public WebElement faPageText;

 public String getAdminPageTitle() {
 return Element.getTitle();
 }

 public String getCurrentUrl() {
 return Element.getCurrentUrl();
 }

 public void clickAdminButton() {
 Element.clickElement(adminButton);
 }

 public void enterEmail(String email) {
 Element.sendKeys(emailField, email);
 }

 public void enterPassword(String password) {
 Element.sendKeys(passwordField, password);
 }

 public void clickAuthenticateButton() {
 Element.scrollAndClick(authenticateButton);
 }

 public void enterOtp(String otp) {
 Element.sendKeys(otpField, otp);
 }

 public void clickSubmitOtpButton() {
 Element.scrollAndClick(submitOtpButton);
 }

 public String getValidationMessage() {
 return Element.getText(invalidCredentialsMessage);
 }

 public String getOtpValidationMessage() {
 return Element.getText(invalidOtpMessage);
 }

 public boolean isFaPageDisplayed() {
 return Element.isDisplayed(faPageText);
 }

 public DashboardPage doLogin(String email, String password, String otp) {
 clickAdminButton();
 enterEmail(email);
 enterPassword(password);
 clickAuthenticateButton();
 enterOtp(otp);
 clickSubmitOtpButton();
 return new DashboardPage(driver);
 }
}
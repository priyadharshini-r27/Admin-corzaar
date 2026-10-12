package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Element;

public class DashboardPage {

private final WebDriver driver;
private final Element Element;

public DashboardPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
this.Element = new Element(driver);
}

@FindBy(xpath = "//a[.//span[normalize-space()='Pending Courses']]")
private WebElement pendingCourses;

@FindBy(xpath = "//a[.//span[normalize-space()='Pending Coupons']]")
private WebElement pendingCoupons;

@FindBy(xpath = "//a[.//span[normalize-space()='Pending Refunds']]")
private WebElement pendingRefunds;

@FindBy(xpath = "//a[.//span[normalize-space()='Institute Approvals']]")
private WebElement instituteApprovals;

public void clickPendingCourses() {
Element.clickElement(pendingCourses);
}

public void clickPendingCoupons() {
Element.clickElement(pendingCoupons);
}

public void clickPendingRefunds() {
Element.clickElement(pendingRefunds);
}

public void clickInstituteApprovals() {
Element.clickElement(instituteApprovals);
}

public String getCurrentUrl() {
return Element.getCurrentUrl();
}

public void navigateBack() {
driver.navigate().back();
}
}
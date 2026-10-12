package stepdefinitions;

import org.testng.Assert;

import pages.LoginPage;
import pages.DashboardPage;
import driverFactory.DriverFactory;
import utils.Constant;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStep {

	private DashboardPage dashboard;

	// Safe getter method ensures dashboard is never null
	private DashboardPage getDashboard() {
	if (dashboard == null) {
	dashboard = new DashboardPage(DriverFactory.getDriver());
	}
	return dashboard;
	}
/**
 @Given("user is on the dashboard page")
 public void user_is_on_dashboard_page() {
 LoginPage login = new LoginPage(DriverFactory.getDriver());
 dashboard = login.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
 }

 * 
 */
	@When("user verify the pending course cart navigation")
	public void user_verify_the_pending_course_cart_navigation() {
	getDashboard().clickPendingCourses(); // Uses safe getter
	String currentUrl = getDashboard().getCurrentUrl();
	Assert.assertTrue(currentUrl.contains("courses"), "Expected URL to contain 'courses' but found: " + currentUrl);
	}

 @When("user verify the pending coupons cart navigation")
 public void user_verify_the_pending_coupons_cart_navigation() {
 dashboard.navigateBack();
 dashboard.clickPendingCoupons();
 String currentUrl = dashboard.getCurrentUrl();
 Assert.assertTrue(currentUrl.contains("coupons"), "Expected URL to contain 'coupons' but found: " + currentUrl);
 }

 @When("user verify the pending funds")
 public void user_verify_the_pending_funds() {
 dashboard.navigateBack();
 dashboard.clickPendingRefunds();
 String currentUrl = dashboard.getCurrentUrl();
 Assert.assertTrue(currentUrl.contains("refunds"), "Expected URL to contain 'refunds' but found: " + currentUrl);
 }

 @Then("user verify the institute approvals")
 public void user_verify_the_institute_approvals() {
 dashboard.navigateBack();
 dashboard.clickInstituteApprovals();
 String currentUrl = dashboard.getCurrentUrl();
 Assert.assertTrue(currentUrl.contains("institutes"), "Expected URL to contain 'institutes' but found: " + currentUrl);
 }
}
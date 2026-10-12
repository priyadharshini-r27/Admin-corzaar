package stepdefinitions;



	import java.util.List;
	import org.testng.Assert;

	import pages.LoginPage;
	import pages.CouponApprovalPage;
	import driverFactory.DriverFactory;
	import utils.Constant;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class CouponApprovalStep {

	 private CouponApprovalPage couponPage;
	 
	// Safe getter ensures couponPage is never null
	 private CouponApprovalPage getCouponPage() {
	 if (couponPage == null) {
	 couponPage = new CouponApprovalPage(DriverFactory.getDriver());
	 }
	 return couponPage;
	 }
	 
	 
	 @Given("admin is on the coupon dashboard page")
	 public void admin_is_on_coupon_dashboard_page() {
	 LoginPage login = new LoginPage(DriverFactory.getDriver());
	 login.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
	 couponPage = new CouponApprovalPage(DriverFactory.getDriver());
	 }

	 @When("admin click the coupon approval module")
	 public void admin_click_coupon_module() {
	 couponPage.clickCouponApproval();
	 Assert.assertTrue(couponPage.getCurrentUrl().contains("coupon"));
	 }

	 @When("admin search the coupon code in search field {string}")
	 public void admin_search_coupon_code(String code) {
	 couponPage.enterSearchCode(code);
	 }

	 @When("the displayed message depends on search code")
	 public void displayed_message_depends_on_search() {
	 String msg = couponPage.getTableText();
	 Assert.assertTrue(msg != null && !msg.isEmpty());
	 }

	 @When("admin verify the details {string} and {string}")
	 public void admin_verify_details(String status, String expectedMessage) {
	 if ("invalid".equalsIgnoreCase(status)) {
	 Assert.assertEquals(couponPage.getEmptyMessage(), expectedMessage);
	 }
	 }

	 @When("admin clear the couponapproval search field")
	 public void clear_search_field() {
	 couponPage.clearSearch();
	 }

	 @When("admin verify filter option is displayed")
	 public void verify_filter_is_displayed() {
	 Assert.assertTrue(couponPage.isFilterButtonDisplayed());
	 }

	 @When("admin select the pending option")
	 public void select_pending() {
	 couponPage.selectPending();
	 }

	 @When("admin select the approved button")
	 public void select_approved() {
	 couponPage.selectApproved();
	 }

	 @When("the approved button displayed correct details")
	 public void verify_approved_details() {
	 List<String> statuses = couponPage.getDisplayedStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status.toLowerCase().trim(), "approved");
	 }
	 }

	 @When("admin select the rejected button")
	 public void select_rejected() {
	 couponPage.selectRejected();
	 }

	 @Then("the reject button should be displayed correct details")
	 public void verify_rejected_details() {
	 List<String> statuses = couponPage.getDisplayedStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status.toLowerCase().trim(), "rejected");
	 }
	 }
	
}

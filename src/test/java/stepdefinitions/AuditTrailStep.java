package stepdefinitions;



	import java.util.List;
	import org.testng.Assert;

	import pages.LoginPage;
	import pages.AuditTrail;
	import driverFactory.DriverFactory;
	import utils.Constant;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class AuditTrailStep {

	 private AuditTrail auditPage;

	 @Given("user is on the dashboard page again")
	 public void user_is_on_dashboard() {
	 LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	 loginPage.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
	 auditPage = new AuditTrail(DriverFactory.getDriver());
	 }

	 @When("admin select the audit trail module")
	 public void admin_select_the_audit_trail_module() {
	 auditPage.clickAuditTrail();
	 Assert.assertTrue(auditPage.getCurrentUrl().contains("audit"));
	 }

	 @When("admin use searchfield and find the details {string}")
	 public void admin_search_details(String query) {
	 auditPage.searchAction(query);
	 }

	 @When("verify the result {string} with message {string}")
	 public void verify_result(String status, String message) {
	 if ("invalid".equalsIgnoreCase(status)) {
	 Assert.assertEquals(auditPage.getEmptyMessage(), message);
	 }
	 }

	 @When("admin clear the search field")
	 public void clear_search() {
	 auditPage.clearSearch();
	 }

	 @When("admin use the filter option")
	 public void check_filter() {
	 Assert.assertTrue(auditPage.isFilterButtonDisplayed());
	 }

	 @When("admin select the course option")
	 public void select_courses() { auditPage.selectCourses(); }

	 @When("verify the displayed result details")
	 public void verify_course_results() {
	 List<String> statuses = auditPage.getDisplayedRowStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status, "Courses");
	 }
	 }

	 @When("admin select the payouts option")
	 public void select_payouts() { auditPage.selectPayouts(); }

	 @When("verify payout details displayed correctly")
	 public void verify_payout_results() {
	 List<String> statuses = auditPage.getDisplayedRowStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status, "Payouts");
	 }
	 }

	 @When("admin select the batches option")
	 public void select_batches() { auditPage.selectBatches(); }

	 @When("verify batches details displayed correctly")
	 public void verify_batch_results() {
	 List<String> statuses = auditPage.getDisplayedRowStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status, "Batches");
	 }
	 }

	 @When("admin select the institute option")
	 public void select_institutes() { auditPage.selectInstitutes(); }

	 @When("verify institute details displayed correctly")
	 public void verify_institute_results() {
	 List<String> statuses = auditPage.getDisplayedRowStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status, "Institutes");
	 }
	 }

	 @When("admin select the coupons option")
	 public void select_coupons() { auditPage.selectCoupons(); }

	 @When("verify coupons details displayed correctly")
	 public void verify_coupon_results() {
	 List<String> statuses = auditPage.getDisplayedRowStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status, "Coupons");
	 }
	 }

	 @When("admin select the Certificates option")
	 public void select_certificates() { auditPage.selectCertificates(); }

	 @Then("verify Certificates details displayed correctly")
	 public void verify_certificate_results() {
	 List<String> statuses = auditPage.getDisplayedRowStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status, "Certificates");
	 }
	 }
	}


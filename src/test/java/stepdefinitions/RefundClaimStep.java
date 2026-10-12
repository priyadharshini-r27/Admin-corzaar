package stepdefinitions;


	import org.testng.Assert;

	import pages.LoginPage;
	import pages.RefundClaimPage;
	import driverFactory.DriverFactory;
	import utils.Constant;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class RefundClaimStep {

	 private RefundClaimPage refundPage;

	 @Given("admin is on the dashboard page")
	 public void admin_on_dashboard() {
	 LoginPage login = new LoginPage(DriverFactory.getDriver());
	 login.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
	 refundPage = new RefundClaimPage(DriverFactory.getDriver());
	 }

	 @When("admin click the refund claim module")
	 public void click_refund_claim_module() {
	 refundPage.clickRefundClaim();
	 }

	 @Then("admin should be navigated to refunds module")
	 public void verify_navigation() {
	 Assert.assertTrue(refundPage.getCurrentUrl().contains("refund"));
	 }
	}


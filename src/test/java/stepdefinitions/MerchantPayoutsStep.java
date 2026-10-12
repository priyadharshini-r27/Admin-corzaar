package stepdefinitions;


	import org.testng.Assert;

	import pages.LoginPage;
	import pages.MerchantPayoutsPage;
	import driverFactory.DriverFactory;
	import utils.Constant;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class MerchantPayoutsStep {

		private MerchantPayoutsPage payoutPage;

		// Safe getter method guarantees payoutPage is never null when called
		private MerchantPayoutsPage getPayoutPage() {
		if (payoutPage == null) {
		payoutPage = new MerchantPayoutsPage(DriverFactory.getDriver());
		}
		return payoutPage;
		}

		@Given("admin is on the Merchant dashboard page")
		public void admin_is_on_dashboard() {
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
		}

		@When("admin click the merchant payment module")
		public void click_merchant_payouts() {
		getPayoutPage().clickMerchantPayouts(); // Uses safe getter
		Assert.assertTrue(getPayoutPage().getCurrentUrl().contains("payout"));
		}

		@When("admin verify the record settlement popup window")
		public void verify_record_settlement_popup() {
		getPayoutPage().clickRecordSettlement(); // Uses safe getter
		Assert.assertTrue(getPayoutPage().isRecordSettlementModalVisible());
		}
		
	 @When("admin select the institute or merchant recipient {string}")
	 public void select_recipient(String recipientId) {
	 payoutPage.selectRecipientByValue(recipientId);
	 }

	 @When("admin enter the settlement amount {string}")
	 public void enter_settlement_amount(String amount) {
	 payoutPage.enterAmount(amount);
	 }

	 @When("admin enter the bank transfer details {string}")
	 public void enter_bank_receipt(String receipt) {
	 payoutPage.enterBankReference(receipt);
	 }

	 @When("admin enter the notes details {string}")
	 public void enter_notes(String notes) {
	 payoutPage.enterNotes(notes);
	 }

	 @When("admin select the log settlement button")
	 public void log_settlement() {
	 payoutPage.clickLogSettlement();
	 }

	 @Then("verify the settlement details should be added")
	 public void verify_settlement_added() {
	 Assert.assertTrue(payoutPage.getCurrentUrl().contains("payout"));
	 }
	}


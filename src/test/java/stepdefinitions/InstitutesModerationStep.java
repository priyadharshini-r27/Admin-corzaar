package stepdefinitions;



import java.util.List;
import org.testng.Assert;

import pages.LoginPage;
import pages.InstitutesModerationPage;
import driverFactory.DriverFactory;
import utils.Constant;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstitutesModerationStep {

 private InstitutesModerationPage institutePage;

 @Given("user is on the institutes moderation page")
 public void user_on_moderation_page() {
 LoginPage login = new LoginPage(DriverFactory.getDriver());
 login.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
 institutePage = new InstitutesModerationPage(DriverFactory.getDriver());
 }

 @When("admin click the institutes moderation module")
 public void click_module() {
 institutePage.clickInstitutesModeration();
 Assert.assertTrue(institutePage.getCurrentUrl().contains("institutes"));
 }

 @When("admin enters {string} in institute search field")
 public void enter_search(String name) {
 institutePage.enterSearch(name);
 }

 @Then("and verify the {string} valid {string} details")
 public void verify_details(String status, String expected) {
 if ("invalid".equalsIgnoreCase(status)) {
 Assert.assertEquals(institutePage.getEmptyMessage(), expected);
 } else {
 Assert.assertTrue(institutePage.getFirstInstituteTitle().contains(expected));
 }
 }

 @When("admin clear the search field in institute module")
 public void clear_search() {
 institutePage.clearSearch();
 }

 @When("admin enters the in institute place {string} search field")
 public void enter_place(String place) {
 institutePage.enterSearch(place);
 }

 @Then("admin should see institutes from place {string} with {string} and expected {string}")
 public void verify_place_results(String place, String status, String expected) {
 if ("invalid".equalsIgnoreCase(status)) {
 Assert.assertEquals(institutePage.getEmptyMessage(), expected);
 } else {
 Assert.assertTrue(institutePage.getPlaceResult().contains(expected));
 }
 }

 @When("admin select the approved option it should be displayed related option")
 public void verify_approved() {
 institutePage.selectApproved();
 assertStatuses("approved");
 }

 @When("admin select the Pending option it should be displayed related option")
 public void verify_pending() {
 institutePage.selectPending();
 assertStatuses("pending");
 }

 @When("admin select the Rejected option it should be displayed related option")
 public void verify_rejected() {
 institutePage.selectRejected();
 assertStatuses("rejected");
 }

 @When("admin select the suspend option it should be displayed related option")
 public void verify_suspended() {
 institutePage.selectSuspended();
 assertStatuses("suspended");
 }

 private void assertStatuses(String expectedStatus) {
 List<String> values = institutePage.getStatuses();
 for (String value : values) {
 Assert.assertEquals(value.toLowerCase().trim(), expectedStatus);
 }
 }
}
package stepdefinitions;


	import java.util.List;
	import org.testng.Assert;

	import pages.LoginPage;
	import pages.CourseModerationPage;
	import driverFactory.DriverFactory;
	import utils.Constant;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class CourseModerationStep {

	 private CourseModerationPage coursePage;

	 @Given("user is on the dashboard page")
	 public void user_is_on_dashboard() {
	 LoginPage login = new LoginPage(DriverFactory.getDriver());
	 login.doLogin(Constant.getEmailId(), Constant.getPassword(), Constant.getOtp());
	 coursePage = new CourseModerationPage(DriverFactory.getDriver());
	 }

	 @When("admin click the course moderation module")
	 public void click_course_moderation() {
	 coursePage.clickCourseModeration();
	 Assert.assertTrue(coursePage.getCurrentUrl().contains("courses"));
	 }

	 @When("admin search the topic in search field {string}")
	 public void search_topic(String query) {
	 coursePage.searchCourse(query);
	 }

	 @Then("admin verify the course {string} as {string} with {string}")
	 public void verify_invalid_course(String course, String status, String expectedMessage) {
	 if ("invalid".equalsIgnoreCase(status)) {
	 Assert.assertEquals(coursePage.getEmptyMessage(), expectedMessage);
	 }
	 }

	 @When("admin search the course topic in search field {string}")
	 public void search_course_topic(String course) {
	 coursePage.searchCourse(course);
	 }

	 @When("admin clear the search field in coursemoderation module")
	 public void clear_search() {
	 coursePage.clearSearch();
	 }

	 @When("admin verify course moderation filter option is displayed")
	 public void verify_filter_displayed() {
	 Assert.assertTrue(coursePage.isFilterDisplayed());
	 }

	 @When("admin select the published option")
	 public void select_published() {
	 coursePage.selectPublished();
	 }

	 @When("admin select the underreview option")
	 public void select_underreview() {
	 coursePage.selectUnderReview();
	 }

	 @When("admin select the rejected option")
	 public void select_rejected() {
	 coursePage.selectRejected();
	 }

	 @Then("the option filter the details and should be displayed correctly for {string}")
	 public void verify_status_filtered(String expectedStatus) {
	 List<String> statuses = coursePage.getDisplayedStatuses();
	 for (String status : statuses) {
	 Assert.assertEquals(status.toLowerCase().trim(), expectedStatus.toLowerCase().trim());
	 }
	 }
	}


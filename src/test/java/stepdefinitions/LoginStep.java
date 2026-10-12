package stepdefinitions;


	

	import java.lang.System.Logger;

	import org.apache.commons.logging.Log;
	import org.testng.Assert;

	import pages.LoginPage;
	import driverFactory.DriverFactory;

	import io.cucumber.java.en.And;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class LoginStep {
		private static String title;
		private LoginPage log;
		
		@Given("user launch the application")
		public void user_launch_the_application()  {
			Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
			System.out.println(DriverFactory.getDriver().getCurrentUrl());
			log=new LoginPage(DriverFactory.getDriver());
			title=log.getAdminPageTitle();
			System.out.println("Page title is:"+title);
		}
		@When("user click the admin button")
		public void user_click_the_admin_button() {
		   log.clickAdminButton();
		   title=log.getAdminPageTitle();
			System.out.println("Page title is:"+title);
		}
		
		@When("user enter the {string}")
		public void user_enter_the(String email) {
			 log.enterEmail(email);
		}

		@When("user enter the password {string}")
		public void user_enter_the_password(String password) {
		     log.enterPassword(password);
		}

		@When("click the authenticate button")
		public void click_the_authenticate_button() {
		     log.clickAuthenticateButton();
		}
		@Then("user verify the {string} and {string}")
		public void user_verify_the_and(String  status, String message) {
			System.out.println("Status:"+status);
			System.out.println("Message:"+message);
		    if(status.equalsIgnoreCase("failed")) {
		    	String actualMessage=log.getValidationMessage();
		   System.out.println("Expected Message:"+message);
		   System.out.println("Actual Message:"+actualMessage);
		    	Assert.assertEquals(actualMessage,message);
		    }
		}

	 
	 	 @And("Admin is on the 2FA verification page")
		public void admin_is_on_the_2fa_verification_page() {
			log=new LoginPage(DriverFactory.getDriver());
		     log.isFaPageDisplayed();
		     System.out.println(log.faPageText);
	 	 }

		@When("admin enters valid {string}")
		public void admin_enters_valid(String otp) {
		      log.enterPassword(otp);
		}

		@When("admin click the verify button")
		public void admin_click_the_verify_button() {
		   log.clickSubmitOtpButton();
		}

		@When("admin verify the {string} and {string}")
		public void admin_verify_the_and(String status, String message ) {
			System.out.println("Status:"+status);
			System.out.println("Message:"+message);

	 	    if(status.equalsIgnoreCase("failed")) {
		    	String actualMessage=log.getValidationMessage();
	 	   System.out.println("Actual Message:"+actualMessage);
		   System.out.println("Actual Message:"+actualMessage);

		    	Assert.assertEquals(actualMessage,message );
		    }
		}

		@Then("admin should be logged in successfully")
		public void admin_should_be_logged_in_successfully() {
		    String actualURL=log.getCurrentUrl();
		    System.out.println("Actual URL:"+actualURL);
		    Assert.assertTrue(actualURL.contains("admin"));
	}
	}


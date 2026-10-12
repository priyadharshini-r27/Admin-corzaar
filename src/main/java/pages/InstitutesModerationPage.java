package pages;


	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.Element;

	public class InstitutesModerationPage {

	private final WebDriver driver;
	private final Element Element;

	public InstitutesModerationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	this.Element = new Element(driver);
	}

	@FindBy(xpath = "//*[normalize-space()='Institutes Moderation']/ancestor::a[1]")
	private WebElement institutesModerationTab;

	@FindBy(xpath = "//*[@placeholder='Search institutes or cities...']")
	private WebElement searchField;

	@FindBy(xpath = "///option[@value='approved']")
	private WebElement approvedOption;

	@FindBy(xpath = "//option[@value='pending']")
	private WebElement pendingOption;

	@FindBy(xpath = "//option[@value='rejected']")
	private WebElement rejectedOption;

	@FindBy(xpath = "//option[@value='suspended']")
	private WebElement suspendedOption;

	@FindBy(xpath = "//span[text()='Approve'] | (//button[normalize-space()='Approve'])[1]")
	private WebElement approveButton;

	@FindBy(xpath = "(//button[normalize-space()='Reject'])[1]")
	private WebElement rejectButton;

	@FindBy(xpath = "//td[normalize-space()='No matching institutes found.']")
	private WebElement emptyMessage;

	@FindBy(xpath = "//span[text()='Apex Institute of Technology']")
	private WebElement firstInstituteTitle;

	@FindBy(xpath = "//table/tbody//tr/td[4]")
	private List<WebElement> statusColumn;

	@FindBy(xpath = "//*[normalize-space()='Bengaluru']")
	private WebElement placeResult;

	public void clickInstitutesModeration() { Element.scrollAndClick(institutesModerationTab); }
	public void enterSearch(String text) { Element.sendKeys(searchField, text); }
	public void clearSearch() { Element.clearField(searchField); }
	public void selectApproved() { Element.clickElement(approvedOption); }
	public void selectPending() { Element.clickElement(pendingOption); }
	public void selectRejected() { Element.clickElement(rejectedOption); }
	public void selectSuspended() { Element.clickElement(suspendedOption); }
	public void clickApprove() { Element.clickElement(approveButton); }
	public void clickReject() { Element.clickElement(rejectButton); }

	public String getEmptyMessage() { return Element.getText(emptyMessage); }
	public String getFirstInstituteTitle() { return Element.getText(firstInstituteTitle); }
	public String getPlaceResult() { return Element.getText(placeResult); }
	public List<String> getStatuses() { return Element.getTexts(statusColumn); }
	public String getCurrentUrl() { return Element.getCurrentUrl(); }
	}

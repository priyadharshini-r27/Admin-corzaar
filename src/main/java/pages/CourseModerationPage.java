package pages;



	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.Element;

	public class CourseModerationPage {

	private final WebDriver driver;
	private final Element Element;

	public CourseModerationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	this.Element = new Element(driver);
	}

	@FindBy(xpath = "(//*[text()='Courses Moderation'])[1]")
	private WebElement courseModerationTab;

	@FindBy(xpath = "//*[@placeholder='Search programs by title or topic...']")
	private WebElement searchField;

	@FindBy(xpath = "//*[@value='published']")
	private WebElement publishedOption;

	@FindBy(xpath = "//*[@value='under_review']")
	private WebElement underReviewOption;

	@FindBy(xpath = "//*[@value='rejected']")
	private WebElement rejectedOption;

	@FindBy(xpath = "//*[@class='px-6 py-12 text-center text-ink-muted dark:text-dark-ink-muted']")
	private WebElement emptyMessage;

	@FindBy(xpath = "(//button[normalize-space()='Reject'])[1]")
	private WebElement rejectButton;

	@FindBy(xpath = "(//button[normalize-space()='Publish'])[1]")
	private WebElement publishButton;

	@FindBy(xpath = "//*[@class='bg-surface-alt dark:bg-slate-800 rounded-xl px-3 py-2 text-xs font-semibold border border-border outline-none']")
	private WebElement filterButton;

	@FindBy(xpath = "//table//tbody//tr/td[4]")
	private List<WebElement> statusColumn;

	public void clickCourseModeration() { Element.clickElement(courseModerationTab); }
	public void searchCourse(String course) { Element.sendKeys(searchField, course); }
	public void clearSearch() { Element.clearField(searchField); }
	public void selectPublished() { Element.clickElement(publishedOption); }
	public void selectUnderReview() { Element.clickElement(underReviewOption); }
	public void selectRejected() { Element.clickElement(rejectedOption); }
	public void clickReject() { Element.clickElement(rejectButton); }
	public void clickPublish() { Element.clickElement(publishButton); }

	public String getEmptyMessage() { return Element.getText(emptyMessage); }
	public boolean isFilterDisplayed() { return Element.isDisplayed(filterButton); }
	public List<String> getDisplayedStatuses() { return Element.getTexts(statusColumn); }
	public String getCurrentUrl() { return Element.getCurrentUrl(); }
	}


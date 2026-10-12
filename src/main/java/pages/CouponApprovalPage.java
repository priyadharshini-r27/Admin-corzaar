package pages;


    import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.Element;

	public class CouponApprovalPage {

	private final WebDriver driver;
	private final Element Element;

	public CouponApprovalPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	this.Element = new Element(driver);
	}

	@FindBy(xpath = "//*[text()='Coupons Approval']")
	private WebElement couponApprovalTab;

	@FindBy(xpath = "//*[@placeholder='Search coupon codes...']")
	private WebElement searchField;

	@FindBy(xpath = "//*[@value='pending']")
	private WebElement pendingOption;

	@FindBy(xpath = "//*[@value='approved']")
	private WebElement approvedOption;

	@FindBy(xpath = "//*[@value='rejected']")
	private WebElement rejectedOption;

	@FindBy(xpath = "(//button[normalize-space()='Approve'])[1]")
	private WebElement approveButton;

	@FindBy(xpath = "(//button[normalize-space()='Reject'])[1]")
	private WebElement rejectButton;

	@FindBy(xpath = "//*[@class='w-full text-left border-collapse']")
	private WebElement tableElement;

	@FindBy(xpath = "//*[@class='px-6 py-12 text-center text-ink-muted dark:text-dark-ink-muted']")
	private WebElement emptyMessage;

	@FindBy(xpath = "//*[@class='bg-surface-alt dark:bg-slate-800 rounded-xl px-3 py-2 text-xs font-semibold border border-border outline-none']")
	private WebElement filterButton;

	@FindBy(xpath = "//table//tbody//tr/td[4]")
	private List<WebElement> statusColumn;

	public void clickCouponApproval() { Element.clickElement(couponApprovalTab); }
	public void enterSearchCode(String code) { Element.sendKeys(searchField, code); }
	public void clearSearch() { Element.clearField(searchField); }
	public void selectPending() { Element.clickElement(pendingOption); }
	public void selectApproved() { Element.clickElement(approvedOption); }
	public void selectRejected() { Element.clickElement(rejectedOption); }
	public void clickApprove() { Element.clickElement(approveButton); }
	public void clickReject() { Element.clickElement(rejectButton); }

	public String getTableText() { return Element.getText(tableElement); }
	public String getEmptyMessage() { return Element.getText(emptyMessage); }
	public boolean isFilterButtonDisplayed() { return Element.isDisplayed(filterButton); }
	public List<String> getDisplayedStatuses() { return Element.getTexts(statusColumn); }
	public String getCurrentUrl() { return Element.getCurrentUrl(); }
	}


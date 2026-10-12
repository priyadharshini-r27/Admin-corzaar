package pages;



	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.Element;

	public class AuditTrail {

	private final WebDriver driver;
	private final Element Element;

	public AuditTrail(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	this.Element = new Element(driver);
	}

	@FindBy(xpath = "//*[text()='Audit Trail']")
	private WebElement auditTrailModule;

	@FindBy(xpath = "//*[@placeholder='Search action logs...']")
	private WebElement searchField;

	@FindBy(xpath = "//*[@class='bg-surface-alt dark:bg-slate-800 rounded-xl px-3 py-2 text-xs font-semibold border border-border outline-none']")
	private WebElement filterButton;

	@FindBy(xpath = "//*[@value='Payouts']")
	private WebElement payoutsOption;

	@FindBy(xpath = "//*[@value='Certificates']")
	private WebElement certificatesOption;

	@FindBy(xpath = "//*[@value='Coupons']")
	private WebElement couponOption;

	@FindBy(xpath = "//*[@value='Batches']")
	private WebElement batchesOption;

	@FindBy(xpath = "//*[@value='Courses']")
	private WebElement coursesOption;

	@FindBy(xpath = "//*[@value='Institutes']")
	private WebElement institutesOption;

	@FindBy(xpath = "//*[@class='px-6 py-12 text-center text-ink-muted dark:text-dark-ink-muted']")
	private WebElement emptyLogMessage;

	@FindBy(xpath = "//tbody/tr/td[3]//*[normalize-space()]")
	private List<WebElement> displayedRows;

	public void clickAuditTrail() {
	Element.clickElement(auditTrailModule);
	}

	public void searchAction(String action) {
	Element.sendKeys(searchField, action);
	}

	public void clearSearch() {
	Element.clearField(searchField);
	}

	public boolean isFilterButtonDisplayed() {
	return Element.isDisplayed(filterButton);
	}

	public void selectPayouts() { Element.clickElement(payoutsOption); }
	public void selectCertificates() { Element.clickElement(certificatesOption); }
	public void selectCoupons() { Element.clickElement(couponOption); }
	public void selectBatches() { Element.clickElement(batchesOption); }
	public void selectCourses() { Element.clickElement(coursesOption); }
	public void selectInstitutes() { Element.clickElement(institutesOption); }

	public String getEmptyMessage() {
	return Element.getText(emptyLogMessage);
	}

	public List<String> getDisplayedRowStatuses() {
	return Element.getTexts(displayedRows);
	}

	public String getCurrentUrl() {
	return Element.getCurrentUrl();
	}
	}

package pages;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.Element;

	public class MerchantPayoutsPage {

	private final WebDriver driver;
	private final Element Element;

	public MerchantPayoutsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	this.Element = new Element(driver);
	}

	@FindBy(xpath = "//*[text()='Merchant Payouts']")
	private WebElement merchantPayoutsTab;

	@FindBy(xpath = "//*[text()='Record Settlement']")
	private WebElement recordSettlementButton;

	@FindBy(id = "merchant-/-institute-recipient")
	private WebElement recipientDropdown;

	@FindBy(id = "settlement-amount-(₹)")
	private WebElement amountField;

	@FindBy(id = "bank-neft-/-rtgs-reference-number")
	private WebElement bankReferenceField;

	@FindBy(id = "settlement-notes-/-memo")
	private WebElement notesField;

	@FindBy(xpath = "//*[text()='Log Settlement']")
	private WebElement logSettlementButton;

	@FindBy(xpath = "(//*[text()='Disburse Payout'])[1]")
	private WebElement disbursePayoutButton;

	public void clickMerchantPayouts() { Element.clickElement(merchantPayoutsTab); }
	public void clickRecordSettlement() { Element.scrollAndClick(recordSettlementButton); }
	public void selectRecipientByValue(String recipientId) { Element.dropDownByValue(recipientDropdown, recipientId); }
	public void enterAmount(String amount) { Element.sendKeys(amountField, amount); }
	public void enterBankReference(String reference) { Element.sendKeys(bankReferenceField, reference); }
	public void enterNotes(String notes) { Element.sendKeys(notesField, notes); }
	public void clickLogSettlement() { Element.clickElement(logSettlementButton); }
	public void clickDisbursePayout() { Element.clickElement(disbursePayoutButton); }

	public boolean isRecordSettlementModalVisible() { return Element.isDisplayed(logSettlementButton); }
	public String getCurrentUrl() { return Element.getCurrentUrl(); }
	}


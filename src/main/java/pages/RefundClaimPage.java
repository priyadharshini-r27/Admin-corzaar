package pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import utils.Element;

	public class RefundClaimPage {

	private final Element Element;

	public RefundClaimPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.Element = new Element(driver);
	}

	@FindBy(xpath = "//span[text()='Refund Claims']")
	private WebElement refundClaimTab;

	public void clickRefundClaim() {
	Element.clickElement(refundClaimTab);
	}

	public String getCurrentUrl() {
	return Element.getCurrentUrl();
	}
	}


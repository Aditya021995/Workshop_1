package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusPage {
	public StatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Download ']")
	private WebElement viewStatus;
	public WebElement getViewStatus() {
		return viewStatus;
	}
 }

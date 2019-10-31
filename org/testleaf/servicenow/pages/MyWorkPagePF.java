package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class MyWorkPagePF extends SeleniumBase {

	public MyWorkPagePF() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame("gsft_main");
	}
	
	@FindBy(how=How.XPATH, using="//button[text()='New']")
	private WebElement eleClickNew;
	
	public TaskPagePF clickNew() {
		
		click(eleClickNew);
		defaultContent();
		return new TaskPagePF();		
	}
	
	@FindBy(how =How.XPATH, using="(//tr[@data-list_id='task']//td)[3]")
	private WebElement eleResultChatEntryNumber;
	public MyWorkPagePF verifyChatEntryCreation(String chatEntryNumber) {
		System.out.println(verifyPartialText(eleResultChatEntryNumber, chatEntryNumber)?
				"Chat entry created successfully":"Chat entry failed to create");
		return this;	

	}
}
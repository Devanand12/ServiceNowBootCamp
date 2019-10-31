package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaf.selenium.pages.CreateChatQueryPage;

public class TaskPagePF extends SeleniumBase{

	public TaskPagePF() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame("gsft_main");
	}
	
	@FindBy(how=How.LINK_TEXT, using="Chat_queue_entry")
	private WebElement eleClickMyChat;
	
	public CreateChatQueryPage ClickChatQuery() {
		click(eleClickMyChat);
		return new CreateChatQueryPage();		
	}
}

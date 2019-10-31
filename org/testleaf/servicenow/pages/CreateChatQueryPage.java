package com.testleaf.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CreateChatQueryPage extends SeleniumBase{

	public CreateChatQueryPage()  {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(how = How.ID, using = "chat_queue_entry.number")
	private WebElement eleChatEntryNumber;

	@Given("Get ChatQuery No")
	public CreateChatQueryPage getChatEntryNumber() {
		ProjectSpecificMethods.chatQueryNumber = getAttribute(eleChatEntryNumber, "value");
		return this;
	}
	
	@FindBy(how = How.ID, using = "chat_queue_entry.short_description")
	private WebElement eleShortDescription;

	@Given("Entering Short Mandatory fields (.*)")
	public CreateChatQueryPage enterShortDescription(String description) {
		clearAndType(eleShortDescription, description);
		return this;
	}
	
	@FindBy(how = How.ID, using = "chat_queue_entry.work_notes")
	private WebElement eleWorkNotes;

	@Given("Entering notes fields (.*)")
	public CreateChatQueryPage enterWorkNotes(String workNotes) {
		clearAndType(eleWorkNotes, workNotes);
		return this;
	}

	@FindBy(how = How.ID, using = "sysverb_insert")
	private WebElement eleSubmit;

	@When("Click on Submit Button")
	public MyWorkPage clickSubmit() {
		click(eleSubmit);
		return new MyWorkPage();
	}



}

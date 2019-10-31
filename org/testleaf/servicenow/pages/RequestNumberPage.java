package org.testleaf.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class RequestNumberPage extends ProjectSpecificMethods {
	
	public RequestNumberPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	// METHOD FOR SELECT BY VALUE IN APPROVAL FIELD
	@FindBy(how=How.XPATH,using="//select[@name='sc_request.approval']") private WebElement eleSelectValueRejected;
	public RequestNumberPage selectValueRejected(String approval) {
		selectDropDownUsingValue(eleSelectValueRejected, approval);
		return this;
		}
	// METHOD FOR SELECT BY VALUE IN REQUEST STATE FIELD
	@FindBy(how=How.XPATH,using="//select[@name='sc_request.request_state']") private WebElement eleSelectValueClosedCancelled;
	public RequestNumberPage selectValueClosedCancelled(String requeststate) {
		selectDropDownUsingValue(eleSelectValueClosedCancelled, requeststate);
		return this;
		}
	// METHOD FOR INPUT THE VALUE IN DESCRIPTION
	@FindBy(how=How.XPATH,using ="//textarea[@id='sc_request.description']") private WebElement eleDescription;
	public RequestNumberPage inputDescription(String desc) {
		clearAndType(eleDescription, desc);
		return this;
	}
	// METHOD FOR INPUT THE VALUE IN SHORT DESCRIPTION
	@FindBy(how=How.XPATH,using ="//input[@id='sc_request.short_description']") private WebElement eleShortDescription;
	public RequestNumberPage shortDescription(String shortdesc) {
		clearAndType(eleShortDescription, shortdesc);
		return this;
	}
	
	//METHOD TO CLEAR THE VALUE IN DESCRIPTION
	@FindBy(how=How.XPATH,using ="//textarea[@id='sc_request.description']") private WebElement eleClearDescription;
	public RequestNumberPage clearDescription() {
	clear(eleClearDescription);
	return this;
	}
	//METHOD TO CLEAR THE VALUE IN SHORT DESCRIPTION
	@FindBy(how=How.XPATH,using ="//input[@id='sc_request.short_description']") private WebElement eleClrShortDescription;
	public RequestNumberPage eleClrShortDescription() {
		clear(eleClrShortDescription);
		return this;
	}
	// METHOD TO CLICK CANCEL REQUEST
	@FindBy(how=How.XPATH,using ="//div[@class='form_action_button_container']/button[2]") private WebElement eleClickCancelRequest;
	public RequestNumberPage clickCancelRequest() {
		click(eleClickCancelRequest);
		return this;
	}
	// METHOD TO CLICK UPDATE
	@FindBy(how=How.XPATH,using ="//div[@class='form_action_button_container']/child::button[text()='Update']") private WebElement eleClickUpdate;
	public RequestNumberPage clickupdate() {
		click(eleClickUpdate);
		return this;
	}
	//METHOD TO VERIFY ERROR MESSAGE
	@FindBy(how=How.XPATH,using ="//span[@class='outputmsg_text']") private WebElement eleVerifyErrorMessage;
	public RequestNumberPage verifyErrorMessage(String errormessage) {
		
		verifyPartialText(eleVerifyErrorMessage, "The following mandatory fields are not filled in: Short description, Work notes");
		return this;
	}
	

}

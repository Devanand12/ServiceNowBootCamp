package com.testleaf.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods{
	public CreateLeadPage() {
		PageFactory.initElements(getDriver(),this);
	}
	@FindBy(how = How.ID, using="createLeadForm_companyName")
	private WebElement companyName;
	public CreateLeadPage enterOnCompanyName(String str){
		clearAndType(companyName,str);
		return this;
	}
	@FindBy(how = How.ID, using="createLeadForm_lastName")
	private WebElement lastName;
	public CreateLeadPage enterOnLastName(String str){
		clearAndType(lastName,str);
		return this;
	}
	@FindBy(how = How.ID, using="createLeadForm_firstName")
	private WebElement firstName;
	public CreateLeadPage enterOnFirstName(String str){
		clearAndType(firstName,str);
		return this;
	}
	@FindBy(how = How.ID, using="createLeadForm_industryEnumId")
	private WebElement industryEnumId;
	public CreateLeadPage selectIndustryEnumId(int index){
		selectDropDownUsingIndex(industryEnumId, 3);
		return this;
	}
	@FindBy(how = How.NAME, using="submitButton")
	private WebElement createLead;
	public ViewLeadPage clickOnCreateLead(){
		click(createLead);
	return new ViewLeadPage();
	}

}

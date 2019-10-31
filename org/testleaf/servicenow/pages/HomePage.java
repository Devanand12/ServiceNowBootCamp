package org.testleaf.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage() 
	{
		PageFactory.initElements(getDriver(), this);
		
	}

	//TO INPUT A VALUE REQUEST IN FILTER -Vignesh
	@FindBy(how=How.XPATH,using="//input[@name='filter']") private WebElement eleFiltertype;
	public HomePage enterFiltertype(String filtertype) {
		clearAndType(eleFiltertype, filtertype);
		return this;
	}
	
	//TO INPUT A VALUE MY WORK IN FILTER -Vignesh
		@FindBy(how=How.XPATH,using="//input[@name='filter']") private WebElement eleFiltertypeWork;
		public HomePage enterFiltertypework(String filtertypework) {
			clearAndType(eleFiltertypeWork, "My Work");
			return this;
		}
	
	//TO SELECT REQUEST BUTTON - Vignesh
	@FindBy(how=How.XPATH,using="//div[text()='Requests']") private WebElement eleMyRequests;
	public RequestPage clickMyRequests() {
		click(eleMyRequests);
		return new RequestPage(); 
	}
	//TO SELECT MY WORK BUTTON - Vignesh
	@FindBy(how=How.XPATH,using="//div[text()='My Work']") private WebElement eleMyWork;
	public RequestPage clickMyWork() {
		click(eleMyWork);
		return new RequestPage(); 
	}
	



}






package com.testleaf.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class CreateIncidentPage extends SeleniumBase {

	public CreateIncidentPage() {
		
	}
	
	public String createNewIncident() {
		switchToFrame("gsft_main");
		WebElement text = getDriver().findElement(By.xpath("//input[@class='form-control'][1]"));
		String incidentNumber = getAttribute(text, "value");
		System.out.println("TextValue =" + text);
		clearAndType(locateElement(Locators.XPATH, "(//input[@class='form-control element_reference_input'])[1]"),"Abel Tuter");
		clearAndType(locateElement(Locators.XPATH, "(//input[@data-ref='incident.short_description'])[2]"),"Request Normal Change");		
		return incidentNumber;		
	}
	
	public CreateIncidentPage clickCreateSubmit() {
		
		click(locateElement(Locators.XPATH, "(//button[contains(@class,'form_action_button')])[3]"));
		System.out.println("Incident Create Successfully created");
		defaultContent();
		return this;		
	}
	

	public CreateIncidentPage validateMandatory() {
		switchToFrame("gsft_main");		
		clearAndType(locateElement(Locators.XPATH, "(//input[@class='form-control element_reference_input'])[1]"),"");
		clearAndType(locateElement(Locators.XPATH, "(//input[@data-ref='incident.short_description'])[2]"),"");
		click(locateElement(Locators.XPATH, "(//button[contains(@class,'form_action_button')])[3]"));
		String ValidationMessage = getElementText(locateElement(Locators.CLASS_NAME, "outputmsg_text"));
		Boolean result = ValidationMessage.contains("Additional comments (Customer visible), Caller");
		Assert.assertEquals(result, Boolean.TRUE);
		return this;
				
	}
	
	public CreateIncidentPage EnterIncidentComments(String notes)
	{
		clearAndType(locateElement(Locators.ID, "incident.comments"), notes);
		return this;
	}
	
	//
	
	
}

package com.testleaf.selenium.pages;

import org.testng.Assert;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class IncidentPage extends SeleniumBase {
	
	public IncidentPage() {
		switchToFrame("gsft_main");
	}

	public IncidentPage enterAssginmentGroup(String group) throws InterruptedException {
		//getDriver().findElementById("sys_display.incident.assignment_group").sendKeys(group);
		clearAndType(locateElement(Locators.ID, "sys_display.incident.assignment_group"),group);
		Thread.sleep(2000);
		return this;
	}
	
	public IncidentPage assertAssginmentGroup(String group) {
		Assert.assertEquals(group, getAttribute(locateElement(Locators.ID, "sys_display.incident.assignment_group"), "value"));
		return this;
	}
	
	public IncidentPage updateState(String state) {
		selectDropDownUsingText(locateElement(Locators.ID, "incident.state"), state);
		return this;
	}
	
	public IncidentPage updateUrgency(String urgency) {
		selectDropDownUsingText(locateElement(Locators.ID, "incident.urgency"), urgency);
		return this;
	}
	
	public IncidentPage EnterNotes(String notes)
	{
		clearAndType(locateElement(Locators.XPATH, "//textarea[@aria-label='Work notes']"), notes);
		return this;
	}
	
	public IncidentPage EnterIncidentComments(String notes)
	{
		clearAndType(locateElement(Locators.XPATH, "//textarea[@id='activity-stream-comments-textarea']"), notes);
		return this;
	}
	public SearchIncident clickUpdate()
	{
		click(locateElement(Locators.XPATH, ".//*[.='Update']"));
		defaultContent();
		return new SearchIncident();
	}
	
	public SearchIncident clickResolve()
	{
		click(locateElement(Locators.ID, "resolve_incident"));
		defaultContent();
		return new SearchIncident();
	}
	
	public ResolveInformation clickResolveInformation()
	{
		click(locateElement(Locators.XPATH,"//span[.='Resolution Information']"));
		return new ResolveInformation();
	}
	
}

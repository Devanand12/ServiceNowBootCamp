package com.testleaf.selenium.pages;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class ResolveInformation extends SeleniumBase {
	
	public ResolveInformation updateCode(String code) {
		selectDropDownUsingText(locateElement(Locators.ID, "incident.close_code"), code);
		return this;
	}
	
	public ResolveInformation EnterNotes(String notes)
	{
		clearAndType(locateElement(Locators.ID,"incident.close_notes"), notes);
		defaultContent();
		return this;
	}
	
	public IncidentPage withinIncidentPage () { return new IncidentPage();}

}

package com.testleaf.selenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class SearchIncident extends SeleniumBase {

	public SearchIncident() {
		switchToFrame("gsft_main");
	}
	
	public SearchIncident enterIncidentID(String data) {
		clearAndType(locateElement(Locators.XPATH, "((//label[text()='Search'])[2]/following::input)[1]"),data, Keys.ENTER);
		return this;
	}

	public IncidentPage ClickIncidentID(String data) {
		click(locateElement(Locators.XPATH, "//a[text()='"+data+"']"));
		defaultContent();
		return new IncidentPage();
	}

	public SearchIncident VerifyPriority(String data, String PriorityStatus) {
		String ActualPriority = getElementText(locateElement(Locators.XPATH, "//a[text()='"+data+"']/following::td[4]"));
		Assert.assertEquals(ActualPriority, PriorityStatus);
		defaultContent();
		return this;
	}

	public SearchIncident VerifyState(String data, String State) {
		String ActualState = getElementText(locateElement(Locators.XPATH, "//a[text()='"+data+"']/following::td[5]"));
		Assert.assertEquals(ActualState, State);
		return this;
	}
	
}

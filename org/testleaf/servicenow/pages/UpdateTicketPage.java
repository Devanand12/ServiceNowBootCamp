package com.testleaf.selenium.pages;

import org.testng.Assert;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class UpdateTicketPage extends SeleniumBase{
	
	public UpdateTicketPage() 
	{
		defaultContent();
		switchToFrame("gsft_main");
	}
	
	public DeleteTicketPage clickDelete()
	{
		click(locateElement(Locators.XPATH, "(//button[text() = 'Delete'])"));
		return new DeleteTicketPage();
	}
	
	public UpdateTicketPage updateState(String state) {
		selectDropDownUsingText(locateElement(Locators.ID, "ticket.state"), state);
		return this;
	}
	
	public UpdateTicketPage updatePriority(String priority) {
		selectDropDownUsingText(locateElement(Locators.ID, "ticket.priority"), priority);
		System.out.println("Update done");
		return this;
	}
	
	public MyWorkPage clickUpdate()
	{
		click(locateElement(Locators.XPATH, ".//*[.='Update']"));
		defaultContent();
		return new MyWorkPage();
	}
	
	public UpdateTicketPage EnterNotes(String notes)
	{
		clearAndType(locateElement(Locators.XPATH, "(//textarea[@class='form-control'])[2]"), notes);
		return this;
	}
	
	public UpdateTicketPage UpdateAssignmentGrp(String Assgrp) {
		clearAndType(locateElement(Locators.ID, "sys_display.ticket.assignment_group"), Assgrp);
		return this;
	}
	
	public UpdateTicketPage VerifyAssignmentGrp(String Assgrpvalue) {
		Assert.assertEquals(Assgrpvalue, getAttribute(locateElement(Locators.ID, "sys_display.ticket.assignment_group"), "value"));
		return this;
	}


}

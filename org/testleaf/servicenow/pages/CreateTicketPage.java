package com.testleaf.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class CreateTicketPage extends SeleniumBase {

	public CreateTicketPage() {
		defaultContent();
		switchToFrame("gsft_main");
		
	}
	
	public String createNewTicket() {
				
		WebElement text = getDriver().findElement(By.xpath("(//div[@class='hidden']/following-sibling::input)[1]"));
		String incidentNumber = getAttribute(text, "value");
		System.out.println("TextValue =" + text);	
		return incidentNumber;			
	}
	
	public CreateTicketPage enterDescription() {
		clearAndType(locateElement(Locators.XPATH, "(//input[@class ='form-control'])[1]"),"New Ticket Request");		
		return this;
	}
	
	public CreateTicketPage enterNotes() {
		clearAndType(locateElement(Locators.XPATH, "(//textarea[@class='form-control'])[2]"),"Created New Ticket");	
		return this;
	}
	
	public CreateTicketPage clickCreateSubmit() {
		
		click(locateElement(Locators.XPATH, "(//div[@class='form_action_button_container']//button)"));
		System.out.println("New Ticket Successfully created");
		defaultContent();
		return this;		
	}
}

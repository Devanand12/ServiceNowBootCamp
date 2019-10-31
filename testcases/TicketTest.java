package com.testleaf.selenium.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.selenium.pages.CreateTicketPage;
import com.testleaf.selenium.pages.LoginPage;
import com.testleaf.selenium.pages.MyWorkPage;
import com.testleaf.selenium.pages.UpdateTicketPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TicketTest extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		excelFileName="TC001";
		testcaseName="Ticket New";
		testcaseDec = "Ticket-Create New Ticket";
		author = "Shobana";
		category = "Documentry";
	}
	
	@Test
	public void runTicket() throws InterruptedException {
		
		String Ticketnum = new LoginPage().enterUsername("admin").enterPassword("India@123").clickLogin().enterFilterSearch("My Work").clickMyWork().ClickNew().ClickTicket().createNewTicket();
		new CreateTicketPage().enterDescription().enterNotes().clickCreateSubmit();
		
		new MyWorkPage().enterTicketID(Ticketnum).ClickTicketID(Ticketnum).updatePriority("3 - Moderate").updateState("Work in Progress").EnterNotes("update").clickUpdate().VerifyState(Ticketnum, "Work in Progress").VerifyPriority(Ticketnum, "3 - Moderate");
		new MyWorkPage().ClickTicketID(Ticketnum).updateState("Closed Complete").updatePriority("2 - High").UpdateAssignmentGrp("IT Securities").EnterNotes("text").clickUpdate().ClickAll();
		new MyWorkPage().enterTicketID(Ticketnum).VerifyState(Ticketnum,"Closed Complete").VerifyPriority(Ticketnum,"2 - High").ClickTicketID(Ticketnum).VerifyAssignmentGrp("IT Securities");
		new UpdateTicketPage().clickDelete().confirmAlert();
	}
}

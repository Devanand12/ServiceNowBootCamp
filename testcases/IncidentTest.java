package com.testleaf.selenium.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.selenium.pages.CreateIncidentPage;
import com.testleaf.selenium.pages.HomePage;
import com.testleaf.selenium.pages.LoginPage;
import com.testleaf.selenium.pages.SearchIncident;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class IncidentTest extends ProjectSpecificMethods {

	@BeforeTest
	public void setData() {
		excelFileName="TC001";
		testcaseName="Create New Incident";
		testcaseDec = "Incident-Create New Incident";
		author = "Shobana";
		category = "Documentry";
	}
	
	@Test
	public void runLogin() throws InterruptedException {
		String incidentnum= new LoginPage().enterUsername("admin").enterPassword("India@123").clickLogin().enterFilterSearch("incident").clickCreateNew().createNewIncident();
		new CreateIncidentPage().EnterIncidentComments("test").clickCreateSubmit();	
		new SearchIncident().enterIncidentID(incidentnum).ClickIncidentID(incidentnum).updateState("In Progress").updateUrgency("1 - High").EnterNotes("text").clickUpdate().enterIncidentID(incidentnum).VerifyState(incidentnum,"In Progress").VerifyPriority(incidentnum,"3 - Moderate");
		new SearchIncident().enterIncidentID(incidentnum).ClickIncidentID(incidentnum).enterAssginmentGroup("Software").EnterIncidentComments("test").clickUpdate().ClickIncidentID(incidentnum).assertAssginmentGroup("Software").defaultContent();
		new HomePage().clickOpen();
		new SearchIncident().enterIncidentID(incidentnum).ClickIncidentID(incidentnum).clickResolveInformation().updateCode("Solved (Permanently)").EnterNotes("test").withinIncidentPage().clickResolve().VerifyState(incidentnum, "Resolved");		
		new HomePage().enterFilterSearch("incident").clickCreateNew().validateMandatory();
	}
}

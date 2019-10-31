package com.testleaf.servicenow.testcases;

import org.testleaf.servicenow.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC010CreateNewRequestInMyWorkNegative extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		testcaseName="Create New Request in My Work TC010";
		testcaseDec="Create New Request in My Work Negative";
		author="Vignesh";
		category="smoke";
		excelFileName="TC010";
	}

	@Test(dataProvider = "fetchData")
	public void runTC010(String username,String password,String filtertype,String errormessage ) {
		new LoginPage()
		.enterUserName(username)
		.enterpassword(password)
		.clickLoginButton()
		.enterFiltertype(filtertype)
		.clickMyWork()
		.clickMyWorkNumber()
		.clearDescription()
		.eleClrShortDescription()
		.clickupdate()
		.verifyErrorMessage(errormessage);


}
}

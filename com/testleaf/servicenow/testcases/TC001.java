package com.testleaf.servicenow.testcases;

import org.testleaf.servicenow.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC001 extends ProjectSpecificMethods{
	@BeforeTest
	public void setData() {
		testcaseName="Login";
		testcaseDec="Login into service now application";
		author="Vignesh";
		category="smoke";
		excelFileName="TC001";
	}
	
	@Test(dataProvider = "fetchData")
	public void runTC001(String username,String password) {
		new LoginPage()
		.enterUserName(username)
		.enterpassword(password)
		.clickLoginButton();
	}

}
